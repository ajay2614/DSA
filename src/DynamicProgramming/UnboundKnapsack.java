package DynamicProgramming;

public class UnboundKnapsack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.

        int dp[][] = new int[n][w+1];

        for(int i=weight[0];i<=w;i++) {
            dp[0][i] = ((int) i/weight[0]) * profit[0];
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<=w;j++) {
                int np = dp[i-1][j];

                int p = Integer.MIN_VALUE;
                if(weight[i] <= j)
                    p = dp[i][j-weight[i]] + profit[i];

                dp[i][j] = Math.max(p,np);
            }
        }
        return dp[n-1][w];
    }

    public static int unboundedKnapsackSpaceOptimized(int n, int w, int[] profit, int[] weight) {
        // Write your code here.

        int prev[] = new int[w+1];
        int cur[] = new int[w+1];
        for(int i=weight[0];i<=w;i++) {
            prev[i] = ((int) i/weight[0]) * profit[0];
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<=w;j++) {
                int np = prev[j];

                int p = Integer.MIN_VALUE;
                if(weight[i] <= j)
                    p = cur[j-weight[i]] + profit[i];

                cur[j] = Math.max(p,np);
            }
            prev = cur;
        }
        return prev[w];
    }
}
