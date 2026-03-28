//добавить новый элемент в коллекцию

package commands;

import vehicle.VehicleParser;

public class Add implements Command {
    public Add(){}

    @Override
    public String execute(String argument) {
        collection.add(new VehicleParser().parse(argument));
        return "element successfully added\n";
    }

    @Override
    public String toString() {
        return "adds new element to collection\nsyntax: add (str - name) (int - x coord) (int - y coord) (int - engine power) (int - capacity) (optional: int - fuel consumption) (str - vehicle type)\n";
    }
}
