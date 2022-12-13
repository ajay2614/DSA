package BinarySearchTree;
class TreeNode_<T> {
    T data;
    TreeNode_<T> left;
    TreeNode_<T> right;

    TreeNode_(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
};
public class CeilFromBst {
    public  static int findCeil(TreeNode_<Integer> root, int x) {
        int ceil = -1;

        while(root != null) {
            if(x > root.data) {
                root = root.right;
            }
            else if(x == root.data) {
                ceil = root.data;
                break;
            }
            else {
                ceil = root.data;
                root = root.left;
            }
        }
        return ceil;
    }
}
