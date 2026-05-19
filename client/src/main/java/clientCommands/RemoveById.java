//удалить элемент из коллекции по его id

package clientCommands;

public class RemoveById implements ClientCommand {
    public RemoveById(){}

    @Override
    public Object execute(String arg) {
        Integer output = Integer.parseInt(arg);

        return output;
    }

    @Override
    public String toString() {
        return "removes element from collection by it's id\n";
    }
}
