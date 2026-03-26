//обновить значение элемента коллекции, id которого равен заданному

package commands;

import vehicle.Vehicle;
import vehicle.VehicleParser;

import java.util.*;

public class Update implements Command{
    @Override
    public String execute(String argument) {
        String[] parts = argument.split("\\s+", 2);
        Integer id = Integer.valueOf(parts[0]);
        Vehicle vehicle = new VehicleParser().parse(parts[1]);
        LinkedList<Vehicle> newCollection = new LinkedList<Vehicle>();
        for (Vehicle vehicle1 : collection) {
            if (vehicle1.getId() == id) {
                newCollection.add(vehicle);
            } else {newCollection.add(vehicle1);}
        }
        return "element successfully updated";
    }

    @Override
    public String toString() {
        return "updates value of element by it's id";
    }
}
