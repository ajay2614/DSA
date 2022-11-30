package BinaryTree;

public class LowestCommonAncestorofaTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null)
            return right;
        else if(right == null)
            return left;
        return root;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE LOWEST COMMON ANCESTOR TREE
         *
         * THE MEANING OF LOWEST COMMON ANCESTOR TREE IS, SUPPOSE ROOT A AND ROOT B ARE GIVEN, SO THE LAST COMMON PARENT OF
         * A AND B WOULD BE LCA.
         *
         * APPROACH,
         *
         * WE WILL USE THE DFS TO SOLVE THIS QUESTION, WHEN WE WILL RECURSE WE WILL CHECK IF THE NODE IS EITHER P OR Q OR
         * NULL, WE WILL DO THIS FOR BOTH LEFT AND RIGHT
         *
         * WHEN WE WILL GET LEFT AND RIGHT, WE HAVE THREE POSSIBILITIES, EITHER LEFT AND RIGHT BOTH ARE NULL OR BOTH HAVE VALUES
         * , SO IF ONE OF THEM IS NULL RETURN THE OTHER ONE, IF NONE OF THEM IS NULL THAT MEANS ANS COMING FROM LEFT AND RIGHT IS
         * P AND Q HENCE CURRENT ROOT IS THEIR LCA, SO RETURN ROOT.
         */
    }
}
