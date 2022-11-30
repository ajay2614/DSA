package BinaryTree;

import java.util.ArrayList;

public class BoundaryTraversalofaTree {

    ArrayList<Integer> boundary(Node node)	{
        ArrayList<Integer> ans = new ArrayList<>();
        if(node == null)
            return ans;
        if(!isLeaf(node))
            ans.add(node.data);

        leftSide(node, ans);
        addLeaves(node, ans);
        rightSide(node, ans);

        return ans;
    }

    public void leftSide(Node node, ArrayList<Integer> ans) {
        Node cur = node.left;
        /**
         * CAN ALSO BE WRITTEN AS
         *
         * while(cur != null) {
         * 	        if(!isLeaf(cur))
         * 	            ans.add(cur.data);
         * 	        if(null != cur.left)
         * 	            cur = cur.left;
         * 	        else
         * 	            cur = cur.right;
         * }
         *
         *
         */
        while (cur != null) {
            if(isLeaf(cur))
                break;
            else {
                ans.add(cur.data);
                if(cur.left != null)
                    cur = cur.left;
                else
                    cur = cur.right;
            }
        }
    }
    public boolean isLeaf(Node node) {
        if(node.left == null && node.right == null)
            return true;
        return false;
    }
    public void addLeaves(Node node, ArrayList<Integer> ans) {
        if(isLeaf(node)) {
            ans.add(node.data);
            return;
        }
        if(node.left != null)
            addLeaves(node.left, ans);
        if(node.right != null)
            addLeaves(node.right, ans);
    }
    public void rightSide(Node node, ArrayList<Integer> ans) {
        Node cur = node.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while (cur != null) {
            if(isLeaf(cur))
                break;
            else {
                temp.add(0, cur.data);
                if (cur.right != null)
                    cur = cur.right;
                else
                    cur = cur.left;
            }
        }

        for (int i : temp) {
            ans.add(i);
        }
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE BOUNDARY TRAVERSAL, MEANS WE HAVE TO CALCULATE ALL THE NODES FROM THE LEFT VIEW
         * , BOTTOM VIEW, AND THE RIGHT VIEW
         *
         * THE APPROACH TO FOLLOW IN THIS QUESTION IS
         *
         * FIRST CALCULATE THE LEFT VIEW WITHOUT CALCULATING THE LEAVES
         *
         * CALCULATE THE LEAVES
         *
         * CALCULATE THE RIGHT VIEW WITHOUT THE LEAVES BUT PLACE IT IN THE REVERSE MANNER IN ANS, AS WE ARE MOVING FROM LEFT
         * TO RIGHT
         *
         * STEPS
         *
         * CHECK FOR ROOT IS NOT A LEAF, IF NOT THEN ADD IN ANS(CHECK BECAUSE IF IT IS IT WILL BE DONE IN THE LEAVES, SO TO AVOID
         * IT GETTING ADDED TWICE).
         *
         * GET THE LEFT SIDE, RUN WHILE TILL CHECK POINTER IS NOT NULL, CHECK FOR WHETHER IT IS LEAF, IF IT IS BREAK, ELSE
         * ADD THE DATA, NOW CHECK FOR THE LEFT IS NOT NULL, IF ITS NOT MOVE CHECK TO LEFT OTHERWISE TO RIGHT(DONE BECAUSE
         * IF LEFT IN LEFT TREE IS NULL MEANS LEFT VIEW WILL HAVE RIGHT).
         *
         * FOR LEAVES, CHECK WHETHER NODE IS LEAF, IF IT IS ADD IN ANS AND RETURN, OTHERWISE RECURSE FOR ITS LEFT IF NOT NULL
         * AND RIGHT IF NOT NULL
         *
         * FOR RIGHT SIDE, IS SAME AS LEFT, JUST WE HAVE TO GET RIGHT VIEW SO CHECK FOR RIGHT, AND IF RIGHT IS NULL GO TO LEFT,
         * THE ONLY DIFF IS, USE A TEMP LIST AND ADD IT IN REVERSE TO ANS AS WE ARE MOVING FROM LEFT TO RIGHT.
         *
         * RETURN THE ANS.
         *
         *
         */
    }
}
