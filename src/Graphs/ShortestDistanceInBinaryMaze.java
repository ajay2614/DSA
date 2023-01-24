package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
class PairDijkstra2d{
    int r;
    int c;
    int d;

    PairDijkstra2d(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
public class ShortestDistanceInBinaryMaze {
    int min = Integer.MAX_VALUE;
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};

        int vis[][] = new int[n][m];
        recursion(grid, vis, source[0], source[1], destination, di, dj, 0);
        if(min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    /**
     * WILL GIVE TLE
     */
    void recursion(int[][] grid, int vis[][], int r, int c, int[] des, int[] di, int[] dj, int steps) {
        if(r == des[0] && c == des[1]) {
            min = Math.min(min, steps);
            return;
        }
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++) {
            int nRow = r + di[i];
            int nCol = c + dj[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                vis[nRow][nCol] = 1;
                recursion(grid, vis, nRow, nCol, des, di, dj, steps+1);
                vis[nRow][nCol] = 0;
            }
        }
    }

    int shortestPathOptimal(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1])
            return 0;

        int n = grid.length;
        int m = grid[0].length;
        Queue<PairDijkstra2d> queue = new LinkedList<>();
        int djk[][] = new int[n][m];

        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                djk[i][j] = (int) 1e9;
            }
        }

        djk[source[0]][source[1]] = 0;
        queue.offer(new PairDijkstra2d(source[0],source[1],0));

        int[] di = {1,0,-1,0};
        int[] dj = {0,1,0,-1};

        while (!queue.isEmpty()) {
            PairDijkstra2d pair = queue.poll();

            for(int i=0;i<4;i++) {
                int nRow = di[i] + pair.r;
                int nCol = dj[i] + pair.c;

                if(nRow >=0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 & pair.d + 1 < djk[nRow][nCol]) {
                    djk[nRow][nCol] = 1 + pair.d;
                    /**
                     * WHY RETURNING HERE?
                     * AS WEIGHT IS INCREASING BY UNIT AND IS CONSTANT, SO THEREFORE WE ARE SURE THAT IF WE REACH THE
                     * DESTINATION IT IS SURELY GOING TO BE THE MIN DISTANCE.
                     * EVEN THE EVERY DJK ELEMENT WILL BE ONLY UPDATED BY ONE TIME AS THE NEXT TIME IT WILL BE ALWAYS TAKING
                     * MORE DISTANCE. WE CAN EVEN CONFIRM THIS BY REPLACING pair.d + 1 < djk[nRow][nCol] BY
                     * djk[nRow][nCol] == (int) 1e9
                     */
                    if(nRow == destination[0] && nCol == destination[1])
                        return djk[nRow][nCol];
                    queue.offer(new PairDijkstra2d(nRow, nCol, pair.d + 1));
                }
            }
        }
       return -1;
    }


    public static void main(String[] args) {
        int grid[][] = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 0, 1}};
        int[] source = {0, 0};
        int[] destination = {3, 4};

        /**
         * WHY WE ARE TAKING QUEUE AND NOT PQ?
         * BECAUSE IN THIS QUESTION WEIGHT IS INCREASING BY ONE UNIT WEIGHT AND THUS IS CONSTANT, FIRST 0 WILL HAVE ALL THE NEIGHBOURING DIST
         * WITH 1 IN Q AND THEN SO ON
         */
    }
}
