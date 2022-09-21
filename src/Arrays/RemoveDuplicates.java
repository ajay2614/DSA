package Arrays;

public class RemoveDuplicates {

    /**
     *  TC : BIG O(N)
     *  SC : BIG 0(1)
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;

        for(int i=1;i<n;i++) {
            if(nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

    /**
     * THE ARRAY HAS DUPLICATES WE NEED TO REMOVE THEM, WE WILL USE TWO VARIABLES, I & J,
     * RUN LOOP FOR I=1, AS THE ARRAY IS SORTED WE WILL ONLY UPDATE IF THE ELEMENT COMES OUT TO BE UNEQUAL TO ARR[J]
     * IN THAT CASE WE WILL INCREASE J FIRST AND THEN UPDATE ARR[J] WITH ARR[I]
     *
     * IN THE END RETURN J+1, AS J STARTED FROM 0TH INDEX.
     */
}
