//очистить коллекцию

package Commands;

import Utils.CollectionContainer;
import Vehicle.Vehicle;

import java.util.LinkedList;

public class Clear implements Command{
    public Clear(){}

    @Override
    public String execute() {
        new CollectionContainer().setCollection(new LinkedList<Vehicle>());
        return "collection successfully cleared\n";
    }

    @Override
    public String toString() {
        return "clears collection";
    }
}
