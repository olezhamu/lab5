package vehicle;

public class VehicleParser {
    public Vehicle parse(String line) {
        if (line == null || line.isEmpty()) {
            throw new IllegalArgumentException("Строка с данными не может быть пустой");
        }

        String[] tokens = line.trim().split("\\s+");
        if (tokens.length < 6) {
            throw new IllegalArgumentException("Недостаточно данных. Ожидается: name x y enginePower capacity [fuelConsumption] type");
        }
        if (tokens.length > 7) {
            throw new IllegalArgumentException("Слишком много данных. Ожидается: name x y enginePower capacity [fuelConsumption] type");
        }

        try {
            String name = tokens[0];
            double x = Integer.parseInt(tokens[1]);
            double y = Integer.parseInt(tokens[2]);
            int enginePower = Integer.parseInt(tokens[3]);
            int capacity = Integer.parseInt(tokens[4]);

            Double fuelConsumption = null;
            int tokenNumber = 5;
            if (tokens.length == 7) {
                fuelConsumption = Double.parseDouble(tokens[5]);
                tokenNumber++;
            }

            VehicleType type = VehicleType.valueOf(tokens[tokenNumber].toUpperCase());

            return new Builder(name, x, y, enginePower, capacity, type).fuelConsumption(fuelConsumption).build();

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Ошибка преобразования числа: " + e.getMessage(), e);
        } catch (Exception e) {
            throw new IllegalArgumentException("Ошибка парсинга: " + e.getMessage(), e);
        }
    }
}