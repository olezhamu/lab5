package managers;

import commands.Command;
import utils.CommandContainer;

import java.io.IOException;
import java.util.Map;

public class CommandManager {
    private final Map<String, Command> commandContainer = CommandContainer.getCommandContainer();

    public void executeCommand(String input) throws IOException {
        String[] parts = input.trim().split("\\s+", 2);
        String commandName = parts[0];
        String argument = parts.length > 1 ? parts[1] : null;

        Command command = commandContainer.get(commandName);
        if (command == null) {
            System.err.println("unknown command: " + commandName);
            new ConsoleManager().println("input 'help' for list of available commands");
            return;
        }
        new ConsoleManager().println(command.execute(argument));
    }
}