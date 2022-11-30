package BinaryTree;

import java.util.HashMap;

public class BinaryTreeFromInorderandPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }

        return build(0, preorder.length - 1, 0, inorder.length - 1, inorder, preorder, map);
    }

    public TreeNode build(int prestart, int preend, int instart, int inend, int[] inorder,
                          int[] preorder, HashMap<Integer, Integer> map) {
        if(prestart > preend || instart > inend)
            return null;

        TreeNode root = new TreeNode(preorder[prestart]);
        int inRoot = map.get(root.val);
        int partition = inRoot - instart;

        root.left = build(prestart + 1, prestart + partition, instart, inRoot, inorder, preorder,map);
        root.right = build(prestart + partition + 1, preend, inRoot + 1, inend, inorder, preorder, map);

        return root;
    }
}
