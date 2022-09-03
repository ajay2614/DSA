package DynamicProgramming;

public class BestTimeToBuyOrSellStocksWithCooldown {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+2][2];

        for(int i = n-1;i>=0;i--) {
            for(int buy = 0; buy<=1;buy++) {
                if(buy == 0)
                    dp[i][buy] = Math.max(dp[i+1][0], dp[i+1][1] - prices[i]);
                else
                    dp[i][buy] = Math.max(dp[i+1][1], dp[i+2][0] + prices[i]);
            }
        }
        return dp[0][0];
    }

    public static void main(String args[]) {

        /*
        QUESTION IS SAME AS BEST TIME TO BUY OR SELL STOCK WITH UNLIMITED TRANSACTIONS, ONLY DIFF IS WE CAN NOT BUY THE NEXT
        IMMEDIATE STOCK JUST AFTER SELLING.

        ONLY CHANGE WE DO IS WHEN WE SELL WE HAVE IND + 2 RATHER THAN IND + 1;
         */
        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maxProfit(Arr));
    }
}
