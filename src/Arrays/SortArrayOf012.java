package Arrays;

public class SortArrayOf012 {
    /**
    TC BIG O(2N)
     */
    public void sortColorsBrute(int[] nums) {
        int n = nums.length;

        int zero = 0;
        int one = 0;

        for(int i=0;i<n;i++) {
            if(nums[i] == 0)
                zero++;
            if(nums[i] == 1)
                one++;
        }

        for(int i=0;i<n;i++) {
            if(zero > 0){
                nums[i] = 0;
                zero--;
            }
            else if(one > 0){
                nums[i] = 1;
                one--;
            }
            else{
                nums[i] = 2;
            }
        }
    }
    /**
    TC BIG O(N)
     */

    public static void sortColors(int[] nums) {
        int n = nums.length;

        int lo = 0;
        int mid = 0;
        int hi = n-1;

        while(mid<=hi) {
            int temp;
            switch (nums[mid]){
                case 0:{
                    temp = nums[lo];
                    nums[lo] = nums[mid];
                    nums[mid] = temp;
                    mid++;
                    lo++;
                    break;
                }
                case 1:{
                    mid++;
                    break;
                }
                case 2:{
                    temp = nums[hi];
                    nums[hi] = nums[mid];
                    nums[mid] = temp;
                    hi--;
                    break;
                }
            }
        }

    }

    public static void main(String[] args) {
        /**
        THE QUESTION IS GIVEN AS ARRAY OF 0 1 & 2 WE NEED TO SORT IT

        FOR OPTIMAL APPROACH WE FOLLOW A VARIATION OF DUTCH NATIONAL FLAG,
        NOTE--
        The primary goal here is to move 0s to the left and 2s to the right of the array and at the same time all the 1s
        shall be in the middle region of the array and hence the array will be sorted.

        WE TAKE LO MID AND HI VARIABLES, THE APPROACH IS THAT WE WILL SLIDE MID VARIABLE UNTIL ITS NOT GREATER THAN HI
        WHEN WE COME ACROSS 0, WE SWAP ELEMENT AT LOW AND MID INDEXES, AND WE INCREASE BOTH LOW AND MID, WHEN WE COME
        ACROSS 1 WE ONLY INCREASE MID, AND FOR 2 WE SWAP HI & MID AND DECREASE HI.

        THE FINAL RESULT WOULD HAVE ALL THE ELEMENTS RIGHT OF HI WOULD BE 2, AND LEFT OF LO WOULD BE 0 & BETWEEN IS 1.

        WHY MID<=HI AND NOT MID<HI, BECAUSE A TESTCASE LIKE 2 0 1 CAN ARISE
        HERE FIRST TIME HI WOULD BECOME 1 FROM 2 AND ARRAY WOULD BECOME 1 0 2, NOW AS 1 ARRIVES, MID WILL ONLY INCREMENT
        AND BECOME EQUAL TO HI, HENCE FINAL ANSWER WOULD FAIL.
         */

        /**
         * WHY WE WROTE BREAK IN SWITCH, BECAUSE THE WORKING OF SWITCH IS IN SUCH A WAY, ONCE IF A CASE GETS EQUAL/EXECUTED
         * THEN IF WE DON'T WRITE BREAK, THEN ALL THE NEXT SWITCH STATEMENTS WILL ALSO GET EXECUTED.
         */

        int arr[] = {2,0,1};
        sortColors(arr);
    }

}
