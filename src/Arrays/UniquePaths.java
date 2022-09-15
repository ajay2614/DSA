package Arrays;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {

        int N = m + n - 2;
        int R = m - 1;
        double ans = 1;

        for(int i=1;i<m;i++) {
            ans = ans * (N - R + i)/i;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTIONS STATES THAT WE ARE GIVEN ROWS AND COLUMN, WE CAN MOVE ONLY RIGHT OR DOWN, FIND THE NUMBER OF WAYS,
         * WE CAN REACH N-1, M-1 DISTANCE
         *
         * RECURSTION
         * TRAVEL ALL PATHS FROM ROW 0 AND COLUMN 0, TC, EXPONENT, AS WE ARE COMPUTING ALL THE CASES
         *
         * HAVE BASE CASE WHEN ROW OR COLUMN BECOMES N OR GREATER THAN N OR M, RETURN 0 AS WE HAVE EXCEEDED BOUNDARY,
         *
         * DP
         *
         * DP IS SIMPLY MADE FROM RECURSION, FIRST ASSIGN DP[0][J] & DP[J][0] AS 1, BECAUSE WE KNOW WE WILL HAVE ONLY ONE
         * WAY TO MOVE RIGHT OR DOWN THE 0TH ROW OR 0TH COLUMN, THEN COMPUTE DP[I][J] = DP[I-1][J] + DP[I][J-1], TC BIG
         * O(N*N) SC SAME AS TC.
         *
         * NOW ON FURTHER OBSERVATION WE OBSERVE THAT ARE WE NEED N-1 RIGHTWARD DIRECTIONS AND M-1 DOWNWARD DIRECTIONS, HENCE
         * WE NEED M-N+2 TOTAL STEPS
         *
         * LETS TAKE EG OF ARRAY WITH 2 ROWS AND 3 COLUMNS, WE CAN EITHER GO
         *
         * R R D OR R D R OR D R R, SO TOTAL STEPS WE TAKE IS 3
         *
         * SO WE CAN CHOOSE M-1 STEPS OR N-1 STEPS AND CALCULATE COMBINATION, WITH COMBINATION EVEN IF WE COMPUTE FOR 2 RIGHTS
         * WHICH IS 3 C 2 OR 1 DOWN 3 C 1, THE ANSWER WOULD ALWAYS BE 3.
         *
         * HENCE WE WILL TAKE N AS M+N-2, AND R AS EITHER M-1 OR N-1
         *
         * TO CALCULATE COMBINATION, SIMPLE WAY IS (N - R + I)/I, I IS STARTING FROM 1 TO R,
         *
         * EG N AS 10 AND R AS 3, WOULD BE (10 - 3 + 1)/1 * (10 - 3 + 2)/2 * (10 - 3 + 3)/3,
         * WHICH IS SIMPLY 10*9*8/1*2*3,
         * NCR IS N!/R!(N-R)! WHICH IN ABOVE EX WOULD BE 10!/3!(7!), DIVIDING 7! IN NUM AND DENO WE GET SAME EXPRESSION.
         *
         * TC WOULD BE IN THIS O(n-1) or  O(m-1) DEPENDING UPON WHICH ONE WE CHOOSE.
         * SC WOULD BE O(1)
         *
         */
        uniquePaths(2, 5);
    }
}
