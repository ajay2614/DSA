package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class NodePair {
    int row;
    int col;
    int dist;
    NodePair( int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
public class ZeroOneMatrixOrDistanceOfNearestCellHavingZeroOne {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int dis[][] = new int[n][m];
        int vis[][] = new int[n][m];
        Queue<NodePair> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(mat[i][j] == 0) {
                    q.offer(new NodePair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int di[] = {1,0,-1,0};
        int dj[] = {0,1,0,-1};
        while (!q.isEmpty()) {
            NodePair pair = q.poll();
            int r = pair.row;
            int c = pair.col;
            int d = pair.dist;
            dis[r][c] = d;

            for(int i=0;i<4;i++) {
                int nRow = r + di[i];
                int nCol = c + dj[i];

                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0) {
                    vis[nRow][nCol] = 1;
                    q.offer(new NodePair(nRow, nCol, d + 1));
                }
            }
        }

        return dis;
    }
}
