package BinarySearchTree;

public class LowestCommonAncestorOfBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;
        if(right == null)
            return left;

        return root;
    }

    public TreeNode lowestCommonAncestorOptimal(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;

        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);

        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {
        /**
         * 2 APPROACHES
         *
         * BRUTE
         *
         * SIMPLY CHECK LIKE CHECKING A BINARY TREE, EVALUATE FOR BOTH LEFT AND RIGHT.
         *
         * OPTIMAL
         *
         * WE KNOW THAT BST PROPERTY WE HAVE SMALLER ON LEFT AND LARGER ON RIGHT, SO WE WILL MOVE TO LEFT
         * IF BOTH P AND Q ARE SMALLER AND RIGHT IF LARGER, IF BOTH DOESN'T SATISFY IT IS CERTAIN THAT THE ROOT IS LCA SO RETURN IT.
         *
         */
    }
}
