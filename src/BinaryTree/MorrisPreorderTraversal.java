package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        if(root == null)
            return ans;

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
                    ans.add(cur.val);
                    cur = cur.left;
                }
                else {
                    next.right = null;
                    cur = cur.right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * IT IS ALMOST EXACTLY SAME AS MORRIS INORDER, ONLY DIFF IS THAT SINCE IN THAT WE HAD TO HAVE LEFT FIRST, HERE WE
         * HAVE TO GET ROOT FIRST, SO NOW WHEN WE FOUND THE NEXT IS NULL MEANS ITS UNVISITED, SO WE ADD THE ROOT IN ANS.
         */
    }
}
