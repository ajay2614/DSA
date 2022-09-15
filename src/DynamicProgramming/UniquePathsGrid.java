package DynamicProgramming;

import java.util.Arrays;

public class UniquePathsGrid {

    public static int uniquePathsRecursion(int m, int n) {
        return recursiveWay(0, 0, m, n);
    }

    public static int recursiveWay(int i, int j, int m, int n) {
        if(i==m-1 && j == n-1)
            return 1;
        if(i >= m  || j >= n)
            return 0;

        int row = recursiveWay(i+1, j, m, n);
        int column = recursiveWay(i, j+1, m, n);

        return row+column;
    }

    public static int uniquePaths(int m, int n) {

        int dp[][] = new int[m][n];

        for(int i=0;i<m;i++) {
            dp[i][0] = 1;
        }
        for(int j=0;j<n;j++) {
            dp[0][j] = 1;
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePathsSpaceOptimized(int m, int n) {

        int prev[] = new int[n];
        int cur[] = new int[n];

        for(int j=0;j<n;j++) {
            prev[j] = 1;
        }

        for(int i=1;i<m;i++) {
            cur[0] = 1;
            for(int j=1;j<n;j++) {
                cur[j] = prev[j] + cur[j-1];
            }
            prev = (int[]) cur.clone();
        }

        return prev[n-1];
    }

    public static void main(String args[]) {
        /**
         * EXPLANATION IN ARRAY PACKAGE, UNIQUE PATHS.
         */
        int m=1;
        int n=3;

        uniquePaths(m, n);
    }
}
