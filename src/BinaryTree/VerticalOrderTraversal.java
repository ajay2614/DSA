package BinaryTree;

import java.util.*;

class Pair3D {
    int horizontal;
    TreeNode node;
    int vertical;
    Pair3D(int horizontal, int vertical, TreeNode node) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.node = node;
    }
}
public class VerticalOrderTraversal {
    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Map<Integer, PriorityQueue<Pair3D>> map = new TreeMap<>();
        Stack<Pair3D> st = new Stack<>();
        st.push(new Pair3D(0, 0, root));

        while(!st.isEmpty()) {
            Pair3D p = st.pop();
            int horizontal = p.horizontal;
            int vertical = p.vertical;
            if(map.get(horizontal) == null) {
                PriorityQueue<Pair3D> pq = new PriorityQueue<>((Pair3D p1, Pair3D p2) -> {
                    if(p1.vertical > p2.vertical)
                        return 1;
                    if(p1.vertical < p2.vertical)
                        return -1;
                    if(p1.node.val > p2.node.val)
                        return 1;
                    if(p1.node.val < p2.node.val)
                        return -1;
                    return 0;
                });
                pq.add(p);
                map.put(horizontal, pq);
            }
            else {
                PriorityQueue<Pair3D> pq = map.get(horizontal);
                pq.add(p);
                map.put(horizontal, pq);
            }

            if(p.node.left != null) {
                st.push(new Pair3D(horizontal-1,vertical+1, p.node.left));
            }
            if(p.node.right != null) {
                st.push(new Pair3D(horizontal+1,vertical+1, p.node.right));
            }
        }

        for(Map.Entry<Integer, PriorityQueue<Pair3D>> m : map.entrySet()) {
            PriorityQueue<Pair3D> pq = m.getValue();
            List<Integer> subAns = new ArrayList<>();
            while (!pq.isEmpty()) {
                subAns.add(pq.poll().node.val);
            }
            ans.add(subAns);
        }
        return ans;
    }
    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WHAT WE HAVE TO DO IS TO CREATE SUBLISTS OF THE NODES THAT ARE SHARING THE SAME HORIZONTAL LEVEL
         * (X AXIS), FOR EG ROOTS LEFT RIGHT HAS SAME LEVEL AS ROOT RIGHT,
         *
         * WHAT WE HAVE TO REMEMBER IS THAT LISTS SHOULD BE SORTED BY THEIR VERTICAL LEVEL, SO ROOT THEN ROOTS LEFT RIGHT
         * WILL COME, IT MAY HAPPEN THAT THE NODES WOULD HAVING SAME VERTICAL AS WELL AS HORIZONTAL LEVEL, IN THIS CASE WE HAVE
         * TO STORE BY THEIR VALUE SORTED IN ASCENDING ORDER
         *
         * APPROACH
         *
         * WE WILL USE LEVEL ORDER TRAVERSAL FOR THIS
         *
         * FIRST CREATE A PAIR CLASS HAVING VERTICAL HORIZONTAL AND THE NODE
         * USE A HASHMAP OF INTEGER AND PRIORITY OF PAIR (SO THAT WE CAN EASILY SORT THE PAIR DEPENDING UPON SITUATION AND PAIR
         * IS USED BECAUSE BOTH THE HORIZONTAL AND NODES DATA MIGHT BE USED FOR SORTING).
         *
         * USE Q LIKE WE DO IN LEVEL ORDER, HAVE Q AS PAIR TYPE
         *
         * STORE ROOT INITIALLY WITH VERTICAL AND HORIZONTAL LEVEL AS 0
         *
         * RUN WHILE LOOP, POP OUT THE NODE, IF IT IS NOT PRESENT ASSIGN IT IN HASHMAP ALONG WITH INITIALIZING NEW PQ, ELSE
         * SIMPLY GET PQ FROM MAP AND STORE THE PAIR.
         *
         * CHECK FOR LEFT OF NODE, IF IT EXISTS STORE THE NEW PAIR IN Q, ADD VERTICAL BY 1 AND DECREASE HORIZONTAL BY 1.
         * CHECK FOR RIGHT OF NODE, IF IT EXISTS STORE THE NEW PAIR IN Q, ADD VERTICAL BY 1 AND ADD HORIZONTAL BY 1.
         *
         * AFTER COMPLETION OF THE LOOP, ITERATE THROUGH ENTRIES AND GET INDIVIDUAL PQ AND STORE IT IN SUBLIST AND THEN IN
         * FINAL LIST.
         *
         *
         */
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);

        verticalTraversal(node);
    }
}
