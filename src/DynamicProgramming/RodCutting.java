package DynamicProgramming;

public class RodCutting {
    public static int cutRod(int price[], int n) {
        // Write your code here.

        int dp[][] = new int[n][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i * price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int np = dp[i - 1][j];
                int p = Integer.MIN_VALUE;
                /*
                Taking rodLength as i + 1 because let's say array is [5,1,4] rodLength 1 means cutting in 3 pieces, and getting
                total 15, similarly choosing 4 means no cutting and giving as length 3.
                 */
                int rodLength = i + 1;
                if (rodLength <= j)
                    p = price[i] + dp[i][j - rodLength];
                dp[i][j] = Math.max(p, np);
            }
        }
        return dp[n - 1][n];
    }

    public static int cutRodSpaceOptimized(int price[], int n) {
        // Write your code here.

        int prev[] = new int[n + 1];
        int cur[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            prev[i] = i * price[0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                int np = prev[j];
                int p = Integer.MIN_VALUE;
                int rodLength = i + 1;
                if (rodLength <= j)
                    p = price[i] + cur[j - rodLength];
                cur[j] = Math.max(p, np);
            }
            prev = cur;
        }
        return prev[n];
    }
}
