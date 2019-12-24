package TreeProbs;


import BuildTree.*;

import java.util.ArrayList;
import java.util.List;

public class MaximumWidthofBinaryTree {
    public int maxWidthOfBinaryTree(TreeNode root) {
        // Write your solution here
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }

    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); end.add(order);
        }
        else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }

    public static void main(String[] args) {
        BuildTree.LevelOrderTree s = new BuildTree.LevelOrderTree();
        TreeNode tree= s.buildTreeInLevelOrder(new String[]{"1","2","3","4", "#", "#", "6"});
        MaximumWidthofBinaryTree ss = new MaximumWidthofBinaryTree();
        int result = ss.maxWidthOfBinaryTree(tree);
        System.out.print(result);

    }
}
