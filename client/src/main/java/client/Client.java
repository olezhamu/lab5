package client;

import clientCommands.Help;
import dto.CommandRequest;
import dto.CommandResponse;
import managers.ClientCommandManager;

import java.io.*;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 8888;
    private static Socket socket;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private static ClientCommandManager clientCommandManager;

    public static void main(String[] args) throws IOException {
        clientCommandManager = new ClientCommandManager();

        Scanner scanner = new Scanner(System.in);
        println("client is running now\nenter 'exit' to finish\nenter 'help' for list of available commands");

        while (true) {
            String input = readLine("> ");
            if (input.isEmpty()) continue;
            if (input.equalsIgnoreCase("exit")) {
                println("bye! ;D");
                break;
            }

            String[] parts = input.split(" ", 2);
            String command = parts[0].toLowerCase();
            String argument = parts.length > 1 ? parts[1] : "";

            if (command.equals("save")) {
                println("command 'safe' is unavailable for client");
                continue;
            }
            if (command.equals("help")) {
                new Help().execute(null);
                continue;
            }
            if (!(clientCommandManager.commandContainer.containsKey(command))){
                println("unknown command: " + command);
                println("input 'help' for list of available commands");
                continue;
            }

            try {
                CommandRequest request = clientCommandManager.executeCommand(command, argument);

                connectToServer();
                sendRequest(request);
                CommandResponse response = receiveResponse();

                println(response.isSuccess() ? "success: " + response.getMessage() : "error: " + response.getMessage());

                closeConnection();
            } catch (ConnectException e) {
                println("can not connect to server, try later");
            } catch (IOException | ClassNotFoundException e) {
                println("error connecting to server: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static DataOutputStream dataOut;
    private static DataInputStream dataIn;

    private static void connectToServer() throws IOException {
        socket = new Socket(HOST, PORT);
        dataOut = new DataOutputStream(socket.getOutputStream());
        dataIn = new DataInputStream(socket.getInputStream());
    }

    private static void sendRequest(CommandRequest request) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(request);
            oos.flush();
        }
        byte[] data = baos.toByteArray();
        dataOut.writeInt(data.length);
        dataOut.write(data);
        dataOut.flush();
    }

    private static CommandResponse receiveResponse() throws IOException, ClassNotFoundException {
        int length = dataIn.readInt();
        byte[] data = new byte[length];
        dataIn.readFully(data);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bais)) {
            return (CommandResponse) ois.readObject();
        }
    }

    private static void closeConnection() {
        try { if (in != null) in.close(); } catch (IOException e) {}
        try { if (out != null) out.close(); } catch (IOException e) {}
        try { if (socket != null) socket.close(); } catch (IOException e) {}
    }

    public static void print(String output){System.out.print(output);}

    public static void println(String output){System.out.println(output);}

    public static String readLine(String promt){print(promt); return new Scanner(System.in).nextLine().trim();}
}