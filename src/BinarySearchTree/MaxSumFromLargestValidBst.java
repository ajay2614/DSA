package BinarySearchTree;
class NodeValue_ {
    int min;
    int max;
    int sum;

    NodeValue_(int min, int max, int sum) {
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}

public class MaxSumFromLargestValidBst {

    /**
     * UNLIKE LARGEST SIZE, HERE A SITUATION CAN ARRIVE ,IT COULD HAPPEN RIGHT IS IN POSITIVE AND LEFT IS IN NEGATIVE SO
     * WHILE RETURNING SUM COULD BE SHORTEN SO WE NEED MAX SUM VARIABLE TO TRACK MAX SUM AT ALL TIMES.
     *
     * REMEMBER IF ROOT HAS HIGHER VALUE THAN SAY LEFT AND RIGHT AND IS NOT VALID BST, FOR
     * EG SAY ROOT IS 14, LEFT IS 12, AND RIGHT IS 11, IT COULD BE THOUGHT THAT RIGHT ANSWER IS 14 AS AN INDIVIDUAL NODE,
     * BUT WE CAN ONLY TAKE MAX FROM VALID BST NODE AND 14 ISN'T SO 12 IS THE ANS HERE.
     */
    int maxSum = 0;
    public NodeValue_ getNodeSize(TreeNode root) {
        if(root == null) {
            return new NodeValue_(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue_ left = getNodeSize(root.left);
        NodeValue_ right = getNodeSize(root.right);

        if(left.max < root.val && root.val < right.min) {
            maxSum = Math.max(maxSum, left.sum + right.sum + root.val);

            return new NodeValue_(Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    left.sum + right.sum + root.val);
        }

        return new NodeValue_(Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.sum, right.sum));
    }
    public int maxSumBST(TreeNode root) {
        getNodeSize(root);
        return maxSum;
    }

}
