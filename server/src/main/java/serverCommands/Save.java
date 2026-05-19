//сохранить коллекцию в файл

package serverCommands;

import managers.ServerFileManager;
import vehicle.Vehicle;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Save implements ServerCommand{
    List<Vehicle> collection;

    public Save(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) throws IOException {
        List<Object> output = new LinkedList<>();

        try {
            String fileName = (String) arg;

            new ServerFileManager().writeCollection(fileName);
            output.add(true);
            output.add("collection successfully saved\n");
        } catch (Exception e) {
            output.add(false);
            output.add("could not save collection\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "saves collection to file\n";
    }
}
