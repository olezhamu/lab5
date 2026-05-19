package vehicle;

import java.io.Serializable;

public enum VehicleType implements Serializable{
    HELICOPTER("helicopter"),
    SUBMARINE("submarine"),
    SHIP("ship");

    private String type;

    VehicleType(String type) {this.type = type;}

    public String getType() {
        return type;
    }
}