//считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде,
// в котором их вводит пользователь в интерактивном режиме.

package Commands;

public class ExecuteScript implements Command{
    private String fileName;

    public ExecuteScript(String fileName){
        this.fileName = fileName;
    }

    @Override
    public String execute() {
        String output = "";
        return output;
    }

    @Override
    public String toString() {
        return "executes script from file";
    }
}
