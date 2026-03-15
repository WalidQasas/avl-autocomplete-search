package avlsearch;

public class AVLNode {

    String word;
    AVLNode left;
    AVLNode right;
    int height;

    public AVLNode(String word) {
        this.word = word;
        this.height = 1; // new nodes start with height = 1
    }
}
