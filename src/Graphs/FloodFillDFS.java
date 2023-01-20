package Graphs;

public class FloodFillDFS {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] vis = new int[n][m];
        int oldColor = image[sr][sc];
        int dRow[] = {1,0,-1,0};
        int dCol[] = {0,1,0,-1};

        dfs(image, vis, sr, sc, color, oldColor, dRow, dCol, n, m);

        return image;
    }

    public void dfs(int[][] image, int[][] vis, int sr, int sc,
                    int color, int oldColor, int[] dRow, int[] dCol, int n, int m) {
        image[sr][sc] = color;
        vis[sr][sc] = 1;
        for(int i=0;i<4;i++) {
            int nRow = sr + dRow[i];
            int nCol = sc + dCol[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && image[nRow][nCol] == oldColor && vis[nRow][nCol] != 1) {
                dfs(image, vis, nRow, nCol, color, oldColor, dRow, dCol, n, m);
            }
        }
    }
}
