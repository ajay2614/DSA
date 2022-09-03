package DynamicProgramming;

public class WildcardMatching {

    public static boolean isMatch(String s, String p) {

        int m = s.length();
        int n = p.length();

        boolean dp[][] = new boolean[n+1][m+1];

        /*
        BASE CASE - BOTH I J ARE EXHAUSTED
         */
        dp[0][0] = true;
        for(int j=1; j<=m; j++) {
            /*
            BASE CASE - I IS EXHAUSTED, WE WILL ALWAYS GET FALSE HERE SO MARK FALSE
            */
            dp[0][j] = false;
        }

        for(int i=1;i<=n;i++) {
            /*
            BASE CASE - J IS EXHAUSTED, WE WILL CHECK FOR EVERY INDEX FOR THE PATTERN SO TO SEE TILL WHERE * EXISTS, IF
            WE FIND * ISN'T THERE WE MARK IT AS FALSE
            */
            boolean flag = true;
            for(int k=1;k<=i;k++){
                if(p.charAt(k-1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(p.charAt(i-1) == s.charAt(j-1) || p.charAt(i-1) == '?') {
                    /*
                    CHAR OF P MATCHES WITH S OR P HAD ? WHICH CAN MATCH WITH S, SO DECREASING INDEX OF BOTH BY 1
                     */
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(p.charAt(i-1) == '*') {
                    /*
                    CHAR OF P HAD * SO WE CAN EITHER DECREASE INDEX OF P OR S AND CHECK IF THERE IS TRUE FOR ANY OF THEM
                     */
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else {
                    /*
                    NEITHER ABOVE CASE HAPPEN, WE WILL ALWAYS GET FALSE SO MARK FALSE
                     */
                    dp[i][j] = false;
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String args[]) {

        /*
        QUESTION STATES THAT THERE IS A PATTERN GIVEN P1 AND A STRING GIVEN S1, P1 MAY HAS * OR ?

        ? MARKS MEANS IF P IS ?JAY AND STRING IS AJAY THE ? CAN FORM CHAR A AND RETURN TRUE;
        * MEANS IF P IS A*Y AND STRING IS AJAY THEN P CAN FORM SUBSEQUENCE JA AND HAS RETURN TRUE;

        NOW THREE CASE CAN ARRIVE
        WHEN STRING AND PATTERN CHARACTER MATCHES OR STR HAS ? THEN WE CAN SIMPLY DECREMENT INDEX BY 1
        AS ? CAN SIMPLY FORM THAT CHARACTER

        WHEN STRING HAS *, IN THIS CASE I CAN EITHER IGNORE IT WHICH MEANS I-1 OR NOT IGNORE IT AND MOVE
        TO THE NEXT CHARACTER OF STRING WHICH FILL FORM CHAIN OF SERIES IN RECURSION WHICH WILL EVENTUALLY
        GIVE US TRUE OR FALSE

        THE LAST CASE IS WHEN CHARACTER DOESN'T MATCH AND WE DON'T HAVE * OR ? TOO, SO AJY CAN NEVER BY ANY
        SO SIMPLY RETURN FALSE;

        --BASE CASE

        1.NOW ONE IS CASE IS WHEN BOTH I AND J ARE 0, THIS MEANS TRUE AS BOTH INDEX ARE ONLY EXHAUSTED AS P MATCHES S

        2.NOW 2ND CASE IS WHEN I HAS EXHAUSTED, IT MEANS WE CAN NEVER MATCH P WITH S, SO RETURN FALSE HERE

        3.NOW 3RD CASE IS WHEN J HAS EXHAUSTED, IT MEANS I CAN RETURN TRUE ONLY WHEN IT HAS ALL THE STARS TILL THAT I,
        SO HERE WE HAVE TO RUN A FOR LOOP AND IF * ISNT THERE AT INDEX RETURN FALSE AS * CAN BE OF 0 SIZE BUT WITHOUT IT
        WE WILL ALWAYS GET FALSE

         */

        String S1 = "ab*cd";
        String S2 = "abdefcd";

        if (isMatch(S2, S1))
            System.out.println("String S1 and S2 do match");
        else System.out.println("String S1 and S2 do not match");
    }
}
