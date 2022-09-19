package LinkedList;


class ListNode {
      int val;
     ListNode next;
     ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class ReverseLinkList {

    /**
     * TC BIG O(N)
     * SC BIG O(1)
     */
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        /**
         *  THE QUESTION STATES THAT REVERSE A LINKED LIST
         *
         *  AS WE KNOW A LL IS LIKE 1 -> 2 -> 3 -> 4, SO IF WE CAN CHANGE THE POINTER TO OPPOSITE DIRECTION, WE WILL BE ABLE TO
         *  FIND THE ANSWER
         *
         *  WE WILL USE TWO DUMMY VARIABLES, PREV AND A NEXT
         *
         *  WE WILL ASSIGN PREV TO NULL IN THE BEGINNING
         *
         *  RUN A WHILE LOOP TILL HEAD IS NOT EQUAL TO NULL
         *
         *  HAVE A NEW NODE CUR, STORE HEAD VALUE IN THAT NODE, HAVE HEAD AS HEAD.NEXT, STORE PREV IN CUR.NEXT
         *  PREV = CUR.
         *
         *  IN THE END PREV WOULD BE RETURNED AS IT WOULD BE HAVING LAST LL.
         */
    }
}
