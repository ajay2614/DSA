package DynamicProgramming;

public class ThreeDdp {
    public static int maximumChocolates(int r, int c, int[][] grid) {
        int dp[][][] = new int[r][c][c];

        for(int j1=0;j1<c;j1++) {
            for(int j2=0;j2<c;j2++) {
                if(j1 == j2)
                    dp[r-1][j1][j2] = grid[r-1][j1];
                else
                    dp[r-1][j1][j2]= grid[r-1][j1] + grid[r-1][j2];
            }
        }

        for(int i=r-2;i>=0;i--) {
            for(int j1=0;j1<c;j1++) {
                for(int j2=0;j2<c;j2++){

                    int maxi = Integer.MIN_VALUE;

                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <=1; dj2++) {
                            int value = 0;

                            if(j1 == j2)
                                value+= grid[i][j1];
                            else
                                value+= grid[i][j1] + grid[i][j2];

                            if(j1 + dj1 < 0 || j1 + dj1 >= c
                                    || j2 + dj2 < 0 || j2 + dj2 >= c)
                                value += (int) Math.pow(-10,9);
                            else
                                value += dp[i+1][j1 + dj1][j2 + dj2];

                            maxi = Math.max(maxi, value);
                        }
                    }

                    dp[i][j1][j2] = maxi;
                }
            }
        }
        return dp[0][0][c-1];
    }

    public static int maximumChocolatesSpaceOptimized(int r, int c, int[][] grid) {

        int prev[][] = new int[c][c];
        int[][] cur = new int[c][c];
        for(int j1=0;j1<c;j1++) {
            for(int j2=0;j2<c;j2++) {
                if(j1 == j2)
                    prev[j1][j2] = grid[r-1][j1];
                else
                    prev[j1][j2]= grid[r-1][j1] + grid[r-1][j2];
            }
        }

        for(int i=r-2;i>=0;i--) {

            for(int j1=0;j1<c;j1++) {
                for(int j2=0;j2<c;j2++){

                    int maxi = Integer.MIN_VALUE;
                    for(int dj1 = -1; dj1 <= 1; dj1++) {
                        for(int dj2 = -1; dj2 <=1; dj2++) {
                            int value = 0;

                            if(j1 == j2)
                                value+= grid[i][j1];
                            else
                                value+= grid[i][j1] + grid[i][j2];

                            if(j1 + dj1 < 0 || j1 + dj1 >= c
                                    || j2 + dj2 < 0 || j2 + dj2 >= c)
                                value += (int) Math.pow(-10,9);
                            else
                                value += prev[j1 + dj1][j2 + dj2];

                            maxi = Math.max(maxi, value);
                        }
                    }

                    cur[j1][j2] = maxi;
                }
            }
            for (int a = 0; a < c; a++) {
                prev[a] = (int[])(cur[a].clone());
            }
        }
        return prev[0][c-1];
    }
}
