//вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)

package commands;

import utils.CollectionContainer;

public class Info implements Command{
    @Override
    public String execute(String argument) {
        String output = "vehicle, LinkedList";
        String cD = new CollectionContainer().getCreationDate() + "";
        output += cD + ", ";
        output += collection.size() + "";
        return output + "\n";
    }

    @Override
    public String toString() {
        return "shows information about collection\nsyntax: info\n";
    }
}
