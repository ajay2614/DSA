package Arrays;

public class MaximumConsecutiveOnes {
    /**
     *  TC : BIG O(N)
     *  SC : BIG 0(1)
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;

        int max = 0;
        int sum = 0;
        for(int i=0;i<n;i++) {
            if(nums[i] == 0)
                sum = 0;
            else {
                sum += 1;
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    /**
     * WE NEED TO FIND HOW MANY MAX CONSECUTIVE ONES ARE THERE
     * WE WILL SIMPLY USE A SUM VARIABLE AND EVERY TIME SUM TURNS OUT TO BE ZERO WE WILL SET THAT TO ZERO, ELSE
     * WE WILL INCREMENT IT BY 1 AND UPDATE IT IN MAX.
     */
}
