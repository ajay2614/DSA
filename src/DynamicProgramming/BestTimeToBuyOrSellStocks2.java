package DynamicProgramming;

public class BestTimeToBuyOrSellStocks2 {
    public static int maxProfit(int[] prices) {

        int n = prices.length;

        int dp[][] = new int[n + 1][2];

        /*
        BASE CASE
        EITHER IF WE HAD TO BUY OR SELL, ON THIS DAY WE SET PROFIT AS 0
         */
        dp[n][0] = 0;
        dp[n][1] = 0;

        for(int i=n-1;i>=0;i--) {
            for(int buy = 0; buy<=1; buy++) {
                if(buy == 0) {
                    /*
                    SITUATION WHERE WE NEED TO BUY, WE CAN EITHER BUY AND SUBTRACT PRICE FROM PROFIT OR WE CAN BYPASS THIS DAY
                     */
                    dp[i][buy] = Math.max(dp[i + 1][0], dp[i + 1][1] - prices[i]);
                }
                else {
                    /*
                    SITUATION WHERE WE NEED TO SELL, WE CAN EITHER SELL AND ADD PRICE FOR PROFIT OR WE CAN BYPASS THIS DAY
                     */
                    dp[i][buy] = Math.max(dp[i + 1][1], dp[i + 1][0] + prices[i]);
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String args[]) {

        /*
        Questions states that we can take more than one element for buying and selling in our total profit, but it has to
        be in sequence, means 1st buy and then sell, can't buy continuously or sell.

        we can solve this via recursion

        now via recursion two stage can come up, either when we have to buy,
        during buy the 2 outcomes are, we either buy the element or not buy it
        hence representation would be max of these 2

                F(IND+1, 1) - ARR[IND] -- BOUGHT

                OR

                F(IND+1,0) -- NOT BOUGHT

        or come up situation when we have to sell, then it would be max of these 2

                F(IND+1,0) + ARR[IND] -- SOLD

                OR

                F(IND+1,1) -- NOT SOLD


         base case would when ind == n, that means if it was till day 7th and we reached 8th day then we return 0
         no profit or loss for this day.

         */
        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maxProfit(Arr));
    }
}
