//очистить коллекцию

package serverCommands;

import vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Clear implements ServerCommand{
    List<Vehicle> collection;

    public Clear(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            collection.clear();
            output.add(true);
            output.add("collection successfully cleared\n");
        } catch (Exception e) {
            output.add(false);
            output.add("collection could not be cleared\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "clears collection\n";
    }
}
