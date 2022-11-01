package StacksAndQueues;

import java.util.HashMap;

/**
 * IMPORTANT
 */
public class LRUCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node == null)
            return -1;

        remove(node);
        insert(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.get(key) != null) {
            remove(map.get(key));
        }
        else if(capacity == map.size()) {
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        insert(node);
    }

    public void remove(Node node) {
        map.remove(node.key);
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void insert(Node node) {
        map.put(node.key, node);
        node.next = head.next;
        head.next = node;
        node.prev = head;
        node.next.prev = node;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WHAT WE HAVE TO DO IS PERFORM 2 FUNCTIONS AT ANY GIVEN STAGE, GET THE VALUE OF A CERTAIN KEY, PUT
         * THE KEY AND VALUE, BUT THE MAIN THING WE HAVE TO KEEP IN MIND IS THAT WE WOULD BE GIVEN SOME CAPACITY, IF WE HAVE
         * ALREADY INSERTED UPTO THAT CAPACITY, THEN WE HAVE TO REMOVE THE LEAST RECENTLY USED KEY AND VALUES AND THEN PLACE
         * THE NEW K,V
         *
         * FOR EG LETS SAY WE HAVE NODES OF K V - 1,1, AFTER THIS WE INSERT 2,2 AND AFTER THIS WE GET VALUE OF KEY 1,1 AND THEN
         * ADD NEW VALUE BUT IF CAPACITY IS 2, WE WOULD HAVE TO REMOVE THE LEAST USED NODE, THAT IS 2 NODE AS IT WAS LEAST RECENTLY
         * USED.
         *
         * APPROACH
         *
         * WE WILL DECLARE A CLASS NODE, HAVING KEY AND VALUE, ALONG WITH NEXT AND PREV NODE,
         * WE WILL DECLARE A HEAD AND TAIL NODE INITIALLY, MAKING SURE THESE ARE LEFT AND RIGHT CORNERS AND EVERY NODE WILL COME
         * BETWEEN THEM, SO WHENEVER WE HAVE TO ADD A NEW NODE, WE WILL MAKE SURE IT IS NEXT TO HEAD SO THAT IT IS THE LAST
         * USED AND WHENEVER WE HAVE TO REMOVE A NODE WE WILL REMOVE FROM TAILS PREV, WHICH MEANS BASICALLY WE ARE
         * STORING NEW NODES OR WHENEVER WE HAVE TO GET A NODE, WILL PLACE THEM IN THE LEFTMOST CORNER AND LAST USED
         * WILL BE REMOVED FROM RIGHTMOST CORNER.
         *
         * STEPS
         *
         * CREATE A NODE CLASS OF KEY VALUE, NEXT AND PREV, IN LRU CLASS DECLARE HEAD AND TAIL NODE,DECLARE A HASHMAP, OF
         * KEY INTEGER AND VALUE NODE, CONNECT HEAD AND TAIL, HEAD NEXT IS TAIL AND TAIL PREV IS HEAD.
         *
         * NOW IN GET, CHECK IF THE NODE IS IN HASHMAP, USING KEY FROM METHOD, IF IT IS, MEANS WE HAVE TO PLACE THIS NODE
         * NOW TO THE LEFT MOST AS IT IS LAST RECENTLY USED, SO REMOVE THE NODE FIRST, BY HAVING ITS PREVIOUS NEXT CONNECT TO
         * ITS NEXT AND ITS NEXT PREV CONNECT TO ITS PREV, AFTER THIS INSERT THIS AS A NEW NODE
         *
         * FOR PUT, CHECK IF THE NODE IS IN HASHMAP, THEN REMOVE THE NODE, ELSE IF CAPACITY IS EQUAL TO HASHMAP SIZE, MEANING
         * WE NEED TO REMOVE THE LAST ELEMENT(RIGHTMOST), SO PASS IN TAILS PREV FOR REMOVAL, NOW SIMPLY INSERT THE NEW NODE.
         *
         */
    }
}

class Node {
    Node next;
    Node prev;
    int val;
    int key;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
