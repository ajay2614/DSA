package BinaryTree;

import java.util.Stack;

public class FlattenaTreeNodetoLinkedList {
    /**
     *
     * 1 ST APPROACH
     */
    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while(cur != null) {
            if(cur.left != null) {
                TreeNode prev = cur.left;

                while(prev.right != null) {
                    prev = prev.right;
                }

                prev.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    /**
     *
     *
     * 2 ND APPROACH
     */

    TreeNode prev = null;
    public void flatten2nd(TreeNode root) {
        if(root == null)
            return;

        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    /**
     *
     *
     * 3 RD APPROACH
     */

    public void flatten3rd(TreeNode root) {
        if(root == null)
            return;
        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        while(!st.isEmpty()) {
            TreeNode cur = st.pop();

            if(cur.right != null)
                st.push(cur.right);
            if(cur.left != null)
                st.push(cur.left);

            if(!st.isEmpty())
                cur.right = st.peek();
            cur.left = null;
        }
    }

    public static void main(String[] args) {
        /**
         *
         * 1ST APPROACH
         *
         * THE APPROACH FOR THIS IS THAT EVERYTIME WE HAVE A LEFT NODE, WE ATTACH IT ABOVE THE RIGHT NODE AND PLACE IT AS THE
         * RIGHT OF ROOT AND MAKING LEFT NULL.
         *
         *
         * 2ND APPROACH(RECURSION)
         *
         * IN THIS WE WILL RECURSE THE RIGHT TREE FIRST, AND THEN THE LEFT TREE, USE A DUMMY NODE, HAVE CUR RIGHT AS PREV AND
         * THEN HAVE CUR AS PREV.
         *
         * 3RD APPROACH(NOT TO BE USED IN INTERVIEWS)
         */
    }
}
