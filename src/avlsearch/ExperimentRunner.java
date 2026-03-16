package avlsearch;

import java.util.ArrayList;
import java.util.List;

public class ExperimentRunner {

	public static void runExperiment(int numWords, boolean bstWorstCase) {
	    System.out.println("----------------------------------");
	    System.out.println("Words inserted: " + numWords);

	    List<String> words;

	    if (bstWorstCase) {
	        // Use sorted words for worst case scenario for BST
	        String[] sortedWords = generateSortedWords(numWords);
	        words = new ArrayList<>();
	        for (String w : sortedWords) words.add(w);
	    } else {
	        // Use random words as usual
	        words = generateRandomWords(numWords, 5);
	    }

	    String prefix = "abc";

	    // AVL Tree
	    AVLTree avl = new AVLTree();
	    long start = System.nanoTime();
	    for (String word : words) {
	        avl.insert(word);
	    }
	    long end = System.nanoTime();
	    long avlInsertTime = (end - start) / 1_000_000;

	    // Search in AVL
	    start = System.nanoTime();
	    avl.searchPrefix(prefix);
	    end = System.nanoTime();
	    long avlSearchTime = (end - start) / 1_000_000;

	    System.out.println("AVL insertion time: " + avlInsertTime + " ms");
	    System.out.println("AVL search time: " + avlSearchTime + " ms");

	    // BST Tree
	    BSTTree bst = new BSTTree();
	    start = System.nanoTime();
	    for (String word : words) {
	        bst.insert(word);
	    }
	    end = System.nanoTime();
	    long bstInsertTime = (end - start) / 1_000_000;

	    // Search in BST
	    start = System.nanoTime();
	    bst.searchPrefix(prefix);
	    end = System.nanoTime();
	    long bstSearchTime = (end - start) / 1_000_000;

	    System.out.println("BST insertion time: " + bstInsertTime + " ms");
	    System.out.println("BST search time: " + bstSearchTime + " ms");
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
    public static String[] generateSortedWords(int n) {
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = String.format("word%05d", i); // word00000, word00001, etc.
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