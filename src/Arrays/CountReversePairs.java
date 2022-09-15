package Arrays;

public class CountReversePairs {
    public static int reversePairs(int[] nums) {
        int n = nums.length;
        return divide(0, n-1, nums);
    }

    public static int divide(int si, int ei, int[] nums) {
        int count = 0;
        int mid = 0;

        if(si < ei) {
            mid = si + (ei-si)/2;
            count += divide(si, mid, nums);
            count += divide(mid+1, ei, nums);

            count += conquer(si,mid,ei,nums);
        }

        return count;
    }
    public static int conquer(int si, int mid, int ei, int[] nums) {
        int j = mid+1;
        int count = 0;
        for(int i = si; i<=mid;i++) {
            while(nums[i] > 2 * nums[j] && j <= ei) {
                j++;
            }
            count += j - (mid + 1);
        }

        int ind1 = si;
        int ind2 = mid+1;
        int x = 0;

        int dummy[] = new int[ei - si + 1];
        while(ind1 <= mid && ind2 <= ei) {
            if(nums[ind1] < nums[ind2])
                dummy[x++] = nums[ind1++];
            else
                dummy[x++] = nums[ind2++];
        }

        while(ind1 <= mid) {
            dummy[x++] = nums[ind1++];
        }
        while(ind2 <= ei) {
            dummy[x++] = nums[ind2++];
        }

        for(int i=0, k=si; i<dummy.length && k <= ei; i++,k++) {
            nums[k] = dummy[i];
        }
        return count;
    }
    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE ARE GIVEN AND ARRAY AND WE NEED TO FIND THOSE PAIRS WHERE LEFT ELEMENT IS MORE THAN TWICE THE RIGHT
         * ELEMENT, EG FOR 4 3 2 1, PAIRS ARE 4 1, 3 1 MEANS 2 PAIR
         *
         * WE CAN USE BRUTE FORCE OF BIG O (N*N) WHERE I AND J LOOP ARE USED
         *
         * OPTIMAL APPROACH IS USING MERGE SORT AND ADDING SOME FUNCTIONALITY IN THAT, LIKE WE DID FOR COUNTINVERSIONS
         *
         * IN CONQUER PART, WE WILL RUN A LOOP FROM MID+1 WHICH IS ALSO CALLED RIGHT HALF IN MERGE SORT,
         * TO END INDEX TILL THE CURRENT I INDEX RUNNING FROM START INDEX TO MID, IS TWICE GREATER,
         * FOR EG IF WE ARE COMPARING  2 4 WITH WITH 1 3, FIRST 2 WILL BE COMPARED TO 1, WE HAVE TO CHECK IF IT IS INDEED
         * MORE THAN TWICE ONLY THEN WE WILL INCREMENT J, AS IT ISNT WE KNOW RIGHT OF J WOULD BE HAVING GREATER SINCE IT CAME
         * FROM SORTING A LEVEL BEFORE, HENCE WE WILL INCREMENT I, NOW ELEMENT AT I IS 4 AS 4 IS MORE THAN TWICE OF 1, WE INCREMENT
         * J, AND ADD COUNT = J + (MID + 1) , WHY J - (MID + 1), BECAUSE WE KNOW J'S VALUE WAS FROM MID + 1, AND WE ALSO KNOW
         * J INDEX WILL COVER ALL THE LEFT ONES TO WITH THIS EXPRESSION AS IT IS SORTED AND LEFT ONES WOULD ALSO BE TWICE
         * SMALLER THAN ELEMENT AT INDEX I, AS CURRENT ONE WHICH IS BIGGER IS
         * NOW 4 ISNT TWICE OF THREE, HENCE HOW IT RAN WAS,
         *
         * 2 4 , 1 3  I IS 0, J IS 2
         * 2 AND 1, J REMAINS 2, 2 - 2 = 0
         * 4 AND 1, J INCREMENTS BY 1, COUNT 3 -2 = 1
         * 4 AND 3, J REMAINS 3, COUNT REMAINS 1 AS 3 -2 = IS STILL 1.
         *
         * OTHER STEPS ARE SAME OF MERGE SORT
         */
        int arr[] = {1,3,2,3,1};
        System.out.println(reversePairs(arr));
    }
}
