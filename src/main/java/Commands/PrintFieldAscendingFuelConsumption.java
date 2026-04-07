//вывести значения поля fuelConsumption всех элементов в порядке возрастания

package Commands;

import Vehicle.Vehicle;

import java.util.*;
import java.util.Comparator;

public class PrintFieldAscendingFuelConsumption implements Command{
    public PrintFieldAscendingFuelConsumption(){}

    @Override
    public String execute() {
        List<Double> fuelConsumptions = new ArrayList<Double>(0);
        String output = "";
        for (Vehicle vehicle : collection) {
            fuelConsumptions.add(vehicle.getFuelConsumption());
        }
        fuelConsumptions.sort(Comparator.naturalOrder());
        for (Double fuelConsumption : fuelConsumptions){output += fuelConsumption + " ";}
        return output + "\n";
    }

    @Override
    public String toString() {
        return "shows values of fuelConsumption field in lower-to-higher order";
    }
}
