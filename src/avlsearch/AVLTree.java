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

        // The normal BST insertion
        if (node == null)
            return new AVLNode(word);

        if (word.compareTo(node.word) < 0)
            node.left = insert(node.left, word);
        else if (word.compareTo(node.word) > 0)
            node.right = insert(node.right, word);
        else
            return node; // duplicate words ignored

        // Update our height
        node.height = 1 + Math.max(height(node.left), height(node.right));

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