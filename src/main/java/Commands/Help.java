//вывести справку по доступным командам

package Commands;

import Utils.CommandContainer;

import java.util.*;

public class Help implements Command{
    public Help(){}

    @Override
    public String execute() {
        String output = "";
        HashMap<String, Command> commands = new CommandContainer().getCommandContainer();
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            output += entry.getKey() + " : " + entry.getValue().toString() + "\n";
        }
        return output;
    }

    @Override
    public String toString() {
        return "shows information about all available commands";
    }
}