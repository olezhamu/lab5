//вывести в стандартный поток вывода все элементы коллекции в строковом представлении

package clientCommands;

public class Show implements ClientCommand {
    public Show(){}

    @Override
    public Object execute(String arg) {
        Object output = arg;

        return output;
    }

    @Override
    public String toString() {
        return "shows all elements of collection\n";
    }
}
