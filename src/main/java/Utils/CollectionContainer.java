package Utils;

import Vehicle.Vehicle;

import java.util.*;

public class CollectionContainer {
    private static LinkedList<Vehicle> collection = new LinkedList<>();
    private final java.time.ZonedDateTime creationDate = ZonedDateTime.now();

    public CollectionContainer() {}

    public LinkedList<Vehicle> sortCollection(LinkedList<Vehicle> newCollection){
        newCollection.sort(Comparator.comparing(Vehicle::getCreationDate)
                .thenComparing(Vehicle::getCapacity)
                .thenComparing(Vehicle::getEnginePower)
                .thenComparing(Vehicle::getName)
                .thenComparing(Vehicle::getType));
        return newCollection;
    }

    public static void setCollection(LinkedList<Vehicle> collection) {
        CollectionContainer.collection = collection;
    }

    public LinkedList<Vehicle> getCollection() {
        return collection;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }
}