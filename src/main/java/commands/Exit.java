//завершить программу (без сохранения в файл)

package commands;

import managers.ConsoleManager;

public class Exit implements Command{
    public Exit(){}

    @Override
    public String execute(String argument) {
        ConsoleManager.stop();
        return "bye! ;p";
    }

    @Override
    public String toString() {
        return "exits program without saving\n";
    }
}
