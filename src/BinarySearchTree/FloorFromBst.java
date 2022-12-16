package BinarySearchTree;

public class FloorFromBst {

    /**
     *
     * TC : BIG O(N)
     * SC : BIG O(1)
     */
    public static int floorInBST(TreeNode_<Integer> root, int X) {
        int floor = -1;

        while(root != null) {
            if(root.data == X) {
                floor = root.data;
                break;
            }
            else if(root.data > X) {
                root = root.left;
            }
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }

    public static void main(String[] args) {
        /**
         * IN THIS WE HAVE TO FIND FLOOR FROM BST, MEANS RETURN THE VALUE WHICH IS EQUAL OR IF NOT EQUAL THEN THE CLOSEST SMALLEST
         *
         * APPROACH
         *
         * SIMPLY RUN A WHILE LOOP, CHECK FOR ALL THREE CASES, WHEN ROOT.VAL IS GREATER, MEANS THIS CAN'T BE POSSIBLE FLOOR,
         * SIMPLY MOVE LEFT IN THIS CASE
         *
         * WHEN VALUE IS SMALLER THEN THIS MEANS IT CAN BE POSSIBLE VALUE AS IT CAN BE CLOSEST SMALLER SO UPDATE THIS AND
         * MOVE RIGHT.
         *
         * IF EQUAL THEN SIMPLY RETURN IT AS EQUAL IS THE CLOSEST.
         */
    }
}
