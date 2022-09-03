package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int s = triangle.get(n-1).size();

        int dp[][] = new int[n][s];
        for(int i=0;i<s;i++) {
            dp[n-1][i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--) {
            for(int j=i;j>=0;j--) {
                int down = triangle.get(i).get(j) + dp[i+1][j];

                int diag = triangle.get(i).get(j) + dp[i+1][j+1];
                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }

    public int minimumTotalSpaceOptimized(List<List<Integer>> triangle) {
        int n = triangle.size();
        int s = triangle.get(n-1).size();

        int prev[] = new int[s];
        for(int i=0;i<s;i++) {
            prev[i] = triangle.get(n-1).get(i);
        }

        for(int i=n-2;i>=0;i--) {
            int cur[] = new int[s];
            for(int j=i;j>=0;j--) {
                int down = triangle.get(i).get(j) + prev[j];

                int diag = triangle.get(i).get(j) + prev[j+1];
                cur[j] = Math.min(down, diag);
            }
            prev = cur;
        }
        return prev[0];
    }

    public static void main(String args[]) {

        List<List<Integer>> arr = new ArrayList<>();
        for (int i=0;i<4;i++) {
            arr.add(new ArrayList<>());
        }
        arr.get(0).add(2);
        arr.get(1).add(3);
        arr.get(1).add(4);
        arr.get(2).add(6);
        arr.get(2).add(5);
        arr.get(2).add(7);
        arr.get(3).add(4);
        arr.get(3).add(1);
        arr.get(3).add(8);
        arr.get(3).add(3);

        int v = minimumTotal(arr);

        System.out.println(v);
    }
}
