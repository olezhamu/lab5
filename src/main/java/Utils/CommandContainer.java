package Utils;

import commands.*;
import vehicle.*;

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
        commandContainer.put("add_if_min", new AddIfMin());
        commandContainer.put("remove_grater", new RemoveGrater());
        commandContainer.put("remove_lower", new RemoveLower());
        commandContainer.put("filter_by_capacity", new FilterByCapacity());
        commandContainer.put("print_unique_engine_power", new PrintUniqueEnginePower());
        commandContainer.put("print_field_ascending_fuel_consumption", new PrintFieldAscendingFuelConsumption());
        return commandContainer;
    }

    public void addCommand(String name, Command command) {
        commandContainer.put(name, command);
    }
}
