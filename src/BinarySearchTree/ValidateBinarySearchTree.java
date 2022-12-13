package BinarySearchTree;

public class ValidateBinarySearchTree {
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
}
