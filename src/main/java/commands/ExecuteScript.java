//считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
// в котором их вводит пользователь в интерактивном режиме.

package commands;

import managers.CommandManager;
import managers.FileManager;

import java.io.IOException;
import java.util.List;

public class ExecuteScript implements Command{
    @Override
    public String execute(String argument) throws IOException {
        String fileName = argument;
        List<String> commandsToRun = new FileManager().readCommands(fileName);
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
