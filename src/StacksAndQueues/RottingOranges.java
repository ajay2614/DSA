package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

class  OrangePair {
    int row;
    int col;
    int time;

    OrangePair(int row, int col, int time) {
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
public class RottingOranges {
    /**
     * Time Complexity: O ( n x n ) x 4
     *
     * Reason: Worst-case – We will be making each fresh orange rotten in the grid and for each rotten orange will
     * check in 4 directions
     *
     * Space Complexity: O ( n x n )
     *
     * Reason: worst-case –  If all oranges are Rotten, we will end up pushing all rotten oranges into the Queue data structure
     *
     * */
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int cntFresh = 0;
        Queue<OrangePair> queue = new LinkedList<>();
        for(int i = 0;i < n;i++) {
            for (int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    vis[i][j] = true;
                    queue.add(new OrangePair(i,j,0));
                }
                if(grid[i][j] == 1)
                    cntFresh++;
            }
        }
        int days = 0;
        int rotFresh = 0;
        int drow[] = {1,0,-1,0};
        int dcol[] = {0,1,0,-1};

        while (!queue.isEmpty()) {
            OrangePair orangePair = queue.poll();
            int row = orangePair.row;
            int col = orangePair.col;
            int time = orangePair.time;
            days = Math.max(time, days);
            for (int i=0;i<4;i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if (nrow >= 0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                    rotFresh++;
                    vis[nrow][ncol] = true;
                    queue.add(new OrangePair(nrow, ncol, time+1));
                }
            }
        }

        if(cntFresh == rotFresh)
            return days;
        return -1;
    }

    public static void main(String[] args) {
        /**
         * IN THE FOLLOWING QUESTION IT IS GIVEN TO US A 2D ARRAY OF 0,1,2. 2S REPRESENT ROTTEN ORANGES, 1S REPRESENT FRESH
         * ORANGES, 0 REPRESENTS EMPTY. EACH ROTTEN ORANGE CAN ROT THE FRESH ONE IN ITS SURROUNDING(HAVING NEIGHBOURING ROW OR COL
         * , MEANING UP DOWN RIGHT AND LEFT)IN 1 DAY,
         *
         * WE NEED TO FIND THE TOTAL DAYS ROTTEN ORANGES CAN ROT FRESH, IF INDEED THEY CAN.
         *
         * APPROACH
         *
         * WE WILL USE THE BFS APPROACH FOR THIS QUESTION, AS IMPLEMENTING DFS WOULD NOT PROVIDE ANY SOLUTION ONLY BFS CAN BE USED
         * HERE.
         *
         * WE WILL MAKE A CLASS PAIR, HAVING ROW,COL AND DAYS.
         * WE WOULD ALSO NEED A VISITED ARRAY TO MARK OUR VISITS.
         *
         * INITIALLY WE NEED TO ITERATE I*J TO GET THE ALREADY ROTTEN ORANGES, ALONG WITH MARKING THEIR VISITS AND STORING THEM
         * AS A PAIR IN QUEUE.
         *
         * AFTER THIS, WHAT WE NEED TO IS NOW KEEP ON POPPING VALUES AND ADDING NEW VALUES TO THE QUEUE, TILL QUEUE IS EMPTY
         * MEANING ALL WHAT WE COULD HAVE VISIT HAVE BEEN VISITED.
         *
         * GET THE PAIR FROM QUEUE, HAVE ITS ROWS AND COLUMNS AND SEARCH FOR ITS NEIGHBOURING ROW AND COLUMN, MEANING IN ITS
         * UP DOWN RIGHT LEFT, WE WOULD BE USING TWO ARRAYS DI AND DJ TO REPRESENT INDEXES OF ROW AND COLUMN(SIMILAR TO HOW WE DID
         * IN RAT IN A MAZE), RUN LOOP FROM O TO 4, HAVE TEMPROW(NROW) AND TEMPCOL(NCOL) WHICH WOULD REPRESENT ITS DIRECTION
         * WHETHER ITS U R D OR L, WHY WE NOT ADDING IN ROW AND USING TEMPROW, WE CANT CHANGE ROW AND COLUMN VAL SINCE LOOP IS
         * RUNNING FROM O TO 4 AND CHANGING WOULD MEAN CHECKING FOR NEXT ROW AND COL WOULD BECOME WRONG, NOW CHECK
         * WHETHER NROW AND NCOL LIES BETWEEN N AND M AND WHETHER IT IS REPRESENTING FRESH ORANGE AND ITS NOT VISITED, IF ALL
         * SATISFIES ADD THIS IN QUEUE. KEEP ON DOING THIS TILL QUEUE IS EMPTY
         *
         * WHY ARE WE USING TWO DIFF COUNT FRESH VARIABLES, BECAUSE IT COULD HAPPEN THAT WE ARE UNABLE TO ROT EVERY FRESH ORANGE
         * IN THIS CASE WE NEED TO RETURN -1, HENCE IN FIRST I*J LOOP WE ARE COUNTING ALL THE GRID[I][J] HAVING 1 MEANING FRESH
         * AND WE ARE INCREMENTING TEMPCOUNT EVERYTIME WE ARE ADDING A ORANGE IN QUEUE,
         *
         * FOR DAYS CHECKING WE ARE KEEPING TRACK OF IT BY HAVING MAX OF TIME OF ALL TIME, WE CAN ALSO HAVE DAYS JUST AS TIME
         * BECAUSE IT IS EXPECTED THAT ORANGES TAKING THE MAX DAYS TO GET ROT WILL BE PLACED LASTLY IN QUEUE, IT PASSES
         * TEST CASES TOO.
         */
    }
}
