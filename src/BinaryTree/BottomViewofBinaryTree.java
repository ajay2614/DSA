package BinaryTree;

import java.util.*;

class NodeB {
    int data;
    NodeB left, right;

    int hd;
    NodeB(int item) {
        data = item;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

public class BottomViewofBinaryTree {
    public ArrayList <Integer> bottomView(NodeB root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<NodeB> q = new LinkedList<>();
        Map<Integer,Integer> m = new TreeMap<>();
        root.hd = 0;
        q.offer(root);

        while(!q.isEmpty()) {
            NodeB node = q.poll();
            int hd = node.hd;
            m.put(node.hd, node.data);

            if(node.left != null) {
                node.left.hd = hd-1;
                q.offer(node.left);
            }
            if(node.right != null) {
                node.right.hd = hd+1;
                q.offer(node.right);
            }
        }

        for(Map.Entry<Integer,Integer> entry : m.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE BOTTOM VIEW OF A TREE, THE IDEA IS USING A LEVEL ORDER TRAVERSAL, IF WE
         * GET A VERTICAL LEVEL SAME AS ALREADY HAPPENED WE WILL REPLACE IT, FOR EG ROOT, THEN LEFT'S RIGHT HAVE SAME LEVEL
         * 0.
         *
         * WE WILL USE HASHMAP AND A QUEUE FOR LEVEL ORDER TRAVERSAL
         *
         * NOW WE WILL ADD THE ROOT IN Q, AND THEN RUN A WHILE LOOP TILL Q IS EMPTY, POP OUT THE NODE FROM Q, AND
         * CHECK IF IT IS IN HASHMAP, IF IT IS THEN ADD OTHERWISE REPLACE THE EXISTING AS THE LATTER ONE NEEDS TO BE PLACED
         * NOW CHECK IF NODE LEFT IS NOT NULL AND NODE RIGHT IS NOT NULL AND THEN ADD THEM IN Q.
         *
         * ITERATE THE HASHMAP ENTRY VALUES AND STORE THEM IN ANS.
         */
    }
}
