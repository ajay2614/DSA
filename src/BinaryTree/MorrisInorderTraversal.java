package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MorrisInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
            if(cur.left == null) {
                ans.add(cur.val);
                cur = cur.right;
            }
            else {
                TreeNode next = cur.left;

                while(next.right != null && next.right != cur) {
                    next = next.right;
                }
                if(next.right == null) {
                    next.right = cur;
                    cur = cur.left;
                }
                else {
                    next.right = null;
                    ans.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * EVEN THOUGH WE CAN EASILY OBTAIN INORDER OR PREORDER VIA THE RECURSION, WITH MORRIS TRAVERSAL WE CAN ACHIEVE IT
         * USING ONLY BIG O(1) SPACE COMPLEXITY
         *
         *
         * APPROACH
         *
         * SINCE WE OBSERVE WHENEVER WE HAVE TO GET THE LEFTMOST FIRST, WE WILL CHECK IF A LEFT NODE IS THERE OR NOT,
         * IF THERE IS NO LEFT NODE, THEN WE CAN SIMPLY ADD THE ROOT AND MOVE TO RIGHT, OTHERWISE WHAT WE KNOW CAN HAPPEN
         * IS WE ADD THE LEFT, AND THEN RIGHT, SO TO TRACK BACK TO ROOT, WE WILL HAVE ROOT LEFT AS NEXT, AND THEN WE WILL
         * WILL ITERATE EITHER NEXT IS NULL OR ROOT.
         *
         * IF ITS NULL WE WILL MARK THE NEXT AS ROOT, AND THEN PROCEED TO LEFT OF ROOT, NOW WHEN WE TRAVERSE BACK, WE
         * WE HAVE POINTER TO RIGHT SO WE WILL GO VIA THAT POINTER IN THE CHECK WHILE NEXT.RIGHT != ROOT, SO IF IT IS
         * ROOT SIMPLY ADD ROOT IN THE ANS, AND THEN MOVE TO THE RIGHT.
         *
         *
         */
    }
}
