package BinarySearchTree;

import java.util.ArrayList;

public class KthLargestElementInBst {
    public int kthLargest(Node root,int K) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);

        return ans.get(ans.size() - K);
    }

    public void inorder(Node root, ArrayList<Integer> ans) {
        if(root == null)
            return;

        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }
}
