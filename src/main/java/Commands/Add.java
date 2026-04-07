//добавить новый элемент в коллекцию

package Commands;

import Vehicle.Vehicle;

public class Add implements Command {
    private Vehicle vehicle;

    public Add(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    @Override
    public String execute() {
        collection.add(vehicle);
        return "element successfully added\n";
    }

    @Override
    public String toString() {
        return "adds new element to collection";
    }
}
