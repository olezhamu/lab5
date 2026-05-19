//обновить значение элемента коллекции, id которого равен заданному

package clientCommands;

import Vehicle.VehicleInputReader;

import java.io.IOException;

public class Update implements ClientCommand {
    public Update(){}

    @Override
    public Object execute(String arg) throws IOException {
        Object[] output = new Object[0];

        output[0] = Integer.parseInt(arg);
        output[1] = new VehicleInputReader().readVehicle();

        return output;
    }

    @Override
    public String toString() {
        return "updates value of element by it's id\n";
    }
}
