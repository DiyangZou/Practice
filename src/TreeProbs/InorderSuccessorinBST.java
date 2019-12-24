package TreeProbs;

import BuildTree.LevelOrderTree;
import BuildTree.TreeNode;

public class InorderSuccessorinBST {

    public int inOrderSuccessor(TreeNode root, int p) {
        // Write your solution here
    /*
    1. There are no duplicate values in the BST.
    2. Value of all nodes in the BST are positive integer.
    3. The given value must be in the BST.
    */
        if(root == null) return -1;

        if(root.key <= p){
            return inOrderSuccessor(root.right, p);
        }else{
            int left = inOrderSuccessor(root.left, p);
            return (left != -1) ? left : root.key;
        }
    }

    public static void main(String[] args) {
        InorderSuccessorinBST s = new InorderSuccessorinBST();
        LevelOrderTree btree = new LevelOrderTree();
        TreeNode root = btree.buildTreeInLevelOrder(new String[]{"20", "8", "22", "4", "12","#", "23", "#", "#", "10", "14"});
        btree.printLevelOrderTree(root);
        int result = s.inOrderSuccessor(root, 8);
        System.out.println("\n");
        System.out.println(result);
    }
}
