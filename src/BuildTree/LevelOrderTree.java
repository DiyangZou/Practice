package BuildTree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTree {

   public TreeNode buildTreeInLevelOrder(String[] array){
        if(array == null || array.length == 0){
            return null;
        }
        TreeNode root = buildMyTree(array, 0);
        return root;
   }

   private TreeNode buildMyTree(String[] array, int index){
       if(index >= array.length || array[index] == "#"){
           return null;
       }

       TreeNode node = new TreeNode(Integer.valueOf((array[index])));
       node.left = buildMyTree(array, index * 2 + 1);
       node.right = buildMyTree(array, index * 2 + 2);

       return node;
   }

   public void printLevelOrderTree(TreeNode root){
       Queue<TreeNode> q = new LinkedList();
       if(root != null){
           q.offer(root);
       }

       while(!q.isEmpty()){
           TreeNode cur = q.poll();
           if(cur == null){
               System.out.print("# ");
           }else {
               System.out.print(cur.key + " ");
               q.offer(cur.left);
               q.offer(cur.right);
           }
       }
   }

    public static void main(String[] args) {
        LevelOrderTree s = new LevelOrderTree();
        TreeNode result = s.buildTreeInLevelOrder(new String[]{"1","2","3","4"});
        s.printLevelOrderTree(result);

    }

}


