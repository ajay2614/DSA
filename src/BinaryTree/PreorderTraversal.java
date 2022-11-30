package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans);
        return ans;
    }
    public void recursion(TreeNode node, List<Integer> ans) {
        if (node == null)
            return;
        ans.add(node.val);
        recursion(node.left, ans);
        recursion(node.right, ans);
    }
    public List<Integer> preorderTraversalUsingStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            ans.add(node.val);
            if(node.right != null)
                st.push(node.right);
            if(node.left != null)
                st.push(node.left);
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * PREORDER
         * ROOT -> LEFT -> RIGHT
         *
         * RECURSION
         *
         * SIMPLY ADD THE NODE, THEN RECURSE FOR ITS LEFT AND RIGHT
         *
         * STACK
         *
         * ADD THE ROOT NODE,
         * THEN ADD THE RIGHT NODE IN STACK AND THEN THE LEFT, (WHY RIGHT FIRST, BECAUSE FOR THE NEXT ITERATION, LEFT WOULD
         * BE AT TOP AS STACK FOLLOWS LIFO).
         */
    }
}
