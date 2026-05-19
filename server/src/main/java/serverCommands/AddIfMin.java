//добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции

package serverCommands;

import utils.CollectionContainer;
import vehicle.Vehicle;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AddIfMin implements ServerCommand{
    List<Vehicle> collection;

    public AddIfMin(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) throws IOException {
        List<Object> output = new LinkedList<>();

        try {
            Vehicle vehicle = (Vehicle) arg;

            LinkedList<Vehicle> collection1 = CollectionContainer.getCollection();
            collection1.add(vehicle);
            LinkedList<Vehicle> collection2 = new CollectionContainer().sortCollection(collection1);
            if (collection2.indexOf(vehicle) == collection2.size() - 1) {
                output.add(true);
                output.add("element successfully added\n");
            } else {
                collection.remove(vehicle);
                output.add(true);
                output.add("this vehicle can't be added because it is not lowest\n");
            }
        }catch (Exception e){
            output.add(false);
            output.add("this vehicle can't be added\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "adds element to collection if it's value lower then value of minimal element of collection\n";
    }
}
