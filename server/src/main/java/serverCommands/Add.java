//добавить новый элемент в коллекцию

package serverCommands;

import vehicle.Vehicle;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Add implements ServerCommand{
    List<Vehicle> collection;

    public Add(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) throws IOException {
        List<Object> output = new LinkedList<>();

        try {
            Vehicle vehicle = (Vehicle) arg;

            collection.add(vehicle);
            output.add(true);
            output.add("element successfully added\n");
        } catch (Exception e) {
            output.add(false);
            output.add("element could not be added\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "adds new element to collection\n";
    }
}
