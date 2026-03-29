//обновить значение элемента коллекции, id которого равен заданному

package commands;

import vehicle.Vehicle;
import vehicle.VehicleParser;

public class Update implements Command{
    public Update(){}

    @Override
    public String execute(String argument) {
        String[] parts = argument.split("\\s+", 2);
        Integer id = Integer.valueOf(parts[0]);
        Vehicle vehicle = new VehicleParser().parse(parts[1]);
        for (Vehicle vehicleToCompare : collection) {
            if (vehicleToCompare.getId() == id) {
                collection.set(collection.indexOf(vehicleToCompare), vehicle);
            }
        }
        return "element successfully updated\n";
    }

    @Override
    public String toString() {
        return "updates value of element by it's id\nsyntax: update (int - id) (str - name) (int - x coord) (int - y coord) (int - engine power) (int - capacity) (optional: int - fuel consumption) (str - vehicle type)\n";
    }
}
