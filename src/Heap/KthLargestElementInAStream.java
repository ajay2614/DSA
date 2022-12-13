package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
    /**
     * TC : BIG O(NLOGK)
     * SC : BIG O(N)
     */
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
        if(a > b)
            return 1;
        if(a < b)
            return -1;
        return 0;
    });
    int k;
    public KthLargestElementInAStream(int k, int[] nums) {
        k = this.k;
        for(int i=0;i<nums.length;i++) {
            if(priorityQueue.size() < k)
                priorityQueue.offer(nums[i]);
            else {
                if (priorityQueue.peek() < nums[i]) {
                    priorityQueue.poll();
                    priorityQueue.offer(nums[i]);
                }
            }
        }
    }

    public int add(int val) {
        /**
         * DONE BECAUSE IT COULD BE THAT ARRAY INITIALIZED USING CONSTRUCTOR HAD SIZE SMALLER THAN K
         * FOR EG IF ARRAY IS EMPTY AND 1ST LARGEST ELEMENT IS REQUIRED.
         */
        if(priorityQueue.size() < k) {
            priorityQueue.offer(val);
        }
        else if(val > priorityQueue.peek()) {
            priorityQueue.poll();
            priorityQueue.offer(val);
        }

        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE INITIALLY GIVEN AN ARRAY AND K AND AN ADD METHOD,
         *
         * WE HAVE TO FIND THE KTH LARGEST ELEMENT IN RUNNING STREAM, MEANS THAT WHENEVER THE ADD IS CALLED THERE IS A NEW
         * NUMBER ADDED IN THE ARRAY AND NOW GET THE KTH LARGEST ELEMENT.
         *
         * USING BRUTE FORCE THAT IS ADDING IN DS SAY IN A LIST AND SORTING IT TO FIND THE N-K WILL GIVE US BIG O(NLOGN) FOR
         * SORTING
         *
         * WE CAN ALSO USE MAX HEAP BUT THAT WOULD ALSO GIVE US BIG O(NLOGN)
         *
         * BUT IF WE USE MIN HEAP AS ALREADY DISCUSSED WE CAN GET THE ANSWER IN BIG O(NLOGK)
         *
         * DECLARE A PRIORITY QUEUE, AND KEEP ADDING TILL SIZE < K, WHEN WE HAVE ADDED K ELEMENTS THEN ONLY CHECK IF
         * THE FIRST ELEMENT IS SMALLER AND REPLACE IT WITH THE ELEMENT BECAUSE FROM TOP IF WE HAVE TO FIND SAY 3RD LARGEST
         * ELEMENT THEN FROM TOP TO BOTTOM IT IS IN ASCENDING ORDER HENCE WE ARE STORING 3 LARGEST ELEMENTS FROM THE ARRAY,
         * NOW IF THE ELEMENT IS SMALLER WE NEED TO REPLACE IT AND BY GETTING THE TOP WE CAN GET THE 3RD LARGEST ELEMENT.
         *
         * SIMILAR APPROACH IS FOLLOWED WHILE USING ADD METHOD
         */
    }
}
