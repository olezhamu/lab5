package vehicle;

public class Vehicle {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long enginePower; //Значение поля должно быть больше 0
    private long capacity; //Значение поля должно быть больше 0
    private Double fuelConsumption = null; //Поле может быть null, Значение поля должно быть больше 0
    private VehicleType type; //Поле не может быть null

    public Vehicle(Builder builder) {
        id = builder.id;//id = count++;
        name = builder.name;
        coordinates = builder.coordinates;
        creationDate = builder.creationDate;
        enginePower = builder.enginePower;
        capacity = builder.capacity;
        fuelConsumption = builder.fuelConsumption;
        type = builder.type;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public java.time.ZonedDateTime getCreationDate(){
        return creationDate;
    }

    public long getCapacity() {
        return capacity;
    }

    public long getEnginePower() {
        return enginePower;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public String getType() {
        return type.getType();
    }

    public String getInfo() {
        return "id: " + id + ", name: " + name + ", coordinates: (" + coordinates.getX() + "; " + coordinates.getY() +
                "), creation date: " + creationDate + ", engine power: " + enginePower + ", fuel consumption: " +
                fuelConsumption + ", type: " + type.getType() + "\n";
    }

    public String toData() {
        String output = name + " " + coordinates.getX() + " " + coordinates.getY() + " " + enginePower + " " + capacity + " ";
        if (fuelConsumption != null) {
            output += fuelConsumption + " ";
        }
        output += type.getType();
        return output;
    }
}