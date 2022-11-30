package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
  }
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans);
        return ans;
    }
    public void recursion(TreeNode node, List<Integer> ans) {
        if(node == null)
            return;
        recursion(node.left, ans);
        ans.add(node.val);
        recursion(node.right, ans);
    }

    public List<Integer> inorderTraversalUsingStack(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true) {
            if(root != null) {
                st.push(root);
                root = root.left;
            }
            else {
                if(st.isEmpty())
                    break;
                root = st.pop();
                ans.add(root.val);
                root = root.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * INORDER TRAVERSAL
         * LEFT -> ROOT -> RIGHT
         *
         * INORDER USING RECURSION
         *
         * IN THIS SIMPLY RECURSE THE ROOT LEFT UNTIL IT IS IS NULL, ADD ALL THE NODES WHILE BACKTRACKING
         * AND THEN SIMPLY TRAVERSE TO RIGHT.
         *
         * INORDER USING STACK
         *
         * IN THIS KEEP ON TRAVERSING AND ASSIGNING ROOT TO ROOT LEFT TILL IT IS NULL, AFTER THIS ADD THE STACK TOP WHICH
         * WOULD BE REPRESENTING LEFT MOST NODE, (AS THE PATTERN IS LEFT ROOT RIGHT) AFTERWARDS ADD THE ROOT RIGHT. MAKE SURE
         * TO CHECK WHETHER STACK IS NOT EMPTY BEFORE ADDING RIGHT NODE, IF STACK IS EMPTY MEANS THERE ISN'T ANY NODE LEFT
         * AND HENCE BREAK.
         */
    }
}
