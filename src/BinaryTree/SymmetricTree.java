package BinaryTree;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return recursion(root.left, root.right);
    }

    public boolean recursion(TreeNode left, TreeNode right) {
        if(left == null || right == null)
            return left == right;
        if(left.val != right.val)
            return false;
        return recursion(left.left, right.right) && recursion(left.right, right.left);
    }
}
