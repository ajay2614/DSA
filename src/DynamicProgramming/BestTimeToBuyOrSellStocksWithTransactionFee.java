package DynamicProgramming;

public class BestTimeToBuyOrSellStocksWithTransactionFee {
    public static int maxProfit(int[] prices, int fee) {

        int n = prices.length;
        int dp[][] = new int[n+1][2];

        for(int i=n-1;i>=0;i--) {
            for(int buy = 0; buy <= 1; buy ++ ){
                if(buy == 0)
                    dp[i][buy] = Math.max(dp[i+1][0], dp[i+1][1] - prices[i]);
                else
                    dp[i][buy] = Math.max(dp[i+1][1], dp[i+1][0] + prices[i] - fee);
            }
        }
        return dp[0][0];
    }

    public static int maxProfitSpaceOptimized(int[] prices, int fee) {

        int n = prices.length;
        int prev[] = new int[2];
        int cur[] = new int[2];
        for(int i=n-1;i>=0;i--) {
            for(int buy = 0; buy <= 1; buy ++ ){
                if(buy == 0)
                    cur[buy] = Math.max(prev[0], prev[1] - prices[i]);
                else
                    cur[buy] = Math.max(prev[1], prev[0] + prices[i] - fee);
            }
            prev = (int[]) cur.clone();
        }
        return prev[0];
    }

    public static void main(String args[]) {

        /*
        QUESTION IS SAME AS BEST TIME TO BUY OR SELL STOCK WITH UNLIMITED TRANSACTIONS, ONLY DIFF IS AFTER SELLING WE HAVE TO
        SUBTRACT TRANSACTION FEE

        ONLY CHANGE WE DO IS WHEN WE SELL WE SUBTRACT IND FEE HENCE METHOD BECOMES (
        RETURN MATH.MAX( F(IND + 1, 1) , F(IND + 1, 0 ) + PRICES[IND] - FEE)
         */
        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maxProfit(Arr, 2));
    }
}
