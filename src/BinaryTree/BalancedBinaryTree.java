package BinaryTree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return recursion(root) != -1;
    }
    public int recursion(TreeNode node) {
        if(node == null)
            return 0;
        int lh = recursion(node.left);
        int rh = recursion(node.right);

        if(lh == -1 || rh == -1)
            return -1;

        if(Math.abs(lh - rh) > 1)
            return -1;
        return 1 + Math.max(lh , rh);
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION A BINARY TREE IS BALANCED IF THE LEFT AND RIGHT CHILD DO NOT DIFFER BY MORE THAN 1 IN TERMS OF HEIGHT,
         *
         * IN THIS RATHER THAN HAVING BOOLEAN AND EVALUATE, WE WILL SIMPLY CALCULATE THE HEIGHT OF BOTH LEFT AND RIGHT, AND CHECK
         * IF THEY DIFFER BY MORE THAN 1, RETURN -1, HENCE IF ANY OF LEFT AND RIGHT IS -1, RETURN -1.
         *
         * RETURN MAX OF BOTH TREES, BECAUSE IT COULD HAPPEN SAY LEFT IS 2, AND RIGHT IS 3, HENCE WITH ROOT ANS WOULD BE 4,
         *
         * NOW IF THAT ROOT WAS RIGHT AND ON LEFT IS 2, THEN WE WILL RETURN -1, AS THEY DIFFER, THATS WHY WE TAKE MAX.
         *
         */
    }
}
