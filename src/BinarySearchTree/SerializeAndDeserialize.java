package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserialize {

    public String serialize(TreeNode root) {
        if(root == null)
            return "";

        StringBuilder res = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                TreeNode node = q.poll();
                if(node == null) {
                    res.append("# ");
                    continue;
                }
                res.append(node.val + " ");
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if(data.equals(""))
            return null;


        /**
         * WHY USING "." DIDN'T WORK?
         *
         * java.lang.String.split splits on regular expressions, and . in a regular expression means "any character".
         *
         * Try temp.split("\\.").
         */

        String[] arr = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        for(int i=1;i<arr.length;i++) {
            TreeNode parent = q.poll();
            if(!arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.offer(left);
            }
            if(!arr[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }

    public static void main(String[] args) {

        /**
         *
         * IN THIS QUESTION WE ARE GIVEN A TREE, WE NEED TO SERIALIZE IT INTO STRING AND THEN DE SERIALIZE IT BACK TO TREE
         *
         * WE WILL SOLVE THIS USING LEVEL ORDER TRAVERSAL
         *
         * FOR SERIALIZING
         *
         * SIMPLY USE THE LEVEL ORDER TECHNIQUE AND KEEP APPENDING THE NODES IN THE STRING, HOWEVER RATHER THAN SKIPPING
         * THE NULL ONES ADD NULL ONES TOO, AND WHEN THE POPPED NODE IS INDEED NULL, USE ANY CHARACTER, MAKE SURE WHILE
         * APPENDING ADD SPACE SO THAT IT CAN BE SPLIT WHILE DESERIALIZING.
         *
         * FOR DESERIALIZING
         *
         * WHILE DESERIALIZING, FIRST SPLIT THE STRING INTO THE ARRAY BASED ON SPACE, NOW GET THE ROOT AT INDEX 0, NOW
         * ADD THIS IN Q, RUN TILL ARR LENGTH, IN THE FOR LOOP SKIP THE NULL BY ONLY SELECTING IF THE STRING IS NOT #,
         * THIS IS WHY WE HAD ADDED NULL IN Q WHILE SERIALIZING, BECAUSE HAD WE SKIPPED THEM THEN WE MIGHT HAVE ADDED WRONG
         * CHILD TO PARENT. KEEP POPPING THE PARENT AND ADDING CHILD AND THEN ALSO ADDING THAT IN QUEUE.
         *
         * RETURN NODE.
         *
         */

    }
}
