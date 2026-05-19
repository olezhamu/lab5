//вывести уникальные значения поля enginePower всех элементов в коллекции

package serverCommands;

import vehicle.Vehicle;

import java.util.*;

public class PrintUniqueEnginePower implements ServerCommand{
    List<Vehicle> collection;

    public PrintUniqueEnginePower(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            List<Long> enginePowers = new ArrayList<>();
            String uniqueEnginePowers = "";
            for (Vehicle vehicle : collection) {
                enginePowers.add(vehicle.getEnginePower());
            }
            for (Long enginePower : enginePowers) {
                if (enginePowers.indexOf(enginePower) == enginePowers.lastIndexOf(enginePower)) {
                    uniqueEnginePowers += enginePower + " ";
                } else {
                    continue;
                }
            }
            output.add(true);
            output.add(uniqueEnginePowers + "\n");
        }catch (Exception e){
            output.add(false);
            output.add("could not get engine powers");
        }

        return output;
    }

    @Override
    public String toString() {
        return "shows unique elements of enginePower field\n";
    }
}
