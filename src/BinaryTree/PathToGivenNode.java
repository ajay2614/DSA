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

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE PATH FOR A NODE
         *
         * WE WILL USE RECURSION(INORDER) TO SOLVE THIS, WE WOULD NEED TWO THINGS, TO KNOW WHETHER THE LEFT OR RIGHT PATH IS
         * CORRECT ONE AND AN ARRAY LIST, SO THAT IS WHY IN THIS WE WILL SOLVE USING BOOLEAN METHOD AND NOT VOID
         *
         * APPROACH
         *
         * WE WILL USE RECURSIVE BOOLEAN METHOD, EVERY STAGE ADD THE NODE AND THEN CHECK FOR LEFT AND IF THAT IS FALSE CHECK RIGHT
         *
         * IF BOTH ARE FALSE, THEN REMOVE THE NODE AS IT IS NOT IN THE PATH.
         */
    }
}
