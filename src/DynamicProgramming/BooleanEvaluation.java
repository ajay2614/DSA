package DynamicProgramming;

import java.util.Arrays;

public class BooleanEvaluation {


    static int countWays(int N, String S){

        int dp[][][]=new int[N+1][N+1][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        int value = recursiveWayMemo(0, S.length()-1, true, S, dp);

        return value;
    }

    public static int recursiveWayMemo(int i, int j, boolean isTrue, String s, int[][][] dp) {
        if(i>j)
            return 0;
        if(i==j) {
            if(isTrue) {
                if(s.charAt(i) == 'T')
                    return 1;
                return 0;
            }
            else {
                if(s.charAt(i) == 'F')
                    return 1;
                return 0;
            }
        }

        if(dp[i][j][isTrue==true?1:0]!=-1){
            return dp[i][j][isTrue==true?1:0];
        }

        int w = 0;
        for(int k=i+1; k<=j-1;k+=2) {

            long lt = recursiveWayMemo(i,k-1,true,s,dp);
            long lf = recursiveWayMemo(i,k-1,false,s,dp);
            long rt = recursiveWayMemo(k+1,j,true,s,dp);
            long rf = recursiveWayMemo(k+1,j,false,s,dp);

            if(s.charAt(k) == '&') {
                if(isTrue)
                    w += rt * lt;
                else
                    w += rt * lf + rf * lt + rf * lf;

            }
            else if(s.charAt(k) == '|') {
                if(isTrue) {
                    w += rt * lt + rf * lt + rt * lf;
                }
                else
                    w += rf * lf;
            }
            else {
                if(isTrue) {
                    w += rf * lt + rt * lf;
                }
                else
                    w += rf * lf + rt * lt;
            }
        }
        return dp[i][j][isTrue==true?1:0]=w%1003;
    }

    public static int recursiveWay(int i, int j, boolean isTrue, String s) {
        if(i>j)
            return 0;
        if(i==j) {
            if(isTrue) {
                if(s.charAt(i) == 'T')
                    return 1;
                return 0;
            }
            else {
                if(s.charAt(i) == 'F')
                    return 1;
                return 0;
            }
        }

        int w = 0;
        for(int k=i+1; k<=j-1;k+=2) {

            long lt = recursiveWay(i,k-1,true,s);
            long lf = recursiveWay(i,k-1,false,s);
            long rt = recursiveWay(k+1,j,true,s);
            long rf = recursiveWay(k+1,j,false,s);

            if(s.charAt(k) == '&') {
                if(isTrue)
                    w += rt * lt;
                else
                    w += rt * lf + rf * lt + rf * lf;

            }
            else if(s.charAt(k) == '|') {
                if(isTrue) {
                    w += rt * lt + rf * lt + rt * lf;
                }
                else
                    w += rf * lf;
            }
            else {
                if(isTrue) {
                    w += rf * lt + rt * lf;
                }
                else
                    w += rf * lf + rt * lt;
            }
        }
        return w%1003;
    }

    static int countWaysTabu(int N, String S) {

        int dp[][][] = new int[N + 1][N + 1][2];

        for (int i = S.length() - 1; i >= 0; i--) {
            for (int j = i; j < S.length(); j++) {
                if (i == j) {
                    if (S.charAt(i) == 'T') {
                        dp[i][j][1] = 1;
                        dp[i][j][0] = 0;
                    } else {
                        dp[i][j][0] = 1;
                        dp[i][j][1] = 0;
                    }
                } else {

                    for (int k = i + 1; k <= j - 1; k += 2) {

                        long lt = dp[i][k - 1][1];
                        long lf = dp[i][k - 1][0];
                        long rt = dp[k + 1][j][1];
                        long rf = dp[k + 1][j][0];
                        if (S.charAt(k) == '&') {
                            dp[i][j][1] += rt * lt;
                            dp[i][j][0] += rt * lf + rf * lt + rf * lf;
                        } else if (S.charAt(k) == '|') {
                            dp[i][j][1] += rt * lt + rf * lt + rt * lf;
                            dp[i][j][0] += rf * lf;
                        } else {
                            dp[i][j][1] += rf * lt + rt * lf;
                            dp[i][j][0] += rf * lf + rt * lt;
                        }
                    }
                }
            }
        }
        return dp[0][S.length() - 1][1];
    }

    public static void main(String args[]) {
        /*
        --HARD

        THE QUESTION STATES THAT THERE IS A STRING EG T & F | T ^ T

        WE NEED TO FIND THE NUMBER OF WAYS IN WHICH CAN WE GET TRUE FROM THIS EQUATION. EG WE F & F ^ T
        IF WE EVALUATE F & (F ^ T), WE GET FALSE BUT IF WE EVALUATE (F & F) ^ T, WE GET TRUE

        RECURSIVE WAY, THE APPROACH IS WE NEED TO DIVIDE THE PROBLEM INTO SUBPROBLEMS, AND FIND NUMBER OF WAYS FOR
        BOTH TRUE AND FALSE, WE USE A VARIABLE ISTRUE TO CHECK WHETHER WE ARE WORKING ON FINDING TRUE WAYS OR FALSE WAYS,

        FOR BASE CASE
        IF(I > J) WE RETURN 0 WAYS

        WHEN I == J, IT MEANS WE ARE HAVING SINGULAR CHARACTER, MEANING ITS EITHER TRUE OR FALSE

        WE CHECH VIA ISTRUE IF WE ARE LOOKING FOR TRUE AND CHAR IS TRUE, WE RETURN 1 WAY ELSE IF CHARIS F WE RETURN 0 WAYS
        SIMILARLY IF ISTRUE IS FALSE, WE ARE LOOKING FOR FALSE, WE RETURN 1 WAY IF CHAR IS F ELSE 0 WAY.

        NOW WHEN I < J, WE NEED TO PARTITION INTO LEFT AND RIGHT SUBARRAYS, WE START K FROM I + 1 TILL J-1, AND INCREMENT IT BY 2
        RATHER THAN 1, WHY ALL THIS, BECAUSE WE ARE LOOKING FOR OPERATORS/SIGNS, WE DO NOT NEED TO CHECK T OR F, WE WANT T CHECK
        | ^ &, AND THESE ARE BETWEEN T AND F CHARACTERS, APART FROM EACH OTHER BY 1 CHAR BETWEEN THEM, HENCE K = K+2
        AND I + 1 AND J-1 BECAUSE CHARACTERS START FROM 1 AND END AT N-2.

        NOW WE FIND WAYS LEFT TRUE, LEFT FALSE, RIGHT TRUE, RIGHT FALSE
        LEFT TRUE WOULD BE [I, K-1, TRUE]
        RIGHT TRUE[K+1, J, TRUE]
        LF AND TF ARE SAME JUST FALSE INSTEAD OF TRUE.

        AFTER EVALUATING WE ARE GOING TO CHECK WHICH CHAR IS THERE

        FOR EVERY CHAR WE CHECK IF WE HAVE TO STORE TRUE WAYS, OR FALSE WAYS,

        TRUE WAYS FOR | WOULD BE RT * LT + RT * LF + LT * RF
        SIMILARLY FOR OTHER DONE IN CODE

        IN THE END RETURN THE NUMBER OF WAYS;

        ONE THING WE NOTICE IS THAT EVERY EXPRESSION HAS SIGN SANDWICHED BETWEEN TWO CHARACTERS,

        NOTE F WOULD START WITH (0, N-1, TRUE)
        0 BECAUSE START OF STR, N-1 BECAUSE END OF STRING, TRUE BECAUSE WE NEED TO FIND TRUE WAYS

        DP TABULATION

        FOR DP WE NEED TO GET 3D DP ARRAY, INSTEAD OF USING VARIABLE ISTRUE, WE REPRESENT IT BY 0 OR 1
        HENCE DP[N][N][2]

        NO WE DO THE SAME THINGS JUST USING BOTTOM UP APPROACH, SO I WOULD RUN FROM N-1 TO 0, J WOULD
        RUN FROM I TO N-1;

        SAME BASE CASES OF I & J WHEN BOTH ARE EQUAL, EVERYTHING WOULD BE SAME JUST CHANGE WOULD BE
        WE WOULD BE EVALUATING BOTH FOR T & F AT EVERY STAGE, DP[I][J][1] & DP[I][J][0], ELSE
        EVERYTHING IS SAME.
         */
    }
}
