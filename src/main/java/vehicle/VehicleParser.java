package vehicle;

public class VehicleParser {
    public static Vehicle parse(String line) {
        String[] parts = line.split(" ");
        if ((parts.length < 6) || (parts.length > 7)) {
            throw new IllegalArgumentException("wrong number of fields, expected: name x y enginePower capacity (optional) fuelConsumption vehicleType" + parts.length);
        }

        String name = parts[0].trim();
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name can't be empty");
        }

        Double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);

        long enginePower = Long.parseLong(parts[3]);
        if (enginePower <= 0) {
            throw new IllegalArgumentException("engine power must be grater then 0");
        }

        long capacity = Long.parseLong(parts[4]);
        if (capacity <= 0) {
            throw new IllegalArgumentException("engine power must be grater then 0");
        }

        Double fuelConsumption = null;
        int partsToken = 5;
        if (parts.length == 7) {
            fuelConsumption = Double.parseDouble(parts[partsToken]);
            partsToken ++;
        }

        VehicleType vehicleType;
        try {
            vehicleType = VehicleType.valueOf(parts[partsToken].trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("unknown type, available types: " + java.util.Arrays.toString(VehicleType.values()));
        }

        return new Builder(name, x, y, enginePower, capacity, vehicleType).fuelConsumption(fuelConsumption).build();
    }
}