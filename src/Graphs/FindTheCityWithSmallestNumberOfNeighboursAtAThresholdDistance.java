package Graphs;

import java.util.Arrays;

public class FindTheCityWithSmallestNumberOfNeighboursAtAThresholdDistance {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int dist[][] = new int[n][n];

        for(int d[] : dist) {
            Arrays.fill(d, (int) 1e9);
        }

        for(int e[] : edges) {
            int i = e[0];
            int j = e[1];
            int d = e[2];

            dist[i][j] = d;
            dist[j][i] = d;
        }

        for(int i=0;i<n;i++) {
            dist[i][i] = 0;
        }

        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int cnt = Integer.MAX_VALUE;
        int city = -1;
        for(int i=0;i<n;i++) {
            int t = 0;
            for (int j=0;j<n;j++) {
                if(dist[i][j] <= distanceThreshold)
                    t++;
            }
            cnt = Math.min(cnt, t);
            if(t == cnt)
                city = i;
        }
        return city;
    }

    public static void main(String[] args) {
        int edges[][] = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int n = 5;
        int distanceThreshold = 2;
        findTheCity(n, edges, distanceThreshold);
    }
}
