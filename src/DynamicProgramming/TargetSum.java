package DynamicProgramming;

public class TargetSum {
    /*
    Question is same as count partitions
     */
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int total = 0;

        for(int i=0;i<n;i++) {
            total += nums[i];
        }

        if(total - target < 0 || (total - target) % 2 == 1)
            return 0;

        int s = (total - target) / 2;

        int dp[][] = new int[n][s+1];

        if(nums[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if(nums[0] != 0 && nums[0] <= s)
            dp[0][nums[0]] = 1;

        for(int i=1;i<n;i++) {
            for(int j = 0; j<=s;j++) {
                int np = dp[i-1][j];

                int p = 0;
                if(nums[i] <= j)
                    p = dp[i-1][j - nums[i]];

                dp[i][j] = np + p;
            }
        }
        return dp[n-1][s];
    }

    public int findTargetSumWaysSpaceOptmized(int[] nums, int target) {
        int n = nums.length;
        int total = 0;

        for(int i=0;i<n;i++) {
            total += nums[i];
        }

        if(total - target < 0 || (total - target) % 2 == 1)
            return 0;

        int s = (total - target) / 2;

        int prev[] = new int[s+1];

        if(nums[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if(nums[0] != 0 && nums[0] <= s)
            prev[nums[0]] = 1;

        for(int i=1;i<n;i++) {
            int cur[] = new int[s + 1];
            for(int j = 0; j<=s;j++) {
                int np = prev[j];

                int p = 0;
                if(nums[i] <= j)
                    p = prev[j - nums[i]];

                cur[j] = np + p;
            }
            prev = cur;
        }
        return prev[s];
    }

}
