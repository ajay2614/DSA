package DynamicProgramming;

public class BestTimeToBuyOrSellStocks {
    public static int maxProfit(int[] prices) {

        int n = prices.length;
        int min = prices[0];
        int bestProfit = 0;

        for(int i=1;i<n;i++) {
            int profit = prices[i] - min;
            bestProfit = Math.max(bestProfit, profit);
            min = Math.min(min, prices[i]);
        }

        return bestProfit;
    }

    public static void main(String args[]) {

        /*
        QUESTION STATES WE NEED TO GET THE MAX PROFIT FROM BUYING ON MINIMUM PRICE AND SELLING IT ON MAXIMUM PRICE

        TO DO THIS QUESTION WE NEED TWO VARIABLES A MAX PROFIT ONE AND OTHER TO KEEP TRACK OF MINIMUM
        INITIALLY PROFIT IS 0 AS BUYING AND SELLING ON 1ST DAY IS ALWAYS 0.
        INITIALLY MIN IS ARR[0]

        IN FOR LOOP FOR ALL ARRAY ELEMENTS WE CHECK PROFIT BY SUBTRACTING PRICE OF THAT DAY WITH OUR MIN
        WE UPDATE PROFIT IF IT'S GREATER THAN PREVIOUS
        AND WE UPDATE THE MIN BY COMPARING WITH ARR[I] IF IT'S LESSER THAN MIN

        RETURN MAXPROFIT AS ANSWER
         */
        int[] Arr  ={7,1,5,3,6,4};

        System.out.println("The maximum profit by selling the stock is "+
                maxProfit(Arr));
    }
}
