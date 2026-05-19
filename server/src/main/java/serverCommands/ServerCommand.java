package serverCommands;

import java.io.IOException;
import java.util.List;

public interface ServerCommand {
    List<Object> execute(Object arg) throws IOException;
    String toString();
}