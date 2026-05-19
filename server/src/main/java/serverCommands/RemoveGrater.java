//удалить из коллекции все элементы, превышающие заданный

package serverCommands;

import utils.CollectionContainer;
import vehicle.Vehicle;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RemoveGrater implements ServerCommand{
    LinkedList<Vehicle> collection;

    public RemoveGrater(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) throws IOException {
        List<Object> output = new LinkedList<>();

        try {
            Vehicle vehicle = (Vehicle) arg;

            String res = "there aren't any grater elements\n";
            LinkedList<Vehicle> newCollection = new CollectionContainer().sortCollection(collection);
            for (Vehicle vehicleToCompare : collection) {
                if (newCollection.indexOf(vehicle) > newCollection.indexOf(vehicleToCompare)) {
                    newCollection.remove(vehicleToCompare);
                    res = "elements are successfully removed\n";
                }
            }
            output.add(true);
            output.add(res);
        }catch (Exception e) {
            output.add(false);
            output.add("could not remove any elements\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "removes all elements from collection if they are higher then entered element\n";
    }
}
