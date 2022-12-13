package BinarySearchTree;
class Node
{
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
class Res {
    Node pre = null;
    Node succ = null;
}
public class FindPredecessorAndSuccessor {
    public static void findPreSuc(Node root, Res p, Res s, int key) {
        p.pre = findPre(root, key);
        s.succ = findSuc(root, key);
    }

    public static Node findPre(Node root, int key) {
        Node pre = null;
        while(root != null) {
            if(root.data >= key) {
                root = root.left;
            }
            else {
                pre = root;
                root = root.right;
            }
        }
        return pre;
    }

    public static Node findSuc(Node root, int key) {
        Node succ = null;
        while(root != null) {
            if(root.data <= key) {
                root = root.right;
            }
            else {
                succ = root;
                root = root.left;
            }
        }
        return succ;
    }
}
