package avlsearch;

import java.util.ArrayList;
import java.util.List;

public class ExperimentRunner {

	public static void runExperiment(String searchTerm, int numWords, boolean bstWorstCase) {
	    System.out.println("----------------------------------");
	    System.out.println("Words inserted: " + numWords);

	    List<String> words;
	    
	    if (bstWorstCase) {
	        // Use sorted words for worst case scenario for BST
	        words = generateSortedWords(numWords);
	    } else {
	        // Use random words as usual
	        words = generateRandomWords(numWords, 5);
	    }

	    AutocompleteEngine avlEngine = new AutocompleteEngine("AVL");
	    AutocompleteEngine bstEngine = new AutocompleteEngine("BST");
	    
	    System.out.println("Starting experiment 1 with AVL-based Autocomlete Engine");

	    // AVL Tree
	    long start = System.nanoTime();
	    for (String word : words) {
	    	avlEngine.addWord(word);
	    }
	    long end = System.nanoTime();
	    double avlInsertTime = (end - start) / 1_000_000.0;

	    // Search in AVL
	    start = System.nanoTime();
	    avlEngine.search(searchTerm);
	    end = System.nanoTime();
	    double avlSearchTime = (end - start) / 1_000_000.0;
	    
	    System.out.println("insertion time: " + avlInsertTime + " ms");
	    System.out.println("search time: " + avlSearchTime + " ms");
	    
	    System.out.println("Starting experiment 2 with BST-based Autocomlete Engine");
	    // BST Tree
	    start = System.nanoTime();
	    for (String word : words) {
	    	bstEngine.addWord(word);
	    }
	    end = System.nanoTime();
	    double bstInsertTime = (end - start) / 1_000_000.0;

	    // Search in BST
	    start = System.nanoTime();
	    bstEngine.search(searchTerm);
	    end = System.nanoTime();
	    double bstSearchTime = (end - start) / 1_000_000.0;

	    System.out.println("insertion time: " + bstInsertTime + " ms");
	    System.out.println("search time: " + bstSearchTime + " ms");
	}

    // Helper to generate random lowercase words of given length
    private static List<String> generateRandomWords(int count, int length) {
        List<String> words = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            words.add(randomWord(length));
        }
        return words;
    }
    
    // Helper for simulating the worst case scenario for BST
    public static List<String> generateSortedWords(int n) {
        List<String> words = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            words.add(String.format("word%05d", i)); // word00000, word00001, etc.
        }
        return words;
    }

    private static String randomWord(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = (char) ('a' + (int) (Math.random() * 26));
            sb.append(c);
        }
        return sb.toString();
    }
}