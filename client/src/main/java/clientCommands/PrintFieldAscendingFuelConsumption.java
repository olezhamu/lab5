//вывести значения поля fuelConsumption всех элементов в порядке возрастания

package clientCommands;

public class PrintFieldAscendingFuelConsumption implements ClientCommand {
public PrintFieldAscendingFuelConsumption(){}

    @Override
    public Object execute(String arg) {
        String output = arg;

        return output;
    }

    @Override
    public String toString() {
        return "shows values of fuelConsumption field in lower-to-higher order\n";
    }
}
