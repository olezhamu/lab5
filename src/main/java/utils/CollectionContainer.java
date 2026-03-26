package utils;

import vehicle.Vehicle;

import java.time.ZonedDateTime;
import java.util.*;

public class CollectionContainer {
    private static LinkedList<Vehicle> collection = new LinkedList<>();
    private final java.time.ZonedDateTime creationDate = ZonedDateTime.now();;

    public CollectionContainer() {}

    public static LinkedList<Vehicle> sortCollection(LinkedList<Vehicle> newCollection){
        newCollection.sort(Comparator.comparing(Vehicle::getCreationDate));
        newCollection.sort(Comparator.comparing(Vehicle::getCapacity));
        newCollection.sort(Comparator.comparing(Vehicle::getEnginePower));
        newCollection.sort(Comparator.comparing(Vehicle::getName));
        newCollection.sort(Comparator.comparing(Vehicle::getType));
        return newCollection;
    }

    public static void setCollection(LinkedList<Vehicle> collection) {
        CollectionContainer.collection = collection;
    }

    public static LinkedList<Vehicle> getCollection() {
        return CollectionContainer.collection;
    }

    public java.time.ZonedDateTime getCreationDate() {
        return creationDate;
    }
}