package DynamicProgramming;
import java.util.Arrays;
public class NumberOfSubsets {
    public static int findWays(int num[], int tar) {

        int dp[][] = new int[num.length][tar+1];
        for(int a[] : dp) {
            Arrays.fill(a, -1);
        }
        return recursion(num, tar, num.length-1, dp);
    }

    public static int recursion(int num[], int tar, int i, int dp[][]) {
        if(i == -1) {
            if(tar == 0)
                return 1;
            else
                return 0;
        }

        if(dp[i][tar] != -1)
            return dp[i][tar];
        int notPick = recursion(num, tar, i-1, dp);
        int pick = 0;

        if(num[i] <= tar)
            pick = recursion(num, tar-num[i], i-1, dp);

        dp[i][tar] = pick + notPick;

        return dp[i][tar];
    }

    //Getting error in some case
    public static int findWaysTab(int num[], int tar) {
        int n = num.length;

        int dp[][] = new int[n][tar+1];

        for(int i=0;i<n;i++) {
            dp[i][0] = 1;
        }

        if(num[0] <= tar)
            dp[0][num[0]] = 1;

        for(int i=1;i<n;i++) {
            for(int j=1;j<=tar;j++) {
                int notPick = dp[i-1][j];

                int pick = 0;

                if(num[i] <= j) {
                    pick = dp[i-1][j - num[i]];
                }

                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][tar];
    }
}
