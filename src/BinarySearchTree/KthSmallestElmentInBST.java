package BinarySearchTree;

public class KthSmallestElmentInBST {

    public int kthSmallestBrute(TreeNode root, int k) {
        int arr[] = new int[2];

        inorder(root, k, arr);
        return arr[1];
    }

    public void inorder(TreeNode node, int k, int arr[]) {
        if(node == null)
            return;
        inorder(node.left, k, arr);

        arr[0]++;
        if(arr[0] == k)
            arr[1] = node.val;

        inorder(node.right, k, arr);
    }

    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        int ans = 0;
        while(root != null) {
            if(root.left == null) {
                count++;
                if(count == k) {
                    ans = root.val;
                    break;
                }
                root = root.right;
            }
            else {
                TreeNode cur = root.left;
                while(cur.right != null && cur.right != root) {
                    cur = cur.right;
                }

                if(cur.right == null) {
                    cur.right = root;
                    root = root.left;
                }
                else {
                    cur.right = null;
                    count++;
                    if(count == k) {
                        ans = root.val;
                        break;
                    }
                    root = root.right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * SINCE WE KNOW INORDER PRODUCES THE RESULT IN A SORTED ORDER, NOW USING INORDER I WE USE A COUNTER THEN WE CAN EASILY
         * GET THE KTH SMALLEST ELEMENT HOWEVER IF WE USE THE MORRIS INORDER TRAVERSAL INORDER WE CAN GET THE MOST OPTIMAL
         * SOLUTION.
         */
    }
}
