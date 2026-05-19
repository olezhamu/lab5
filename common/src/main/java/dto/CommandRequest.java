package dto;

import java.io.Serializable;

public class CommandRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String commandName;
    private final Object argument;   // может быть String, Vehicle, Coordinates и т.д.

    public CommandRequest(String commandName, Object argument) {
        this.commandName = commandName;
        this.argument = argument;
    }

    public String getCommandName() { return commandName; }
    public Object getArgument() { return argument; }
}