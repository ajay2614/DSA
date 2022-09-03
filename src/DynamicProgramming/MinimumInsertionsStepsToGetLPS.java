package DynamicProgramming;

public class MinimumInsertionsStepsToGetLPS {
    public static int minInsertions(String s) {

        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int dp[][] = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return (n - dp[n][n]);
    }

    public static int minInsertionsSpaceOptimized(String s) {

        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();

        int prev[] = new int[n+1];
        int cur[] = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++) {
                if(s.charAt(i-1) == s2.charAt(j-1)){
                    cur[j] = 1 + prev[j-1];
                }
                else
                    cur[j] = Math.max(prev[j],cur[j-1]);
            }
            prev = (int[]) cur.clone();
        }
        return (n - prev[n]);
    }
    public static void main(String args[]) {

        /*
        THE LOGIC IS VERY INTERESTING, WE KNOW WITH THE HELP OF LPS WE GET THE LENGTH OF LONGEST PALINDROME SUBSEQUENCE,
        NOW THE LOGIC IS THE IF WE SUBTRACT THE LPS WITH THE STRING LENGTH WE GET THE MIN NUMBER OF INSERTION STEPS REQUIRED,

        EXAMPLE
        ABCAA IS A STRING, AAA IS PALINDROME NOW WE NEED TO ADD B AND C IN SUCH A WAY IT BECOMES A PALINDROME, WE CAN DO THIS
        BY ADDING C AND MAKING STRING AS ABCACA AND THE B TO MAKE IT ABCACBA, WHICH IS 2 STEPS WHICH IS JUST LENGTH - LPS.
         */

        String s= "abcaa";
        System.out.println("The Minimum insertions required to make string palindrome: "+
                minInsertions(s));
    }
}
