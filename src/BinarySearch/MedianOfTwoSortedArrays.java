package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class MedianOfTwoSortedArrays {

    /**
     * TC : BIG O(LOG(N+M))
     * SC : BIG O(1)
     */
    public double findMedianSortedArraysBrute(int[] nums1, int[] nums2) {

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i:nums1) {
            arr.add(i);
        }
        for(int i:nums2) {
            arr.add(i);
        }

        Collections.sort(arr);

        if(arr.size() % 2 == 0) {
            int a = arr.get((arr.size()/2) - 1);
            int b = arr.get(arr.size()/2);

            double c = (double) a + (double) b;

            return c/2.0;

        }

        return (double) arr.get(arr.size()/2);
    }

    /**
     * TC : BIG O(MIN(N,M))
     */

    public double findMedianSortedArraysBruteBetter(int[] nums1, int[] nums2) {

        ArrayList<Integer> arr = new ArrayList<>();
        int i = 0;
        int j = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;

        while(i < n1 && j < n2) {
            if(nums1[i] < nums2[j]) {
                arr.add(nums1[i]);
                i++;
            }
            else{
                arr.add(nums2[j]);
                j++;
            }
        }

        while(i < n1) {
            arr.add(nums1[i]);
            i++;
        }

        while(j < n2) {
            arr.add(nums2[j]);
            j++;
        }

        if(arr.size() % 2 == 0) {
            int a = arr.get((arr.size()/2) - 1);
            int b = arr.get(arr.size()/2);

            double c = (double) a + (double) b;

            return c/2.0;

        }

        return (double) arr.get(arr.size()/2);
    }

    /**
     *
     * Time Complexity : log(min(m,n))
     *
     * Reason: We are applying binary search in the array with minimum size among the two.
     * And we know the time complexity of the binary search is log(N) where N is the size of the array.
     * Thus, the time complexity of this approach is log(min(m,n)), where m,n are the sizes of two arrays.
     *
     * Space Complexity: O(1)
     *
     * Reason: Since no extra data structure is used, making space complexity to O(1).
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if(n1 > n2)
            return findMedianSortedArrays(nums2,nums1);

        int low = 0;
        int hi = n1;

        while(low <= hi) {
            int cut1 = low + (hi-low)/2;
            int cut2 = (n1+n2+1)/2 - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2-1];

            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1) {
                if((n1 + n2)%2==0) {
                    double left = (double) Math.max(l1,l2);
                    double right = (double) Math.min(r1,r2);

                    return (left+right)/2.0;
                }
                else
                    return (double) Math.max(l1,l2);
            }

            if(l1 > r2) {
                hi = cut1-1;
            }
            else if(l2 > r1) {
                low = cut1+1;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {
        /**
         * WHY WE CHECK HAVE BIGGER ARRAY AT 2ND, TO PREVENT ARRAY OUT OF BOUND
         * SAY WE HAD [1],[] IN THIS TESTCASE WHEN WE WOULD RUN THEN INITIALLY CUT1
         * WOULD BE 0 + 1 = 0, CUT 2 WOULD BE 1 + 1/2 WHICH IS EQUAL TO 1, NOW AS IN ARR2 THERE IS NO ELEMENTS SO TO
         * PREVENT SUCH SITUATION WE USE SMALLER ARRAY AT FIRST.
         */

        /**
         * BRUTE APPROACH
         *
         * SINCE WE NEED TO FIND MEDIAN, WE CAN SIMPLY STORE BOTH THE ARRAY IN A SINGLE DS, SUCH AS LIST, AFTER THIS WE CAN
         * SORT AND THEN FIND THE MEDIAN.
         *
         * BETTER BRUTE
         *
         * RATHER THAN USE SORT METHOD, WE CAN USE TWO POINTER APPROACH LIKE WE DO IN MERGE SORT TO STORE THE LIST CONTENTS
         *
         * OPTIMAL APPROACH
         *
         * THE OPTIMAL APPROACH FOLLOWS BINARY SEARCH, FROM THE QUESTION WE KNOW THAT BOTH THE ARRAYS ARE SORTED,
         * NOW SUPPOSE YOU SEPERATE AN ARRAY SAY 1 2 4 5 AND 1 3 4 5, IN SUCH A WAY THAT LEFT SIDE OF 1 ARRAY
         * IS SMALLER THAN RIGHT SIDE OF 2ND ARRAY AND LEFT SIDE OF SECOND ARRAY IS SMALLER THAN RIGHT SIDE OF FIRST ARRAY,
         * WE CAN EASILY FIND OUR MEDIAN, WHY IT IS CERTAIN THIS WILL WORK, AFTER THIS IF WE CAN GET THE MAX LEFT
         * AND MIN RIGHT WE CAN GET THE MEDIAN FOR EVEN N1+N2 AND FOR ODD WE CAN SIMPLY GET MAX L1, L2.
         *
         * BECAUSE SAY WE MERGE THE ABOVE ARRAY, IT BECOMES 1 1 2 3 4 4 5 5, AS WE CAN SEE IF WE HAD CHOSEN THE L1 AND L2
         * AS 2 AND 3 AND COMPARED WITH 4 AND 4 AS R1 AND R2, WE WOULD HAVE GOTTEN THE TWO NUMBERS WHICH CAN BE PART
         * OF OUR MEDIAN, AS WE KNOW IN THE LEFT SIDE IT WOULD BE BIGGER NUMBER THAT WOULD BE ON RIGHT WE WOULD CHECK THE MAX
         * OF L1 L2, AND R1 R2 IF THE ABOVE L1<=R2 AND L2<=R1 SATISFIES ONLY, WITHOUT THIS CONDITION IT IS CERTAIN
         * WE ARE NOT AT THE RIGHT PARTITION, BASICALLY WE ARE JUST PARTITIONING IN SUCH A WAY, THERE BECOMES 2 CUTS
         * ONE BETWEEN L1 AND R1 OF ARRAY1, AND OTHER BETWEEN L2 AND R2 OF ARRAY2, WHERE TOTAL NUMBER OF LEFT SIDE,
         * WHICH HAS L1 AND L2, IS EQUAL TO TOTAL NUMBER ON THE RIGHT SIDE(FOR EVEN), IN OTHER WAY, WE CAN ALSO SAY
         * THAT WE ARE FINDING THE LEFT PART OF BOTH THE ARRAYS COMBINED AND RIGHT PART OF BOTH THE ARRAYS COMBINED
         * FOR EG FOR 1 2 4 5, 1 3 4 5, LEFT PART WOULD BE 1 2 AND 1 3, WHICH IF WE HAD COMBINED WOULD BE 1 1 2 3
         * AND RIGHT WOULD BE 4 4 5 5, WHICH IS EXACTLY THE APPROACH WE ARE FOLLOWING, AND WITH THESE WE ARE PICKING
         * THE MIDDLE ELEMENTS WHICH CAN MAKE MEDIAN. FOR THIS WE NEED TO FOLLOW BINARY SEARCH, AS IT WILL HELP
         * US TO GET THE CUTS, THE APPROACH WOULD BE IF WE GET L1 > R2, THEN TO DECREASE THE L1 AND HENCE DECREASING
         * THE CUT, ELSE IF L2 > R1, THEN WE WOULD INCREASE THE CUT
         *
         * STEPS:
         *
         * HAVE LOW AND HIGH AS 0 AND N, HERE HIGH MEANS NUMBER OF ELEMENTS WE CAN PICK, NOT TO GET CONFUSED WITH 0 BASED
         * INDEXING
         *
         * GET THE CUT1, MEANING THE CUT ON ARRAY1, IT WOULD BE LOW+HIGH/2
         * CUT 2 WOULD BE (N1+N2+1)/2 - CUT1. HERE N1+N2 TO GET THE EXACT CUT SUCH THAT LEFT ELEMENTS ARE IN SAME NUMBER
         * AS THE RIGHT ELEMENTS, WHY +1, BECAUSE FOR ODD SAY 1 2 3, AND 1,4, CUT1 WOULD BE 1 AND THEN CUT2 WOULD BE 3-1 = 2.
         * WHICH MEANS BOTH 1 AND 4 OF ARRAY 2, SO LEFT SIDE WOULD BE HAVING 1 1 4 AND RIGHT WOULD BE HAVING 2 AND 3.
         * THIS IS DONE SO THAT LEFT ALWAYS HAS 1 MORE ELEMENT THAN RIGHT AS TOTAL IS IN ODD AND THAT'S WHY WE LOOK FOR
         * ONLY MAX OF L1,L2 FOR ODD AS ANS MEDIAN, AND THIS NEVER GIVES PROBLEM FOR EVEN BECAUSE SAY 8/2 AND 9/2 IS SAME THING
         *
         * NOW CHECK WHETHER CUT1 IS ZERO OR NOT, IF NOT THEN RETURN ARR[CUT1-1] AS L1 AND SAME FOR L2 FOR CUT2
         * IF ZERO RETURN INTMIN
         * FOR R1 R2, ITS COMPLETE OPPOSITE, CHECK IF CUT HAS NOT PASSED THE BOUNDARY, RETURN MAX IF IT HAS
         * SAME FOR CUT2.
         *
         * CHECK FOR L1<=R2 AND L2<=R1, RETURN ANS ACC TO EVEN OR ODD
         *
         * NOW IF L1 > R2 MEANING WE NEED TO GET TO SMALLER INDEX SO HAVE HIGH AS CUT1-1
         *
         * FOR EG 7 12 14 15 AND 1 2 3 4 9 11, WHEN WE COMPARE 12 AS L1 WITH 4 AS R2, L1 IS GREATER THAN R2, THEN DECREASE
         * HIGH LIKE WE DO IN BS, HAVE HIGH AS CUT1-1.
         *
         * FOR L2 > R1, WHEN WE COMPARE 7 AS R1 AND 1 AS L2, 7 IS GREATER THAN 1, SO WE NEED TO MOVE THE PARTITION
         * SO THAT R1 INCREASES AND L2 DECREASES SO FOR LOW WE DO CUT1 + 1.
         *
         * NOTE : DON'T CONFUSE IT'S LOW AND HIGH WITH NORMAL BINARY SEARCH, HERE BASICALLY LOW = CUT1+1 MEANS WE ARE
         * INCREASING THE NUMBER OF ELEMENTS IN ARRAY1, AND HIGH = CUT1-1 MEANS WE ARE DECREASING IN ARRAY1
         */
        findMedianSortedArrays(new int[]{2}, new int[]{1,3});
    }
}
