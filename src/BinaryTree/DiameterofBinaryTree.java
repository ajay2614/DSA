package BinaryTree;

public class DiameterofBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int arr[] = new int[1];
        recursion(arr, root);
        return arr[0];
    }

    public int recursion(int arr[], TreeNode node) {
        if(node == null)
            return 0;
        int lh = recursion(arr, node.left);
        int rh = recursion(arr, node.right);

        arr[0] = Math.max(arr[0], lh + rh);

        return 1 + Math.max(lh,rh);
    }

    public static void main(String[] args) {
        /**
         * A DIAMETER OF A BINARY TREE IS THE MAXIMUM LENGTH BETWEEN TWO NODES.
         *
         * TO FIND THIS WE WILL USE RECURSION, WHEN NODE IS NULL RETURN 0, ELSE CHECK FOR LEFT AND RIGHT, IN BACKTRACKING
         * CHECK WHETHER THE MAX IS SMALLER THAN LEFT TREE AND RIGHT TREE, IF IT IS ADD THE VALUE OF BOTH IN THE MAX.
         *
         * RETURN 1+MAX OF LEFT OR RIGHT(DONE BECAUSE OTHERWISE IT WOULD NOT FOLLOW THE 1 PATH).
         */
    }
}
