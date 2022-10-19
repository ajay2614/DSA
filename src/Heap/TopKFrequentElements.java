package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Ele {
    int occurrences;
    int value;

    public Ele(int occurrences, int value) {
        this.occurrences = occurrences;
        this.value = value;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
public class TopKFrequentElements {

    /**
     *
     * TC : (N LOGN)
     * BIG O(N) IN FIRST LOOP
     * BIG O(N) IN ADDING VALUES
     * BIG O(KLOGN) IN ADDING IN THE ARRAY (BECAUSE K STEPS FOR ADDING IN ARRAY AND LOGN BECAUSE IN WORST CASE PRIORITY
     * QUEUE WOULD BE HAVING N ELEMENTS HENCE LOGN WHILE HEAPIFYING)
     *
     */

    public int[] topKFrequentBrute(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer,Ele> map = new HashMap<>();

        for (int i=0;i<n;i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],new Ele(1,nums[i]));
            else {
                Ele ele = map.get(nums[i]);
                map.put(nums[i], new Ele(ele.getOccurrences() + 1, ele.getValue()));
            }
        }

        PriorityQueue<Ele> priorityQueue = new PriorityQueue<>((o1,o2) -> {
            if(o1.getOccurrences() < o2.getOccurrences())
                return 1;
            else if(o1.getOccurrences() > o2.getOccurrences())
                return -1;
            return 0;
        });

        for (Ele e : map.values()) {
            priorityQueue.add(e);
        }
        int arr[] = new int[k];
        int i=0;
        while(k-- > 0) {
            arr[i++] = priorityQueue.poll().getValue();
        }
        return arr;
    }
    /**
     *
     * TC : (N LOGK)
     * BIG O(N) IN FIRST LOOP
     * BIG O(N) IN ADDING VALUES IN WORST CASE
     * BIG O(KLOGK) IN ADDING IN THE ARRAY (BECAUSE K STEPS FOR ADDING IN ARRAY AND LOGK BECAUSE WE ARE NOT ALLOWING TO ADD IF SIZE
     * == K, SO THAT HEAPIFYING ONLY TAKES LOG K)
     *
     */
    public static int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        HashMap<Integer,Ele> map = new HashMap<>();

        for (int i=0;i<n;i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],new Ele(1,nums[i]));
            else {
                Ele ele = map.get(nums[i]);
                map.put(nums[i], new Ele(ele.getOccurrences() + 1, ele.getValue()));
            }
        }

        PriorityQueue<Ele> priorityQueue = new PriorityQueue<>((o1,o2) -> {
            if(o1.getOccurrences() > o2.getOccurrences())
                return 1;
            else if(o1.getOccurrences() < o2.getOccurrences())
                return -1;
            return 0;
        });

        for (Ele e : map.values()) {

             if (priorityQueue.size() < k) {
                priorityQueue.add(e);
            }
            else if(priorityQueue.peek().getOccurrences() < e.getOccurrences() && priorityQueue.size() == k) {
                priorityQueue.poll();
                priorityQueue.add(e);
            }
        }
        int arr[] = new int[k];
        int i=0;
        while(k-- > 0) {
            arr[i++] = priorityQueue.poll().getValue();
        }
        return arr;
    }

    public static void main(String[] args) {

        /**
         * THE QUESTION STATES THAT GIVEN AN ARRAY WE NEED TO FIND KTH MOST FREQUENT ELEMENTS AND RETURN IN ARRAY
         * MEANING FOR BELOW ARRAY 1 APPEARS THRICE AND 2 APPEARS TWICE, SO TWO MOST FREQUENT ELEMENTS ARE 1 AND 2
         *
         * TO DO THIS QUESTION FIRST WE NEED A HASHMAP TO STORE OCCURANCES AND THEIR VALUES, AFTER THIS WE CAN STORE
         * THEM IN AN ARRAYLIST AS AN ELEMENT CLASS HAVING OCCURRENCES AND VALUE AND SORT THEM BASED ON THEIR OCCURRENCES
         * AND THEN ADD THE ELEMENTS IN ARRAY AND RETURN
         *
         * AS THIS APPROACH WOULD TAKE BIG O(N LOGN) IN WORST CASE, AND SINCE QUESTION ASKS TO FIND A BETTER APPROACH
         * THAN THIS, WE CAN DO SOME OTHER APPROACH
         *
         * 2ND APPROACH WE WILL USE A PRIORITY QUEUE, INSTEAD OF USING AN ARRAYLIST WE WILL USE A PRIORITY QUEUE, WE CAN
         * STORE VALUE AS THE KEY IN HASHMAP AND ELEMENT CLASS AS VALUE, AFTER THIS WE CAN STORE IN PRIORITY QUEUE WHICH
         * WILL SORT IN DESCENDING BASED ON OCCURRENCES, AND THE ADD THE K TOP ELEMENTS FROM IT, BUT EVEN THIS APPROACH
         * WILL GIVE US N LOG N IN WORST CASE
         *
         * 3RD AND MOST OPTIMAL APPROACH IS, USING THE SAME STEPS AS THE ABOVE ADDING IN HASHMAP, THE VALUE AND ELEMENT
         * ONCE AFTER THIS, WE WILL USE MIN HEAP INSTEAD OF MAX HEAP AND WILL ONLY STORE IN CERTAIN CASES
         *
         * IF HEAP SIZE IS SMALLER THAN K
         *
         * SINCE WE ARE NOT HAVING K ELEMENTS YET IN THE HEAP WE CAN SIMPLY ADD THE ELEMENT IN K
         *
         * IF HEAP SIZE IS EQUAL TO K AND HEAP TOP ELEMENT HAS LESSER OCCURRENCES THAN ITERATED ELEMENT, THAT WOULD MEAN
         * IN THIS CASE SURELY THE TOP ELEMENT IS NOT PART OF K ELEMENTS AS THERE IS ANOTHER ELEMENT THAT IS HAVING MORE
         * OCCURRENCES THAN IT, SO IN THIS CASE SIMPLY REMOVE THE TOP ELEMENT AND ADD THE ITERATED ELEMENT
         *
         * SINCE IN THIS CASE WE WILL ONLY BE FILLING HEAP BY SIZE K RATHER THAN N IN MAX HEAP, THE STEPS
         * TO OPERATE/HEAPIFY WOULD BE BIG O(LOGK), SO IN THIS WAY WE HAVE TRIMMED THE COMPLEXITY FROM BIG O(NLOGN) TO
         * BIG O(NLOGK)
         *
         *
         */
        int arr[] = {1,1,1,2,2,3};
        int k = 2;

        topKFrequent(arr, k);
    }
}
