//добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции

package Commands;

import utils.CollectionContainer;
import Vehicle.Vehicle;

import java.util.LinkedList;

public class AddIfMin implements Command {
    private Vehicle vehicle;

    public AddIfMin(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String execute() {
        String output = "this vehicle can't be added\n";
        LinkedList<Vehicle> collection1 = new CollectionContainer().getCollection();
        collection1.add(vehicle);
        LinkedList<Vehicle> collection2 = new CollectionContainer().sortCollection(collection1);
        if (collection2.indexOf(vehicle) == collection2.size()-1) {
            collection.add(vehicle);
            output = "element successfully added\n";
        }
        return output;
    }

    @Override
    public String toString() {
        return "adds element to collection if it's value lower then value of minimal element of collection";
    }
}
