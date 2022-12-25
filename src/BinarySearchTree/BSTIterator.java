package BinarySearchTree;

import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        if(!st.isEmpty()) {
            TreeNode node = st.pop();
            pushAll(node.right);
            return node.val;
        }
        return -1;
    }

    public boolean hasNext() {
        return !st.isEmpty();
    }
    public void pushAll(TreeNode node) {
        while(node != null) {
            st.push(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE GIVEN A BINARY SEARCH TREE INITIALLY, AT CERTAIN STAGE WE NEED TO GET ITS NEXT, MEANING THE
         * SMALLEST VAL NODE, ALSO WE NEED TO CHECK IF THERE IS A NEXT NODE LEFT OR IF WE HAVE POPPED EVERY NODE.
         *
         * BRUTE APPROACH WOULD BE TO GET ALL THE NODE IN ARRAY AND SORT IT, THEN USING A POINTER RETURN NEXT AND CHECK IF POINTER
         * HAS EXCEEDED SIZE THEN RETURN FALSE FOR HASNEXT
         *
         * OPTIMAL APPROACH
         *
         * USE A STACK INITIALLY, FROM ROOT, PUSH ALL THE LEFT NODES, NOW WHEN WE HAVE TO GET NEXT IT WILL GET THE LEFTMOST
         * NODE, POP THAT, BUT NOW PUSH ALL THE NODES TO THE RIGHT IN THE STACK, IN A WAY WE ARE FOLLOWING INORDER HERE.
         */
    }
}
