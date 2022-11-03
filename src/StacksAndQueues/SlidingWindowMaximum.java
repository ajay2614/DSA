package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public int[] maxSlidingWindowBrute(int[] nums, int k) {

        int n = nums.length;
        int m = 0;
        int arr[] = new int[n-k+1];

        for(int i=0;i<n-k+1;i++) {
            int max = Integer.MIN_VALUE;
            for(int j=i;j<i+k;j++) {
                max = Math.max(nums[j], max);
            }
            arr[m++] = max;
        }

        return arr;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        int j = 0;
        for(int i=0;i<n;i++) {
            if(!deque.isEmpty() && deque.peekFirst() == i-k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);

            if(i >= k-1) {
                arr[j++] = nums[deque.peekFirst()];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE GIVEN A SLIDING WINDOW WHICH WILL RUN FROM LEFT THAT CAN COVER K ELEMENTS AT A TIME, WE NEED
         * TO FIND THE MAX ELEMENT AMONG THAT K ELEMENTS AT EVERY STAGES OF THE WINDOW,
         *
         * FOR EG FOR 1 2 1 3 4, AND K IS 2, THEN 2 2 3 4 WILL BE RESULTING ARRAY,
         *
         * BRUTE APPROACH, AS WE CAN SEE THE RESULTING ARRAY WILL HAVE N-K+1 ELEMENTS, AND AS THE LEFT MOST ELEMENT FOR THE LAST
         * K ELEMENTS WILL BE N-K, SO WE WILL RUN THE LOOP FROM 0 TO N-K, AND WILL COMPUTE THE MAX RUNNING A NESTED LOOP INSIDE
         *
         *
         * OPTIMAL APPROACH
         *
         * IN THE OPTIMAL APPROACH WE WILL USE AN ARRAY DEQUE,
         *
         * WHAT WE WILL DO IS RATHER THAN RUNNING NESTED LOOP AND COMPUTING WITH LEFT MOST ELEMENT AT EVERY STAGE WE WILL COMPUTE
         * MAX TILL THE RIGHTMOST ELEMENT AND ADD IN THE ARRAY.
         *
         * SO THE APPROACH TO USE THIS IS THAT IN THE DEQUE WHICH CAN TAKE FROM BOTH THE FRONT AND BACK, WE WILL MAKE SURE THAT
         * THAT AT EVERY COMPUTATION STAGE THE DEQUE HAS THE MAX ELEMENT INDEX AT THE FRONT, WE WILL RUN THE LOOP FROM 0 TO N,
         *
         * WE WILL START COMPARING ARRAY ELEMENT FROM THE LAST OF DEQUE, AND IF THE ELEMENT AT THE INDEX OF THE DEQUE IS SMALLER
         * WE WILL POP IT AND KEEP ON POPPING IT TILL THE CURRENT ELEMENT INDEX IS PLACED IN SUCH A WAY THAT INDEXES IN
         * DEQUE ARE SORTED BASED ON ELEMENTS DESCENDING ORDER, SUCH THAT HIGHEST ELEMENT INDEX IS AT FIRST.
         *
         * WHY WE CAN EASILY REMOVE THE INDEX AT THE LAST, SUPPOSE FOR 1 2 5, WHEN 5 WILL COME, MEANING 5 WILL DEFINITELY BE MAX
         * OF 1 2 AND 5, SO WE DON'T NEED 1 AND 2 FOR ANY CASE, AND WHY NOT EMPTY THE DEQUE?,
         *
         * SINCE WE NEED TO GET MAX OF ONLY K ELEMENTS AT A TIME, WE WILL ALSO USE A CASE SUCH THAT WE ARE NOT CONSIDERING AN
         * ELEMENT WHICH IS OUTSIDE THE WINDOW, SO TO MAKE SURE ONLY WINDOW ELEMENTS ARE COVERED WE WILL CHECK IF AT FIRST
         * THE INDEX IS NOT EQUAL TO I-K, FOR EG FOR K AS 3 FOR BELOW, 0 WOULD HAVE BEEN OUT OF BOUND WHEN I WAS 3, SO JUST
         * CHECKING WHETHER THE MAX ELEMENT IS NOT INDEED 0, WHICH WOULD HAVE GIVEN OUT OF WINDOW ELEMENT,
         *
         * TO INSERT IN DEQUE WE WILL SIMPLY INSERT CURRENT ELEMENT INDEX AFTER REMOVING INDEX OF ELEMENTS SMALLER THAN CURRENT
         *
         * TO INSERT IN ANSWER ARRAY WE NEED TO MAKE SURE IT IS NOT LYING ON THE LEFT MOST SIDE AS SAY FOR BELOW ARRAY, WE KNOW
         * FIRST WINDOW WOULD END AT 2ND INDEX AND THEN WILL CONTINUE TILL LAST INDEX SO CHECK WHETHER I >= K-1.
         * THEN SIMPLY GET THE INDEX OF BIGGEST ELEMENT AT FIRST.
         */
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        maxSlidingWindow(arr, k);
    }
}
