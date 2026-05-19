//удалить элемент из коллекции по его id

package clientCommands;

import client.Client;

public class RemoveById implements ClientCommand {
    public RemoveById(){}

    @Override
    public Object execute(String arg) {
        try {
            Integer output = Integer.parseInt(arg);

            return output;
        } catch (NumberFormatException e) {
            Client.println("wrong format of data");
            return null;
        }
    }

    @Override
    public String toString() {
        return "removes element from collection by it's id\n";
    }
}
