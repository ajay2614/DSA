package DynamicProgramming;

public class PalindromePartitioning2 {

    public int minCut(String s) {
        int ans = recursion(s, 0, s.length());
        return ans-1;
    }

    public int recursion(String s, int i, int n) {
        if(i == n)
            return 0;

        int min = Integer.MAX_VALUE;

        for(int j=i;j<n;j++) {
            if(isPalindrome(i, j, s)) {
                int cost = 1 + recursion(s, j+1, n);
                min = Math.min(cost, min);
            }
        }
        return min;
    }

    public int recursionMemo(String s, int i, int n,int[] dp) {
        if(i == n)
            return 0;
        if(dp[i] != -1)
            return dp[i];

        int min = Integer.MAX_VALUE;

        for(int j=i;j<n;j++) {
            if(isPalindrome(i, j, s)) {
                int cost = 1 + recursionMemo(s, j+1, n, dp);
                min = Math.min(cost, min);
            }
        }
        dp[i] = min;
        return dp[i];
    }

    public boolean isPalindrome(int i, int j, String s) {
        while(i<j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int minCutTabu(String s) {
        int n = s.length();
        int dp[] = new int[s.length() + 1];
        dp[n] = 0;
        for(int i=n-1; i>=0;i--) {
            int min = Integer.MAX_VALUE;
            for(int j=i;j<n;j++) {
                if(isPalindrome(i,j,s)) {
                    int cost = 1+dp[j+1];
                    min = Math.min(min, cost);
                }
            }
            dp[i] = min;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        /*
        THE QUESTION STATES THAT WE NEED TO FIND MINIMUM WAYS BY WHICH WE CAN PARTITION A STRING INTO SUBSTRING IN SUCH A WAY
        EVERY SUBSTRING IS A PALINDROME

        RECURSIVE WAY, WHAT WE NEED TO DO, IS START RECURSION FROM INDEX 0, RUN A FOR LOOP INSIDE RECURSION

        FOR J WHICH RUNS FROM I TILL N-1. NOW CHECK IF STRING FROM I TO J IS PALINDROME, IF IT IS, ADD THE STEP 1 +
        THE NUMBER OF STEPS FOR REMAINING SUBSTRING, EG AACDA, WE CHECK FROM I = 0, AND J=1, WHICH IS AA, WE CHECK
        THIS SUBSTRING IS PALINDROME, HENCE WE PASS CDA, AS THE REMAINING PART TO CHECK, CDA IS PASSED AS CALLING
        THE RECURSION METHOD AND PASSING J+1 AS INDEX.

        INT THE END CHECK FOR MIN STEPS,

        NOTE THAT WE HAVE TO SUBTRACT 1 FROM FINAL ANSWER BECAUSE AS ASSUME STRING ABC, AS A GETS CHECKED THEN B GETS CHECKED
        AND C GETS CHECKED AS PALINDROME AND THEN WHEN WE CALL RECURSIVE METHOD IT RETURNS 0, BUT WE HAVE WRITTER "1 + " IN METHOD
        AS THERE IS NO NEED TO COUNT THIS AS STEP, WE SUBTRACT 1 FROM ANSWER.

        DP TABU

        FOR DP TABU WE DECLARE 1D ARRAY, OF LENGTH N+1, WHY 1D, BECAUSE ONLY 1 INDEX I WAS USED IN RECURSIVE FUNCTIONS,
        WHY N+1, TO REPRESENT BASE CASE I==N, RETURN 0, DP[N] = 0, UNLIKE CALLING RECURSIVE FUNCTION, WE JUST GET STEP
        BY DP[J+1], IN THE END RETURN DP[0]-1 WHICH WILL BE FINAL ANSWER.

         */

    }

}
