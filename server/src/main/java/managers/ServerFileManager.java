package managers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import vehicle.Vehicle;
import utils.CollectionContainer;
import vehicle.VehicleDeserializer;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class ServerFileManager {
    private final ObjectMapper objectMapper;

    public ServerFileManager() {
        this.objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(new SimpleModule().addDeserializer(Vehicle.class, new VehicleDeserializer()));
    }

    public List<String> readCommands(String fileName) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName));
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            return bufferedReader.lines()
                    .map(String::trim)
                    .filter(line -> !line.isEmpty())
                    .collect(Collectors.toList());
        } catch (Exception e) {
            return Collections.singletonList("file doesn't exist");
        }
    }

    public Boolean readCollection(String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            CollectionContainer.setCollection(new LinkedList<>());
            return false;
        }

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(file))) {
            ArrayList<Vehicle> collection = objectMapper.readValue(reader, new TypeReference<ArrayList<Vehicle>>() {});
            CollectionContainer.setCollection(new LinkedList<>(collection));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Boolean writeCollection(String fileName) throws IOException {
        Collection<Vehicle> collection = new CollectionContainer().getCollection();
        File file = new File(fileName);
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
            objectMapper.writeValue(writer, collection);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}