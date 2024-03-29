package DynamicProgramming;
import java.util.Arrays;
public class SubsetSumEqualK {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        boolean dp[][] = new boolean[n][k+1];

        for(int i=0;i<n;i++) {
            dp[i][0] = true;
        }


        if(arr[0]<=k)
            dp[0][arr[0]] = true;

        for(int i=1;i<n;i++) {
            for(int j=1;j<=k;j++) {

                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(arr[i] <= j) {
                    int val = j - arr[i];
                    take = dp[i - 1][j - arr[i]];
                }

                dp[i][j] = take || notTake;
            }
        }
        return dp[n-1][k];
    }

    public static boolean subsetSumToKspaceOptimized(int n, int k, int arr[]){
        // Write your code here.
        boolean prev[] = new boolean[k+1];

        prev[0] = true;

        if(arr[0]<=k)
            prev[arr[0]] = true;

        for(int i=1;i<n;i++) {

            boolean cur[] = new boolean[k+1];
            cur[0] = true;

            for(int j=1;j<=k;j++) {

                boolean notTake = prev[j];
                boolean take = false;
                if(arr[i] <= j)
                    take = prev[j - arr[i]];

                cur[j] = take || notTake;
            }
            prev = cur;
        }
        return prev[k];
    }

    public static boolean subsetSumToKRecursion(int n, int k, int arr[]){
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += arr[i];
        }

        if(sum < k)
            return false;
        int dp[][] = new int[n][sum+1];

        for(int[] a : dp) {
            Arrays.fill(a,-1);
        }
        return recursion(n, n-1, k, arr, 0, dp);
    }

    public static boolean recursion(int n, int ind, int target, int arr[], int sum, int[][] dp) {
        boolean res = false;
        if(ind == 0) {
            res = arr[ind] + sum == target || sum == target;
            if(res)
                dp[ind][sum] = 1;
            else
                dp[ind][sum] = 0;
            return res;
        }

        if(dp[ind][sum] != -1) {
            return dp[ind][sum] == 1;
        }
        boolean pick = recursion(n, ind-1, target, arr, sum + arr[ind], dp);
        boolean notPick = recursion(n, ind-1, target, arr, sum, dp);

        res = pick || notPick;

        if(res)
            dp[ind][sum] = 1;
        else
            dp[ind][sum] = 0;

        return pick || notPick;
    }

    public static void main(String args[]) {

        /**
        https://www.youtube.com/watch?v=s6FhG--P7z0&t=17s
        understand properly from here
         */
        int arr[] = {3,2};
        int k=4;
        int n = arr.length;

        if(subsetSumToK(n,k,arr))
            System.out.println("Subset with given target found");
        else
            System.out.println("Subset with given target not found");
    }


}
