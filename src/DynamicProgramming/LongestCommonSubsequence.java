package DynamicProgramming;

public class LongestCommonSubsequence {
    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];
        /*
        filling first rows as 0, because we shifted the index, now if recursion uses index < 0, return 0,
        with shifting index we can match ind == 0 and return 0, so this step is added in our tabulation,
        we can remove the case of -1
         */
        for(int i=0;i<=m;i++) {
            dp[0][i] = 0;
        }

        for (int i=0;i<=n;i++) {
            dp[i][0] = 0;
        }

        for(int i1=1;i1<=n;i1++) {
            for (int i2 = 1; i2 <= m; i2++) {
                if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
                    /*
                    if it was recursion s1 = acd & s2 = bcd, it's like we match d & if its matching we check for remaining
                    string, ie ac & bc, now since tabulation is bottom up approach we match from left to right.
                     */
                    dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
                }
                else
                    dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
            }
        }
        String print = printLcs(dp,s1,s2);
        System.out.println("PRINT LCS -> " + print);
        return dp[n][m];
    }
    public static String printLcs(int [][] dp, String s1, String s2) {
        int n = dp.length;
        int m = dp[0].length;

        int length = dp[n-1][m-1];
        int ind = length - 1;
        int i = n-1;
        int j = m-1;
        String str = "";
        for (int l=0;l<length;l++) {
            str += "$";
        }

        StringBuilder str1 = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(s2);
        StringBuilder ans = new StringBuilder(str);



        while (i > 0 && j > 0) {
            if (str1.charAt(i-1) == str2.charAt(j-1)) {
                ans.setCharAt(ind--, str1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                /*
                Number came from up
                 */
                i--;
            }
            else {
                /*
                Number came from left
                 */
                j--;
            }
        }
        return ans.toString();
    }
    public static void main(String args[]) {
        /*
        The most important thing to notice here is that we shifted the index, like 0 is 1 and -1 is 0
        this is because unlike recursion we can't represent -1 in tabulation.
         */

        String s1= "acd";
        String s2= "ced";

        System.out.println("The Length of Longest Common Subsequence is "+lcs(s1,s2));
    }
}
