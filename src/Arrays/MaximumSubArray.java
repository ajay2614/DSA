package Arrays;

public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {

        int sum = 0;
        int n = nums.length;
        int result = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            sum = sum + nums[i];
            result = Math.max(sum, result);
            if(sum < 0)
                sum = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        /*
        FOLLOWING SOLUTION IMPLEMENTS KADANES ALGO

        WE TAKE INITIAL SUM = 0, WE RUN FOR LOOP AND ADD INDEX AND COMPUTE MAX RESULT, IF WE FOUND SUM LESSER THAN 0,
        THE WE INITIALIZE IT TO 0.
         */
    }
}
