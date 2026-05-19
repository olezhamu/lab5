//вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)

package clientCommands;

public class Info implements ClientCommand {
    public Info(){}

    @Override
    public Object execute(String arg) {
        String output = arg;

        return output;
    }

    @Override
    public String toString() {
        return "shows information about collection\n";
    }
}
