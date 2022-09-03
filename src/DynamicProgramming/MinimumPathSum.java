package DynamicProgramming;

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

    public static void main(String args[]) {

        int matrix[][] = {{5,9,6},{11,5,2}};


        System.out.println(minSumPath(matrix));
    }
}