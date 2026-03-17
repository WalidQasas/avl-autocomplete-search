package avlsearch;

public class BSTTree implements MyTree{

    private BSTNode root;
    @Override
    public void insert(String word) {
        root = insert(root, word);
    }

    private BSTNode insert(BSTNode node, String word) {

        if (node == null)
            return new BSTNode(word);

        if (word.compareTo(node.word) < 0)
            node.left = insert(node.left, word);
        else if (word.compareTo(node.word) > 0)
            node.right = insert(node.right, word);

        return node;
    }
    @Override
    public void searchPrefix(String prefix) {
        searchPrefix(root, prefix);
    }

    private void searchPrefix(BSTNode node, String prefix) {
        if (node == null) return;

        searchPrefix(node.left, prefix);

        if (node.word.startsWith(prefix)) {
            System.out.println(node.word);
        }

        searchPrefix(node.right, prefix);
    }
}