package commands;

import utils.CollectionContainer;
import vehicle.Vehicle;

import java.io.IOException;
import java.util.*;

public interface Command {
    LinkedList<Vehicle> collection = new CollectionContainer().getCollection();
    String execute(String argument) throws IOException;
    String toString();
}