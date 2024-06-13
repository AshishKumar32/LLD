package indexer;

import java.util.*;

public class FileSearcher extends IndexHandler {
    public FileSearcher() {
        super();
    }

    public List<String> search(final String searchQuery) {
        final String query = searchQuery.toLowerCase();
        HashSet<String> filesSet = new HashSet<>();
        for (String word : query.split("\\s+")) {
            if(invertedIndex.containsKey(word)) {
                List<String> fileList = invertedIndex.get(word);
                if(filesSet.isEmpty()){
                    filesSet.addAll(fileList);
                }
                else {
                    HashSet<String> temp = new HashSet<>();
                    for(String file : fileList) {
                        if(filesSet.contains(file)){
                            temp.add(file);
                        }
                    }
                    filesSet = temp;
                }
            }
            else {
                return Collections.emptyList();
            }
        }
        return filesSet.stream().toList();
    }
}
