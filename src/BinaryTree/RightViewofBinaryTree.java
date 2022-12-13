package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewofBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        recursion(root, ans, 0);
        return ans;
    }
    public void recursion(TreeNode node, List<Integer> ans, int level) {
        if(node == null)
            return;

        if(level == ans.size())
            ans.add(node.val);
        recursion(node.right, ans, level+1);
        recursion(node.left, ans, level+1);
    }

    public static void main(String[] args) {
        /**
         * SAME EXPLANATION AS LEFT VIEW
         */
    }
}
