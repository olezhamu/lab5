//считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
// в котором их вводит пользователь в интерактивном режиме.

package clientCommands;

import client.Client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ExecuteScript implements ClientCommand{

    @Override
    public Object execute(String argument) throws IOException {
        String fileName = argument.trim();
        List<String> lines = new LinkedList<>();

        lines.add(fileName);

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            lines.add(String.valueOf(bufferedReader.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList())));
        } catch (Exception e) {
            Client.println("file doesn't exist");
            return null;
        }

        return lines;
    }

    @Override
    public String toString() {
        return "executes script from file\n";
    }
}
