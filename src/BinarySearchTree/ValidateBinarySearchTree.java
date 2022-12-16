package BinarySearchTree;

public class ValidateBinarySearchTree {
    /**
     * TC : BIG O(N)
     * SC : BIG O(1)
     */
    public boolean isValidBST(TreeNode root) {
        return recursionPre(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean recursionPre(TreeNode node, long lowerBound, long upperBound) {
        if(node == null)
            return true;

        if(lowerBound >= node.val || node.val >= upperBound)
            return false;

        boolean left = recursionPre(node.left, lowerBound, node.val);
        boolean right = recursionPre(node.right, node.val, upperBound);

        return left && right;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION GIVEN A TREE WE NEED TO CHECK WHETHER IT'S A VALID BST OR NOT
         *
         * WE WILL SIMPLY TRAVERSE THE LEFT AND RIGHT OF TREE AND WILL CHECK IF ROOT VAL IS NOT GREATER OR EQUAL TO MAX OR
         * SMALLER OR EQ TO MIN
         *
         * WE WILL START WITH MAX AS MAX VALUE AND MIN AS MIN VALUE FOR ROOT, AND WILL EVALUATE FOR OTHERS
         *
         */
    }
}
