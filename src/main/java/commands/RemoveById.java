//удалить элемент из коллекции по его id

package commands;

import vehicle.Vehicle;


public class RemoveById implements Command{
    public RemoveById(){}

    @Override
    public String execute(String argument) {
        try {
            Integer id = Integer.valueOf(argument);
            for (Vehicle vehicle : collection) {
                if (id == vehicle.getId()){
                    collection.remove(vehicle);
                    break;
                }
            }
            return "element successfully removed\n";
        } catch (NumberFormatException e) {
            return "wrong format of id. must be Integer";
        }
    }

    @Override
    public String toString() {
        return "removes element from collection by it's id\n";
    }
}
