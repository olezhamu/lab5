//вывести значения поля fuelConsumption всех элементов в порядке возрастания

package serverCommands;

import vehicle.Vehicle;

import java.util.*;
import java.util.Comparator;

public class PrintFieldAscendingFuelConsumption implements ServerCommand{
    List<Vehicle> collection;

    public PrintFieldAscendingFuelConsumption(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            List<Double> fuelConsumptions = new ArrayList<>();
            String listFuelConsumptions = "";
            for (Vehicle vehicle : collection) {
                fuelConsumptions.add(vehicle.getFuelConsumption());
            }
            fuelConsumptions.sort(Comparator.naturalOrder());
            for (Double fuelConsumption : fuelConsumptions) {
                listFuelConsumptions += fuelConsumption + " ";
            }
            listFuelConsumptions += "\n";
            output.add(true);
            output.add(listFuelConsumptions);
        } catch (Exception e){
            output.add(false);
            output.add("could not get fuel consumptions\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "shows values of fuelConsumption field in lower-to-higher order\n";
    }
}
