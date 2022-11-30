package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans);
        return ans;
    }
    public void recursion(TreeNode node, List<Integer> ans) {
        if(node == null)
            return;
        recursion(node.left, ans);
        recursion(node.right, ans);
        ans.add(node.val);
    }
    public List<Integer> postorderTraversalUsingTwoStacks(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);

        while(!st1.isEmpty()) {
            TreeNode node = st1.pop();
            st2.push(node);
            if(node.left!=null)
                st1.push(node.left);
            if(node.right!=null)
                st1.push(node.right);
        }
        while(!st2.isEmpty()) {
            ans.add(st2.pop().val);
        }
        return ans;
    }
    public List<Integer> postorderTraversalUsing1stack(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;

        while(cur != null || !st.isEmpty()) {
            if(cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            else {
                TreeNode temp = st.peek().right;
                if(temp == null) {
                    temp = st.pop();
                    ans.add(temp.val);

                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        ans.add(temp.val);
                    }

                }
                else {
                    cur = temp;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * POSTORDER
         *
         * LEFT RIGHT ROOT
         *
         * RECURSION
         *
         * TRAVERSE LEFT, THEN RIGHT AND THEN ADD THE ANS,
         *
         * USING 2 STACKS
         *
         * IN THIS ADD THE ROOT IN STACK 1, AND THEN KEEP POPPING AND ADDING THE POPPED IN STACK 2, AND ADD THE LEFT AND
         * RIGHT NODE OF THAT POPPED NODE IN STACK 1, DO THIS WHILE ST 1 IS EMPTY, SIMPLY ADD ALL THE ELEMENTS IN STACK
         * 2 AFTER THIS.
         *
         * USING 1 STACK(AVOID IN INTERVIEW)
         *
         * IN THIS WE WILL USE A CUR POINTER, ASSIGN ROOT AS CUR, RUN A WHILE LOOP TILL CUR != NULL || STACK IS NOT EMPTY,
         * (T || F IS T), (SO WHEN CUR IS GOING TO BE NULL, STACK HAS TO BE NON EMPTY)
         *
         * IF CUR != NULL, ADD CUR IN STACK ASSIGN CUR AS CUR LEFT,
         *
         * IF WHEN IT IS NULL,HAVE TEMP AS AS CURRENT STACK.TOP.RIGHT, IF TEMP IS NULL, (MEANS WE HAVE TO ITERATE BACK FROM
         * HERE AS WE ARE ON RIGHT LEAF NODE), HAVE TEMP AS ST.POP(), ADD IT IN ANS, NOW RUN A WHILE LOOP
         * AND CHECK TILL STACK IS EMPTY AND ST.TOP.RIGHT == TEMP, ASSIGN TEMP AS ST.TOP.RIGHT AND ADD IT IN ANS IF TRUE,
         * THIS IS DONE SO THAT WE CAN ADD ALL THE ROOT NODES,
         *
         * IF TEMP IS NOT NULL, MEANS WE HAVE NODES AT RIGHT SO ASSIGN CUR = TEMP.
         *
         */



    }
}
