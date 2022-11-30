package BinaryTree;

public class MaxDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        return recursion(root, 0);
    }
    public int recursion(TreeNode node, int ans) {
        if(node == null)
            return ans;
        int left = recursion(node.left, ans+1);
        int right = recursion(node.right, ans+1);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE MAX DEPTH OF A BINARY TREE, MEANING THE VERTICAL HEIGHT OF BINARY TREE
         *
         * WE WILL USE RECURSION, FOR THIS AT EVERY STAGE WE WILL EVALUATE THE LEFT AND RIGHT OF A NODE, AND WILL RETURN
         * THE MAX OF IT, ALSO WHILE PASSING RECURSION WE ARE PASSING ANS+1, +1 IS FOR CURRENT LEVEL.
         */
    }
}
