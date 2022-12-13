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
}
