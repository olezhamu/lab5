//удалить из коллекции все элементы, превышающие заданный

package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;
import vehicle.VehicleParser;

import java.util.LinkedList;

public class RemoveGrater implements Command{
    public RemoveGrater(){}

    @Override
    public String execute(String argument) {
        Vehicle vehicle = new VehicleParser().parse(argument);
        String output = "there aren't any grater elements";
        LinkedList<Vehicle> newCollection = new CollectionContainer().sortCollection(collection);
        for (Vehicle vehicleToCompare : collection) {
            if (newCollection.indexOf(vehicle) > newCollection.indexOf(vehicleToCompare)) {
                newCollection.remove(vehicleToCompare);
                output = "elements are successfully removed";
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return "removes all elements from collection if they are higher then entered element\nsyntax: remove_grater (str - name) (int - x coord) (int - y coord) (int - engine power) (int - capacity) (optional: int - fuel consumption) (str - vehicle type)\n";
    }
}
