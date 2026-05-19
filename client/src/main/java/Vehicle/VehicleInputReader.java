package Vehicle;

import client.Client;
import vehicle.Builder;
import vehicle.Vehicle;
import vehicle.VehicleType;

import java.io.Serializable;
import java.io.IOException;

public class VehicleInputReader implements Serializable{
    
    public VehicleInputReader() throws IOException {}

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
            String input = Client.readLine("write name (String): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                Client.println("error: name can't be empty");
                continue;
            }
            return input;
        }
    }

    private Double readX() {
        while (true) {
            String input = Client.readLine("write X coordinate (Double): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                Client.println("error: X can't be empty");
                continue;
            }
            try {
                Double x = Double.parseDouble(input);
                return x;
            } catch (NumberFormatException e) {
                Client.println("error: write number correctly");
            }
        }
    }

    private double readY() {
        while (true) {
            String input = Client.readLine("write Y coordinate (double): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                Client.println("error: Y can't be empty");
                continue;
            }
            try {
                double y = Double.parseDouble(input);
                return y;
            } catch (NumberFormatException e) {
                Client.println("error: write number correctly");
            }
        }
    }

    private long readEnginePower() {
        while (true) {
            String input = Client.readLine("write enginePower (long > 0): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                Client.println("error: enginePower can't be empty");
                continue;
            }
            try {
                long enginePower = Long.parseLong(input);
                if (enginePower <= 0) {
                    Client.println("error: enginePower must be grater then 0");
                    continue;
                }
                return enginePower;
            } catch (NumberFormatException e) {
                Client.println("error: write number correctly");
            }
        }
    }

    private long readCapacity() {
        while (true) {
            String input = Client.readLine("write capacity (long > 0): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                Client.println("error: capacity can't be empty");
                continue;
            }
            try {
                long capacity = Long.parseLong(input);
                if (capacity <= 0) {
                    Client.println("error: capacity must be grater then 0");
                    continue;
                }
                return capacity;
            } catch (NumberFormatException e) {
                Client.println("error: write number correctly");
            }
        }
    }

    private Double readFuelConsumption() {
        while (true) {
            String input = Client.readLine("write fuelConsumption (Double > 0, or empty input for null): ");
            if (input == null) continue;
            input = input.trim();
            if (input.isEmpty()) {
                return null;
            }
            try {
                double fuelConsumption = Double.parseDouble(input);
                if (fuelConsumption <= 0) {
                    Client.println("error: fuelConsumption must be grater then 0");
                    continue;
                }
                return fuelConsumption;
            } catch (NumberFormatException e) {
                Client.println("error: write number correctly");
            }
        }
    }

    private VehicleType readVehicleType() {
        String types = "";
        for (VehicleType type : VehicleType.values()) {
            types += type.getType() + "/";
        }

            while (true) {
                String input = Client.readLine("write type from list (" + types + "): ");
                if (input == null) continue;
                input = input.trim();
                if (input.isEmpty()) {
                    Client.println("error: type can't be empty");
                    continue;
                }
                try {
                    return VehicleType.valueOf(input.toUpperCase());
                } catch (IllegalArgumentException e) {
                    Client.println("error: '" + input + "' is incorrect type");
                }
            }
        }
    }