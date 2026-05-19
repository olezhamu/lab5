//вывести элементы, значение поля capacity которых равно заданному

package clientCommands;

import client.Client;

public class FilterByCapacity implements ClientCommand {
    public FilterByCapacity(){}

    @Override
    public Object execute(String arg) {
        try {
            long output = Long.parseLong(arg);

            return output;
        } catch (NumberFormatException e) {
            Client.println("wrong format of data");
            return null;
        }
    }

    @Override
    public String toString() {
        return "shows all elements which capacity equals entered capacity\n";
    }
}
