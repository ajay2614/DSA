package DynamicProgramming;

public class MinimumCoins {
    static int minimumElements(int[] arr, int T){

        int n= arr.length;

        int dp[][]=new int[n][T+1];

        for(int i=0; i<=T; i++){
            if(i%arr[0] == 0)
                dp[0][i] = i/arr[0];
            else dp[0][i] = (int)Math.pow(10,9);
        }

        for(int ind = 1; ind<n; ind++){
            for(int target = 0; target<=T; target++){

                int notTake = 0 + dp[ind-1][target];
                int take = (int)Math.pow(10,9);
                if(arr[ind]<=target) {
                    //As we can take a coin again, it stays to the same index
                    take = 1 + dp[ind][target - arr[ind]];
                }

                dp[ind][target] = Math.min(notTake, take);
            }
        }

        int ans = dp[n-1][T];
        if(ans >=(int)Math.pow(10,9)) return -1;
        return ans;
    }

    public int coinChangeSpaceOptimized(int[] coins, int target) {

        int n = coins.length;
        int dp[] = new int[target + 1];
        int temp[] = new int[target + 1];
        for(int i=0;i<=target;i++) {
            if(i % coins[0] == 0)
                dp[i] = i/coins[0];
            else
                dp[i] = (int)Math.pow(10,9);
        }

        for(int i=1;i<n;i++) {

            for(int j=0;j<=target;j++) {
                int notP = dp[j];
                int p = (int)Math.pow(10,9);

                if(coins[i] <= j)
                    p = temp[j - coins[i]] + 1;

                temp[j] = Math.min(notP, p);
            }
            dp = temp;
        }
        if(dp[target] >= (int)Math.pow(10,9))
            return -1;
        return dp[target];

    }

    public static void main(String args[]) {

        int arr[] ={1,2,5};
        int T=11;

        System.out.println("The minimum number of coins required to form the target sum is "+minimumElements(arr,T));
    }
}
