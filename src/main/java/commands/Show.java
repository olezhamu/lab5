//вывести в стандартный поток вывода все элементы коллекции в строковом представлении

package commands;

import vehicle.Vehicle;

public class Show implements Command{
    public Show(){}

    @Override
    public String execute(String argument) {
        String output = "";
        for (Vehicle vehicle : collection) {
            output += vehicle.getInfo();
        }
        return output;
    }

    @Override
    public String toString() {
        return "shows all elements of collection\nsyntax: show\n";
    }
}
