package Graphs;

public class SurroundedRegions {
    private void dfs(int row, int col, char[][] board, int[][] vis, int di[], int dj[]) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        for (int i=0;i<4;i++) {
            int nRow = row + di[i];
            int nCol = col + dj[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O') {
                dfs(nRow, nCol, board, vis, di, dj);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int vis[][] = new int[n][m];
        int di[] = {1,0,-1,0};
        int dj[] = {0,-1,0,1};

        for (int i=0;i<n;i++) {
            //FIRST COL
            if(board[i][0] == 'O' && vis[i][0] == 0)
                dfs(i, 0, board, vis, di, dj);
            //LAST COL
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0)
                dfs(i, m-1, board, vis, di, dj);
        }

        for (int j=0;j<m;j++) {
            //FIRST ROW
            if(board[0][j] == 'O' && vis[0][j] == 0)
                dfs(0,j,board,vis,di,dj);
            //LAST ROW
            if(board[n-1][j] == 'O' && vis[n-1][j] == 0)
                dfs(n-1,j,board,vis,di,dj);
        }

        for(int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char arr[][] = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        surroundedRegions.solve(arr);
    }
}
