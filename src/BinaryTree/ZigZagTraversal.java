package BinaryTree;

import java.util.*;

public class ZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;

        while (!q.isEmpty()) {
            List<Integer> subAns = new ArrayList<>();
            int size = q.size();

            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();

                if(node.left != null)
                    q.offer(node.left);
                if(node.right != null)
                    q.offer(node.right);

                if(reverse)
                    subAns.add(0, node.val);
                else
                    subAns.add(node.val);
            }
            reverse = reverse ? false : true;
            ans.add(subAns);
        }
        return ans;
    }
}
