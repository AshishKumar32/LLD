package indexer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class FileIndexer {
    private static String FILE_LOCATION = "files/";
    private HashMap<String, String> invertedIndex = new HashMap<>();

    public void createIndex(final String fileName) throws FileNotFoundException {
        final String fullLocation = FILE_LOCATION + fileName;
        final File file = new File(fullLocation);
        final Scanner reader = new Scanner(file);
        while(reader.hasNextLine()){

        }

    }
    private void addToIndex(final String line) {

    }
}
