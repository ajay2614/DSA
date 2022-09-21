package LinkedList;

public class IsPalindromeLL {
    public boolean isPalindrome(ListNode head) {
        ReverseLinkList reverseLinkList = new ReverseLinkList();
        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode next = reverseLinkList.reverseList(slow.next);
        slow = next;
        while(slow != null) {
            if(head.val != slow.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindromeWhenListALsoReturn(ListNode head) {
        ReverseLinkList reverseLinkList = new ReverseLinkList();

        if(head == null || head.next == null)
            return true;
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = reverseLinkList.reverseList(slow.next);

        ListNode dummySlow = slow.next;
        ListNode dummyHead = head;


        while(dummySlow != null) {
            if(dummyHead.val != dummySlow.val)
                return false;
            dummySlow = dummySlow.next;
            dummyHead = dummyHead.next;
        }

        slow.next = reverseLinkList.reverseList(slow.next);

        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }

        return true;
    }

    /**
     * THE APPROACH IS TO FIND THE LEFT MIDDLE IF RIGHT AND MIDDLE IF LEFT OF LL
     *
     * TO DO THIS WE USE SLOW AND FAST NODE CONCEPT TO FIND LL,
     *
     * WHY WE NEED TO FIND LEFT MIDDLE FOR EVEN, BECAUSE HAD WE FOUND RIGHT MIDDLE THE ANSWER WOULD HAD BEEN SAME,
     * BUT THEN WE WOULD BE REVERSING FROM SLOW, RATHER THAN SLOW.NEXT, AS IN REVERSE OUR PREV WOULD START FROM
     * NULL HENCE LIST WOULD HAVE BEEN SEPERATED, SO IF WE HAD TO FIND ACTUAL LIST AGAIN, WE WOULD NOT BE ABLE
     * TO DO, SO ALWAYS PASS SLOW.NEXT AS REVERSE LIST HERE
     *
     * NOW START FROM SLOW.NEXT AND HEAD AND CHECK IF THE NODE VAL ISNT SAME THEN RETURN FALSE
     * ELSE TRUE
     *
     * IF NEED TO RETURN LIST USE DUMMY POINTERS FOR SLOW.NEXT AND HEAD RATHER THAN USING ACTUAL.
     *
     * AND REVERSE AGAIN BY SLOW.NEXT SAME WAY.
     *
     */

}
