package DynamicProgramming;

public class MinimumInsertionDeletionReplaceToConvertString1ToString2 {
    public static int minStepsToConvertS1toS2(String str1, String str2) {
        //Your code goes here

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        /*
        BASE CASES
        AS WRITTEN BELOW J IS 0 SO INSERTION I VALUE
         */
        for(int i=0;i<=n;i++) {
            dp[i][0] = i;
        }
          /*
        BASE CASES
        AS WRITTEN BELOW I IS 0 SO INSERTION J VALUE
         */
        for(int j=0;j<=m;j++) {
            dp[0][j] = j;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    /*
                    STRING MATCHES NO OPERATION REQUIRE, JUST NEED TO DECREASE BOTH INDEX BY 1
                     */
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    /*
                    MINIMUM OF INSERTION(DP[I][J-1]), DELETION(DP[I-1][J]) AND
                    REPLACE(DP[I-1][J-1]) + 1 MOVE
                     */
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1],
                            dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }

    public int minDistanceSpaceOptimized(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int prev[] = new int[m+1];

        for(int j=0;j<=m;j++) {
            prev[j] = j;
        }

        for(int i=1;i<=n;i++) {
            int cur[] = new int[m+1];
            cur[0] = i;
            for(int j=1;j<=m;j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    cur[j] = prev[j-1];
                else
                    cur[j] = 1 + Math.min(prev[j-1], Math.min(cur[j-1], prev[j]));
            }
            prev = cur;
        }
        return prev[m];
    }

    public static void main(String args[]) {

        /*
        WHAT THIS QUESTION IS ASKING IS TO FIND MINIMUM STEPS TO CONVERT S1 TO S2
        WE CAN USE THREE OPERATIONS IN BETWEEN, DELETE A CHAR, REPLACE A CHAR, INSERT A CHAR

        NOW THE APPROACH TO SOLVE THIS IS THAT WE CAN HAVE TO SITUATIONS

        1 -> WHEN BOTH THE STRING MATCHES, IN THIS CASE WE ONLY NEED TO DECREASE INDEX FOR BOTH STRINGS AND MOVE ON
        WITHOUT ADDING ANY OPERATION

        2 -> WHEN THEY DON'T MATCH, NOW IN THIS CASE WE HAVE TO FIND MIN STEPS TAKEN BY INSERTION, DELETION OR REPLACE
        AND ALSO ADDING 1 SINCE WE ARE MAKING A MOVE/OPERATION.

        IN TERMS OF RECURSION THE FUNCTION FOR INSERTION WOULD BE -> f(i, j-1, s1, s2)
        REASON FOR THIS IS BECAUSE LET'S SAY VIA EXAMPLE ABC IS STRING 1 AND BD IS STRING 2 THEN BY ADDING D IN ABC I WILL BE ON C
        SO WE JUST NEED TO MOVE J POINTER

        IN TERMS OF RECURSION THE FUNCTION FOR DELETION WOULD BE -> f(i-1, j, s1, s2)
        EXAMPLE - ABDC AND BD AND WE DELETE C FROM S1 SO WE SHIFT I TO I-1;

        IN TERMS OF RECURSION THE FUNCTION FOR REPLACE WOULD BE -> f(i-1, j-1, s1, s2)
        EXAMPLE - ABC AND BD AND WE REPLACE D FROM S1 WITH C SO WE SHIFT I TO I-1 AND J TO J-1 AS BOTH D MATCH NOW


        --BASE CASES
        TWO SITUATIONS CAN ARRIVE EITHER I HAS BECOME SMALLER THAN 0 OR J HAS BECOME

        IN CASE OF I BECOMING 0 WE KNOW THAT FOR EMPTY STRING S1 TO CONVERT TO A STRING S2
        WE NEED TO INSERT THE NUMBER OF CHARACTERS OF S2. HENCE WE RETURN J.

        SIMILARLY IN CASE OF J, TO CONVERT A NON EMPTY STRING S1 TO EMPTY STRING S2 WE NEED TO DELETE ALL
        THE CHAR OF THAT STRING S1. HENCE WE RETURN I.


         */
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: "+
                minStepsToConvertS1toS2(s1,s2));
    }
}
