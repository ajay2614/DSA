package BinaryTree;

public class MaxPathSum {
    public int maxPathSum(TreeNode root) {
        int arr[] = new int[1];
        arr[0] = Integer.MIN_VALUE;
        recursion(root, arr);
        return arr[0];
    }

    public int recursion(TreeNode node, int arr[]) {
        if(node == null)
            return 0;

        int left = Math.max(0,recursion(node.left, arr));
        int right = Math.max(0,recursion(node.right, arr));

        arr[0] = Math.max(arr[0], left + right + node.val);

        return Math.max(left + node.val, right + node.val);
    }
    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE MAX PATH, WHAT MAX PATH BASICALLY MEANS IS THE PATH HAVING NO DUPLICATE NODES,
         * AND IT SHOULD OBVIOUSLY NOT BE HAVING MORE THAN 1 PATH.
         *
         * SOLUTION
         *
         * WHAT THE APPROACH WE CAN FOLLOW IS SIMILAR TO FINDING THE MAX HEIGHT, SINCE WE WERE ABLE TO FIND THE MAX HEIGHT
         * IN A SIMILAR WAY WITH SOME CHANGES WE CAN GET MAX PATH
         *
         * START FROM ROOT NODE, GO TO LEFT AND RECURSE, AND GO TO RIGHT, FIND THE MAX PATHS FROM THERE, WHY WE ARE USING
         * MAX WITH 0, BECAUSE IT COULD HAPPEN THAT A NODE IS NEGATIVE SO WE WILL NOT CONSIDER ANY NEGATIVE NODES/PATHS,
         *
         * FOR EVALUATION MAX, ADD THE LEFT AND RIGHT AND NODE.VAL, FIND THE MAX FROM THIS, IT'S LIKE NODE HAS LEFT AND RIGHT
         * SO NODE + ITS LEFT AND RIGHT MAKES A PATH.
         *
         * IN FINAL RETURN WE ARE ONLY RETURNING MAX OF LEFT AND RIGHT + NODE VAL, BECAUSE IF WE HAD PASSED BOTH, IT WOULD HAVE
         * BECOME 2 WAY PATH.
         *
         */
    }
}
