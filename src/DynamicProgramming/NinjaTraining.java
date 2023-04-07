package DynamicProgramming;
import java.util.Arrays;
public class NinjaTraining {
    static int ninjaTraining(int n, int[][] points) {


        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0;
                for (int task = 0; task <= 2; task++) {
                    if (task != last) {
                        int activity = points[day][task] + dp[day - 1][task];
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }

        }

        return dp[n - 1][3];
    }
    public static int ninjaTrainingOptimized(int n, int points[][]) {

        // Write your code here..
        int prev[] = new int[4];
        prev[0] = Math.max(points[0][1], points[0][2]);
        prev[1] = Math.max(points[0][0], points[0][2]);
        prev[2] = Math.max(points[0][0], points[0][1]);
        prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1 ; day < n ; day++){
            int temp[] = new int[4];
            for(int last = 0 ; last < 4 ; last++){
                temp[last] = 0;
                for(int task = 0 ; task < 3; task++) {
                    if(task != last) {
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
    public static int recursion(int i, int last, int points[][], int n, int[][] dp) {
        if(i == 0) {
            int max = 0;
            for(int j=0;j<3;j++) {
                if(j != last) {
                    max = Math.max(points[0][j], max);
                }
            }
            return max;
        }
        if(dp[i][last] != -1)
            return dp[i][last];
        int max = 0;
        for(int j=0;j<3;j++) {
            if(j != last) {
                max = Math.max(max, points[i][j] + recursion(i-1, j, points, n, dp));
            }
        }
        dp[i][last] = max;
        return dp[i][last];
    }
    public static int ninjaTrainingMemo(int n, int points[][]) {
        int dp[][] = new int[n][4];
        for(int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        return recursion(n-1, 3, points, n, dp);

    }


    public static void main(String args[]) {

        int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};

        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
}
