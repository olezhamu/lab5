//вывести справку по доступным командам

package clientCommands;

import client.Client;
import utils.ClientCommandContainer;

import java.util.*;

public class Help implements ClientCommand{
    public Help(){}

    @Override
    public Object execute(String arg) {
        String output = arg;
        HashMap<String, ClientCommand> commands = ClientCommandContainer.getClientCommandContainer();
        for (Map.Entry<String, ClientCommand> entry : commands.entrySet()) {
            Client.println(entry.getKey() + ": " + entry.getValue().toString() + "---\n");
        }
        commands.remove("save");
        return output;
    }

    @Override
    public String toString() {
        return "shows information about all available commands\n";
    }
}