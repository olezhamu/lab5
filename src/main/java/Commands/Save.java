//сохранить коллекцию в файл

package Commands;

public class Save implements Command{
    public Save(){}

    @Override
    public String execute() {
        return "";
    }

    @Override
    public String toString() {
        return "saves collection to file";
    }
}
