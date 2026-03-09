package Vehicle;

public class Coordinates {
    private Double x; //Поле не может быть null
    private double y;

    public Coordinates(Double x, double y){
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}