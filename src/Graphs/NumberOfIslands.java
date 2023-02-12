package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class P {
    int row;
    int col;

    P(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class NumberOfIslands {
    private static void bfs(int row, int col, int[][] vis, char[][] grid, int m, int n) {
        vis[row][col] = 1;
        Queue<P> q = new LinkedList<>();

        q.offer(new P(row,col));

        while(!q.isEmpty()) {
            P pair = q.poll();
            int r = pair.row;
            int c = pair.col;

            for(int i=-1;i<=1;i++) {
                for(int j=-1;j<=1;j++) {
                    /**
                     *  Remove this line if all the 6 diagonals of land can be considered
                     */
                    if(! (i+j == 1 || i+j == -1))
                        continue;
                    int nR = r + i;
                    int nC = c + j;

                    if(nR >= 0 && nR < m && nC >= 0 && nC < n
                            && vis[nR][nC] == 0 && grid[nR][nC] == '1'
                    ) {
                        vis[nR][nC] = 1;
                        q.offer(new P(nR,nC));
                    }
                }
            }
        }
    }
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];
        int cnt = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(vis[i][j] == 0 && grid[i][j] == '1') {
                    cnt++;
                    bfs(i,j,vis,grid,m,n);
                }
            }
        }
        return cnt;
    }

    public static int numIslandsDfs(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == '1' && vis[i][j] == 0) {
                    dfs(i, j, grid, vis);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void dfs(int row, int col, char[][] grid, int vis[][]) {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = 1;
        int di[] = {1,0,-1,0};
        int dj[] = {0,-1,0,1};

        for(int i=0;i<4;i++) {
            int nR = di[i] + row;
            int nC = dj[i] + col;

            if(nR >= 0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == '1' && vis[nR][nC] == 0) {
                dfs(nR, nC, grid, vis);
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        numIslandsDfs(grid);

        /**
         * IN THIS QUESTION WE NEED TO FIND THE TOTAL ISLANDS, AN ISLAND IS SIMPLY A COMPONENT OF 1
         * WHICH COULD BE CONNECTED BY ANOTHER 1 ON ITS ADJACENT 4 SIDES, FOR EG THE ABOVE HAS 3 TOTAL COMPONENTS
         *
         * TO SOLVE THIS SIMPLY USE BFS OR DFS AND VISITED ARRAY TO MARK VISIT, SIMPLY ITERATE AND WHENEVER YOU GET 1
         * WHICH HAS NOT BEEN VISITED RUN BFS/DFS FOR IT AND SIMPLY MARK ALL THE 1S IN ITS COMPONENTS VISITED AND
         * INCREASE THE COUNT THIS WAY WHENEVER WE FIND A 1 THAT HAS NOT BEEN VISITED YET, WE CAN SIMPLY DO THE SAME PROCESS
         * FOR IT.
         */
    }
}
