//вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)

package Commands;

import Utils.CollectionContainer;
import Vehicle.Vehicle;

import java.util.LinkedList;

public class Info implements Command{
    public Info(){}

    @Override
    public String execute() {
        String output = "vehicle, ";
        //output += (string) collection.getCreationDate() + ", ";
        output += collection.size() + "";
        return output + "\n";
    }

    @Override
    public String toString() {
        return "shows information about collection";
    }
}
