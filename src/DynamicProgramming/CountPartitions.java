package DynamicProgramming;

public class CountPartitions {
    public static int countPartitions(int n, int d, int[] arr) {

        int total = 0;
        for(int i=0;i<n;i++) {
            total += arr[i];
        }
        if(total - d < 0 || (total - d) % 2 == 1)
            return 0;
        int target = (total - d) / 2;

        int dp[][] = new int[n][target + 1];
        if(arr[0] == 0)
            dp[0][0] = 2;
        else
            dp[0][0] = 1;

        if(arr[0] != 0 && arr[0] <= target)
            dp[0][arr[0]] = 1;

        for(int i = 1; i < n; i++) {
            for(int j=0; j<= target; j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if(j - arr[i] >= 0)
                    pick = dp[i-1][j - arr[i]];

                dp[i][j] = (pick + notPick) % 1000000007;
            }
        }
        return dp[n-1][target];
    }
    public static int countPartitionsSpaceOptimized(int n, int d, int[] arr) {

        int total = 0;
        for(int i=0;i<n;i++) {
            total += arr[i];
        }
        if(total - d < 0 || (total - d) % 2 == 1)
            return 0;
        int target = (total - d) / 2;

        int prev[] = new int[target + 1];
        if(arr[0] == 0)
            prev[0] = 2;
        else
            prev[0] = 1;

        if(arr[0] != 0 && arr[0] <= target)
            prev[arr[0]] = 1;

        for(int i = 1; i < n; i++) {
            int temp[] = new int[target + 1];
            for(int j=0; j<= target; j++) {
                int notPick = prev[j];
                int pick = 0;
                if(j - arr[i] >= 0)
                    pick = prev[j - arr[i]];

                temp[j] = (pick + notPick) % 1000000007;
            }
            prev = temp;
        }
        return prev[target];
    }
    public static void main(String args[]) {

        /*
        Breakdown if this question, we are given subset difference d
        we need to find all subsets where s1 - s2 is d
        s1 - s2 = d;
        total - s2 - s2 = d;
        total - d/2 = s2;
        target = total -d / 2;

        hence we need to find subsets with target;
         */

        int arr[] = {6, 7, 0, 7, 3, 6};
        int n = arr.length;
        int d=13;

        System.out.println("The number of subsets found are " +countPartitions(n,d,arr));
    }
}
