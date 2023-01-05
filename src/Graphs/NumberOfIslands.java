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

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        numIslands(grid);
    }
}
