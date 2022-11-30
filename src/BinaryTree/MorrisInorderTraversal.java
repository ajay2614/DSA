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
}
