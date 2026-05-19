//вывести справку по доступным командам

package serverCommands;

import managers.ServerCommandManager;
import utils.*;

import java.util.*;

public class Help implements ServerCommand{
    public Help(){}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            String res = "";
            Map<String, ServerCommand> commands = new ServerCommandManager().getCommands();
            for (Map.Entry<String, ServerCommand> entry : commands.entrySet()) {
                res += entry.getKey() + ": " + entry.getValue().toString() + "---\n";
            }
            output.add(true);
            output.add(res);
        }catch (Exception e){
            output.add(false);
            output.add("could not run this command");
        }

        return output;
    }

    @Override
    public String toString() {
        return "shows information about all available commands\n";
    }
}