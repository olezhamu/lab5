//обновить значение элемента коллекции, id которого равен заданному

package Commands;

import Vehicle.Vehicle;

import java.util.*;

public class Update implements Command{
    private Integer id;
    private Vehicle vehicle;

    public Update(Integer id, Vehicle vehicle) {
        this.id = id;
        try {this.vehicle = vehicle;} catch (Exception e) {throw new CommandParameterException("update id", "vehicle");}
    }

    @Override
    public String execute() {
        LinkedList<Vehicle> newCollection = new LinkedList<Vehicle>();
        for (Vehicle vehicle1 : collection) {
            if (vehicle1.getId() == id) {
                newCollection.add(vehicle);
            } else {newCollection.add(vehicle1);}
        }
        return "element successfully updated";
    }

    @Override
    public String toString() {
        return "updates value of element by it's id";
    }
}
