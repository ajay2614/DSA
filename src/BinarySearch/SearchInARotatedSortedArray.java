package BinarySearch;

public class SearchInARotatedSortedArray {

    public static int search(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int high = n-1;

        int mid = -1;

        while(low <= high) {
            mid = low + (high-low)/2;

            if(nums[mid] == target)
                return mid;

            if(nums[low] <= nums[mid]) {
                if(nums[low] <= target && target <= nums[mid])
                    high = mid-1;
                else
                    low = mid+1;
            }
            else if(nums[mid] <= nums[high]) {
                if(nums[mid] <= target && target <= nums[high])
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return -1;
    }

    /**
     *
     * IN THIS WE ARE GIVEN A ARRAY WHICH IS ROTATED SORTED, MEANS IT HAS LEFT PART AND RIGHT PART WHICH IS SORTED
     *
     * FOR EG 4 5 6 7 0 1 2, HERE ARRAY IS SORTED FROM 4 TO 7, AND FROM 0 TO 2.
     *
     * NOW THE APPROACH IS THAT IF WE CAN FIRST CHECK WHETHER WE ARE IN LEFT PART IS SORTED OR RIGHT PART IS SORTED.
     * AND THEN WE CAN CHECK WHETHER TARGET LIES IN THE LEFT PART OR RIGHT PART, WE CAN MANIPULATE LEFT AND RIGHT.
     *
     * STEPS
     *
     * GET MID AS LOW + HIGH / 2
     *
     * CHECK IF THE TARGET ELEMENT IS AT MID, IF SO RETURN MID
     *
     * ELSE CHECK IF ARR[LOW] <= ARR[MID], THIS MEANS THE LEFT PART IS SORTED, IT CAN FAIL FOR EG WE ARE
     * CHECK 4 5 1 2 3, WHEN MID IS 1
     *
     * IF THE ABOVE CONDITION IS TRUE, MEANS WE CAN SIMPLY SEARCH FOR OUR TARGET ELEMENT, IF IT
     * IS GREATER THAN ARR[LOW] AND SMALLER THAN ARR[MID] MEANS IT IS IN LEFT PART, THEN WE SIMPLY DO HIGH = MID-1.
     * ELSE MEANS IT IS IN RIGHT PORTION, HENCE LOW = MID+1.
     *
     * OTHERWISE IF ARR[LOW] <= ARR[MID] FAILS MEANING RIGHT HALF IS SORTED, AS IN 4 5 1 2 3, 1 3 IS SORTED
     * HENCE WE CHECK IF TARGET IS PRESENT IN ARR[MID] AND ARR[HIGH], IF SO, LOW = MID+1, ELSE HIGH = MID-1.
     *
     */
}
