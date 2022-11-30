package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new ArrayList<>();

            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                subAns.add(node.val);
                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);
            }

            ans.add(subAns);
        }

        return ans;
    }

    public static void main(String[] args) {
        /**
         * A SIMPLE IMPLEMENTATION OF LEVEL ORDER TRAVERSAL, ADD ROOT NODE IN Q, RUN TILL Q IS EMPTY, DECLARE SUB LIST, RUN
         * FOR Q SIZE AND GET ALL THE NODES DATA, AND ADD TO SUB LIST, ALSO PUSH THE CHILD NODES, ADD SUBLIST IN ANS, RETURN ANS.
         */
    }
}
