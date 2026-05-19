//вывести элементы, значение поля capacity которых равно заданному

package clientCommands;

public class FilterByCapacity implements ClientCommand {
    public FilterByCapacity(){}

    @Override
    public Object execute(String arg) {
        long output = Long.parseLong(arg);

        return output;
    }

    @Override
    public String toString() {
        return "shows all elements which capacity equals entered capacity\n";
    }
}
