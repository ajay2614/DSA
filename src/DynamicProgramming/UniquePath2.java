package DynamicProgramming;
import java.util.Arrays;
public class UniquePath2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(i >= 0 && j >=0 && obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else if(i==0 && j==0)
                    dp[i][j] = 1;
                else {
                    int up = 0;
                    int left = 0;

                    if( i > 0)
                        up = dp[i-1][j];
                    if( j > 0)
                        left = dp[i][j-1];

                    dp[i][j] = up + left;
                }
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstaclesSpaceOptimized(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int prev[] = new int[n];
        for(int i=0;i<m;i++){
            int temp[] = new int[n];
            for(int j=0;j<n;j++) {
                if(i >= 0 && j >=0 && obstacleGrid[i][j] == 1)
                    temp[j] = 0;
                else if(i==0 && j==0)
                    temp[j] = 1;
                else {
                    int up = 0;
                    int left = 0;

                    if( i > 0)
                        up = prev[j];
                    if( j > 0)
                        left = temp[j-1];

                    temp[j] = up + left;
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
    public int uniquePathsWithObstaclesAlternate(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m > 0 && n > 0 && obstacleGrid[0][0] == 1)
            return 0;
        int dp[][] = new int[m][n];
        for(int i=0;i<m;i++) {
            if(obstacleGrid[i][0] != 1)
                dp[i][0] = 1;
            //USING BREAK AS WE ARE GOING ROW WISE AND IF WE ENCOUNTER AN OBSTACLE THERE IS NO WAY TO REACH
            //NEXT OBSTACLE
            else
                break;
        }
        for(int j=0;j<n;j++) {
            if(obstacleGrid[0][j] != 1)
                dp[0][j] = 1;
            else
                break;
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(obstacleGrid[i][j] != 1 ) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(m >= 1 && n >= 1 && obstacleGrid[0][0] == 1)
            return 0;
        int dp[][] = new int[m][n];
        for(int a[] : dp) {
            Arrays.fill(a, -1);
        }
        recursion(0,0,m,n,obstacleGrid, dp);
        return dp[0][0];
    }

    public int recursion(int i, int j, int m, int n, int[][] obstacleGrid, int dp[][]) {
        if(i == m-1 && j == n-1) {
            if(obstacleGrid[i][j] == 1)
                dp[i][j] = 0;
            else
                dp[i][j] = 1;
            return dp[i][j];
        }
        if(i == m || j == n)
            return 0;
        if(obstacleGrid[i][j] == 1)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int row = recursion(i+1, j, m, n, obstacleGrid, dp);
        int col = recursion(i, j+1, m, n, obstacleGrid, dp);

        dp[i][j] =  row + col;
        return dp[i][j];
    }

    public static void main(String[] args) {
        /**
         * IN THIS WE HAVE TO FIND THE UNIQUE PATHS, ONLY DIFFERENCE WITH NORMAL IS THAT IN THIS WE CAN HAVE OBSTACLES
         * AND WE MUST DISCARD ANY PATH WITH OBSTACLE IN IT,
         *
         * AS THE FIRST STEP IS FILLING OUT THE 0TH ROW JTH COL AND 0TH COL ITH ROW, BUT SINCE WE CAN ONLY MOVE IN ONE DIRECTION
         * THAT IS EITHER BOTTOM OR RIGHT SO IF WE ENCOUNTER AN OBSTACLE WE CAN NOT TRAVEL TO NEXT STAGES
         *
         * AFTER THAT SIMPLY USE THE TABULATION DP TO EVALUATE.
         */
        int obstacle[][] = {{0,0},{1,1},{0,0}};
        uniquePathsWithObstacles(obstacle);
    }
}
