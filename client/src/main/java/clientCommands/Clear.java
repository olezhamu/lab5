//очистить коллекцию

package clientCommands;

import vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Clear implements ClientCommand {
    public Clear(){}

    @Override
    public Object execute(String arg) {
        Object output = arg;

        return output;
    }

    @Override
    public String toString() {
        return "clears collection\n";
    }
}
