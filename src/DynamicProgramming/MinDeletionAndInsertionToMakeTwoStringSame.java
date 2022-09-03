package DynamicProgramming;

public class MinDeletionAndInsertionToMakeTwoStringSame {
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        int ans = n + m - (2 * dp[n][m]);
        return ans;
    }

    public static void main(String args[]) {

        /*
        LOGIC IS THAT FOR EXAMPLE WE HAVE ABC AND ANC IF WE CAN FIND THE LCS FOR IT, WHICH WILL BE 2,
        NOW TO FIND INSERTIONS, WE NEED TO SUBTRACT STR1 SIZE WITH LCS AND TO GET DELETION WE NEED TO GET
        STR2 SIZE WITH LCS AND HENCE WE CAN GET OUR ANSWER
         */
        String str1= "abcd";
        String str2= "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                +minDistance(str1,str2));
    }
}
