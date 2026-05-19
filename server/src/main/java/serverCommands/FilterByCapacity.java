//вывести элементы, значение поля capacity которых равно заданному

package serverCommands;

import vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class FilterByCapacity implements ServerCommand{
    List<Vehicle> collection;

    public FilterByCapacity(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            long capacity = (Long) arg;

            String listOfEqual = "this elements have capacity that equal to entered:\n";
            for (Vehicle vehicle : collection) {
                if (vehicle.getCapacity() == capacity) {
                    listOfEqual += vehicle.getName() + "\n";
                }
            }
            output.add(true);
            output.add(listOfEqual);
        } catch (Exception e) {
            output.add(false);
            output.add("could not run this command\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "shows all elements which capacity equals entered capacity\n";
    }
}
