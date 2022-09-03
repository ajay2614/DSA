package DynamicProgramming;

import java.util.Arrays;

public class MinimumCostToCutStick {
    public static int recursiveFn(int i, int j, int cuts[]) {
        if(i > j)
            return 0;

        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++) {
            int cut = cuts[j+1] - cuts[i-1] + recursiveFn(i,k-1,cuts) +
                    recursiveFn(k+1,j, cuts);
            min = Math.min(cut, min);
        }
        return min;
    }
    public int minCostRecursive(int n, int[] cuts) {

        int c = cuts.length;
        int[] cutsTemp = new int[c+2];
        cutsTemp[0] = 0;

        for(int i=1;i<=c;i++) {
            cutsTemp[i] = cuts[i-1];
        }

        cutsTemp[c+1] = n;

        Arrays.sort(cutsTemp);

        return recursiveFn(1, c, cutsTemp);
    }

    public static int minCostMemo(int n, int[] cuts) {

        int c = cuts.length;
        int[] cutsTemp = new int[c+2];
        cutsTemp[0] = 0;

        int dp[][] = new int[c+1][c+1];
        for(int i=0;i<c+1;i++){
            for(int j=0;j<c+1;j++) {
                dp[i][j] = -1;
            }
        }

        for(int i=1;i<=c;i++) {
            cutsTemp[i] = cuts[i-1];
        }

        cutsTemp[c+1] = n;

        Arrays.sort(cutsTemp);

        return recursiveFnMemo(1, c, cutsTemp, dp);
    }

    public static int recursiveFnMemo(int i, int j, int cuts[], int dp[][]) {
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++) {
            int cut = cuts[j+1] - cuts[i-1] + recursiveFnMemo(i,k-1,cuts,dp) +
                    recursiveFnMemo(k+1,j, cuts,dp);
            min = Math.min(cut, min);
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    public static int minCostTabu(int n, int[] cuts) {

        int c = cuts.length;
        int[] cutsTemp = new int[c+2];
        cutsTemp[0] = 0;

        for(int i=1;i<=c;i++) {
            cutsTemp[i] = cuts[i-1];
        }

        cutsTemp[c+1] = n;

        Arrays.sort(cutsTemp);

        int dp[][] = new int[c+2][c+2];

        for(int i=c;i>=1;i--) {
            for(int j=1;j<=c;j++) {
                if(i > j)
                    continue;

                int min = Integer.MAX_VALUE;

                for(int k=i;k<=j;k++) {
                    int cut = cutsTemp[j+1] - cutsTemp[i-1] + dp[i][k-1] +
                            dp[k+1][j];

                    min = Math.min(cut, min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }

    public static void main(String[] args) {
        /*
        Very Hard

        THE QUESTION STATES THAT WE ARE GIVEN A CHOCOLATE OF LENGTH N, AND WE ARE GIVEN A CUT ARRAY, WE NEED TO FIND THE MINI
        MUM COST OF CUTTING WHEN WE CUT USING THE ELEMENTS IN CUT ARRAY, COST OF THE CUT ARRAY IS --

        FOR EG LENGTH IS 4 AND CUTS ARE 1 2 AND WE DO 1 SO THE CHOCOLATE WOULD BE 0 1 MEANS 1 SQUARE AND 1 2 3 4

        [1][2][3]
         1 2 3 4
        YOU CAN SIMPLY SAY 3 PIECES OF CHOCOLATE AFTER CUTTING LENGTH 1, SO TOTAL COST TILL NOW IS 4 WHICH WAS INITIAL COST
        ADDING 3 AFTER CUTTING IT 1 PIECE

        RECURSIVE WAY

        WHAT WE ARE GIVEN IS CUTS ARRAY, SINCE IT COULD BE THAT N IS GREATER THAN LAST ELEMENT OF THIS ARRAY
        AND 0 IS NOT AT INITIAL WE WILL USE A TEMP ARRAY AND ASSIGN 0 AND LAST INDEX AS N, AS WE WOULD NEED
        THE N INDEX

        RUN A LOOP FROM I TILL J FOR VARIABLE K, ACTING AS PARTITIONER LIKE IT DID FOR MCM

        NOW FOR CUTTING AT K INDEX, COST WOULD BE CUTS[J+1] - CUTS[I-1], ASSUMING WE STARTED FOR CUTS ARR 1 2 3 4
        SETTING J AS 3 WHICH IS LENGTH OF CUTS, CUTSTEMP WOULD BE 0 1 2 3 4 5 SO COST WOULD BE CUTS[3+1] - CUTS[1-1]
        WHICH IS CUTS[4] = 5 - 0, = 5 WHICH IS INITIAL COST, NOW WE WILL FIND FOR LEFT AND RIGHT SIDE VIA
        F(I, K-1) , F(K+1, J)

        EG 1 IS 1, K = 3, J=5
        F(1,3), F(4,5)

        WHY I,K-1 & K+1, J, BECAUSE ITS LIKE WE CUT A CHOCOLATE, LETS SAY CHOCOLATE 0 1 2 3 4
        WE CUT 2 AND APPLY THE COST, THEN WE HAVE TO FIND FOR 0 1 WHICH WILL BE DONE BY F(I,K-1) &
        3,4 DONE BY F(K+1,J)

        USE MIN TO TRACK MIN VARIABLES.
        WHEN I IS GREATER THAN J RETURN 0, I COULD BE EQUAL TO J, NO PROBLEM IN THAT


        TABULATION WAY

        TO RUN LOOPS AS I WAS RUNNING TILL C IN RECURSION, HERE IT WILL RUN FROM C TO 1,
        SIMILARLY J WOULD RUN FROM 1 TO C, I IS MOVING LEFTWARDS, J IS MOVING RIGHTWARDS

        WHEN I > J CONTINUE;

        K's LOOP IS SAME

        AS IN THIS SITUATION CAN ARISE WHEN SAY CUTS LENGTH IS 4, SO I J IS 4, AS IT WOULD LOOK

        FOR DP[K+1][J] WE NEED TO INITALIZE DPS SIZE TO C+2.

        OTHER THINGS AND WORKING ARE SAME CONCEPT OF RECURSION
         */
        int cuts[] = {1,3,4,5};
        int n = 7;

        System.out.println(minCostMemo(n, cuts));
        System.out.println(minCostTabu(n, cuts));
    }
}
