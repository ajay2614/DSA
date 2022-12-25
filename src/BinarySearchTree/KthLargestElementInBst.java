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

    public static void main(String[] args) {
        /**
         * IN THIS WE WILL NEED AN ARRAY OR WILL NEED TO CALCULATE SIZE BECAUSE TO GET KTH LARGEST WE NEED
         * TOTAL NODES.
         */
    }
}
