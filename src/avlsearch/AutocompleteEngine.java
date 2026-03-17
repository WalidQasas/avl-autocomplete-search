package avlsearch;

public class AutocompleteEngine {
	// let the AutocompleteEngine do the heavy lifting 
	// we want to compare using a BSTTree v.s. AVLTree
    private MyTree tree;
    
    public AutocompleteEngine(String treeType) {
    	if (treeType == "AVL") 
    		tree = new AVLTree();
    	else
    		tree = new BSTTree();
    }

    public void addWord(String word) {
        tree.insert(word);
    }

    public void search(String prefix) {
        System.out.println("suggestion for: " + prefix);
        tree.searchPrefix(prefix);
    }
}