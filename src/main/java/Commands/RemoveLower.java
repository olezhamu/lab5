//удалить из коллекции все элементы, меньшие, чем заданный

package Commands;

import utils.CollectionContainer;
import Vehicle.Vehicle;

import java.util.LinkedList;

public class RemoveLower implements Command{
    public Vehicle vehicle;

    public RemoveLower(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String execute() {
        String output = "there aren't any lower elements";
        LinkedList<Vehicle> newCollection = new CollectionContainer().sortCollection(collection);
        for (Vehicle vehicleToCompare : collection) {
            if (newCollection.indexOf(vehicle) < newCollection.indexOf(vehicleToCompare)) {
                newCollection.remove(vehicleToCompare);
                output = "elements are successfully removed";
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return "removes all elements from collection if they are lower then entered element";
    }
}
