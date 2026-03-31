package Utils;

import Commands.*;
import Vehicle.*;

import java.util.HashMap;

public class CommandContainer {
    private static HashMap<String, Command> commandContainer = new HashMap<String, Command>();
    private Vehicle vehicle = new Vehicle("vehicle", 1, 1, 1, 1, 1, VehicleType.HELICOPTER);

    public static HashMap<String, Command> getCommandContainer() {
        commandContainer.put("help", new Help());
        commandContainer.put("info", new Info());
        commandContainer.put("show", new Show());
        commandContainer.put("add", new Add());
        commandContainer.put("update", new Update());
        commandContainer.put("remove_by_id", new RemoveById());
        commandContainer.put("clear", new Clear());
        commandContainer.put("save", new Save());
        commandContainer.put("execute_script", new ExecuteScript());
        commandContainer.put("exit", new Exit());
        commandContainer.put("add_if_min {element}", new AddIfMin(vehicle));
        commandContainer.put("remove_grater {element}", new RemoveGrater(vehicle));
        commandContainer.put("remove_lower {element}", new RemoveLower(vehicle));
        commandContainer.put("filter_by_capacity capacity", new FilterByCapacity(vehicle.getCapacity()));
        commandContainer.put("print_unique_engine_power", new PrintUniqueEnginePower());
        commandContainer.put("print_field_ascending_fuel_consumption ", new PrintFieldAscendingFuelConsumption());
    }

    public static HashMap<String, Command> getCommandContainer() {
        return commandContainer;
    }
}
