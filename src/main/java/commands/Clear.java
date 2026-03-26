//очистить коллекцию

package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;

import java.util.LinkedList;

public class Clear implements Command{
    @Override
    public String execute(String argument) {
        CollectionContainer.setCollection(new LinkedList<Vehicle>());
        return "collection successfully cleared\n";
    }

    @Override
    public String toString() {
        return "clears collection";
    }
}
