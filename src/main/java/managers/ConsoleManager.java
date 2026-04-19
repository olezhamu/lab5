package managers;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class ConsoleManager {
    private static LineReader lineReader;
    private static boolean isRunning = true;

    static {
        System.setProperty("org.jline.terminal.provider", "exec");
    }


    public ConsoleManager() throws IOException {
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        this.lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                .appName("VehicleConsole")
                .build();
    }

    public void start() throws IOException {
        while (isRunning) {
            String input = readLine("> ");
            if (input == null) {
                break;
            }
            if (input.trim().isEmpty()) {
                continue;
            }
            if ("exit".equalsIgnoreCase(input.trim())) {
                println("bye! ;p");
                break;
            }

            lineReader.getHistory().add(input);

            new CommandManager().executeCommand(input);
        }
    }

    public static LineReader getReader() { return lineReader; }

    public static String readLine(String prompt) {
        try {
            return lineReader.readLine(prompt);
        } catch (UserInterruptException | EndOfFileException e) {
            return null;
        } catch (Exception e) {
            System.err.println("error reading data: " + e.getMessage());
            return null;
        }
    }

    public static void println(String output) {
        System.out.println(output);
    }

    public static void print(String output) {
        System.out.print(output);
    }

    public static void stop() {
        isRunning = false;
    }
}
