//обновить значение элемента коллекции, id которого равен заданному

package serverCommands;

import vehicle.Vehicle;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Update implements ServerCommand{
    List<Vehicle> collection;

    public Update(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) throws IOException {
        List<Object> output = new LinkedList<>();

        try {
            Object[] updateArgs = (Object[]) arg;
            Integer id = (Integer) updateArgs[0];
            Vehicle vehicle = (Vehicle) updateArgs[1];

            String res = "element with entered id doesn't exist\n";
            vehicle.setId(id);
            for (Vehicle vehicleToCompare : collection) {
                if (vehicleToCompare.getId() == id) {
                    res = "element successfully updated\n";
                    collection.set(collection.indexOf(vehicleToCompare), vehicle);
                }
            }
            output.add(true);
            output.add(res);
        } catch (NumberFormatException e) {
            output.add(false);
            output.add("could not update element\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "updates value of element by it's id\n";
    }
}
