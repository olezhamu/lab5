package Vehicle;

public enum VehicleType {
    HELICOPTER("helicopter"),
    SUBMARINE("submarine"),
    SHIP("ship");

    private String type;

    VehicleType(String type) {this.type = type;}

    public String getType() {
        return type;
    }
}