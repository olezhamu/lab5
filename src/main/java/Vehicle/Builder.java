package Vehicle;

import java.time.ZonedDateTime;

public class Builder {
    protected Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    protected String name; //Поле не может быть null, Строка не может быть пустой
    protected Coordinates coordinates; //Поле не может быть null
    protected java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    protected long enginePower; //Значение поля должно быть больше 0
    protected long capacity; //Значение поля должно быть больше 0
    protected Double fuelConsumption = null; //Поле может быть null, Значение поля должно быть больше 0
    protected VehicleType type; //Поле не может быть null
    private static Integer count = 0;

    public Builder(String name, Double x, Double y, long enginePower, long capacity, VehicleType type) {
        this.id = count++;
        this.name = name;
        this.coordinates = new Coordinates(x, y);
        this.creationDate = ZonedDateTime.now();
        this.enginePower = enginePower;
        this.capacity = capacity;
        this.type = type;
    }

    public Double fuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return fuelConsumption;
    }

    public Vehicle build() {
        return new Vehicle(this);
    }
}