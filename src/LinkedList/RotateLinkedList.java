package LinkedList;

public class RotateLinkedList {


    /**
     *  Time Complexity: O(Number of nodes present in the list*k)
     *
     *  Reason: For k times, we are iterating through the entire list to get the last element and move it to first.
     *
     *  Space Complexity: O(1)
     */
    public static ListNode rotateRightBrute(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        for (int i = 0; i < k; i++) {
            ListNode temp = head;
            while (temp.next.next != null) temp = temp.next;
            ListNode end = temp.next;
            temp.next = null;
            end.next = head;
            head = end;
        }
        return head;
    }

    /**
     * Time Complexity: O(length of list) + O(length of list – (length of list%k))
     *
     * Reason: O(length of the list) for calculating the length of the list. O(length of the list – (length of list%k)) for breaking link.
     *
     * Space Complexity: O(1)
     *
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)
            return head;

        int count  = 1;
        ListNode cur = head;

        while(cur.next != null) {
            count++;
            cur = cur.next;
        }

        k = k % count;
        if(k == 0)
            return head;
        cur.next = head;
        count = count - k;
        while(count != 0) {
            cur = cur.next;
            count--;
        }

        head = cur.next;
        cur.next = null;

        return head;
    }

    /**
     * ROTATE LINKED LIST
     *
     * WE ARE GIVEN A NUMBER K, WE HAVE TO ROTATE IT TILL K TURNS
     * FOR EG LIST OF 1 2 3, FOR K = 2, FIRST ROTATION MEANS 3 1 2, SECOND ROTATION MEANS 2 3 1
     *
     * BRUTE APPROACH, IN BRUTE APPROACH RUN LOOP FROM 0 TO K-1, AND EVERY TIME ITERATE TO LAST AND SET LAST NEXT AS HEAD
     *
     * AS WE KNOW ABOVE APPROACH HAS HIGH COMPLEXITY AND IS ALMOST IMPOSSIBLE TO CALCULATE FOR HIGH K LIKE 10000 K VALUES
     *
     * WE DISCARD THIS APPROACH
     *
     *
     * OPTIMAL APPROACH
     *
     * SUPPOSE K IS EQUAL TO 10 AND LENGTH IS 5, FOR 10 K TURNS WE KNOW THAT LIST WOULD BECOME THE SAME AS INITIAL
     *
     * SUPPOSE K IS 12 AND L IS 5, WE KNOW 2 ROTATIONS ARE REQUIRED, SO WE CAN GET THE MINIMAL FOR OF K
     *
     * NOW WE ALSO KNOW THAT FOR K = 2, L = 5, MEANS LL OF 1 2 3 4 5, RESULT WOULD BE 4 5 1 2 3, AS LAST TWO ELEMENTS
     * WOULD COME FORWARD
     *
     * SO FIRST CALCULATE LENGTH, AND AT THE END MAKE SURE LAST POINTER POINTS TO HEAD AS FOR 1 2 3 4 5, 5 NEEDS TO
     * POINT AT 1.
     * SO WE WILL ITERATE TILL L = 5-2, THAT IS TILL 3RD AFTER THIS HAVE HEAD IS CUR.NEXT, AS HEAD WOULD BE HAVING CYCLE
     * HERE STARTING FROM 4, WE NEED TO HAVE CUR.NEXT WHICH WAS 3.NEXT =4 POINT TO NULL AS WE NEED TO DELETE LINK/POINTER
     * FROM 3 TO 4.
     * SO SET CUR.NEXT AS NULL
     *
     *
     */
}
