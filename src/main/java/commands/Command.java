package commands;

import managers.ConsoleManager;
import org.jline.reader.LineReader;
import utils.CollectionContainer;
import vehicle.Vehicle;

import java.io.IOException;
import java.util.*;

public interface Command {
    LinkedList<Vehicle> collection = new CollectionContainer().getCollection();
    String execute(String argument) throws IOException;
    String toString();
}