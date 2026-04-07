//очистить коллекцию

package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;

import java.util.LinkedList;

public class Clear implements Command{
    public Clear(){}

    @Override
    public String execute(String argument) {
        collection.clear();
        return "collection successfully cleared\n";
    }

    @Override
    public String toString() {
        return "clears collection\n";
    }
}
