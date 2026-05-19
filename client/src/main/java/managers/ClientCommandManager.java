package managers;

import clientCommands.ClientCommand;
import dto.CommandRequest;
import utils.ClientCommandContainer;

import java.io.IOException;
import java.util.Map;

public class ClientCommandManager {
    public final Map<String, ClientCommand> commandContainer = ClientCommandContainer.getClientCommandContainer();

    public CommandRequest executeCommand(String commandName, String argument) throws IOException {
        ClientCommand command = commandContainer.get(commandName);
        Object output = command.execute(argument);
        return new CommandRequest(commandName, output);
    }
}