//удалить из коллекции все элементы, превышающие заданный

package clientCommands;

import vehicle.Vehicle;
import Vehicle.VehicleInputReader;

import java.io.IOException;

public class RemoveGrater implements ClientCommand {
    public RemoveGrater(){}

    @Override
    public Object execute(String arg) throws IOException {
        Vehicle output = new VehicleInputReader().readVehicle();

        return output;
    }

    @Override
    public String toString() {
        return "removes all elements from collection if they are higher then entered element\n";
    }
}
