import indexer.FileIndexer;
import indexer.FileSearcher;
import indexer.IndexHandler;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final FileIndexer fileIndexer = new FileIndexer();
        final FileSearcher fileSearcher = new FileSearcher();
        String searchQuery;
        System.out.println("Enter Search Query below : ");
        Scanner sc = new Scanner(System.in);
        searchQuery = sc.nextLine();
        fileIndexer.loadHashMap();
        List<String> fileList = List.of("climate change.txt", "Mental Health.txt", "storytelling.txt", "technology.txt", "tokyo.txt");
        for(String file : fileList){
            fileIndexer.createIndex(file);
        }
        fileIndexer.saveHashMap();
        List<String> results = fileSearcher.search(searchQuery);
        if(results.isEmpty()) {
            System.out.println("Search term not found");
        }
        else {
            System.out.println("Found in following files : ");
            results.forEach(System.out::println);
        }
    }
}