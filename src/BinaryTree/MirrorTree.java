package BinaryTree;

public class MirrorTree {
    void mirror(Node node) {
        if(node == null)
            return;
        mirror(node.left);
        mirror(node.right);

        swap(node, node.left, node.right);
    }

    void swap(Node root, Node left, Node right) {
        root.left = right;
        root.right = left;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO CREATE A MIRROR OF THE TREE GIVEN, SIMPLY TRAVERSE ALL THE WAY TO LEFT USING RECURSION
         * AND THEN TO RIGHT, IN BACKTRACKING SWAP THE LEFT WITH RIGHT.
         */
    }
}
