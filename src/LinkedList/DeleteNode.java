package LinkedList;

public class DeleteNode {
    /**
     * TC BIG O(1)
     * SC BIG O(1)
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
    /**
     * THE QUESTION STATES THAT THERE IS A NODE GIVEN AND YOU NEED TO DELETE IT, NO ACCESS TO HEAD IS GIVEN, ONLY NODE IS GIVEN
     * WHAT WE WILL DO IS CHANGE VAL OF NODE TO ITS NEXT AND POINT IT TO NEXT.NEXT
     */
}
