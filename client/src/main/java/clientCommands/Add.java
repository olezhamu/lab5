//добавить новый элемент в коллекцию

package clientCommands;

import vehicle.Vehicle;
import Vehicle.VehicleInputReader;

import java.io.IOException;

public class Add implements ClientCommand {
    public Add(){}

    @Override
    public Object execute(String arg) throws IOException {
        Vehicle output =  new VehicleInputReader().readVehicle();

        return output;
    }

    @Override
    public String toString() {
        return "adds new element to collection\n";
    }
}
