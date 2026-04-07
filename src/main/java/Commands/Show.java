//вывести в стандартный поток вывода все элементы коллекции в строковом представлении

package Commands;

import Vehicle.Vehicle;

public class Show implements Command{
    public Show(){}

    @Override
    public String execute() {
        String output = "";
        for (Vehicle vehicle : collection) {
            output += vehicle.getInfo() + "\n";
        }
        return output;
    }

    @Override
    public String toString() {
        return "shows all elements of collection";
    }
}
