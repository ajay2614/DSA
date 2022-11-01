package LinkedList;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        do {
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }while(slow != fast);

        fast = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * WILL USE THE CONCEPT OF FAST AND SLOW POINTER AS DONE FOR FINDING DUPLICATE IN ARRAY
     *
     * FIRST START FAST AND SLOW POINTER, FAST RUNS TWICE, WHEN THEY INTERSECT, START FAST FROM HEAD AND SLOW
     * WHEN THEY MEET WE HAVE OUR CYCLE POINT.
     *
     * WHY WE USE FAST == NULL AND FAST.NEXT == NULL, BECAUSE FAST.NEXT AND FAST.NEXT.NEXT WOULD FAIL TESTCASES
     * AS AN EG SAY LL IS 1, SO FAST.NEXT WOULD BE NULL HENCE FAST.NEXT.NEXT == NULL WOULD FAIL
     */
}
