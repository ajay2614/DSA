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
}
