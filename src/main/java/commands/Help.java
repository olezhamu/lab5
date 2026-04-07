//вывести справку по доступным командам

package commands;

import utils.CommandContainer;

import java.util.*;

public class Help implements Command{
    public Help(){}

    @Override
    public String execute(String argument) {
        String output = "";
        HashMap<String, Command> commands = CommandContainer.getCommandContainer();
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            output += entry.getKey() + ": " + entry.getValue().toString() + "---\n";
        }
        return output;
    }

    @Override
    public String toString() {
        return "shows information about all available commands\n";
    }
}