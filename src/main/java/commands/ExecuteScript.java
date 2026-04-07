//считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
// в котором их вводит пользователь в интерактивном режиме.

package commands;

import managers.CommandManager;
import managers.FileManager;

import java.io.IOException;
import java.util.*;

public class ExecuteScript implements Command{
    private static final Set<String> executingFiles = new HashSet<>();

    @Override
    public String execute(String argument) throws IOException {
        String fileName = argument.trim();

        if (executingFiles.contains(fileName)) {
            throw new IOException("recursion: file '" + fileName + "' already have been executed");
        }
        executingFiles.add(fileName);

        List<String> linesFromFile = new FileManager().readCommands(fileName);
        List<String> commandsToRun = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        for (String line : linesFromFile) {
            String trimmed = line.trim();
            if (trimmed.equals("add") || trimmed.equals("add_if_min") || trimmed.equals("removeGrater") || trimmed.equals("removeLower") || trimmed.contains("update")) {
                if (current.length() > 0) {
                    commandsToRun.add(current.toString().trim());
                    current.setLength(0);
                }
                current.append(trimmed);
            } else if (trimmed.contains("clear") || trimmed.contains("execute_script") ||
                    trimmed.contains("exit") || trimmed.contains("filter_by_capacity") ||
                    trimmed.contains("help") || trimmed.contains("info") ||
                    trimmed.contains("print_field_ascending_fuel_consumption") ||
                    trimmed.contains("print_unique_engine_power") ||trimmed.contains("remove_by_id") ||
                    trimmed.contains("save") || trimmed.contains("show")){
                if (current.length() > 0) {
                    commandsToRun.add(current.toString().trim());
                    current.setLength(0);
                }
                commandsToRun.add(trimmed);
            }else {
                current.append(" ").append(trimmed);
            }
        }
        if (current.length() > 0) commandsToRun.add(current.toString().trim());

        for (String commandToRun : commandsToRun) {
            new CommandManager().executeCommand(commandToRun);
        }
        String output = "script successfully executed";
        return output;
    }

    @Override
    public String toString() {
        return "executes script from file\nsyntax: execute_script (str - file name)\n";
    }
}
