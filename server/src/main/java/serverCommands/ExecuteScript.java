package serverCommands;

import dto.CommandRequest;
import dto.CommandResponse;
import managers.ServerFileManager;
import managers.ServerCommandManager;
import vehicle.Vehicle;
import vehicle.VehicleParser;

import java.io.IOException;
import java.util.*;

public class ExecuteScript implements ServerCommand {
    private static final Set<String> executingFiles = new HashSet<>();
    private final ServerCommandManager registry = new ServerCommandManager();

    public ExecuteScript(){}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        //try{
        List<String> lines = Collections.singletonList((String) arg);
        String fileName = lines.get(0);
        lines.remove(0);

        if (executingFiles.contains(fileName)) {
            output.add(false);
            output.add("recursion: file '" + fileName + "' is already being executed\n");
            return output;
        }
        executingFiles.add(fileName);

        try {
            List<String> rawLines = new ServerFileManager().readCommands(fileName);
            List<String> commandLines = collapseCommands(rawLines);

            for (String cmdLine : commandLines) {
                CommandRequest cmdRequest = parseCommandLine(cmdLine);
                if (cmdRequest == null) {
                    output.add(false);
                    output.add("failed to parse command: " + cmdLine + "\n");
                    return output;
                }
                CommandResponse response = registry.executeCommand(cmdRequest);
                if (!response.isSuccess()) {
                    output.add(false);
                    output.add("script failed at: " + cmdLine + " -> " + response.getMessage() + "\n");
                    return output;
                }
            }
            output.add(true);
            output.add("script executed successfully");
        } catch (IOException e) {
            output.add(false);
            output.add("failed to read script file: " + e.getMessage() + "\n");
        }

        return output;
    }

    private List<String> collapseCommands(List<String> lines) {
        Set<String> multiLine = new HashSet<>(Arrays.asList("add", "add_if_min", "removeGrater", "removeLower"));
        Set<String> singleLine = new HashSet<>(Arrays.asList(
                "clear", "execute_script", "exit", "filter_by_capacity", "help", "info",
                "print_field_ascending_fuel_consumption", "print_unique_engine_power",
                "remove_by_id", "save", "show", "update"
        ));

        List<String> result = new ArrayList<>();
        StringBuilder current = null;

        for (String line : lines) {
            String trimmed = line.trim();
            if (multiLine.contains(trimmed)) {
                if (current != null) result.add(current.toString().trim());
                current = new StringBuilder(trimmed);
            } else if (singleLine.contains(trimmed) || trimmed.startsWith("update")) {
                if (current != null) {
                    result.add(current.toString().trim());
                    current = null;
                }
                result.add(trimmed);
            } else if (current != null) {
                current.append(" ").append(trimmed);
            } else {
                result.add(trimmed);
            }
        }
        if (current != null) result.add(current.toString().trim());
        return result;
    }

    private CommandRequest parseCommandLine(String cmdLine) {
        String[] parts = cmdLine.trim().split("\\s+", 2);
        String cmdName = parts[0].toLowerCase();
        String argStr = parts.length > 1 ? parts[1] : "";

        try {
            switch (cmdName) {
                case "add":
                case "add_if_min":
                case "remove_grater":
                case "remove_lower":
                    Vehicle v = VehicleParser.parse(argStr);
                    return new CommandRequest(cmdName, v);
                case "update":
                    String[] upParts = argStr.split("\\s+", 2);
                    if (upParts.length < 2) throw new IllegalArgumentException();
                    Integer id = Integer.parseInt(upParts[0]);
                    Vehicle updV = VehicleParser.parse(upParts[1]);
                    updV.setId(id);
                    return new CommandRequest(cmdName, new Object[]{id, updV});
                case "remove_by_id":
                case "filter_by_capacity":
                    long num = Long.parseLong(argStr);
                    return new CommandRequest(cmdName, num);
                case "show":
                case "info":
                case "clear":
                case "print_field_ascending_fuel_consumption":
                case "print_unique_engine_power":
                case "save":
                case "execute_script":
                    return new CommandRequest(cmdName, argStr.isEmpty() ? null : argStr);
                default:
                    return null;
            }
        } catch (Exception e) {
            System.err.println("Parse error in script: " + cmdLine + " - " + e.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "executes script from file\n";
    }
}