package utils;

import clientCommands.*;
import vehicle.*;

import java.util.HashMap;

public class ClientCommandContainer {
    private static HashMap<String, ClientCommand> commandContainer = new HashMap<>();

    public ClientCommandContainer() {}

    public static HashMap<String, ClientCommand> getClientCommandContainer() {
        commandContainer.put("add", new Add());
        commandContainer.put("add_if_min", new AddIfMin());
        commandContainer.put("clear", new Clear());
        commandContainer.put("execute_script", new ExecuteScript());
        commandContainer.put("filter_by_capacity", new FilterByCapacity());
        commandContainer.put("help", new Help());
        commandContainer.put("info", new Info());
        commandContainer.put("print_field_ascending_fuel_consumption", new PrintFieldAscendingFuelConsumption());
        commandContainer.put("print_unique_engine_power", new PrintUniqueEnginePower());
        commandContainer.put("save", new Save());
        commandContainer.put("remove_by_id", new RemoveById());
        commandContainer.put("remove_grater", new RemoveGrater());
        commandContainer.put("remove_lower", new RemoveLower());
        commandContainer.put("show", new Show());
        commandContainer.put("update", new Update());
        return commandContainer;
    }

    public void addClientCommand(String name, ClientCommand command) {
        commandContainer.put(name, command);
    }
}
