package BinaryTree;

public class MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        return recursion(root, 0);
    }

    public int recursion(TreeNode root, int nodes) {
        if(root == null)
            return nodes;

        int left = recursion(root.left, 1 + nodes);
        int right = recursion(root.right, 1 + nodes);

        if(left == nodes+1)
            return right;
        if(right == nodes+1)
            return left;
        return Math.min(left, right);
    }
}
