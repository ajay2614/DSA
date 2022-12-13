package BinarySearchTree;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
 }
 public class SearchInBinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val) {
            if(val > root.val)
                root = root.right;
            else
                root = root.left;
        }

        return root;
    }
}
