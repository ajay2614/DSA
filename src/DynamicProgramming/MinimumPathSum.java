package DynamicProgramming;
import java.util.Arrays;
public class MinimumPathSum {
    public static int minSumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dp[][] = new int[m][n];

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                }
                else{
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i > 0)
                        up += dp[i-1][j];
                    else
                        up += (int)Math.pow(10,9);
                    if(j > 0)
                        left += dp[i][j-1];
                    else
                        left += (int)Math.pow(10,9);

                    dp[i][j] = Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int minPathSumSpaceOptimized(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int prev[] = new int[n];

        for(int i=0;i<m;i++) {
            int temp[] = new int[n];
            for(int j=0;j<n;j++) {
                if(i == 0 && j == 0) {
                    temp[j] = grid[i][j];
                }
                else{
                    int up = grid[i][j];
                    int left = grid[i][j];

                    if(i > 0)
                        up += prev[j];
                    else
                        up += (int)Math.pow(10,9);
                    if(j > 0)
                        left += temp[j-1];
                    else
                        left += (int)Math.pow(10,9);

                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }

    public static int minPathSumRecursion(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        for(int a[] : dp) {
            Arrays.fill(a, -1);
        }
        recursion(0, 0, m, n, grid, dp);
        return dp[0][0];
    }

    public static int recursion(int i, int j, int m, int n, int[][] grid, int[][] dp) {
        if(i == m || j == n) {
            return Integer.MAX_VALUE;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(i == m-1 && j == n-1) {
            dp[i][j] = grid[i][j];
            return dp[i][j];
        }

        int down = recursion(i+1, j, m, n, grid, dp);
        int right = recursion(i, j+1, m,n , grid, dp);

        dp[i][j] = grid[i][j] + Math.min(down, right);
        return dp[i][j];
    }
    public static void main(String args[]) {

        int matrix[][] = {{1,3,1},{1,5,1},{4,2,1}};


        System.out.println(minPathSumRecursion(matrix));
    }
}