package DynamicProgramming;
import java.util.Arrays;

public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int ar[] : dp) {
            Arrays.fill(ar, -1);
        }
        return recursion(amount, coins, n-1, dp);
    }

    public int recursion(int amount, int[] coins, int ind, int dp[][]) {
        if(ind == -1) {
            if(amount == 0)
                return 1;
            return 0;
        }
        if(dp[ind][amount] != -1)
            return dp[ind][amount];
        int notPick = recursion(amount, coins, ind-1, dp);
        int pick = 0;
        if(coins[ind] <= amount)
            pick = recursion(amount - coins[ind], coins, ind, dp);

        dp[ind][amount] = pick + notPick;
        return dp[ind][amount];
    }


    public int changeTabulation(int amount, int[] coins) {
        int n = coins.length;

        int dp[][] = new int[n][amount+1];

        for(int i=0;i<n;i++) {
            dp[i][0] = 1;
        }
        /**
         * This simply means if ind is 0 then we can either take coins[0] or not take
         * now suppose the i is 12 and coin is 3, then means we can take the coin to make the i
         * as 12 % 3 = 4, as we pick 3 4 times then we make this amount, hence it would categorise as 1 way other wise
         * it is similar to other subsequence questions
         */
        for(int i=1;i<=amount;i++) {
            if(i % coins[0] == 0) {
                dp[0][i] = 1;
            }
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<=amount;j++) {
                int notPick = dp[i-1][j];

                int pick = 0;

                if(coins[i] <= j) {
                    pick = dp[i][j-coins[i]];
                }

                dp[i][j] = pick + notPick;
            }
        }
        return dp[n-1][amount];
    }
}
