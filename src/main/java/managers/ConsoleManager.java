package managers;

import commands.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleManager {
    private final BufferedReader reader;
    private static boolean isRunning;

    public ConsoleManager() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        isRunning = true;
    }

    public void start() throws IOException {
        while (isRunning) {
            print("> ");
            String input = readLine();
            if (input == null) {
                break;
            }
            if (input.trim().isEmpty()) {
                continue;
            }
            if (input.equals("exit")) {
                println("bye! ;p");
                break;
            }
            new CommandManager().executeCommand(input);
        }
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("error reading data: " + e.getMessage());
            return null;
        }
    }

    public void println(String output) {
        System.out.println(output);
    }

    public void print(String output) {
        System.out.print(output);
    }

    public static void stop() {
        isRunning = false;
    }
}