//вывести элементы, значение поля capacity которых равно заданному

package Commands;

import Vehicle.Vehicle;

public class FilterByCapacity implements Command{
    private long capacity;

    public FilterByCapacity(long capacity) {
        this.capacity = capacity;
    }

    @Override
    public String execute() {
        String output = "this elements have capacity that equal to entered:\n";
        for (Vehicle vehicle : collection) {
            if (vehicle.getCapacity() == capacity) {
                output += vehicle.getName() + "\n";
            }
        }
        return output;
    }

    @Override
    public String toString() {
        return "shows all elements which capacity equals entered capacity";
    }
}
