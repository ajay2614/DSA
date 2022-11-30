package BinaryTree;

public class ChildrenSumProperty {
    public static void changeTree(BinaryTreeNode < Integer > root) {
        if(root == null)
            return;
        int sum = 0;

        if(root.left != null)
            sum += root.left.data;
        if(root.right != null)
            sum += root.right.data;

        if(sum >= root.data)
            root.data = sum;
        else {
            if(root.left != null)
                root.left.data = root.data;
            if(root.right != null)
                root.right.data = root.data;
        }

        changeTree(root.left);
        changeTree(root.right);

        int total = 0;

        if(root.left != null)
            total += root.left.data;
        if(root.right != null)
            total += root.right.data;

        if(root.left != null || root.right != null)
            root.data = total;
    }

    public static void main(String[] args) {
        /**
         *
         * CHILDREN SUM PROPERTY STATES THAT VAL OF ROOT SHOULD BE EQUAL TO ITS LEFT AND RIGHT CHILD VALUE UNLESS ITS LEAF
         *
         * NOTE : WE CAN NOT DECREASE VALUE
         *
         * NOW A COMMON APPROACH MAY COME IN THE MIND, THAT IF WE START FROM LEAF AND ADD THE NODES VAL, WE CAN GET OUR ANSWER
         * BUT THAT IS WRONG AS SUPPOSE LEFT CHILD IS 39 AND RIGHT IS 5 BUT ROOT IS 50, NOW WE CAN NOT DECREASE IT
         *
         * APPROACH
         *
         * WHILE RECURSION EVALUATE THE SUM OF LEFT AND RIGHT CHILD, IF SUM IS GREATER THAN ROOT VALUE,
         * THEN HAVE THE ROOT VALUE AS THE SUM, IF NOT THEN UPDATE BOTH THE LEFT AND RIGHT CHILD WITH ROOTS VALUE,
         *
         * UPON BACKTRACKING THERE IS ALWAYS A POSSIBILITY THAT CHILD NODES VALUE MAY HAVE INCREASED IF THEIR CHILD WE GREATER
         * , SO WE WILL EVALUATE VALUE OF LEFT AND RIGHT AGAIN AND STORE THE TOTAL IN ROOT.
         *
         *
         */
    }
}
