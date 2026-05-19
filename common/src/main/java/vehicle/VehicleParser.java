package vehicle;

import java.io.Serializable;
import java.io.IOException;

public class VehicleParser implements Serializable{
    public static Vehicle parse(String line) throws IOException {
        String[] parts = line.split(" ");
        if ((parts.length < 6) || (parts.length > 7)) {
            return null;
        }

        String name = parts[0].trim();
        if (name == null || name.isEmpty()) {
            return null;
        }

        Double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);

        long enginePower = Long.parseLong(parts[3]);
        if (enginePower <= 0) {
            return null;
        }

        long capacity = Long.parseLong(parts[4]);
        if (capacity <= 0) {
            return null;
        }

        Double fuelConsumption = null;
        int partsToken = 5;
        if (parts.length == 7) {
            fuelConsumption = Double.parseDouble(parts[partsToken]);
            if (fuelConsumption <= 0) {
                return null;
            }
            partsToken ++;
        }

        VehicleType vehicleType;
        try {
            vehicleType = VehicleType.valueOf(parts[partsToken].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }

        return new Builder(name, x, y, enginePower, capacity, vehicleType).fuelConsumption(fuelConsumption).build();
    }
}