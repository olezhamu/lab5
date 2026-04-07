package vehicle;

import managers.ConsoleManager;

public class VehicleInputReader {
    private final ConsoleManager console = new ConsoleManager();

    public VehicleInputReader() {
    }

    public Vehicle readVehicle() {
        String name = readName();
        Double x = readX();
        double y = readY();
        long enginePower = readEnginePower();
        long capacity = readCapacity();
        Double fuelConsumption = readFuelConsumption();
        VehicleType type = readVehicleType();

        return new Builder(name, x, y, enginePower, capacity, type).fuelConsumption(fuelConsumption).build();
    }

    private String readName() {
        while (true) {
            console.print("write name (String): ");
            String input = console.readLine();
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                console.println("error: name can't be empty");
                continue;
            }
            return input;
        }
    }

    private Double readX() {
        while (true) {
            console.print("write X coordinate (Double): ");
            String input = console.readLine();
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                console.println("error: X can't be empty");
                continue;
            }
            try {
                Double x = Double.parseDouble(input);
                return x;
            } catch (NumberFormatException e) {
                console.println("error: write number correctly");
            }
        }
    }

    private double readY() {
        while (true) {
            console.print("write Y coordinate (double): ");
            String input = console.readLine();
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                console.println("error: Y can't be empty");
                continue;
            }
            try {
                double y = Double.parseDouble(input);
                return y;
            } catch (NumberFormatException e) {
                console.println("error: write number correctly");
            }
        }
    }

    private long readEnginePower() {
        while (true) {
            console.print("write enginePower (long > 0): ");
            String input = console.readLine();
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                console.println("error: enginePower can't be empty");
                continue;
            }
            try {
                long enginePower = Long.parseLong(input);
                if (enginePower <= 0) {
                    console.println("error: enginePower must be grater then 0");
                    continue;
                }
                return enginePower;
            } catch (NumberFormatException e) {
                console.println("error: write number correctly");
            }
        }
    }

    private long readCapacity() {
        while (true) {
            console.print("write capacity (long > 0): ");
            String input = console.readLine();
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                console.println("error: capacity can't be empty");
                continue;
            }
            try {
                long capacity = Long.parseLong(input);
                if (capacity <= 0) {
                    console.println("error: capacity must be grater then 0");
                    continue;
                }
                return capacity;
            } catch (NumberFormatException e) {
                console.println("error: write number correctly");
            }
        }
    }

    private Double readFuelConsumption() {
        while (true) {
            console.print("write fuelConsumption (Double > 0, or empty input for null): ");
            String input = console.readLine();
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                return null;
            }
            try {
                double fuelConsumption = Double.parseDouble(input);
                if (fuelConsumption <= 0) {
                    console.println("error: fuelConsumption must be grater then 0");
                    continue;
                }
                return fuelConsumption;
            } catch (NumberFormatException e) {
                console.println("error: write number correctly");
            }
        }
    }

    private VehicleType readVehicleType() {
        String types = "available types: ";
        for (VehicleType type : VehicleType.values()) {
            types += type.getType() + " ";
        }
            console.println(types);

            while (true) {
                console.print("write type from list: ");
                String input = console.readLine();
                if (input == null) continue;
                input = input.trim();
                if (input.isEmpty()) {
                    console.println("error: type can't be empty");
                    continue;
                }
                try {
                    return VehicleType.valueOf(input.toUpperCase());
                } catch (IllegalArgumentException e) {
                    console.println("error: '" + input + "' is incorrect type");
                }
            }
        }
    }