package DynamicProgramming;

public class MinFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i=1;i<m;i++) {
            for(int j=0;j<n;j++) {
                int up = matrix[i][j] + dp[i-1][j];

                int left = matrix[i][j];
                if(j > 0)
                    left+= dp[i-1][j-1];
                else
                    left+= Math.pow(10,9);
                int right = matrix[i][j];
                if(j < n-1)
                    right+= dp[i-1][j+1];
                else
                    right+=Math.pow(10,9);

                dp[i][j] = Math.min(up, Math.min(left,right));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            min = Math.min(min, dp[m-1][i]);
        }
        return min;
    }
    public int minFallingPathSumSpaceOptimized(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int prev[] = new int[n];
        for(int i=0;i<n;i++){
            prev[i] = matrix[0][i];
        }

        for(int i=1;i<m;i++) {
            int temp[] = new int[n];
            for(int j=0;j<n;j++) {
                int up = matrix[i][j] + prev[j];

                int left = matrix[i][j];
                if(j > 0)
                    left+= prev[j-1];
                else
                    left+= Math.pow(10,9);
                int right = matrix[i][j];
                if(j < n-1)
                    right+= prev[j+1];
                else
                    right+=Math.pow(10,9);

                temp[j] = Math.min(up, Math.min(left,right));
            }
            prev = temp;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            min = Math.min(min, prev[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        int matrix[][] = {{17,82}, {1,-44}};
        int val = minFallingPathSum(matrix);
        System.out.println(val);
    }
}
