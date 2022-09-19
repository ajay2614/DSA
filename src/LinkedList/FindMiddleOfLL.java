package LinkedList;

public class FindMiddleOfLL {

    /**
     * TC BIG O(N)
     * SC BIG O(1)
     */
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;


        while(temp != null && temp.next != null) {
            head = head.next;
            temp = temp.next.next;
        }
        return head;
    }

    /**
     * THE QUESTION WANTS US TO RETURN LL FROM MIDDLE, WE WILL USE A SLOW AND FAST POINTER TILL FAST IS NOT NULL OR
     * FAST.NEXT IS NOT NULL
     *
     * FOR EG FOR 1->2->3->4->5->6, FAST WILL RUN 1 TO 3, SLOW 1 TO 2, FAST 3 TO 5, SLOW 2 TO 3, FAST WILL BECOME NULL
     * AND SLOW WILL 4, HENCE WE FIND OUR ANS
     */
}
