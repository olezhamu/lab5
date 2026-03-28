package managers;

import utils.CollectionContainer;
import vehicle.Vehicle;
import vehicle.VehicleParser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
    private final VehicleParser vehicleParser;

    public FileManager() {
        this.vehicleParser = new VehicleParser();
    }

    public List<String> readCommands(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + fileName);
        }
        return Files.lines(path).map(String::trim).filter(line -> !line.isEmpty()).collect(Collectors.toList());
    }

    public void readCollection(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + fileName);
        }

        LinkedList<Vehicle> collection = new LinkedList<>();

        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(path.toFile()));
             BufferedReader bufferedReader = new BufferedReader(reader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                Vehicle vehicle = vehicleParser.parse(line);
                collection.add(vehicle);
            }
        }
        new CollectionContainer().setCollection(collection);
    }

    public void writeCollection(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }

        LinkedList<Vehicle> collection = new CollectionContainer().getCollection();
        if (collection == null) {
            throw new IllegalStateException("Коллекция не инициализирована");
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(path.toFile()))) {
            for (Vehicle vehicle : collection) {
                writer.println(vehicle.toData());
            }
        }
    }
}