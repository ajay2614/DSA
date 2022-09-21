package LinkedList;

import java.util.HashSet;

public class GetIntersectionBetweenTwoLL {
    public ListNode getIntersectionNodeBetterThanBrute(ListNode headA, ListNode headB) {

        HashSet<ListNode> hs = new HashSet<>();

        while(headA != null) {
            hs.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(hs.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
    public ListNode getIntersectionNodeOptimalApproach(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    /**
     * THE QUESTION STATES THAT THERE ARE TWO LINKED LIST WHICH ARE INTERSECTING EACH OTHER AT A CERTAIN POINT
     *
     * WE NEED TO FIND THAT INTERSECTION POINT
     *
     * THE BETTER THAN BRUTE APPROACH
     *
     * USE A HASHSET AND STORE EVERY VALUE FROM L1 IN THAT, IN L2 ITERATE AND CHECK IF THAT EXISTS, THEN RETURN THAT NODE
     *
     * MAKE SURE TO ADD NODE IN HASHSET AND NOT ITS VALUE AS VALUE CAN BE SAME
     *
     * OPTIMAL APPROACH
     *
     * ITERATE THROUGH BOTH THE LIST, WHEN THE SMALLER LIST BECOMES NULL, POINT THE DUMMY NODE TO HEAD OF OTHER LIST, NOW
     * SIMILARLY WHEN OTHER LIST BECOMES NULL POINT IT AT HEAD OF L1, NOW WHEN BOTH BECOMES EQUAL RETURN THAT NODE
     *
     * EXAMPLE SAY 1ST NODE IS 3 4 8 9 AND OTHER IS 1 2 3 4 8 1, WITH BOTH INTERSECTING AT 8
     *
     * WHEN WE START A BECOMES NULL AND B IS AT 8 ATM OF L2, SO A IS INIT TO L2, NOW WHEN B BECOMES NULL A IS 2 ATM AND
     * B WILL START FROM 3 AND A WILL START FROM 3, THEY ARE BOUND TO MEET AT 8,
     *
     * THIS APPROACH IN A WAY WE WANT TO CUT THE STEPS BETWEEN SMALLER LL AND BIGGER SUCH THAT THEY START AT SAME TIME
     *
     * NOTE : ANOTHER OPTIMAL APPROACH IS TO FIRST CALCULATE LENGTH OF BOTH, FIND THE DIFF, AND PLACE THE BIGGER LL TO
     * THE DIFF, NEVER USE THIS APPROACH IN INTERVIEW AS ABOVE ONE IS VERY SMALL AND EASY TO UNDERSTAND AND THIS ONE IS
     * LARGE AND COMPLEX
     */
}
