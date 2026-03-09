package Vehicle;

import static java.lang.Math.pow;

public class Coordinates {
    private Double x; //Поле не может быть null
    private double y;
    private Double r = pow(x*x + y*y, 0.5);

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

    public Double getR() {
        return r;
    }
}