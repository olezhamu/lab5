package managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleManager {
    private final BufferedReader reader;
    private boolean isRunning;

    public ConsoleManager() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
        this.isRunning = true;
    }

    public void start() throws IOException {
        while (isRunning) {
            System.out.print("> ");
            String input = readLine();
            if (input == null) {
                // Достигнут конец ввода (Ctrl+D / Ctrl+Z)
                break;
            }
            if (input.trim().isEmpty()) {
                continue;
            }
            new CommandManager().executeCommand(input);
        }
    }

    public String readLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Ошибка чтения ввода: " + e.getMessage());
            return null;
        }
    }

    public void stop() {
        isRunning = false;
    }
}