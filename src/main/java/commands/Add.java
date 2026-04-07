//добавить новый элемент в коллекцию

package commands;

import vehicle.VehicleInputReader;
import vehicle.VehicleParser;

public class Add implements Command {
    public Add(){}

    @Override
    public String execute(String argument) {
        if (argument == null){
            collection.add(new VehicleInputReader().readVehicle());
        } else {
            collection.add(VehicleParser.parse(argument));
        }
        return "element successfully added\n";
    }

    @Override
    public String toString() {
        return "adds new element to collection\n";
    }
}
