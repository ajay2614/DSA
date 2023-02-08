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

        /**
         * IN THIS QUESTION WE HAVE TO FIND THE CITY WITH THE LEAST NEIGHBOURING CITIES BETWEEN THRESHOLD DISTANCE
         *
         * THE QUESTION MEANS THAT SUPPOSE DISTANCE IS 4, THEN SAY THE CITY 0 REACHES 1 IN 2 AND REACHES 2 VIA 1 IN 4
         * SO CITY 0 HAS 2 CITIES AMONG THRESHOLD DISTANCE, WE HAVE TO FIND THE CITY WITH MIN NEIGHBOURING CITIES
         * AND IF THERE IS MORE THAN 1 CITY SIMPLY RETURN THE LATEST ONE.
         *
         * WE WILL USE THE FLOYD WARSHALL ALGO TO GET THE DISTANCE BETWEEN THE CITIES, SINCE THIS IS AN UNDIRECTED
         * GRAPH AS GIVEN I HAVE CREATED AN ADJACENCY ARRAY FOR THE SAME
         *
         * AFTER COMPUTING MIN DISTANCE FOR ALL THE NODES WE WILL USE THE FOR LOOP TO COMPUTE FOR
         * EVERY CITY WHICH WILL HAVE ANOTHER FOR LOOP TO COUNT THE NEIGHBOURING CITIES AMONG THE THRESHOLD DISTANCE,
         * I HAVE USED A COUNT VARIABLE TO KEEP TRACK OF MIN AND IF THE COUNT OF CITIES COMES EQUAL TO MIN MEANS
         * THIS IS A CITY THAT UP UNTIL THIS FAR HAS THE LEAST NEIGHBOURING CITIES AMONG THRESHOLD DISTANCE SO SIMPLY UPDATE
         * AS ACC TO QUESION WE HAVE TO RETURN THE LATEST
         *
         */
    }
}
