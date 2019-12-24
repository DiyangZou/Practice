package AlgSprint;

import BuildTree.TreeNode;
import BuildTree.LevelOrderTree;

import java.util.*;


public class KClosestElementsinBST {
    public List<Integer> kClosestBST(TreeNode root, int target, int k) {
        // Write your solution here
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<DiffNode> pq = new PriorityQueue<>(new Comparator<DiffNode>() {
            @Override
            public int compare(DiffNode e1, DiffNode e2) {
                if (e1.diff == e2.diff) {
                    return 0;
                }
                return e1.diff > e2.diff ? -1 : 1;
            }
        });
        helper(root, target, k, pq);

        while(!pq.isEmpty()){
            result.add(pq.poll().node.key);
        }
        return result;
    }

    private void helper(TreeNode root, int target, int k, Queue<DiffNode> pq){
        if(root == null) return;
        if(pq.size() < k){
            pq.offer(new DiffNode(root, Math.abs(target-root.key)));
        }else{
            if(Math.abs(target - root.key) < pq.peek().diff){
                pq.poll();
                pq.offer(new DiffNode(root, Math.abs(target-root.key)));
            }
        }
        helper(root.left, target, k, pq);
        helper(root.right, target, k, pq);
    }

    class DiffNode{
        TreeNode node;
        int diff;

        public DiffNode(TreeNode node, int diff){
            this.node = node;
            this.diff = diff;
        }
    }

    public static void main(String[] args) {

    }
}
