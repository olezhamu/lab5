//обновить значение элемента коллекции, id которого равен заданному

package commands;

import vehicle.Vehicle;
import vehicle.VehicleInputReader;
import vehicle.VehicleParser;

import java.io.IOException;

public class Update implements Command{
    public Update(){}

    @Override
    public String execute(String argument) throws IOException {
        try {
            String[] parts = argument.split("\\s+", 2);
            Integer id = Integer.valueOf(parts[0]);
            Vehicle vehicle;
            if (parts.length == 1) {
                vehicle = new VehicleInputReader().readVehicle();
            } else {
                vehicle = VehicleParser.parse(parts[1]);
            }
            vehicle.setId(id);
            for (Vehicle vehicleToCompare : collection) {
                if (vehicleToCompare.getId() == id) {
                    collection.set(collection.indexOf(vehicleToCompare), vehicle);
                }
            }
            return "element successfully updated or element with entered id doesn't exist\n";
        } catch (NumberFormatException e) {
            return "wrong format of id. must be Integer";
        }
    }

    @Override
    public String toString() {
        return "updates value of element by it's id\n";
    }
}
