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

     /**
      *
      * TC : BIG O(N)
      * SC : BIG O(1)
      */
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null && root.val != val) {
            if(val > root.val)
                root = root.right;
            else
                root = root.left;
        }

        return root;
    }

    public static void main(String[] args) {
        /**
         * SINCE BST HAS LOWER VALUES ON LEFT AND HIGHER VALUES ON RIGHT SIMPLY ITERATE THE TREE USING WHILE LOOP
         */
    }
}
