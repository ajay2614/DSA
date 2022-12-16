package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
class Node_ {
    public int val;
    public Node_ left;
    public Node_ right;
    public Node_ next;

    public Node_() {}

    public Node_(int _val) {
        val = _val;
    }

    public Node_(int _val, Node_ _left, Node_ _right, Node_ _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class PopulateNextPointerInEachNode {

    /**
     * Time Complexity: O(N) where n is the number of nodes in the binary tree.
     * Auxiliary Space: O(N) where n is the number of nodes in the binary tree.
     */
    public Node_ connect(Node_ root) {
        if(root == null)
            return null;
        Queue<Node_> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0;i<size;i++) {
                Node_ node_ = q.poll();

                if(i == size - 1)
                    node_.next = null;
                else
                    node_.next = q.peek();

                if(node_.left != null)
                    q.offer(node_.left);
                if(node_.right != null)
                    q.offer(node_.right);
            }
        }
        return root;
    }

    /**
     *Time Complexity: O(N) where n is the number of nodes in the binary tree.
     * Auxiliary Space: O(1) (NOT SURE)
     */
    public Node_ connectOptimalApproach(Node_ root) {
        recursionPre(root);
        return root;
    }

    public void recursionPre(Node_ root) {
        if(root == null)
            return;

        if(root.left != null)
            root.left.next = root.right;
        if(root.right != null)
            root.right.next = root.next == null ? null : root.next.left;

        recursionPre(root.left);
        recursionPre(root.right);
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO POPULATE THE NEXT POINTERS TO A NODE, USUALLY THIS MEANS POINT TO RIGHT NEIGHBOUR AND
         * IF THERE ISN'T ONE POINT TO NULL
         *
         * LEVEL ORDER APPROACH
         *
         * SIMPLY USE LEVEL ORDER TRAVERSAL AND FOR EVERY ELEMENT WHICH ISN'T LAST IN FOR LOOP HAVE THAT AS TOP OF QUEUE
         *
         * RECURSION
         *
         * PASS ON THE ROOT(NO NEED TO HAVE ROOT NEXT AS IT WAS ALREADY NULL), CHECK IF LEFT IS NOT NULL
         * IF ISN'T HAVE ROOTS RIGHT AS NEXT,(NO NEED TO CHECK ROOT RIGHT BEING NULL HERE AS ALREADY GIVEN THAT TREE IS PERFECT)
         *
         * NOW FOR RIGHT IT CAN HAPPEN ITS PARENT WASNT THE LAST IN THE LEVEL, SO THIS CHILD CAN HAVE NEXT SO CHECK IF
         * ITS PARENT NEXT IS NOT NULL IF IT ISNT, GET THE LEFT CHILD IF ITS PARENT NEXT ELSE POINT NULL.
         *
         */
    }
}
