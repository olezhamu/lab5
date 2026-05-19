//сохранить коллекцию в файл

package clientCommands;

import client.Client;

import java.io.IOException;

public class Save implements ClientCommand {
    public Save(){}

    @Override
    public Object execute(String arg) throws IOException {
        Object output = arg;
        Client.println("this command is not available for client");

        return output;
    }

    @Override
    public String toString() {
        return "saves collection to file\n";
    }
}
