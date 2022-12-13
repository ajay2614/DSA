package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BstIteratorLeftAndRight {

    Stack<TreeNode> st = new Stack<>();
    boolean reverse;
    BstIteratorLeftAndRight(TreeNode node, boolean reverse) {
        this.reverse = reverse;
        pushAll(node);
    }
    void pushAll(TreeNode node) {
        if(!reverse) {
            while(node != null) {
                st.push(node);
                node = node.left;
            }
        }
        else {
            while(node != null) {
                st.push(node);
                node = node.right;
            }
        }
    }

    int next() {
        TreeNode node = st.pop();
        if(!reverse) {
            pushAll(node.right);
        }
        else{
            pushAll(node.left);
        }
        return node.val;
    }

}

public class TwoSum4 {
    /**
     * BIG O(N)
     * BIG O(N)
     */
    public boolean findTargetBrute(TreeNode root, int k) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);

        int i = 0;
        int j = arr.size()-1;

        while(i < j) {
            if(arr.get(i) + arr.get(j) == k)
                return true;
            if(arr.get(i) + arr.get(j) > k)
                j--;
            else
                i++;
        }
        return false;
    }

    public void inorder(TreeNode root, List<Integer> ans) {
        if(root == null)
            return;

        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    /**
     *
     * BIG O(N)
     * BIG O(H)
     */
    public boolean findTargetOptimal(TreeNode root, int k) {
        BstIteratorLeftAndRight left = new BstIteratorLeftAndRight(root, false);
        BstIteratorLeftAndRight right = new BstIteratorLeftAndRight(root, true);

        int l = left.next();
        //prev
        int r = right.next();

        while(l < r) {
            if(l + r == k)
                return true;
            if(l + r > k)
                r = right.next();
            else
                l = left.next();
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE NEED TO CHECK WHETHER THERE EXISTS 2 NODES WHOSE VALUE IS EQUAL TO K.
         *
         * BRUTE
         *
         * SINCE WE KNOW THAT INORDER PRODUCES BST IN ASCENDING SORT, SIMPLY STORE THAT IN AN ARRAY LIST, AND USING TWO
         * POINTER APPROACH CHECK FOR EACH SUM.
         *
         * OPTIMAL
         *
         * IN THIS RATHER THAN USING LIST WHICH GIVE O(N) COMPLEXITY WE WILL TRY TO AVOID, WITH BST ITERATOR WE
         * CAN GET BIG O(H) COMPLEXITY SO WE WILL USE THAT, SINCE WE KNOW BST ITERATOR WITH LEFT ROOT RIGHT
         * APPROACH PRODUCES IN ASCENDING SORTING SO RATHER THAN THAT WE WILL USE RIGHT ROOT LEFT TOO TO GET IN
         * DESCENDING.
         *
         * USE A POINTER TO CHECK IF REVERSE WHILE PUSHING AND GETTING NEXT.
         *
         * NOW GET LEFT POINTER AS THE LEFTMOST, AND RIGHT POINTER AS RIGHTMOST, USE THE SAME TWO POINTER APPROACH
         * IF VAL IS GREATER THAN ACTUAL DECREASE BY GETTING NEXT FROM RIGHT ELSE GET ONE INCREASED FROM LEFT.
         *
         * SINCE WE ARE USING IF L < R, THERE IS NO NEED TO CHECK IF ST IS EMPTY AS SUPPOSE A TREE HAS ROOT AND RIGHT
         * LEFT WILL GIVE ROOT AND RIGHT WILL GIVE RIGHT, NOW IF THE ACTUAL WAS BIGGER WE WOULD BE INCREASING LEFT WHICH
         * WILL ALSO BE RIGHT SO L < R WOULD FAIL AND WILL GET OUT OF LOOP.
         */
    }
}
