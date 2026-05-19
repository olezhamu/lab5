//удалить из коллекции все элементы, меньшие, чем заданный

package clientCommands;

import vehicle.Vehicle;
import Vehicle.VehicleInputReader;

import java.io.IOException;

public class RemoveLower implements ClientCommand {
    public RemoveLower(){}

    @Override
    public Object execute(String arg) throws IOException {
        Vehicle output = new VehicleInputReader().readVehicle();

        return output;
    }

    @Override
    public String toString() {
        return "removes all elements from collection if they are lower then entered element\n";
    }
}
