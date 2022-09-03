package DynamicProgramming;

/*
BestTimeToBuyOrSellStocks4 is same, only diff is that transactions in this is given as 2 where as in that it is given K.
 */
public class BestTimeToBuyOrSellStocks3 {
    public static int maxProfit(int[] prices) {

        int n = prices.length;

        int dp[][][] = new int[n+1][2][3];


        for(int i=n-1;i>=0;i--) {
            for(int buy=0;buy<=1;buy++) {
                /*
                    Why cap starts from 1 and not 0? because as base case in recursion
                    if cap == 0 return 0, and 0 is already defined in arr when we declared it.
                 */
                for(int cap=1;cap<=2;cap++) {
                    if(buy == 0) {
                        dp[i][buy][cap] = Math.max(dp[i + 1][0][cap],
                                dp[i + 1][1][cap] - prices[i]);
                    }
                    else {
                        /*
                        Why cap is decreasing when we sell, because it indicates we exhausted 1 transaction on selling
                         */
                        dp[i][buy][cap] = Math.max(dp[i + 1][1][cap],
                                dp[i + 1][0][cap - 1] + prices[i]);
                    }
                }
            }
        }
        /*
        Why is index 1 = 0? because that's where our final value is
        Why is buy index = 0? because when we sold last element last value is 0 because if we buy and unable to sell it won't
        count in profit
        Why is transaction index 2? because it indicates the total transaction we can have.
         */
        return dp[0][0][2];
    }

    public int maxProfitSpaceOptimized(int[] prices) {

        int n = prices.length;

        int prev[][] = new int[2][3];


        for(int i=n-1;i>=0;i--) {
            int cur[][] = new int[2][3];
            for(int buy=0;buy<=1;buy++) {
                for(int cap=1;cap<=2;cap++) {
                    if(buy == 0)
                        cur[buy][cap] = Math.max(prev[0][cap],
                                prev[1][cap] - prices[i]);
                    else
                        cur[buy][cap] = Math.max(prev[1][cap],
                                prev[0][cap-1] + prices[i]);
                }
            }
            prev = cur;
        }
        return prev[0][2];
    }

    public static void main(String args[]) {

        /*
        Questions states that we can only have two transactions.

        we can solve this via recursion

        now via recursion two stage can come up, either when we have to buy,
        during buy the 2 outcomes are, we either buy the element or not buy it
        hence representation would be max of these 2

                F(IND+1, 1, Cap) - ARR[IND] -- BOUGHT (Cap states total transactions would start from 2)

                OR

                F(IND+1,0, Cap) -- NOT BOUGHT

        or come up situation when we have to sell, then it would be max of these 2

                F(IND+1,0, Cap-1) + ARR[IND] -- SOLD (As we sell means we completed 1 transaction)

                OR

                F(IND+1,1) -- NOT SOLD


         base case would when ind == n, that means if it was till day 7th and we reached 8th day then we return 0
         no profit or loss for this day.

         also would be when cap == 0, that means it reached the limit of transaction.

         */
        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maxProfit(Arr));
    }
}
