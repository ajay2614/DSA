package BinarySearchTree;

public class BSTFromASortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructUsingBinarySearch(0, nums.length-1, nums);
    }
    public TreeNode constructUsingBinarySearch(int low, int hi, int arr[]) {
        if(low > hi)
            return null;

        int mid = low + (hi - low) / 2;
        TreeNode node = new TreeNode(arr[mid]);

        node.left = constructUsingBinarySearch(low, mid-1, arr);
        node.right = constructUsingBinarySearch(mid+1,hi, arr);

        return node;
    }
}
