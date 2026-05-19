package managers;

import serverCommands.*;
import dto.CommandRequest;
import dto.CommandResponse;

import java.io.IOException;
import java.util.*;

public class ServerCommandManager {
    private final Map<String, ServerCommand> commands = new HashMap<>();

    public void register(String name, ServerCommand command) {
        commands.put(name.toLowerCase(), command);
    }

    public ServerCommandManager() {}

    public CommandResponse executeCommand(CommandRequest request) throws IOException {
        ServerCommand cmd = commands.get(request.getCommandName());
        Object arg = request.getArgument();
        if (cmd == null) {
            return new CommandResponse(false, "unknown command: " + request.getCommandName() + "\ninput 'help' for list of available commands");
        }
        List<Object> output = cmd.execute(arg);
        return new CommandResponse((Boolean) output.get(0), (String) output.get(1));
    }

    public Map<String, ServerCommand> getCommands() {
        return commands;
    }
}