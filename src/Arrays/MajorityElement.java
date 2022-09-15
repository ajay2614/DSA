package Arrays;
public class MajorityElement {

    /**
     *  Time Complexity: O(N)
     *  Space Complexity: O(1)
     */
    public static int majorityElement(int[] nums) {

        int n = nums.length;
        if(n == 1)
            return nums[0];

        int element = 0;
        int count = 0;

        for(int i=0;i<n;i++) {
            if(count == 0) {
                element = nums[i];
            }
            if(element == nums[i])
                count++;
            else
                count--;
        }

        return element;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT IN ARRAY THERE EXISTS AN ELEMENT WHICH APPEARS MORE THAN N/2 TIMES, WE HAVE TO RETURN THAT
         * ELEMENT
         *
         * BRUTE APPROACH
         *
         * IN THIS WE CAN USE A HASHMAP, AND STORE THE VALUE FOR RESPECTIVE ELEMENTS, AND THEN RUN A LOOP TO CHECK WHICH ELEMENT
         * HAS THE MAX COUNT VALUE AND RETURN IT
         *
         * OPTIMAL APPROACH
         *
         * TO SOLVE THIS OPTIMALLY WE USE MOORE VOTING ALGO APPROACH
         *
         * STEPS
         *
         * WE WILL ITERATE THE ARRAY, AND WE WILL USE CERTAIN STEPS, IF THE COUNT IS EQUAL TO ZERO, UPDATE THE ELEMENT AND
         * INCREASE ITS COUNT, ELSE IF THE ELEMENT IS EQUAL TO NUMS[I] INCREASE THE COUNT ELSE DECREASE IT
         *
         * BASICALLY WHAT THIS MEANS WE ARE CANCELLING THE COUNT WHEN WE HAVE DIFF ELEMENT, AND IT IS SURE THAT WHEN WE REACH ZERO
         * FOR COUNT MEANS THE CURRENT ELEMENT IS GREATER THAN THE ELEMENT STORED, NOW SINCE THE MAJORITY ELEMENT IS GREATER
         * THAN N/2 WE ARE BOUND TO GET OUR ANSWER FROM THIS
         *
         * EG 7 5 5 5 7
         *
         * FIRST WE HAVE 7 AS ELEMENT AND COUNT IS 1, THEN WE GET 5 COUNT DECREASES, NOW COUNT BECAME ZERO, AS COUNT IS ZERO
         * WE ADD 5 AS CURRENT ELEMENT AND INCREASE ITS COUNT BY 1, THEN 2 AND THEN 7 DECREASES IT COUNT BY 1 BUT AS COUNT
         * STILL IS GREATER THAN ZERO, WE RETURN THE ELEMENT 5.
         */
        int arr[] = {10,9,9,9,10};
        majorityElement(arr);
    }
}
