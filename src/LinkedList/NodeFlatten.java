package LinkedList;

class Node {
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}

public class NodeFlatten {
    Node flatten(Node root)
    {
        if(root == null || root.next == null)
            return root;

        root.next = flatten(root.next);
        root = merge(root, root.next);

        return root;
    }

    public Node merge(Node cur, Node nex) {
        Node node = new Node(0);
        Node temp = node;

        while(cur != null && nex != null) {
            if(cur.data < nex.data) {
                temp.bottom = cur;
                temp = temp.bottom;
                cur = cur.bottom;
            }
            else {
                temp.bottom = nex;
                temp = temp.bottom;
                nex = nex.bottom;
            }
        }

        if(cur != null)
            temp.bottom = cur;
        else
            temp.bottom = nex;

        return node.bottom;
    }

    /**
     *
     *
     * IN THIS WE ARE GIVEN A LL THAT HAS NEXT AND BOTTOM ALSO, MEANS A LIST LIKE
     *
     *      5   8
     *      7   9
     *
     * FROM QUESTION WE CAN SEE THAT BOTTOM ELEMENTS ARE SORTED AND ALSO LEFT TO RIGHT IT IS SORTED
     *
     * NOW WHAT WE CAN DO IS USE RECURSION AND GET TO THE LAST NODE D, RETURN IT, AND MERGE WITH THE LEFT OR CURRENT NODE C
     *
     * IN MERGE WHAT WE HAVE TO DO IS USE A DUMMY NODE, AND ITERATE THROUGH BOTH THE NODES TILL ONE OF THEM IS NULL
     * WHEN VAL OF A IS SMALLER ADD IT TO BOTTOM OR ELSE VICE VERSA
     *
     * THE IDEA IS TO CREATE A SINGLE MERGED LIST FROM ALL THE NODE, IN THE END RETURN DUMMY NODES BOTTOM AS IT CONTAINS
     * ALL THE VALUE.
     *
     */
}
