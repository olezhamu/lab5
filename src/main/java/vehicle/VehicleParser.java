package vehicle;

import managers.ConsoleManager;

import java.io.IOException;

public class VehicleParser {
    public static Vehicle parse(String line) throws IOException {
        String[] parts = line.split(" ");
        if ((parts.length < 6) || (parts.length > 7)) {
            ConsoleManager.println("wrong number of fields, expected: name x y enginePower capacity (optional) fuelConsumption vehicleType");
            return null;
        }

        String name = parts[0].trim();
        if (name == null || name.isEmpty()) {
            ConsoleManager.println("name can't be empty");
            return null;
        }

        Double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);

        long enginePower = Long.parseLong(parts[3]);
        if (enginePower <= 0) {
            ConsoleManager.println("engine power must be grater then 0");
            return null;
        }

        long capacity = Long.parseLong(parts[4]);
        if (capacity <= 0) {
            ConsoleManager.println("engine power must be grater then 0");
            return null;
        }

        Double fuelConsumption = null;
        int partsToken = 5;
        if (parts.length == 7) {
            fuelConsumption = Double.parseDouble(parts[partsToken]);
            if (fuelConsumption <= 0) {
                ConsoleManager.println("fuel consumption must be grater then 0");
                return null;
            }
            partsToken ++;
        }

        VehicleType vehicleType;
        try {
            vehicleType = VehicleType.valueOf(parts[partsToken].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            ConsoleManager.println("unknown type, available types: " + java.util.Arrays.toString(VehicleType.values()));
            return null;
        }

        return new Builder(name, x, y, enginePower, capacity, vehicleType).fuelConsumption(fuelConsumption).build();
    }
}