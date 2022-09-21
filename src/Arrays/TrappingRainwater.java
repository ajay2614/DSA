package Arrays;

public class TrappingRainwater {

    /**
     * Time Complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array.
     *
     * Space Complexity: O(N)+O(N) for prefix and suffix arrays.
     */
    public int trapBetterApproach(int[] height) {

        int n = height.length;

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        int max = 0;
        for(int i=0;i<n;i++) {
            max = Math.max(max, height[i]);
            leftMax[i] = max;
        }

        max = 0;

        for(int i=n-1;i>=0;i--) {
            max = Math.max(max, height[i]);
            rightMax[i] = max;
        }

        int res = 0;
        for(int i=0;i<n;i++) {
            int min = Math.min(leftMax[i], rightMax[i]);

            res += min - height[i];
        }
        return res;
    }

    /**
     * Time Complexity: O(N) because we are using 2 pointer approach.
     *
     * Space Complexity: O(1) because we are not using anything extra.
     */

    public static int trapOptimalApproach(int[] height) {

        int n = height.length;

        int l = 0;
        int r = n-1;

        int res = 0;
        int lmax = 0;
        int rmax = 0;
        while(l <= r) {
            if(height[l] < height[r]) {
                if(height[l] < lmax) {
                    res += lmax - height[l];
                }
                else {
                    lmax = height[l];
                }
                l++;
            }
            else {
                if(height[r] < rmax) {
                    res += rmax - height[r];
                }
                else {
                    rmax = height[r];
                }
                r--;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        /**
         * THE QUESTION STATES THAT WE ARE GIVEN AN ARRAY OF HEIGHTS OF BUILDING, WE NEED TO FIND HOW MUCH TOTAL
         * UNITS OF WATER IS BEING TRAPPED, FOR EG FOR 2 0 3, 2 UNITS OF WATER IS BEING TRAPPED.
         *
         *
         * BETTER THAN BRUTE APPROACH IS
         *
         * AT EVERY STAGE WE NEED TO FIND THE LEFT MAX AND RIGHT MAX AND COMPUTE THE MIN OF BOTH - THE CURRENT ELEMENT
         *
         * WHY SUBTRACTING CURRENT ELEMENT AND WHY MIN OF BOTH MAX, FOR EG LETS SEE FOR 2 1 3, FOR COMPUTING 1,
         * 2 WOULD BE LMAX AND 3 RMAX, AS WE KNOW WATER WOULD BE STORED WITH SMALLER MAX, AS IT WOULD START FLOWING FROM
         * THERE, NOW WE ALSO KNOW THAT UPTO THAT UNIT WATER WILL BE STORED TILL ITS LENGTH SO THAT IS WHY WE
         * ARE SUBTRACTING ARR[I]
         *
         * USE A ARRAY TO COMPUTE LEFT MAX AT EVERY HEIGHT AND SIMILARLY FOR AN ARRAY COMPUTE RMAX
         *
         * NOW RUN A LOOP AND FIND MIN OF BOTH LMAX AND RMAX AT PARTICULAR INDEX AND SUBTRACT IT WITH CURRENT HEIGHT AND
         * ADD IN RESULT/ANSWER.
         *
         * OPTIMAL APPROACH
         *
         * THIS APPROACH FOLLOWS TWO POINTER, WE HAVE LEFT POINTER AT 0 AND RIGHT POINTER AT 0
         *
         * WE RUN IT TILL LEFT CROSSES RIGHT
         *
         * NOW IF HEIGHT[LEFT] < HEIGHT[RIGHT], WE WILL CHECK IF HEIGHT[LEFT] IS GREATER THAN OR EQUAL TO LMAX, WE WILL
         * UPDATE OUR LMAX OR WILL AD IN THE ANS AS MAX - HEIGHT[LEFT]
         *
         * HOW THIS WORKS?
         *
         * WHEN WE HAVE THIS CONDITION HEIGHT[LEFT] < HEIGHT[RIGHT], IT MEANS THAT WE ARE ABSOLUTELY SURE THAT AMONG
         * ALL THE ELEMENTS AT RIGHT THERE IS ONE ELEMENT THAT IS GREATER THAN LMAX, WHICH WE CAN ALSO SAY
         * THAT RMAX IS DEFINITELY GREATER THAN LMAX, WE ENTER IN THIS CASE BECAUSE AS WE KNOW WE NEED TO SELECT MIN
         * OF BOTH MAX, NOW HEIGHT[LEFT] > LMAX, WE ARE SURE THAT IT IS SOMETHING LIKE 1 2 1 4 5, HERE FOR 2 FIRST
         * WE ENTER IF CASE THEN WE KNOW WE CANT FILL ANYTHING HERE AS THIS BUILDING IS THE MAX AMONG ALL THE LEFT
         * AND WE UPDATE AS LMAX TO 2.
         *
         *
         * SIMILARLY, VICE VERSA FOR RIGHT.
         *
         */


        int height[] = {0,1,0,2,1,0,1,3,2,1,2,1};

        trapOptimalApproach(height);

    }
}
