//удалить элемент из коллекции по его id

package serverCommands;

import vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;


public class RemoveById implements ServerCommand{
    List<Vehicle> collection;

    public RemoveById(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            Integer id = (Integer) arg;

            for (Vehicle vehicle : collection) {
                if (id == vehicle.getId()){
                    collection.remove(vehicle);
                    break;
                }
            }
            output.add(true);
            output.add("element successfully removed\n");
        } catch (Exception e) {
            output.add(false);
            output.add("element could not be removed");
        }

        return output;
    }

    @Override
    public String toString() {
        return "removes element from collection by it's id\n";
    }
}
