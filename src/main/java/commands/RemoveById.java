//удалить элемент из коллекции по его id

package commands;

import vehicle.Vehicle;


public class RemoveById implements Command{
    @Override
    public String execute(String argument) {
        Integer id = Integer.valueOf(argument);
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
        return "removes element from collection by it's id\nsyntax: remove_by_id (int - id)\n";
    }
}
