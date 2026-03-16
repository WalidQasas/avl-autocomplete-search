package avlsearch;

public class AutocompleteEngine {

    private AVLTree tree;

    public AutocompleteEngine() {
        tree = new AVLTree();
    }

    public void addWord(String word) {
        tree.insert(word);
    }

    public void search(String prefix) {
        System.out.println("suggestion for: " + prefix);
        tree.searchPrefix(prefix);
    }
}