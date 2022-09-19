package LinkedList;

public class RemoveNthFromEnd {
    /**
     * TC BIG O(2N)
     * SC BIG O(1)
     */
    public ListNode removeNthFromEndBrute(ListNode head, int n) {

        ListNode res = head;
        ListNode cur = head;
        int k = 0;
        while(cur != null) {
            k++;
            cur = cur.next;
        }

        k = k-n;

        if(k == 0) {
            return res.next;
        }

        while(k > 1) {
            head = head.next;
            k--;
        }

        head.next = head.next.next;

        return res;

    }

    /**
     * TC BIG O(N)
     * SC BIG O(1)
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummyStart = new ListNode();
        dummyStart.next = head;
        ListNode fast = dummyStart;
        ListNode slow = dummyStart;
        int k = 0;

        while(k != n) {
            k++;
            fast = fast.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return dummyStart.next;
    }

    /**
     *
     * IN THIS QUESTION WE ARE GIVEN N, WE NEED TO DELETE NTH ELEMENT FROM END, FOR EG 1 2 3 4 5, N=2, 4 IS 2ND LAST
     * ELEMENT FROM END MEANS WE NEED TO DELETE 4,
     *
     *
     * BRUTE APPROACH
     *
     * WE WILL RUN A LOOP AND CALCULATE TOTAL LENGTH, WHICH WOULD BE 5, FOR ABOVE
     *
     * AFTER THIS IF K=K-N, IF K IS 0, MEANS FIRST ELEMENT, IN THIS CASE WE SIMPLY RETURN HEAD.NEXT;
     *
     * ELSE WE TRAVERSE TILL K IS NOT EQUAL TO 1, BECAUSE WE NEED TO GET PREV ELEMENT AND NOT THE ELEMENT TO BE DELETED,
     * IN THE END SIMPLY HAVE CUR.NEXT = CUR.NEXT.NEXT
     *
     *
     * OPTIMAL APPROACH
     * INIT A NEW NODE, HAVE HEAD AS NEXT OF THAT NODE, HAVE FAST AND SLOW NODE AND THEIR VALUE IS DUMMY NODE
     *
     * INIT A NEW VARIABLE K AS 0, RUN A LOOP TILL K != N
     *
     * K++, AND HAVE FAST AS FAST.NEXT IN THE LOOP,
     *
     * NOW RUN A NEW LOOP TILL FAST.NEXT != NULL
     * HAVE BOTH SLOW AND FAST AS THEIR NEXT IN THE LOOP
     *
     * IN THE END HAVE SLOW.NEXT AS SLOW.NEXT.NEXT
     *
     * RETURN DUMMY.NEXT
     *
     * WHY DUMMY.NEXT AND NOT HEAD.NEXT, BECAUSE THERE COULD BE CASE N=5, LIKE ABOVE, FAST WILL MOVE TILL 5TH NODE AND SINCE
     * ITS NEXT IS EQUAL TO NULL, 2ND LOOP WILL NOT WORK, SO SLOW.NEXT = SLOW.NEXT.NEXT, WITH THIS DUMMY NEXT WOULD BE POINTING
     * TO 2ND ELEMENT SO THAT IS WHY RETURN DUMMY.NEXT
     *
     *
     */
}
