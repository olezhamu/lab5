package clientCommands;

import java.io.IOException;

public interface ClientCommand {
    Object execute(String arg) throws IOException;
    String toString();
}