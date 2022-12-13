package BinaryTree;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null)
            return p == q;
        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO CHECK WHETHER THE TREE IS SAME, SO WE WILL SIMPLY CHECK IF EITHER OF THEM IS NOT
         * NULL, AND IF RETURN WHETHER THEY BOTH NULL OR NOT
         *
         * CHECK WHETHER THE VAL OF NODE IS SAME AND CHECK FOR ITS LEFT AND RIGHT CHILDREN, SINCE WE HAVE TO CHECK IF BOTH
         * ARE SAME VALUE TREE AND NOT SAME NODES(HAVING SAME MEMORY ALLOCATION) SO WE WILL NOT CHECK THEIR NODES BEING SAME.
         */
    }
}
