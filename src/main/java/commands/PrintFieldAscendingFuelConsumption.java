//вывести значения поля fuelConsumption всех элементов в порядке возрастания

package commands;

import vehicle.Vehicle;

import java.util.*;
import java.util.Comparator;

public class PrintFieldAscendingFuelConsumption implements Command{
    @Override
    public String execute(String argument) {
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
        return "shows values of fuelConsumption field in lower-to-higher order\nsyntax: print_field_ascending_fuel_consumption\n";
    }
}
