package server;

import dto.CommandRequest;
import dto.CommandResponse;
import managers.ServerFileManager;
import managers.ServerCommandManager;
import serverCommands.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

import static utils.CollectionContainer.collection;

public class Server {
    private static final int PORT = 8888;
    private static ServerCommandManager serverCommandManager;
    private static final org.apache.logging.log4j.Logger logger =
            org.apache.logging.log4j.LogManager.getLogger(Server.class);

    private static class ClientContext {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int expectedLength = -1; // -1 = ждём первые 4 байта (длину)
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            String fileName = args[0];
            new ServerFileManager().readCollection(fileName);
        }

        serverCommandManager = new ServerCommandManager();
        serverCommandManager.register("add", new Add(collection));
        serverCommandManager.register("add_if_min", new AddIfMin(collection));
        serverCommandManager.register("clear", new Clear(collection));
        serverCommandManager.register("execute_script", new ExecuteScript());
        serverCommandManager.register("exit", new Exit(collection));
        serverCommandManager.register("filter_by_capacity", new FilterByCapacity(collection));
        serverCommandManager.register("help", new Help());
        serverCommandManager.register("info", new Info(collection));
        serverCommandManager.register("print_field_ascending_fuel_consumption", new PrintFieldAscendingFuelConsumption(collection));
        serverCommandManager.register("print_unique_engine_power", new PrintUniqueEnginePower(collection));
        serverCommandManager.register("remove_by_id", new RemoveById(collection));
        serverCommandManager.register("remove_grater", new RemoveGrater(collection));
        serverCommandManager.register("remove_lower", new RemoveLower(collection));
        serverCommandManager.register("save", new Save(collection));
        serverCommandManager.register("show", new Show(collection));
        serverCommandManager.register("update", new Update(collection));

        logger.info("server started on port " + PORT);

        Selector selector = Selector.open();
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.bind(new InetSocketAddress(PORT));
        serverChannel.configureBlocking(false);
        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        logger.info("waiting for connections...");

        while (true) {
            selector.select();
            Iterator<SelectionKey> keys = selector.selectedKeys().iterator();
            while (keys.hasNext()) {
                SelectionKey key = keys.next();
                keys.remove();
                try {
                    if (!key.isValid()) continue;
                    if (key.isAcceptable()) {
                        acceptClient(serverChannel, selector);
                    } else if (key.isReadable()) {
                        handleClientRequest(key);
                    }
                } catch (IOException e) {
                    logger.error("error processing client", e);
                    key.cancel();
                    if (key.channel() != null) key.channel().close();
                }
            }
        }
    }

    private static void acceptClient(ServerSocketChannel serverChannel, Selector selector) throws IOException {
        SocketChannel client = serverChannel.accept();
        client.configureBlocking(false);
        client.register(selector, SelectionKey.OP_READ);
        // Прикрепляем контекст к ключу
        SelectionKey key = client.keyFor(selector);
        if (key != null) key.attach(new ClientContext());
        logger.info("new client connected: " + client.getRemoteAddress());
    }

    private static void handleClientRequest(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        ClientContext ctx = (ClientContext) key.attachment();
        if (ctx == null) {
            ctx = new ClientContext();
            key.attach(ctx);
        }

        ByteBuffer buffer = ByteBuffer.allocate(8192);
        int bytesRead = client.read(buffer);
        if (bytesRead == -1) {
            client.close();
            key.cancel();
            logger.info("client disconnected");
            return;
        }

        buffer.flip();
        byte[] data = new byte[buffer.remaining()];
        buffer.get(data);
        ctx.buffer.write(data);

        // Обрабатываем накопленные данные, пока есть полное сообщение
        while (true) {
            byte[] fullBuffer = ctx.buffer.toByteArray();
            if (ctx.expectedLength == -1 && fullBuffer.length >= 4) {
                // Вычитываем длину сообщения
                ByteBuffer lenBuffer = ByteBuffer.wrap(fullBuffer, 0, 4);
                ctx.expectedLength = lenBuffer.getInt();
                // Удаляем эти 4 байта из буфера
                ctx.buffer.reset();
                ctx.buffer.write(fullBuffer, 4, fullBuffer.length - 4);
                fullBuffer = ctx.buffer.toByteArray();
            }

            if (ctx.expectedLength != -1 && fullBuffer.length >= ctx.expectedLength) {
                // Извлекаем сериализованный объект
                byte[] objectData = new byte[ctx.expectedLength];
                System.arraycopy(fullBuffer, 0, objectData, 0, ctx.expectedLength);
                // Сохраняем остаток данных для следующего сообщения
                byte[] remaining = new byte[fullBuffer.length - ctx.expectedLength];
                System.arraycopy(fullBuffer, ctx.expectedLength, remaining, 0, remaining.length);
                ctx.buffer.reset();
                ctx.buffer.write(remaining);

                // Десериализуем и обрабатываем
                try (ByteArrayInputStream bais = new ByteArrayInputStream(objectData);
                     ObjectInputStream ois = new ObjectInputStream(bais)) {
                    CommandRequest request = (CommandRequest) ois.readObject();
                    logger.info("received command: " + request.getCommandName());

                    CommandResponse response = serverCommandManager.executeCommand(request);

                    // Отправляем ответ (тоже с префиксом длины)
                    sendResponse(client, response);
                } catch (ClassNotFoundException e) {
                    logger.error("deserialization error", e);
                }
                // Сбрасываем ожидаемую длину, чтобы начать приём следующего сообщения
                ctx.expectedLength = -1;
                // Если в буфере ещё остались данные – повторим цикл
                continue;
            }
            break; // недостаточно данных, выходим
        }
    }

    private static void sendResponse(SocketChannel client, CommandResponse response) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(response);
            oos.flush();
        }
        byte[] data = baos.toByteArray();
        ByteBuffer buf = ByteBuffer.allocate(4 + data.length);
        buf.putInt(data.length);
        buf.put(data);
        buf.flip();
        while (buf.hasRemaining()) {
            client.write(buf);
        }
    }
}