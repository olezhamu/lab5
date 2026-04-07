//вывести элементы, значение поля capacity которых равно заданному

package commands;

import vehicle.Vehicle;

public class FilterByCapacity implements Command{
    public FilterByCapacity(){}

    @Override
    public String execute(String argument) {
        try {
            long capacity = Long.parseLong(argument);
            String output = "this elements have capacity that equal to entered:\n";
            for (Vehicle vehicle : collection) {
                if (vehicle.getCapacity() == capacity) {
                    output += vehicle.getName() + "\n";
                }
            }
            return output;
        } catch (NumberFormatException e) {
            return "wrong format of capacity. must be long";
        }
    }

    @Override
    public String toString() {
        return "shows all elements which capacity equals entered capacity\n";
    }
}
