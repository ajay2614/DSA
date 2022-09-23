package LinkedList;

import java.util.HashMap;

class Node2 {
    int val;
    Node2 next;
    Node2 random;

    public Node2(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithARandomPointer {
    public Node2 copyRandomListBrute(Node2 head) {
        HashMap<Node2, Node2> map = new HashMap<>();
        Node2 temp = head;
        while(temp != null) {
            map.put(temp, new Node2(temp.val));
            temp = temp.next;
        }

        Node2 tmp = head;

        while(tmp != null) {
            map.get(tmp).next = map.get(tmp.next);
            map.get(tmp).random = map.get(tmp.random);

            tmp = tmp.next;
        }

        return map.get(head);

    }

    public Node2 copyRandomListOptimal(Node2 head) {
        Node2 iter = head;
        while(iter != null) {
            Node2 front = iter.next;
            Node2 temp = new Node2(iter.val);
            iter.next = temp;
            temp.next = front;

            iter = front;
        }

        iter = head;

        while(iter != null) {
            if(iter.random != null)
                iter.next.random = iter.random.next;
            iter = iter.next.next;
        }

        iter = head;

        Node2 dummy = new Node2(0);
        Node2 copy = dummy;

        while(iter != null) {
            Node2 temp = iter.next;
            Node2 front = temp.next;
            iter.next = front;
            iter = front;
            copy.next = temp;
            copy = copy.next;
        }
        return dummy.next;
    }

    /**
     * THE QUESTION STATES THAT WE ARE GIVEN A LINKED LIST, EACH NODE HAS TWO POINTERS, ONE TO NEXT AND OTHER TO RANDOM NODE, RANDOM
     * CAN ALSO BE NULL.
     *
     * WE NEED TO RETURN A DEEP COPY OF THE LINKED LIST
     *
     * BRUTE APPROACH
     *
     * IN BRUTE APPROACH WE USE A HASHMAP, IN HASHMAP WE STORE ACTUAL NODE AND DUMMY NODE INIT WITH ACTUAL VALUE.
     * WE HAVE COLLECTED VALUES NOW TO STORE NEXT AND RANDOM IN THE DUMMY NODES WE USE ANOTHER LOOP
     *
     * STORE NODE VALUE NEXT AS MAP.GET(TMP.NEXT)
     *
     * WHAT HAPPENING IS ABOVE THAT WHEN WE DO MAP.GET(TEMP).NEXT = MAP.GET(TEMP.NEXT)
     *
     * MEANS DUMMY NODE WE INIT WILL BE FETHCHED AND BE POINTED AS NEXT TO THE DUMMY NODES.
     *
     * SAME WAY WE DO FOR RANDOM
     *
     * IN THE END WE RETURN MAP.GET(HEAD), AS THE FIRST DUMMY NODE STARTS FROM HERE.
     *
     * OPTIMAL APPROACH
     *
     * BY THIS APPROACH WE FIRST NEED TO STORE THE DUMMY NODES BETWEEN TWO ACTUAL NODE, OR IN RIGHT IF NODE IS LAST,
     *
     * EG FOR 1 2, WE STORE A DUMMY NODE 1` AND 1 1` 2, SO FIRSTLY WE RUN LOOP AND SET DUMMY NODE AS NEXT OF TEMP
     * AND TEMP.NEXT IS SET NEXT OF DUMMY NODE.
     *
     * NOW WE DO SIMILAR PROCESS FOR RANDOM, WE KNOW THE NODES STORED, IF AN ACTUAL NODE RANDOM IS NOT NULL IT MEANS
     * FOR DUMMY NODE NEXT TO IT, RANDOM WOULD BE TEMP.RANDOM.NEXT, AS TEMP.RANDOM IS ACTUAL ONE.
     *
     * IN THE END WE USE A DUMMY NODE AND ITERATE THROUGH IT AND GET THE VALUES FROM TEMP.NEXT AND SET IT AS THAT DUMMY
     * NEXT, MAKE SURE TO MAKE TEMP.NEXT AS TEMP.NEXT.NEXT BECAUSE WE NEED TO HAVE THE INPUT LIST SAME IN THE END
     *
     * RETURN DUMMY NEXT
     *
     */
}
