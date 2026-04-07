//вывести уникальные значения поля enginePower всех элементов в коллекции

package Commands;

import Vehicle.Vehicle;

import java.util.*;

public class PrintUniqueEnginePower implements Command{
    public PrintUniqueEnginePower(){}

    @Override
    public String execute() {
        List<Long> enginePowers = new ArrayList<Long>(0);
        String output = "";
        for (Vehicle vehicle : collection) {enginePowers.add(vehicle.getEnginePower());}
        for (Long enginePower : enginePowers) {
            if (enginePowers.indexOf(enginePower) == enginePowers.lastIndexOf(enginePower)) {
                output += enginePower + " ";
            } else {continue;}
        }
        return output + "\n";
    }

    @Override
    public String toString() {
        return "shows unique elements of enginePower field";
    }
}
