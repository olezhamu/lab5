//вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)

package serverCommands;

import utils.CollectionContainer;
import vehicle.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Info implements ServerCommand{
    List<Vehicle> collection;

    public Info(LinkedList<Vehicle> collection){this.collection = collection;}

    @Override
    public List<Object> execute(Object arg) {
        List<Object> output = new LinkedList<>();

        try {
            String info = "vehicle, LinkedList, ";
            String cD = new CollectionContainer().getCreationDate() + "";
            info += cD + ", ";
            info += collection.size() + "";
            output.add(true);
            output.add(info + "\n");
        }catch (Exception e) {
            output.add(false);
            output.add("could not get information about collection\n");
        }

        return output;
    }

    @Override
    public String toString() {
        return "shows information about collection\n";
    }
}
