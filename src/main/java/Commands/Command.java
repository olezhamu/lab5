package Commands;

import utils.CollectionContainer;
import Vehicle.Vehicle;

import java.util.*;

public interface Command {
    LinkedList<Vehicle> collection = new CollectionContainer().getCollection();
    String execute();
    String toString();
}