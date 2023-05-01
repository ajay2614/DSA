package DynamicProgramming;
import java.util.Arrays;
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for(int i=0;i<n;i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0)
            return false;

        boolean dp[][] = new boolean[n][sum/2 + 1];

        if(nums[0] <= sum/2)
            dp[0][nums[0]] = true;
        for(int i=1;i<n;i++) {
            for(int j=0;j<=sum/2;j++) {
                boolean notPick = dp[i-1][j];
                boolean pick = false;
                if(nums[i] <= j) {
                    pick = dp[i-1][j - nums[i]];
                }

                dp[i][j] = pick || notPick;
            }
        }
        return dp[n-1][sum/2];
    }
    public boolean canPartitionRecursion(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0)
            return false;
        int dp[][] = new int[n][sum + 1];
        for(int a[] : dp) {
            Arrays.fill(a, -1);
        }
        return recursion(n, nums, n-1, sum/2, 0, dp);
    }

    public boolean recursion(int n, int[] nums, int ind, int sum, int s, int[][] dp) {
        if(ind == -1) {
            if(s == sum)
                return true;
            return false;
        }

        if(dp[ind][s] != -1) {
            if(dp[ind][s] == 1)
                return true;
            else
                return false;
        }
        boolean notPick = recursion(n, nums, ind-1, sum, s, dp);
        boolean pick = recursion(n, nums, ind-1, sum, s + nums[ind], dp);

        boolean res = pick || notPick;

        if(res)
            dp[ind][s] = 1;
        else
            dp[ind][s] = 0;

        return res;
    }
}
