package managers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import utils.CollectionContainer;
import vehicle.Vehicle;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FileManager {
    private final ObjectMapper objectMapper;

    public FileManager() {
        this.objectMapper = new ObjectMapper();
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
        LinkedList<Vehicle> collection;
        if (!Files.exists(path)) {
            throw new IOException("Файл не найден: " + fileName);
        } else {
            collection = objectMapper.readValue(path.toFile(), new TypeReference<LinkedList<Vehicle>>() {});
        }
        CollectionContainer.setCollection(collection);
    }

    public void writeCollection(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        if (path.getParent() != null && !Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        objectMapper.writeValue(path.toFile(), CollectionContainer.getCollection());
    }
}