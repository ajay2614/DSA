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

        root.left = build(prestart + 1, prestart + partition, instart, inRoot - 1, inorder, preorder,map);
        root.right = build(prestart + partition + 1, preend, inRoot + 1, inend, inorder, preorder, map);

        return root;
    }

    public static void main(String[] args) {
        /**
         *
         * IN THIS QUESTION WE ARE GIVEN AN INORDER(LRR) AND PREORDER(RLR), WE HAVE TO MAKE A BINARY TREE FROM IT
         *
         * APPROACH:
         *
         * 1ST WE WILL STORE THE INORDER VALUES IN A HASHMAP ALONG WITH THEIR ORDER
         *
         * USE A FUNCTION WHICH RETURNS TREENODE
         *
         * WE WILL USE THE STARTING AND ENDING VARIABLES FOR BOTH INORDER AND PREORDER,
         *
         * SO TO BUILD WE KNOW WE WILL NEED THE ROOT FIRST, SO AS WE KNOW PREORDERS 1ST IS ALWAYS ROOT, SO TAKE THAT,
         * NOW SINCE WE KNOW INORDER HAS ROOT IN THE MIDDLE AND LEFT AND RIGHT, SO WE CAN TAKE THE POSITION OF ROOT,
         * FROM THE MAP, NOW WITH THIS WE CAN GET THE VALUES ON THE LEFT AND RIGHT SUBTRACTING INROOT POSITION WITH
         * INSTART, (IT MIGHT SEEM THAT THIS IS OF NO USE AS LEFT MIGHT SEEM TO BE 0, BUT CONSIDER FOR THE RIGHT TRAVERSALS
         * LEFT WOULD NOT BE 0, HENCE THIS IS USED). NO BUILD THE LEFT AND RIGHT,
         *
         * FOR LEFT, THE PRESTART WOULD BE NOW BE +1, AS IT IS ROOT LEFT RIGHT, PREEND WOULD BE PRESTART + NUMS
         *           (SUPPOSE NUMS WOULD RETURN 3, MEANS 3 ELEMENTS ON LEFT, HENCE FOR POSTEND WOULD MEANS START+1
         *           AND TILL INDEX 3( ELEMENTS WITH IN 1,2,3)).
         *           ,
         *           THE INSTART WOULD BE INSTART, INEND WOULD BE INROOT-1
         *
         * FOR RIGHT, THE PRESTART WOULD BE PRESTART + NUMS + 1, PREEND WOULD BE PREEND
         *            THE INSTART WOULD BE INROOT + 1, INEND WOULD BE INEND.
         *
         *
         */
    }
}
