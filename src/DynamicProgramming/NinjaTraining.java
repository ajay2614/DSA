package DynamicProgramming;

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


    public static void main(String args[]) {

        int[][] points = {{10,40,70},
                {20,50,80},
                {30,60,90}};

        int n = points.length;
        System.out.println(ninjaTraining(n, points));
    }
}
