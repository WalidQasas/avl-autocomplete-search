package avlsearch;

import java.util.Random;

public class ExperimentRunner {

    public static void runExperiment(int numberOfWords) {

        AutocompleteEngine engine = new AutocompleteEngine();
        Random random = new Random();

        String[] words = new String[numberOfWords];

        // Generate random words
        for (int i = 0; i < numberOfWords; i++) {
            words[i] = generateRandomWord(random, 5);
        }

        // Measure insertion time
        long startInsert = System.nanoTime();

        for (String word : words) {
            engine.addWord(word);
        }

        long endInsert = System.nanoTime();

        // Measure search time
        long startSearch = System.nanoTime();

        engine.search("ab");   // prefix search test

        long endSearch = System.nanoTime();

        System.out.println("Words inserted: " + numberOfWords);
        System.out.println("Insertion time: " + (endInsert - startInsert) / 1_000_000 + " ms");
        System.out.println("Search time: " + (endSearch - startSearch) / 1_000_000 + " ms");
    }

    private static String generateRandomWord(Random random, int length) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < length; i++) {
            word.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return word.toString();
    }
}