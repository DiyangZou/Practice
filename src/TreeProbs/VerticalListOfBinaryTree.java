package TreeProbs;

import java.util.*;
import BuildTree.TreeNode;
import BuildTree.LevelOrderTree;
import BuildTree.InOrderTraversal;

public class VerticalListOfBinaryTree {
    public List<List<Integer>> verticalPrint(TreeNode root) {
        // Write your solution here
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] minVal = new int[]{Integer.MAX_VALUE};
        int[] maxVal = new int[]{Integer.MIN_VALUE};

        helper(root, map, 0, minVal, maxVal);
        for(int i = minVal[0]; i <= maxVal[0]; i++){
            if(map.containsKey(i)){
                result.add(map.get(i));
            }
        }
        return result;
    }

    private void helper(TreeNode root, Map<Integer, List<Integer>> map, int level, int[] min, int[] max){
        if(root == null){
            return;
        }
        min[0] = Math.min(min[0], level);
        max[0] = Math.max(max[0], level);
        if(map.containsKey(level)){
            map.get(level).add(root.key);
        }else{
            List<Integer> cur = new ArrayList<>();
            cur.add(root.key);
            map.put(level, cur);
        }
        helper(root.left, map, level-1, min, max);
        helper(root.right, map, level+1, min, max);
    }

    public static void main(String[] args) {
        VerticalListOfBinaryTree s = new VerticalListOfBinaryTree();
        LevelOrderTree btree = new LevelOrderTree();
        TreeNode root = btree.buildTreeInLevelOrder(new String[]{"5","3","7","#","4","8","#","#","#", "#","#","#","9"}); // change build func: input string[], # assumption
        List<List<Integer>> result = s.verticalPrint(root);
        BuildTree.InOrderTraversal.inorderTravesal(root);
        for(int i = 0; i < result.size(); i++){
            System.out.print(result.get(i));
        }

    }
}
