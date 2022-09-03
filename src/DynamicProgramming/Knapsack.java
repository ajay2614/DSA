package DynamicProgramming;

/*
Very Important
 */
public class Knapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int dp[][] = new int[n][maxWeight + 1];

        for(int i=weight[0];i<=maxWeight;i++) {
            dp[0][i] = value[0];
        }

        for(int i=1;i<n;i++) {
            for(int cap = 0; cap <= maxWeight; cap++) {

                int notPick = 0 + dp[i-1][cap];
                int taken = Integer.MIN_VALUE;
                if(weight[i] <= cap)
                    taken = dp[i-1][cap - weight[i]] + value[i];

                dp[i][cap] = Math.max(notPick, taken);
            }
        }
        return dp[n-1][maxWeight];
    }

    static int knapsackSpaceOptimized(int[] weight, int[] value, int n, int maxWeight) {

        int prev[] = new int[maxWeight + 1];

        for(int i=weight[0];i<=maxWeight;i++) {
            prev[i] = value[0];
        }

        for(int i=1;i<n;i++) {
            int cur[] = new int[maxWeight + 1];
            for(int cap = 0; cap <= maxWeight; cap++) {
                int notPick = 0 + prev[cap];
                int taken = Integer.MIN_VALUE;
                if(weight[i] <= cap)
                    taken = prev[cap - weight[i]] + value[i];

                cur[cap] = Math.max(notPick, taken);
            }
            prev = cur;
        }
        return prev[maxWeight];
    }

    public static void main(String args[]) {

        int wt[] = {1,2,4,5};
        int val[] = {5,4,8,6};
        int W=5;

        int n = wt.length;

        System.out.println("The Maximum value of items, thief can steal is "
                +knapsack(wt,val,n,W));
    }
}
