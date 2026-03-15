package avlsearch;

public class AVLTree {

    private AVLNode root;

    public AVLTree() {
        root = null;
    }

    // Insert method
    public void insert(String word) {
        root = insert(root, word);
    }

    // Internal recursive insert
    private AVLNode insert(AVLNode node, String word) {
        // TODO implement the insertion logic
        return node;
    }

    // Height helper
    private int height(AVLNode node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // Balance factor
    private int getBalance(AVLNode node) {
        if (node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    // Right rotation
    private AVLNode rotateRight(AVLNode y) {
        // TODO
        return y;
    }

    // Left rotation
    private AVLNode rotateLeft(AVLNode x) {
        // TODO
        return x;
    }
}