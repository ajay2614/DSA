package DynamicProgramming;

public class CountSquareSubmatrices {

    public int countSquares(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n][m];

        for(int i=0;i<n;i++) {
            dp[i][0] = matrix[i][0];
        }
        for(int j=0;j<m;j++) {
            dp[0][j] = matrix[0][j];
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                if(matrix[i][j] == 1)
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                else
                    dp[i][j] = 0;
            }
        }

        int sum = 0;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        /*
        THE QUESTION STATES THAT WE ARE GIVEN A 2D ARRAY FULL OF 0 & 1, WE HAVE TO FIND HOW MANY TOTAL SUBSQUARES WE CAN MAKE
        FROM THIS ARRAY, WE ONLY CAN COUNT IT AS SUBSQUARE IF IT IS 1 AND NOT 0, EXAMPLE FOR ARRAY OF
        1 1
        1 1, TOTAL 5 SUBSQUARES, 4 SINGULAR, AND 1 2D

        BRUTE FORCE APPROACH WOULD BE WE TO ITERATE FOR EVERY 1 AND COMPUTE TOTAL SQUARES FOR IT,

        FOR OPTIMAL APPROACH, FIRST WE COPY FOR ROW AND COLUMN 0, EXACT SAME VALUE, AS IT WILL FORM 1 SQUARE ONLY IF IT AS
        ROW 0 OR COLUMN 0, NOW FOR REMAINING ELEMENTS, WE CALCULATE THE MIN OF DIAGONAL, PREV ROW SAME COLUMN, CURRENT ROW,
        PREVIOUS COLUMN, IN THE END WE CALCULATE THE TOTAL WHICH WILL GIVE US FINAL ANSWER.
         */
    }
}
