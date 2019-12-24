package BuildTree;

public class InOrderTraversal {
    public static void inorderTravesal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTravesal(root.left);
        System.out.print(root.key);
        inorderTravesal(root.right);
    }
}
