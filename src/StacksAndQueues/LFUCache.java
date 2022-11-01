package StacksAndQueues;

import java.util.HashMap;

/**
 * VERY VERY DIFFICULT
 */
class DNode {
    int key;
    int val;
    int freq;
    DNode prev;
    DNode next;

    DNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.freq = 1;
    }
}

class DList {
    int size;
    DNode head;
    DNode tail;

    DList() {
        this.size = 0;
        head = new DNode(0,0);
        tail = new DNode(0,0);
        head.next = tail;
        tail.prev = head;
    }

    void add(DNode node) {
        size++;
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    void remove(DNode node) {
        size--;
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

}
public class LFUCache {

    int minFreq = 0;
    int size = 0;
    int capacity;
    HashMap<Integer, DNode> nodeMap = new HashMap<>();
    HashMap<Integer, DList> freqMap = new HashMap<>();
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        DNode node = nodeMap.get(key);
        if(node == null)
            return -1;
        update(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(capacity == 0)
            return;
        if(nodeMap.get(key) != null) {
            DNode node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else {
            size++;
            if(size > capacity) {
                DList list = freqMap.get(minFreq);
                nodeMap.remove(list.tail.prev.key);
                list.remove(list.tail.prev);
                size--;
            }
            DNode node = new DNode(key, value);
            DList list = freqMap.getOrDefault(1, new DList());
            list.add(node);
            nodeMap.put(key, node);
            freqMap.put(1, list);
            minFreq = 1;
        }
    }
    public void update(DNode node) {
        DList list = freqMap.get(node.freq);
        list.remove(node);
        if(list.size == 0 && minFreq == node.freq)
            minFreq++;
        node.freq++;
        list = freqMap.getOrDefault(node.freq, new DList());
        list.add(node);
        freqMap.put(node.freq, list);
    }

    public static void main(String[] args) {

        /**
         * IN THIS QUESTION WE HAVE TO WORK AROUND WITH THE ELEMENTS BASED ON THEIR FREQUENCY, SO WHEN THE CAPACITY INCREASES
         * WE NEED TO DELETE THE LEAST FREQUENT ELEMENT, AND THEN INSERT THE NEW ONE, AND IF WE NEED TO GET THE ELEMENT THEN
         * FREQUENCY WILL INCREASE, ALSO IF THE FREQUENCY IS SAME THEN WE NEED TO TAIL THE ELEMENT BASED ON LRU.
         *
         * IN THIS QUESTION WE WILL NEED 2 HASHMAP, ONE FOR NODES AND KEY, SECOND FOR FREQUENCY,
         * SO BASICALLY IT IS IN ONE WAY SORT OF ROWS AND COLUMNS,
         * THE ROWS PROCEEDING MEANS ACCESSING THE FREQUENCIES WHERE ELEMENT IS PRESENT AND LIKE LRU THE COLUMNS PROCEEDING
         * MEANS THE LEAST RECENTLY USED.
         *
         * WE WILL ALSO NEED TO DECLARE TWO CLASSES
         *
         * ONE IS THE NODE CLASS HAVING FREQ KEY VALUE PREV AND NEXT
         * SECOND IS THE LIST CLASS, WHICH IS LIKE COLLECTION OF NODES, SO IT WILL HAVE METHODS TO ADD AND DELETE NODE
         * LIKE IN THE LRU, WE WILL ALSO NEED TO ADD THE HEAD AND TAIL ALONG WITH THE SIZE IN THIS CLASS.
         *
         * WE WILL ALSO NEED TO HAVE MIN FREQ TO TRACK MIN FREQUENCE SO THAT WHEN SIZE BECOMES GREATER THAN CAPACITY WE CAN
         * USE THIS TO GET THE LIST AND REMOVE THE LAST NODE.
         * WE WILL ALSO NEED SIZE TO TRACK TOTAL ELEMENTS WE HAVE ADDED AND TO MAKE SURE THEY DON'T SURPASS THE CAPACITY
         *
         * IN THE GET METHOD WE WILL CHECK FIRST WHETHER THE NODE IS ALREADY PRESENT OR NOT BY USING NODEMAP, IF IT IS PRESENT
         * MEANS WE NEED TO INCREASE ITS FREQUENCY BY 1, WE WILL USE AN UPDATE METHOD TO DO THAT
         *
         * IN THE UPDATE METHOD GET THE LIST USING THE FREQ OF THAT NODE FROM THE FREQ MAP, FROM THIS FREQ MAP REMOVE THE NODE,
         * NOW IF THE SIZE OF THIS LIST HAS BECOME 0 AND MIN FREQUENCY WAS SAME, MEANS WE WOULD HAVE TO INCREASE THE MIN FREQUENCY
         * BY 1 AS THE LAST ONE HAS NO ELEMENTS NOW,
         *
         * AFTER THIS INCREASE THE NODE FREQUENCY AND CHECK IF THERE EXISTS A LIST OR NOT, FROM THE LIST UPDATE THE NODE IN THIS
         * AND UPDATE IN FREQUENCY MAP THE NEW LIST.
         *
         *
         * FOR PUT OPTION
         *
         * FIRST WE WILL CHECK IF CAPACITY IS 0, MEANS NO NODE CAN BE ADDED, SIMPLY RETURN IN THIS CASE
         * ELSE CHECK IF THE NODE IS ALREADY PRESENT USING NODE MAP, IF IT IS SIMPLY UPDATE THE VALUE OF THAT NODE AFTER GETTING
         * FROM NODE MAP, AND THE UPDATE THIS NODE LIKE WE DID ABOVE
         *
         * IF BOTH THESE CASE FAIL MEANS A NEW NODE IS GOING TO GET ADDED, INCREASE THE SIZE AND CHECK IF SIZE IS GREATER THAN
         * CAPACITY, IF THIS IS THE CASE MEANS WE NEED TO MIN FREQUENCY NODE, AND REMOVE ITS LRU NODE, FOR THIS SIMPLY GET THE LIST
         * USING FREQ MAP WITH MIN FREQ, AFTER THIS REMOVE THIS NODE USING THE KEY FROM NODEMAP, AND FROM THE LIST AND DECREASE
         * SIZE BY 1.
         *
         * THEN TO ADD NEW NODE WE WILL SIMPLY GET LIST WITH FREQ1 OR NEW LIST FROM FREQMAP, CREATE NODE USING KEY VALUE,
         * UPDATE IT INTO THE LIST, UPDATE THIS NODE IN THE NODEMAP, AND LIST IN FREQMAP, AND AS THE FREQ 1 IS THE MIN, HAVE
         * THE MIN FREQ BY 1.
         *
         */
    }
}