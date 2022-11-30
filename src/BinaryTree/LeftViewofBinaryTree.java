package BinaryTree;

import java.util.ArrayList;

class Node
{
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
public class LeftViewofBinaryTree {
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        recursion(root, ans, 0);
        return ans;
    }

    public void recursion(Node node, ArrayList<Integer> ans, int level) {
        if(node == null)
            return;
        if(ans.size() == level)
            ans.add(node.data);

        recursion(node.left, ans, level+1);
        recursion(node.right, ans, level+1);
    }
    public static void main(String[] args) {
        /**
         *
         * AS THE NAME SUGGESTS WE NEED TO FIND THE LEFT VIEW OF A BINARY TREE
         *
         * A COMMON THOUGHT MAY ARISE IS TO USE RECURSION, ADD THE NODE, TRAVERSE FOR NODE.LEFT IF IT IS NOT NULL, ELSE TRAVERSE
         * FOR NODE.RIGHT, AS WE MAY THINK THAT SINCE IF NODE DOESN'T HAVE LEFT THEN WE CAN MOVE RIGHT, BUT THE PROBLEM HERE IS
         * SUPPOSE FOR A TREE HEIGHT OF LEFT NODE IS 3 BUT HEIGHT OF RIGHT IS 4, NOW WE WOULD NEED TO INCLUDE THE LAST NODE
         * WHICH COULD BE VISIBLE AT RIGHT TOO, BUT THIS SOLN WOULDN'T HAVE COVERED THAT AND WOULD ONLY HAVE COVERED THE LEFT SIDE
         *
         * SO TO SOLVE THIS WE WILL USE A SMART TRICK OF COMPARING LEVEL WITH LIST SIZE, IF THE LEVEL IS SAME, MEANS ANS HAS
         * LEVEL - 1 NODES, HENCE FOR THAT LEVEL THE SLOT IS AVAILABLE, SO WE WILL SIMPLY ADD NODE, WE WILL RUN THE RECURSION
         * FOR LEFT NODES FIRST SO THAT LEFT VIEW IS COVERED IF LEFT ONES ARE AVAILABLE AND WHEN RIGHT WILL RUN IT WILL NOT
         * ADD IF ANS IS MORE THAN LEVEL. THIS WAY WE CAN EASILY FIND THE SOLUTION FOR LEFT VIEW OR THE VISE VERSA FOR THE RIGHT
         * VIEW.
         */
    }
}
