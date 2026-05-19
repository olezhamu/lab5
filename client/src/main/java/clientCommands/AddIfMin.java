//добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции

package clientCommands;

import vehicle.Vehicle;
import Vehicle.VehicleInputReader;

import java.io.IOException;

public class AddIfMin implements ClientCommand {
    public AddIfMin(){}

    @Override
    public Object execute(String arg) throws IOException {
        Vehicle output =  new VehicleInputReader().readVehicle();

        return output;
    }

    @Override
    public String toString() {
        return "adds element to collection if it's value lower then value of minimal element of collection\n";
    }
}
