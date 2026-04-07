//удалить из коллекции все элементы, меньшие, чем заданный

package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;
import vehicle.VehicleInputReader;
import vehicle.VehicleParser;

import java.util.LinkedList;

public class RemoveLower implements Command{
    public RemoveLower(){}

    @Override
    public String execute(String argument) {
        Vehicle vehicle;
        if (argument == null){
            vehicle = new VehicleInputReader().readVehicle();
        } else {
            vehicle = VehicleParser.parse(argument);
        }
        String output = "there aren't any lower elements\n";
        LinkedList<Vehicle> newCollection = new CollectionContainer().sortCollection(collection);
        for (Vehicle vehicleToCompare : collection) {
            if (newCollection.indexOf(vehicle) < newCollection.indexOf(vehicleToCompare)) {
                newCollection.remove(vehicleToCompare);
                output = "elements are successfully removed\n";
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return "removes all elements from collection if they are lower then entered element\nsyntax: remove_lower (str - name) (int - x coord) (int - y coord) (int - engine power) (int - capacity) (optional: int - fuel consumption) (str - vehicle type)\n";
    }
}
