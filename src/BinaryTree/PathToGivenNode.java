package BinaryTree;

import java.util.ArrayList;

public class PathToGivenNode {
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans = new ArrayList();
        if(A == null)
            return ans;
        if(A.val == B) {
            ans.add(A.val);
            return ans;
        }
        recursion(ans, A, B);
        return ans;
    }

    public boolean recursion(ArrayList<Integer> ans, TreeNode node, int val) {
        if(node == null)
            return false;

        ans.add(node.val);
        if(node.val == val)
            return true;

        if(recursion(ans, node.left, val) || recursion(ans, node.right, val))
            return true;
        ans.remove(ans.size() - 1);
        return false;
    }
}
