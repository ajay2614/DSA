package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    private void dfs(int row, int col, int[][] grid, int[][] vis, int di[], int dj[]) {
        vis[row][col] = 1;
        int n = grid.length;
        int m = grid[0].length;

        for (int i=0;i<4;i++) {
            int nRow = row + di[i];
            int nCol = col + dj[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, grid, vis, di, dj);
            }
        }
    }
    public int numEnclavesDfs(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int di[] = {1,0,-1,0};
        int dj[] = {0,-1,0,1};

        for (int i=0;i<n;i++) {
            //FIRST COL
            if(grid[i][0] == 1 && vis[i][0] == 0)
                dfs(i, 0, grid, vis, di, dj);
            //LAST COL
            if(grid[i][m-1] == 1 && vis[i][m-1] == 0)
                dfs(i, m-1, grid, vis, di, dj);
        }

        for (int j=0;j<m;j++) {
            //FIRST ROW
            if(grid[0][j] == 1 && vis[0][j] == 0)
                dfs(0,j, grid,vis,di,dj);
            //LAST ROW
            if(grid[n-1][j] == 1 && vis[n-1][j] == 0)
                dfs(n-1,j, grid,vis,di,dj);
        }
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        Queue<NodePair> q = new LinkedList<>();
        int di[] = {1,0,-1,0};
        int dj[] = {0,-1,0,1};

        for(int i=0;i<n;i++) {
            if(grid[i][0] == 1 && vis[i][0] == 0) {
                vis[i][0] = 1;
                q.offer(new NodePair(i,0, 0));
            }
            if(grid[i][m-1] == 1 && vis[i][m-1] == 0) {
                vis[i][m-1] = 1;
                q.offer(new NodePair(i, m-1, 0));
            }
        }

        for (int j=0;j<m;j++) {
            if(grid[0][j] == 1 && vis[0][j] == 0) {
                vis[0][j] = 1;
                q.offer(new NodePair(0,j,0));
            }
            if(grid[n-1][j] == 1 && vis[n-1][j] == 0) {
                vis[n-1][j] = 1;
                q.offer(new NodePair(n-1, j, 0));
            }
        }

        while (!q.isEmpty()) {
            NodePair pair = q.poll();
            int row = pair.row;
            int col = pair.col;

            for(int i=0;i<4;i++) {
                int nRow = row + di[i];
                int nCol = col + dj[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                        && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1) {
                    q.offer(new NodePair(nRow, nCol, 0));
                    vis[nRow][nCol] = 1;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
