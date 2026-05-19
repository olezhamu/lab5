//вывести в стандартный поток вывода все элементы коллекции в строковом представлении

package serverCommands;

import vehicle.Vehicle;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Show implements ServerCommand{
    List<Vehicle> collection;

    public Show(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            String res = "";
            if (collection.isEmpty()) {
                res = "collection is empty\n";
            } else {
                List<Vehicle> outCollection = collection.stream().sorted(Comparator.comparing(Vehicle::getName)).toList();
                for (Vehicle vehicle : outCollection) {
                    res += vehicle.getInfo();
                }
                res += "\n";
            }
            output.add(true);
            output.add(res);
        } catch (Exception e) {
            output.add(false);
            output.add("could not show collection\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "shows all elements of collection\n";
    }
}
