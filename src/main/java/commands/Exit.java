//завершить программу (без сохранения в файл)

package commands;

public class Exit implements Command{
    @Override
    public String execute(String argument) {

        return "bye! ;p";
    }

    @Override
    public String toString() {
        return "exits program without saving\nsyntax: exit\n";
    }
}
