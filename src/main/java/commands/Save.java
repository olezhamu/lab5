//сохранить коллекцию в файл

package commands;

import managers.FileManager;

import java.io.IOException;

public class Save implements Command{
    public Save(){}

    @Override
    public String execute(String argument) throws IOException {
        String fileName = argument;
        new FileManager().writeCollection(fileName);
        return "collection successfully saved\n";
    }

    @Override
    public String toString() {
        return "saves collection to file\n";
    }
}
