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
}
