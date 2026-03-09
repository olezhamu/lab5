package Utils;

public class IdContainer {
    private static int counter = 0;
    private final int id;

    public IdContainer() {  // Правильный конструктор
        counter++;
        this.id = counter;
    }

    public int getId() {
        return this.id;
    }
}