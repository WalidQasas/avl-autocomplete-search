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

        // Get bf (balance factor)
        int balance = getBalance(node);

        // LL (LEFT LEFT) case
        if (balance > 1 && word.compareTo(node.left.word) < 0)
            return rotateRight(node);

        // RR (RIGHT RIGHT) case
        if (balance < -1 && word.compareTo(node.right.word) > 0)
            return rotateLeft(node);

        // LR (LEFT RIGHT) case
        if (balance > 1 && word.compareTo(node.left.word) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // RL (RIGHT LEFT) case
        if (balance < -1 && word.compareTo(node.right.word) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

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

        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Do the rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    // Left rotation
    private AVLNode rotateLeft(AVLNode x) {

        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Do the rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }
    
    public void searchPrefix(String prefix) {
        searchPrefix(root, prefix);
    }

    private void searchPrefix(AVLNode node, String prefix) {

        if (node == null)
            return;

        // check left subtree
        searchPrefix(node.left, prefix);

        // check current word
        if (node.word.startsWith(prefix)) {
            System.out.println(node.word);
        }

        // check right subtree
        searchPrefix(node.right, prefix);
    }
}