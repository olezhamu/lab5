package Utils;

import Vehicle.Vehicle;

import java.util.*;

public class CollectionContainer {
    private static LinkedList<Vehicle> collection = new LinkedList<>();
    public CollectionContainer() {}

    public LinkedList<Vehicle> sortCollection(LinkedList<Vehicle> newCollection){
        newCollection.sort(Comparator.comparing(Vehicle::getCreationDate));
        newCollection.sort(Comparator.comparing(Vehicle::getCapacity));
        newCollection.sort(Comparator.comparing(Vehicle::getEnginePower));
        newCollection.sort(Comparator.comparing(Vehicle::getName));
        newCollection.sort(Comparator.comparing(Vehicle::getType));
        return newCollection;
    }

    public void setCollection(LinkedList<Vehicle> collection) {
        CollectionContainer.collection = collection;
    }

    public LinkedList<Vehicle> getCollection() {
        return CollectionContainer.collection;
    }
}