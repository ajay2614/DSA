package Arrays;

import java.util.HashSet;

/**
 * NOTE : DON'T CONFUSE THIS WITH LONGEST COMMON SUBSEQUENCE, WHICH IS A DP QUESTION
 */
public class LongestConsecutiveSequence {
    /**
     * TC -> BIG 0(3N), 1ST TIME WHILE TRAVERSING ARRAY, 2ND TIME WHILE TRAVERSING ARRAY, 3RD TIME WHILE TRAVERSING SEQUENCE
     * IN HASHET
     *
     * SC -> BIG O(N), HASHSET TAKEN EXTRA
     */
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums) {
            hashSet.add(i);
        }

        int max = 0;
        for(int i : nums) {
            if(!hashSet.contains(i-1)) {
                int count = 1;
                int cur = i+1;
                while (hashSet.contains(cur)) {
                    count++;
                    cur++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /**
         * THIS QUESTION ASKS US TO FIND THE LONGEST CONSECUTIVE SEQUENCE, MEANING GIVEN AN ARRAY FOR EG
         * 100 200 1 2 5 4 3 300, LONGEST CONSECUTIVE SEQUENCE IS 1 2 3 4 5
         *
         * BRUTE APPROACH
         *
         * SORT THE ARRAY, AND THEN FIND WHERE SEQUENCE ENDS AND NOTE WHETHER ITS BIGGER THAN A VARIABLE SAY MAX WHICH IS STORING
         * SEQUENCES
         *
         * ON LEETCODE IT IS MENTIONED TO FIND IT IN BIG O(N) COMPLEXITY.
         * WE CAN USE A HASHSET TO DO IT IN BIG O(N)
         * FIRST STEP IS TO ADD EVERY ELEMENT IN SET
         *
         * AFTER THIS TRAVERSE ARRAY ELEMENTS, USE A IF CASE WHEN ELEMENT DOES'T HAVE SMALLER THAN 1 OF THEMSELF
         * RUN A WHILE LOOP INSIDE, AND THEN TRAVERSE AND COUNT HOW MANY ELEMENTS MORE THAN THE CURRENT ELEMENT ARE IN HASHSET,
         * WITH THIS APPROACH WHAT HAPPENS IS THAT WE ONLY TRAVERSE ELEMENTS 1 TIME WHERE WE COUNT THE SEQUENCE
         *
         * FOR EG FOR ABOVE ARRAY, WE KNOW THAT IT WONT WORK FOR 5 OR 4,3,2 IT WILL ONLY GET STARTED FOR 1, AND FROM THEN
         * IT WILL COUNT HOW MANY SEQUENCE IS MADE FROM 1, SO WE STAY IN BIG O(N) AND DO NOT TAKE EXTRA COMPLEXITY
         *
         *
         */
    }
}
