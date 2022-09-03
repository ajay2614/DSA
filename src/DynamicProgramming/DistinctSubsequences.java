package DynamicProgramming;

public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0;i<=n;i++) {
            /*
            base case in terms of recursion, in this index of s2 is 0 hence we can return 1;
             */
            dp[i][0] = 1;
        }

        for(int j=1;j<=m;j++) {
           /*
            base case in terms of recursion, in this index of s2 is not 0 hence we can return 0;
             */
            dp[0][j] = 0;
        }

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    /*
                    we can decrease index for both string or for 1 string
                    example for babgbag and bag when g matches then either we can decrease both string by 1 and remaining
                    becomes babgba and ba or we can decrease index of s1 as we can consider other options.
                     */
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else
                    /*
                    as there is only one option we can take which is decreasing index of first string as the char aren't matching
                     */
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][m];
    }

    public int numDistinctSpaceOptimized(String s, String t) {

        int n = s.length();
        int m = t.length();

        int prev[] = new int[m+1];

        prev[0] = 1;

        for(int j=1;j<=m;j++) {
            prev[j] = 0;
        }

        for(int i=1;i<=n;i++) {
            int cur[] = new int[m + 1];
            cur[0] = 1;
            for(int j=1;j<=m;j++) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    cur[j] = prev[j-1] + prev[j];
                else
                    cur[j] = prev[j];
            }
            prev = cur;
        }

        return prev[m];
    }



    public static void main(String args[]) {

        /*
        In this question, we need to find the distinct subsequences we can make of string2 from string1, for example
        we can use last three char to make one subsequence of s2.
        Approach

        use multiple indexes for both strings

        during recursion 2 base cases can reach
        one is when s2 is completely over, ie index for s2 is now 0, then we return 1, otherwise if it isnt and s1 index is 0,
        we return 0.

        2 cases can arrive during recursion
        if char of s1 at certain index i matches char of s2 and index j, then we can take this case and decrease both index by 1
        or we can decrease the index of s1 by 1, meaning we are not taking this

        otherwise if they don't match we can only use 1 case that is not taking this.
         */
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is "+
                numDistinct(s1,s2));
    }

}
