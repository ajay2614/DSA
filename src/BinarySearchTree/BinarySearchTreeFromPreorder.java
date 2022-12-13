package BinarySearchTree;

public class BinarySearchTreeFromPreorder {
    /**
     * TC = O(N * N)
     * SC = O(1)
     */
    public TreeNode bstFromPreorderBrute(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0]);

        for(int i=1;i<preorder.length;i++) {
            insertBrute(root, preorder[i]);
        }

        return root;
    }

    private void insertBrute(TreeNode node, int val) {
        if(node.val > val) {
            if(node.left == null) {
                TreeNode left = new TreeNode(val);
                node.left = left;
            }
            else {
                insertBrute(node.left, val);
            }
        }
        else {
            if(node.right == null) {
                TreeNode right = new TreeNode(val);
                node.right = right;
            }
            else {
                insertBrute(node.right, val);
            }
        }
    }

    /**
     * TC = O(NLOGN) IF WE USE BINARY TREE USING INORDER AND PREORDER, ONLY THAT WE WILL GENERATE INORDER BY SORTING
     * PREORDER ARRAY AS IT IS BST AND INORDER FOR BST IS ALWAYS SORTED
     * SC = O(1)
     */


    /**
     * TC = O(N)
     * SC = O(1)
     */

    public TreeNode bstFromPreorder(int[] preorder) {
        return insert(preorder, new int[]{0}, Integer.MAX_VALUE);
    }

    private TreeNode insert(int[] pre, int i[], int bound) {
        if(i[0] == pre.length || bound < pre[i[0]])
            return null;
        TreeNode root = new TreeNode(pre[i[0]++]);

        root.left = insert(pre, i, root.val);
        root.right = insert(pre, i, bound);

        return root;
    }
}
