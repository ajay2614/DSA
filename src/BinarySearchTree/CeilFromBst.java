package BinarySearchTree;
class TreeNode_<T> {
    T data;
    TreeNode_<T> left;
    TreeNode_<T> right;

    TreeNode_(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};
public class CeilFromBst {
    /**
     *
     * TC : BIG O(N)
     * SC : BIG O(1)
     */
    public  static int findCeil(TreeNode_<Integer> root, int x) {
        int ceil = -1;

        while(root != null) {
            if(x > root.data) {
                root = root.right;
            }
            else if(x == root.data) {
                ceil = root.data;
                break;
            }
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        /**
         * IN THIS WE HAVE TO FIND CEIL FROM BST, MEANS RETURN THE VALUE WHICH IS EQUAL OR IF NOT EQUAL THEN THE CLOSEST GREATEST
         *
         * APPROACH
         *
         * SIMPLY RUN A WHILE LOOP, CHECK FOR ALL THREE CASES, WHEN ROOT.VAL IS GREATER, MEANS THIS CAN BE POSSIBLE CEIL,
         * UPDATE CEIL BY THIS VALUE AND MOVE LEFT.
         *
         * WHEN VALUE IS SMALLER THEN MOVE RIGHT AND NO UPDATION AS WE DON'T HAVE ANY USE FOR THE VALUE SMALLER THAN REQUIRED
         *
         * IF EQUAL THEN SIMPLY RETURN IT AS EQUAL IS THE CLOSEST.
         */
    }
}
