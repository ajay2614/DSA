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

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO CHECK WHETHER THE TREE IS SYMMETRIC, IT CAN ALSO BE CALLED AS MIRROR
         *
         * WE WILL SOLVE THIS USING RECURSION, PREORDER APPROACH
         *
         * SIMPLY CHECK FOR ROOT LEFT AND RIGHT ARE NOT NULL FIRST AND THEIR VALUES ARE SAME
         * AFTERWARDS, CHECK FOR ROOT LEFT LEFT AND ROOT RIGHT RIGHT
         * THE OUTER NODES BEING SAME AND THEN CHECK FOR LEFT'S RIGHT AND RIGHT'S LEFT THE INNER NODES BEING SAME.
         */
    }
}
