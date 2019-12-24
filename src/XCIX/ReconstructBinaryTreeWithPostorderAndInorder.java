package XCIX;

import BuildTree.*;
import BuildTree.InOrderTraversal.*;

import java.util.HashMap;
import java.util.Map;


public class ReconstructBinaryTreeWithPostorderAndInorder {

    public TreeNode reconstruct(int[] inOrder, int[] postOrder) {
        // Write your solution here
    /*
    The given sequences are not null and they have the same length
    There are no duplicate keys in the binary tree
    */
        int[] index = new int[]{postOrder.length-1};
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }
        TreeNode node = helper(inOrder, postOrder, index, 0, postOrder.length-1, map);
        return node;
    }

    private TreeNode helper(int[] in, int[] post, int[] idx, int left, int right, Map<Integer, Integer> map){
        if(left > right){
            return null;
        }
        TreeNode node = new TreeNode(post[idx[0]]);
        idx[0]--;
        if(left == right){
            return node;
        }
        int curIdx = map.get(node.key);
        node.right = helper(in, post, idx, curIdx+1, right, map);
        node.left = helper(in, post, idx, left, curIdx-1, map);
        return node;
    }

    public static void main(String[] args) {
        ReconstructBinaryTreeWithPostorderAndInorder s = new ReconstructBinaryTreeWithPostorderAndInorder();
        /*
        * postorder traversal = {1, 4, 3, 11, 8, 5}
        * inorder traversal = {1, 3, 4, 5, 8, 11}
        * */
        TreeNode result = s.reconstruct(new int[]{1, 3, 4, 5, 8, 11}, new int[]{1, 4, 3, 11, 8, 5});
       InOrderTraversal.inorderTravesal(result);
    }
}
