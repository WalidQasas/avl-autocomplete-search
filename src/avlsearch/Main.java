package avlsearch;

public class Main {

	public static void main(String[] args) {
		
		AVLTree tree = new AVLTree();

	    tree.insert("c");
	    tree.insert("b");
	    tree.insert("a"); // this should trigger rotation

	    tree.insert("d");
	    tree.insert("e");

		System.out.println("Insertions Completed!");
	}
	
}
