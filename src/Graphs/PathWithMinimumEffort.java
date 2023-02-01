package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    public static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int dis[][] = new int[n][m];

        for(int[] arr : dis) {
            Arrays.fill(arr, (int) 1e9);
        }

        dis[0][0] = 0;

        int di[] = {1,0,-1,0};
        int dj[] = {0,-1,0,1};

        PriorityQueue<PairDijkstra2d> pq = new PriorityQueue<>((a,b) -> {
            if(a.d > b.d)
                return 1;
            if(a.d < b.d)
                return -1;
            return 0;
        });

        pq.offer(new PairDijkstra2d(0,0,0));

        while (!pq.isEmpty()) {
            PairDijkstra2d pair = pq.poll();
            int row = pair.r;
            int col = pair.c;
            int dist = pair.d;

            if(row == n-1 && col == m-1) {
                return dist;
            }

            for (int i=0;i<4;i++) {
                int nRow = di[i] + row;
                int nCol = dj[i] + col;

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m) {
                    int diff = Math.max(Math.abs(heights[nRow][nCol] - heights[row][col]), dist);

                    if(diff < dis[nRow][nCol]) {
                        dis[nRow][nCol] = diff;
                        pq.offer(new PairDijkstra2d(nRow, nCol, diff));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,10,6,7,9,10,4,9}};
        minimumEffortPath(arr);

        /**
         *
         * IN THIS QUESTION WE HAVE TO CALCULATE THE MIN EFFORT IN A PATH REACHING FROM SOURCE TO DESTINATION
         * NOW THE COMPLEX PART IN THIS QUESTION IS IF WE ARE MOVING FROM SAY PATH 1 TO PATH 2, WE WILL HAVE TO TAKE THE MAX OF
         * THESE TWO PATH EG, SAY FOR ARRAY
         * 1 2 2
         * 3 8 2
         * 5 3 5, WHEN 0,1 PATH 1 DIFF BETWEEN CELL WILL BE 1, NOW DIFFERENCE BETWEEN 0,2 AND 0,1 IS 0 BUT DIST FOR 0,1 IS GREATER HENCE WE
         * WILL TAKE 1
         *
         * BUT ANOTHER COMPLEX PART IS AFTER TAKING THIS DIFFERENCE WE WILL CHECK WHETHER THE DIST[0][2] IS GREATER THAN DIST TAKEN ABOVE
         * IF IT IS ONLY THEN WE WILL UPDATE IT.
         *
         * HENCE, IN THIS WAY WE ARE CONSIDERING THE MAX ABS DIFF OF EVERY CELL FOR AN INDEX AND AT THE SAME TIME WE ARE STORING
         * THE SMALLEST OF THAT MAX IN THAT INDEX
         *
         * SO USE PRIORITY QUEUE WITH MIN HEAP, WHY MIN HEAP
         * AS THERE WILL BE SITUATIONS WHERE SAY FOR 1,1 8-3 5 WILL ALSO BE IN Q AND 8-2 WILL ALSO, SINCE WE HAVE TO TAKE MIN MAX ABS FOR EVERY
         * INDEX THERE WILL BE OF NO USE TO TAKE 6 HENCE USING PQ, THAT OVERUSE CAN EASILY BE AVOIDED, ALSO BY THIS WHEN WE WILL
         * ACTUALLY POP THE LAST ELEMENT WE WILL BE SURE THAT IT IS HAVING THE MIN MAX ABS, SO WE CAN SIMPLY RETURN IT.
         *
         */
    }

}
