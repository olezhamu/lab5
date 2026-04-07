package vehicle;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class VehicleDeserializer extends JsonDeserializer<Vehicle> {
    @Override
    public Vehicle deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = parser.readValueAsTree();

        Integer id = node.get("id").asInt();
        String name = node.get("name").asText();

        Double x = node.get("coordinates").get("x").asDouble();
        Double y = node.get("coordinates").get("y").asDouble();

        long seconds = (long) node.get("creationDate").asDouble();
        int nanos = (int) ((node.get("creationDate").asDouble() - seconds) * 1_000_000_000);
        ZonedDateTime creationDate = Instant.ofEpochSecond(seconds, nanos).atZone(ZoneId.systemDefault());

        long enginePower = node.get("enginePower").asLong();
        long capacity = node.get("capacity").asLong();

        Double fuelConsumption = null;
        if (node.has("fuelConsumption") && !node.get("fuelConsumption").isNull()) {
            fuelConsumption = node.get("fuelConsumption").asDouble();
        }

        VehicleType type = VehicleType.valueOf(node.get("type").asText().toUpperCase());

        Builder builder = new Builder(name, x, y, enginePower, capacity, type).id(id).creationDate(creationDate).fuelConsumption(fuelConsumption);
        return builder.build();
    }
}