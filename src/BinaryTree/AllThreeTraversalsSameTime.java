package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class BinaryTreePair {
    int num;
    BinaryTreeNode<Integer> node;

    BinaryTreePair(int num, BinaryTreeNode<Integer> node) {
        this.num = num;
        this.node = node;
    }
}
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}
public class AllThreeTraversalsSameTime {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)
            return ans;
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        Stack<BinaryTreePair> st = new Stack<>();
        st.push(new BinaryTreePair(1, root));

        while(!st.isEmpty()) {
            BinaryTreePair p = st.pop();

            if(p.num == 1) {
                pre.add(p.node.data);
                p.num++;
                st.push(p);
                if(p.node.left != null) {
                    st.push(new BinaryTreePair(1,p.node.left));
                }
            }
            else if(p.num == 2) {
                in.add(p.node.data);
                p.num++;
                st.push(p);
                if(p.node.right != null) {
                    st.push(new BinaryTreePair(1,p.node.right));
                }
            }
            else {
                post.add(p.node.data);
            }
        }

        ans.add(in);
        ans.add(pre);
        ans.add(post);

        return ans;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO USE ALL THREE TRAVERSALS AT THE SAME TIME
         *
         * APPROACH
         *
         * USE A STACK AND INSIDE IT STORE PAIR OF NUM AND NODE
         *
         * ADD ROOT TO STACK, NOW THE APPROACH OR SERIES TO SOLVE IS
         *
         * RUN TILL STACK IS NOT EMPTY
         *
         * POP FROM STACK
         *
         * IF(NODE HAS NUM 1, ADD IT INTO THE PREORDER, INCREASE NUM BY 1 AND PUSH IT BACK, CHECK IF IT HAS LEFT, IF IT HAS
         * THEN PUSH THE NEW PAIR OF STACK LEFT AND 1 AS NUM.
         *
         * IF(NODE HAS NUM 2, ADD IT INTO THE INORDER, INCREASE NUM BY 1 AND PUSH IT BACK, CHECK IF IT HAS RIGHT, IF IT HAS
         * THEN PUSH THE NEW PAIR OF STACK RIGHT AND 1 AS NUM.
         *
         * IF(NODE HAS NUM 3, DO NOTHING EXCEPT ADDING IT IN POST ORDER)
         *
         * ADD ALL THE THREE LIST IN THE MAIN ANS LIST.
         */
    }
}
