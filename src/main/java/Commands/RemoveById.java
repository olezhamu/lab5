//удалить элемент из коллекции по его id

package Commands;

import Utils.CollectionContainer;
import Vehicle.Vehicle;

import java.util.function.Predicate;


public class RemoveById implements Command{
    private Integer id;

    public RemoveById(Integer id){
        this.id = id;
    }

    @Override
    public String execute() {
        for (Vehicle vehicle : collection) {
            if (id == vehicle.getId()){
                collection.remove(vehicle);
                break;
            }
        }
        return "element successfully removed";
    }

    @Override
    public String toString() {
        return "removes element from collection by it's id";
    }
}
