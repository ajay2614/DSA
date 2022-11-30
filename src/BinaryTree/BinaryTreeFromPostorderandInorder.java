package BinaryTree;

import java.util.HashMap;

public class BinaryTreeFromPostorderandInorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }
        return build(0,inorder.length-1,0,postorder.length-1,inorder, postorder, map);
    }

    public TreeNode build(int inStart, int inEnd, int postStart, int postEnd, int[] inorder, int[] postorder,
                          HashMap<Integer, Integer> map) {
        if(inStart > inEnd || postStart > postEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(root.val);
        int partition = inRoot - inStart;

        root.left = build(inStart, inRoot - 1, postStart, postStart + partition - 1, inorder, postorder, map);
        root.right = build(inRoot+1, inEnd, postStart + partition, postEnd - 1, inorder, postorder, map);

        return root;
    }
}
