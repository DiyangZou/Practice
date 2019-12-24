package XCIX;

import BuildTree.*;

public class ReconstructBinarySearchTreeWithLevelOrderTraversal {
    public TreeNode reconstruct(int[] level) {
        // Write your solution here
    /*
    The given sequence is not null
    There are no duplicate keys in the binary search tree
    */

        if(level.length == 0){
            return null;
        }
        TreeNode node = null;
        for(int i = 0; i < level.length; i++){
            node = build(node, level[i]);
        }
        return node;

    }

    private TreeNode build(TreeNode node, int val) {
        if (node == null) {
            TreeNode cur = new TreeNode(val);
            return cur;
        }
        if (node.key > val) {
            node.left = build(node.left, val);
        } else {
            node.right = build(node.right, val);
        }
        return node;
    }

    public static void main(String[] args) {
        ReconstructBinarySearchTreeWithLevelOrderTraversal s = new ReconstructBinarySearchTreeWithLevelOrderTraversal();
        TreeNode result = s.reconstruct(new int[]{5,3,8,1,4,11});
        BuildTree.InOrderTraversal.inorderTravesal(result);
    }
}
