package TreeProbs;

import BuildTree.*;

public class RecoverBinarySearchTree {

    TreeNode first = null, second = null, pred = null;
    public TreeNode recover(TreeNode root) {
        recoverTree(root);
        int temp = first.key;
        first.key = second.key;
        second.key = temp;
        return root;
    }

    private void recoverTree(TreeNode node) {
        if (node == null) return;
        recoverTree(node.left);
        if (first == null && pred != null && pred.key > node.key) {
            first = pred;
        }
        if (first != null && pred.key > node.key) {
            second = node;
        }
        pred = node;
        recoverTree(node.right);
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree s = new RecoverBinarySearchTree();
        LevelOrderTree b = new LevelOrderTree();
        TreeNode root = b.buildTreeInLevelOrder(new String[]{"4", "2", "6", "1","5","3","7"});
        TreeNode result = s.recover(root);
        b.printLevelOrderTree(result);

    }
}
