package LinkedList;

public class SumOfTwoLL {
    /**
     * TC BIG O MAX(N,M)
     * SC BIG O(1)
     *
     * AS SMALLER 1 WOULD GET EXHAUSTED FIRST, IT COULD BE N IS BIGGER OR M IS BIGGER
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry !=0) {
            int sum = 0;

            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum/10;
            sum = sum%10;

            ListNode dummyNext = new ListNode(sum);
            temp.next = dummyNext;
            temp = temp.next;
        }
        return dummy.next;
    }

    /**
     * WE ARE GIVEN TWO LINKED LIST IN THIS QUESTION, WHAT WE NEED TO DO IS TO FIND THE SUM OF BOTH LL,
     *
     * FOR EG 8 3 1 AND 5 4 6, IT IS BASICALLY LIKE 645 + 138 = 783 SO WE NEED TO HAVE A RESULT LL AS
     * 3 8 7
     *
     * ANOTHER EG 2 4 3 AND 5 6 7 9 = 9765 + 342 = 10107, SO WE NEED TO GET 70101
     *
     * APPROACH
     *
     * WE WILL HAVE A DUMMY NODE, AND TEMP NODE INIT THAT DUMMY NODE VALUE, INIT A CARRY VARIABLE AS 0
     *
     * WE WILL RUN A WHILE LOOP TILL L1 != NULL OR L2 != NULL OR CARRY IS NOT EQUAL TO 0,
     * WHY CARRY = BECAUSE SAY 9 AND 9 WOULD BE 8 FIRST, AFTER THAT WE ARE LEFT WITH CARRY 1, SO 8 1, AS 18 IS 9+9
     *
     * INIT A SUM VARIABLE, GET VALUE OF L1 AND L2 IF NOT NULL, AND INIT BOTH TO THEIR NEXT, AFTER THIS
     * ADD CARRY IN THE SUM AS IF IT WAS 1 WE NEED TO ADD THAT IN SUM, AFTER THIS WE NEED TO INIT
     * SUM % 10 AS IN A NEW NODE, AND NEED TO INIT CARRY BY SUM = SUM/10, WHICH WILL GIVE US CARRY
     *
     * ASSIGN THIS NODE AS TEMP.NEXT, AND HAVE TEMP = TEMP.NEXT
     *
     * IN THE END RETURN DUMMY.NEXT
     *
     *
     *
     */
}
