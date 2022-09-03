package DynamicProgramming;

public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int lcs = dp[n][m];
        int lengthOfSuperSequence = n + m - dp[n][m];

        int i = n;
        int j = m;

        String ans = "";
        while(i>0 && j>0) {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                ans += str1.charAt(i-1);
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) {
                ans += str1.charAt(i-1);
                i--;
            }
            else {
                ans += str2.charAt(j-1);
                j--;
            }
        }

        while(i > 0) {
            ans += str1.charAt(i-1);
            i--;
        }
        while(j > 0) {
            ans += str2.charAt(j-1);
            j--;
        }
        return ans;
    }

    public static void main(String args[]) {
        /*
        In this question we need to find a super-sequence, the way to find is to first dp array of lcs,
        once after this step we will traverse the string like printing string, if we see there is a comman or a match,
        we will add in string only once, otherwise we will add every character in string.

        in a way its like finding lcs example for abac and cab the subsequence is ab. we traverse and find cabac as the result.
         */

        String s1 = "abac";
        String s2 = "cab";

        System.out.println("The Longest Common Supersequence is "+shortestCommonSupersequence(s1,s2));
    }
}
