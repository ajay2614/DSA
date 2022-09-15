package Arrays;

import java.util.HashMap;

public class LargestSubarrayWithSum0 {
    /**
     * Time Complexity: O(N^2) as we have two loops for traversal
     * Space Complexity : O(1) as we aren’t using any extra space.
     */
    public static int maxLenBrute(int arr[], int n) {
        int max = 0;

        for(int i=0;i<n;i++) {
            int x = arr[i];
            for(int j=i+1;j<n;j++) {
                x += arr[j];

                if(x == 0)
                    max = Math.max(j - i + 1, max);
            }
        }
        return max;
    }

    /**
     * Time Complexity: O(N), as we are traversing the array only once
     * Space Complexity: O(N), in the worst case we would insert all array elements prefix sum into our hashmap
     */


    public static int maxLen(int arr[], int n) {

        HashMap<Long,Integer> map = new HashMap<>();
        long sum = 0;
        int max = 0;
        for(int i=0;i<n;i++) {

            sum += arr[i];

            if(sum == 0) {
                max = i+1;
            }
            else if(map.containsKey(sum)) {
                max = Math.max(i - map.get(sum), max);
            }
            else{
                map.put(sum, i);
            }

        }
        return max;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE ARE GIVEN AN ARRAY, WITH POSITIVE AND NEGATIVE VALUES,
         * WE NEED TO FIND THE MAX LEN SUBARRAY WHICH SUM EQUALS TO 0
         *
         * BRUTE APPROACH
         *
         * RUN A I & J LOOP, CHECK FOR SUM, WHENEVER 0, UPDATE THE LENGTH OF SUBARRAY
         *
         * OPTIMAL APPROACH
         *
         * WE WILL USE A HASHMAP,
         *
         * APPROACH WHENEVER OUR SUM BECOMES 0, WE ADD MAX VALUE AS I+1, WHY? BECAUSE WE ARE RUNNING FROM 0 TO N-1
         * EVERYTIME WHEN SUM IS ZERO WE KNOW FOR SURE IT IS MAX VALUE AS IT IS FROM START.
         *
         * EVERY TIME WE GET A SUM VALUE PRESENT IN HASHMAP WE CAN EVALUATE THAT
         *
         * EG SUM FROM 0 TO 2 INDEX IS 1 2 3, AND IF NEXT VALUE COMES AS 2, WE KNOW FOR SURE THERE WERE VALUES
         * THAT WOULD COMPUTE TO ZERO, EG 1 1 1 -1, AS WE CAN SEE 2ND AND 3RD INDEX MAKES A 0 HENCE WE ARE SURE,
         * THAT FROM THE LAST SUM VALUE, WHICH WAS 2 FROM 1ST INDEX, SUBTRACTING THIS FROM I, WE WILL GET
         * A SUBARRAY WHICH IS 0
         *
         * EVERYTIME WE GET A SUM VALUE WHICH ISNT ZERO NEITHER IT IS PRESENT IN MAP, WE WILL PUT IT INTO MAP
         *
         */
    }
}
