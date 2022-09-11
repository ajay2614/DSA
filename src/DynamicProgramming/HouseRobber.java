package DynamicProgramming;

public class HouseRobber {

    public static int rob(int[] nums) {

        int n = nums.length;

        int dp[] = new int[n+2];

        for(int i=n-1;i>=0;i--) {
            int p = nums[i] + dp[i+2];
            int np = dp[i+1];

            dp[i] =Math.max(p, np);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        /*
        USING DP TABULATION APPROACH, WE EITHER PICK OR WE DONT PICK.
         */
        int arr[] = {2,1,1,2};

        rob(arr);
    }
}
