//обновить значение элемента коллекции, id которого равен заданному

package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;
import vehicle.VehicleParser;

import java.util.*;

public class Update implements Command{
    public Update(){}

    @Override
    public String execute(String argument) {
        String[] parts = argument.split("\\s+", 2);
        Integer id = Integer.valueOf(parts[0]);
        Vehicle vehicle = new VehicleParser().parse(parts[1]);
        for (Vehicle vehicle1 : collection) {
            if (vehicle1.getId() == id) {
                collection.set(collection.indexOf(vehicle1), vehicle);
            }
        }
        return "element successfully updated\n";
    }

    @Override
    public String toString() {
        return "updates value of element by it's id\nsyntax: update (int - id) (str - name) (int - x coord) (int - y coord) (int - engine power) (int - capacity) (optional: int - fuel consumption) (str - vehicle type)\n";
    }
}
