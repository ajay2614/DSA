package DynamicProgramming;

public class LongestPalindromeSubstring {
    public String longestPalindromeBrute(String s) {
        int n = s.length();

        String ans = "";

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(check(i, j, s)) {
                    if(s.substring(i, j+1).length() > ans.length())
                        ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }

    public boolean check(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
    public static String longestPalindrome(String s) {

        int n = s.length();
        int dp[][] = new int[n][n];

        int end = 0;
        int start = 0;
        for(int i=0;i<n;i++) {
            dp[i][i] = 1;
        }

        for(int i=0;i<n-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                start = i;
                end=i+1;
            }
        }

        int k = 2;
        int row = 0;
        while (k < n) {
            int col = row + k;

            while (col < n) {
                if(s.charAt(row) == s.charAt(col) && dp[row+1][col-1] == 1) {
                    dp[row][col] = 1;
                    start = row;
                    end = col;
                }
                row++;
                col++;
            }
            row = 0;
            k++;
        }
        return s.substring(start, end+1);
    }
    public static void main(String[] args) {
        String s = "aaaaa";
        longestPalindrome(s);
    }
}
