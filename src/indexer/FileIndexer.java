package indexer;

import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class FileIndexer extends IndexHandler {
    public FileIndexer() {
        super();
    }

    public void createIndex(final String fileName) throws FileNotFoundException {
        final String fullLocation = basePath + fileName;
        final File file = new File(fullLocation);
        final Scanner reader = new Scanner(file);
        while(reader.hasNextLine()){
            final String line = reader.nextLine();
            addToIndex(line, fileName);
        }
    }
    public void addToIndex(String line, String fileName) {
        for (String word : line.split("\\s+")) {
            String lowerWord = word.toLowerCase();
            lowerWord = lowerWord.replaceAll("[,.]$", "");

            List<String> fileList = invertedIndex.computeIfAbsent(lowerWord, k -> new ArrayList<>());

            if (!fileList.contains(fileName)) {
                fileList.add(fileName);
            }
        }
    }

}
