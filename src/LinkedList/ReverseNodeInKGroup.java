package LinkedList;
/**
VERY IMPORTANT/HARD
 */
public class ReverseNodeInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode pre = dummy;
        ListNode c = head;
        int count = 0;
        while(c != null) {
            count++;
            c = c.next;
        }

        while(count >= k) {
            ListNode cur = pre.next;
            ListNode nextN = cur.next;

            for(int i=1;i<k;i++) {
                cur.next = nextN.next;
                nextN.next = pre.next;
                pre.next = nextN;
                nextN = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;
    }

    /**
     * IN THIS QUESTION WE ARE GIVEN A LIST AND K, WHAT WE NEED TO DO IS ROTATE LIST TILL KTH INTERVALS
     *
     * MEANING - FOR A LIST 1 2 3 4 5 6 7 8, AND K=3, 3 2 1 6 5 4 7 8
     *
     * TILL 3RD INTERVAL REVERSED 1 2 3, THEN FROM 4-6, REVERSED 4 5 6, NOTICE WE DIDN'T REVERSE 7 8
     * THIS IS BECAUSE ELEMENT COUNT HERE WAS SMALLER THAN K
     *
     * STEPS
     *
     * FIRST GET THE LENGTH OF LIST
     *
     * WE WILL USE THREE NODES AT EVERY STAGE TO GET OUR ANSWER PRE, CUR, AND NEXT
     *
     * INITIALIZE ALL THESE THREE TO DUMMY NODE FOR NOW HAVING ITS NEXT AS HEAD
     *
     * RUN A WHILE LOOP TILL COUNT >= K, THIS IS BECAUSE WHEN IT IS LESSER WE DON'T NEED TO MODIFY AS DONE ABOVE WITH 7 8
     *
     * IN THE START ASSIGN CUR AS PRE NEXT AND NEXT AS CUR NEXT
     *
     * RUN LOOP INSIDE FOR K-1 TIMES, AS FOR 1 2 3, WE NEED TO MODIFY TWICE, SO RUN FROM 1 TO < K
     *
     * IN THIS LOOP -
     * ASSIGN CUR.NEXT AS NEXT.NEXT, 1 -> 3
     * ASSIGN NEXT.NEXT TO PREV.NEXT, 2 -> 1
     * PREV.NEXT = NEXT, PREV -> 2
     * NEXT = CUR.NEXT, NEXT BECOMES 3
     *
     * WHY WE POINTED NEXT.NEXT TO PREV.NEXT AND NOT CUR
     *
     * BECAUSE IF WE HAD DONE THAT THEN IN NEXT ITERATION, NEXT.NEXT WOULD HAD BECOME 3->1, BUT WE ARE NOT CHANGING THE VALUE OF CUR
     * HENCE WE USED PREV,
     *
     * 1 -> 4
     * 3 -> 2
     * PREV.NEXT 3
     * NEXT = 4
     * AFTER THIS PREV WOULD COME OUT OF LOOP
     * NOW ASSIGN PREV = CUR, AFTER THIS PREV = 1, AND CUR WOULD BE 4 AND NEXT WOULD BE 5, BY SAME LOOP WE WILL DO AGAIN
     * FOR 4 5 6.
     */
}
