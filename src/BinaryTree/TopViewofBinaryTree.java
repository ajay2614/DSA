package BinaryTree;

import java.util.*;

class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
public class TopViewofBinaryTree {
    public static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> m = new TreeMap<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int hd = pair.hd;
            Node node = pair.node;
            if(m.get(hd) == null)
                m.put(hd, node.data);
            if(node.left != null) {
                q.offer(new Pair(node.left, hd-1));
            }
            if(node.right != null) {
                q.offer(new Pair(node.right, hd+1));
            }
        }

        for(Map.Entry<Integer,Integer> map : m.entrySet()) {
            ans.add(map.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION IS PRETTY SIMILAR TO BOTTOM VIEW OF A TREE, THE ONLY DIFF IS SINCE FOR BOTTOM WE NEED TO UPDATE
         * THE LATTER NODES HAVING SAME VERTICAL LEVEL, IN THIS WE WILL ONLY TAKE WHEN VERTICAL LEVEL NODE IS NOT PRESENT,
         * IF PRESENT THEN WE WILL NOT TAKE IT AS IT WILL BE COVERED BY TOP ONE, SO THE ONLY CHANGE WILL BE
         * FROM BOTTOM VIEW IS THAT ONLY UPDATE HASHMAP WHEN VERTICAL VALUE IS NOT PRESENT FOR THAT TREE.
         */
    }
}
