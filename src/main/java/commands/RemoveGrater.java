//удалить из коллекции все элементы, превышающие заданный

package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;
import vehicle.VehicleParser;

import java.util.LinkedList;

public class RemoveGrater implements Command{
    @Override
    public String execute(String argument) {
        Vehicle vehicle = new VehicleParser().parse(argument);
        String output = "there aren't any grater elements";
        LinkedList<Vehicle> newCollection = CollectionContainer.sortCollection(collection);
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
        return "removes all elements from collection if they are higher then entered element";
    }
}
