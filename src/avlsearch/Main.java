package avlsearch;

public class Main {

	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();

		tree.insert("dog");
		tree.insert("cat");
		tree.insert("apple");
		tree.insert("zebra");
		
		System.out.println("Insertions Completed!");
	}
	
}
