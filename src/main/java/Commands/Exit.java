//завершить программу (без сохранения в файл)

package Commands;

public class Exit implements Command{
    public Exit(){}

    @Override
    public String execute() {
        return "";
    }

    @Override
    public String toString() {
        return "exits program without saving";
    }
}
