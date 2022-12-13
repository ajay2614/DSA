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

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND A BINARY TREE FROM POSTORDER AND INORDER ARRAY
         *
         * APPROACH
         *
         * SIMILAR TO PRE AND IN, WE WILL PLACE INORDER IN MAP ALONG WITH ITS ORDER
         *
         * NOW SINCE POST ORDER ALWAYS HAVE ROOT AT LAST, GET THAT AND INSERT IN THE ROOTNODE
         *
         * NOW TO CALCULATE THE LEFT AND RIGHT VALUES, WE GET THE INORDER ROOT POSITION, AND TOTAL NUMS TO LEFT
         * USING INROOT - INSTART WE CAN GET NUMS TO LEFT AND RIGHT, NOW
         *
         * FOR LEFT TREE, INSTART WOULD BE INSTART, INEND WOULD BE INROOT-1, POSTSTART WOULD BE POSTART, POSTEND WOULD BE
         * POSTSTART+NUMS-1(SUPPOSE INROOT - INSTART RETURN 3, MEANS 3 NUMS ON THE LEFT, SO IN TERMS OF 0 BASED INDEXING
         * WE TAKE POSTSTART+NUMS-1).
         * FOR RIGHT TREE, INSTART WOULD BE INROOT+1, INEND WOULD BE INEND, POSTSTART WOULD BE POSTSTART+NUMS, POSTEND WOULD
         * BE POSTEND-1 AS WE HAVE TO ELIMINATE THE ROOT.
         *
         *
         *
         */
    }
}
