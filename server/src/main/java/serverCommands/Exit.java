//завершить программу (без сохранения в файл)

package serverCommands;

import vehicle.Vehicle;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Exit implements ServerCommand{
    static List<Vehicle> collection;

    public Exit(List<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) throws IOException {
        List<Object> output = new LinkedList<>();
        new Save((LinkedList<Vehicle>) collection).execute("collection");
        output.add(true);
        output.add("bye! ;p");
        return output;
    }

    @Override
    public String toString() {
        return "exits program without saving\n";
    }
}
