package BinarySearchTree;
class NodeValue {
    int min;
    int max;
    int size;

    NodeValue(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}
public class SizeOfLargestBST {
    public NodeValue getNodeSize(TreeNode root) {
        if(root == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = getNodeSize(root.left);
        NodeValue right = getNodeSize(root.right);

        if(left.max < root.val && root.val < right.min) {
            return new NodeValue(Math.min(root.val, left.min),
                    Math.max(root.val, right.max),
                    left.size + right.size + 1);
        }

        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE,
                Math.max(left.size, right.size));
    }
    public int maxSizeBST(TreeNode root) {
        return getNodeSize(root).size;
    }

    public static void main(String[] args) {
        /**
         * SAME AS MAX SUM BST, ONLY FEW DIFFERENCES.
         */
    }
}
