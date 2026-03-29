//добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции

package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;
import vehicle.VehicleParser;

import java.util.LinkedList;

public class AddIfMin implements Command {
    public AddIfMin(){}

    @Override
    public String execute(String argument) {
        Vehicle vehicle = new VehicleParser().parse(argument);
        String output = "this vehicle can't be added\n";
        LinkedList<Vehicle> collection1 = new CollectionContainer().getCollection();
        collection1.add(vehicle);
        LinkedList<Vehicle> collection2 = new CollectionContainer().sortCollection(collection1);
        if (collection2.indexOf(vehicle) == collection2.size()-1) {
            output = "element successfully added\n";
        } else {collection.remove(vehicle);}
        return output;
    }

    @Override
    public String toString() {
        return "adds element to collection if it's value lower then value of minimal element of collection\nsyntax: add_if_min (str - name) (int - x coord) (int - y coord) (int - engine power) (int - capacity) (optional: int - fuel consumption) (str - vehicle type)\n";
    }
}
