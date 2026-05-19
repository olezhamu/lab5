//вывести уникальные значения поля enginePower всех элементов в коллекции

package clientCommands;

public class PrintUniqueEnginePower implements ClientCommand {
    public PrintUniqueEnginePower(){}

    @Override
    public Object execute(String arg) {
        Object output = arg;

        return output;
    }

    @Override
    public String toString() {
        return "shows unique elements of enginePower field\n";
    }
}
