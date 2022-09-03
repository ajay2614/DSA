package DynamicProgramming;

public class LongestPalindromicSubsequence {

    public static int lps(String s) {

        StringBuilder str1 = new StringBuilder(s);
        StringBuilder str2 = new StringBuilder(s);
        str2.reverse();

        int length = str1.length();
        int dp[][] = new int[length+1][length+1];

        for (int i=1;i<=length;i++) {
            for (int j=1;j<=length;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[length][length];
    }

    public int longestPalindromeSubseqSpaceOptimized(String s) {

        StringBuilder str1 = new StringBuilder(s);
        String s2 = str1.reverse().toString();


        int length = s.length();
        int prev[] = new int[length+1];
        int cur[] = new int[length+1];
        for (int i=1;i<=length;i++) {
            for (int j=1;j<=length;j++) {
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }
                else
                    cur[j] = Math.max(prev[j], cur[j-1]);
            }
            prev = (int[]) cur.clone();
        }

        return prev[length];
    }
    public static void main(String args[]) {

        String s= "abbac";

        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(lps(s));
    }
}
