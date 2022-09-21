package LinkedList;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        do {
            if(fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }while(slow != fast);

        return true;
    }

    /**
     * WE WILL USE FAST AND SLOW POINTER, IF THEY MEET MEANS THERE IS A CYCLE.
     */
}
