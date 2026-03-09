package Utils;

import Commands.*;
import Vehicle.*;

import java.util.HashMap;

public class CommandContainer {
    private static HashMap<String, Command> commandContainer = new HashMap<String, Command>();
    private Vehicle vehicle = new Vehicle("vehicle", 1, 1, 1, 1, 1, VehicleType.HELICOPTER);

    public CommandContainer(){
        commandContainer.put("help", new Help());
        commandContainer.put("info", new Info());
        commandContainer.put("show", new Show());
        commandContainer.put("add {element}", new Add(vehicle));
        commandContainer.put("update id {element}", new Update(vehicle.getId(), vehicle));
        commandContainer.put("remove_by_id id", new RemoveById(vehicle.getId()));
        commandContainer.put("clear", new Clear());
        commandContainer.put("save", new Save());
        commandContainer.put("execute_script file_name", new ExecuteScript(null));
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
