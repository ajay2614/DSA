package LinkedList;

public class Merge2SortedLL {

    /**
     * TC BIG O(N+M)
     * SC BIG O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;

        if(l1.val > l2.val) {
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }

        ListNode res = l1;

        while(l1 != null && l2 != null) {
            ListNode temp = null;

            while(l1 != null && l1.val <= l2.val) {
                temp = l1;
                l1 = l1.next;
            }

            temp.next = l2;

            ListNode tmp = l1;
            l1 = l2;
            l2 = tmp;
        }
        return res;
    }

    /**
     * WE ARE GIVE 2 SORTED LL, WE NEED TO MERGE THEM
     *
     * WHAT WE WILL DO IN THIS IS FIRST CHECK IF L1==NULL, THEN RETURN L2 OR VICE VERSA
     * INITIALLY WE WILL CHECK IF L1 IS GREATER THAN L2, IF IT IS WE WILL SWAP, WHY THIS?, BECAUSE WE NEED A DUMMY LIST CUR,
     * WHICH NEEDS TO START FROM SMALLER ELEMENT
     * AFTER THIS INIT DUMMYLIST WITH L1.
     *
     * RUN WHILE LOOP TILL L1 && L2 IS NOT NULL
     *
     * HAVE A VARIABLE TEMP AS NULL, RUN A WHILE LOOP TILL L1 <= L2.VAL, KEEP ON GOING ITS NEXT AND KEEP ON STORING L1 IN TEMP
     *
     * WHEN WE ENCOUNTER ELEMENT OF L2 WHAT WE WILL DO IS POINT TEMP.NEXT AS L2. AND SWAP L1 & L2
     *
     * DRY RUN SUPPOSE 1 3 4 AND 1 2 5, WHEN 1 BECOMES 3, LOOP WILL BREAK, AND HERE TEMP IS 1, SO WE WILL POINT TO L2
     * MAKING LIST 1 1 2 5 AND 3 4, WE WILL SWAP L1 & L2, BECAUSE OTHERWISE L1 WOULD ALWAYS BE BIGGER THAN L2.
     *
     *
     */
}
