package avlsearch;

public class Main {

	public static void main(String[] args) {
		
        AutocompleteEngine engine = new AutocompleteEngine();

        engine.addWord("apple");
        engine.addWord("application");
        engine.addWord("apply");
        engine.addWord("banana");
        engine.addWord("band");
        engine.addWord("bandwidth");

        engine.search("app");
	}
	
}
