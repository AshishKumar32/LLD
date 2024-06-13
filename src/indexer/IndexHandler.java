package indexer;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexHandler {
    final String relativePath = "resources/index.txt";
    final String basePath = "resources/";
    public static Map<String, List<String>> invertedIndex = new HashMap<>();

    public void loadHashMap() {
        File file = new File(relativePath);
        if (!file.exists() || file.length() == 0) {
            System.out.println("File not found or empty. Initialize the file first.");
            return;
        }
        try (FileInputStream fileReader = new FileInputStream(relativePath);
             ObjectInputStream objectStream = new ObjectInputStream(fileReader)) {
            invertedIndex = (HashMap<String, List<String>>) objectStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveHashMap() {
        try (FileOutputStream fileOutput = new FileOutputStream(relativePath);
             ObjectOutputStream objectStream = new ObjectOutputStream(fileOutput)) {
            objectStream.writeObject(invertedIndex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
