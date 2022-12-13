package BinarySearchTree;

public class FloorFromBst {
    public static int floorInBST(TreeNode_<Integer> root, int X) {
        int floor = -1;

        while(root != null) {
            if(root.data == X) {
                floor = root.data;
                break;
            }
            else if(root.data > X) {
                root = root.left;
            }
            else {
                floor = root.data;
                root = root.right;
            }
        }
        return floor;
    }
}
