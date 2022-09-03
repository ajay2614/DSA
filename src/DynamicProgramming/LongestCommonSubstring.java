package DynamicProgramming;

public class LongestCommonSubstring {

    public static int lcs(String str1, String str2) {
        // Write your code here.
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        int max = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                }
                else
                    dp[i][j] = 0;
            }
        }
        return max;
    }

    public static int lcsSpaceOptimized(String str1, String str2) {
        // Write your code here.
        int n = str1.length();
        int m = str2.length();

        int prev[] = new int[m+1];
        int max = 0;
        for(int i=1;i<=n;i++) {
            int cur[] = new int[m+1];
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                    max = Math.max(max, cur[j]);
                }
                else
                    cur[j] = 0;
            }
            prev = cur;
        }
        return max;
    }

    public static void main(String args[]) {

        String s1= "abcjklp";
        String s2= "acjkp";

        System.out.println("The Length of Longest Common Substring is "+lcs(s1,s2));
    }
}
