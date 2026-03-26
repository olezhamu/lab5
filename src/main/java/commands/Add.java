//добавить новый элемент в коллекцию

package commands;

import vehicle.Vehicle;
import vehicle.VehicleParser;

public class Add implements Command {
    @Override
    public String execute(String argument) {
        collection.add(new VehicleParser().parse(argument));
        return "element successfully added\n";
    }

    @Override
    public String toString() {
        return "adds new element to collection";
    }
}
