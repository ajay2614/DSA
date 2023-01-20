package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    private void dfs(int[][] grid, int[][] vis, int row, int col, ArrayList<P> arrayList) {
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        arrayList.add(new P(row,col));
        int di[] = {1,0,-1,0};
        int dj[] = {0,1,0,-1};
        for(int i=0;i<4;i++) {
            int nRow = row + di[i];
            int nCol = col + dj[i];

            if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                dfs(grid, vis, nRow, nCol, arrayList);
            }
        }
    }
    private ArrayList<String> getStringList(ArrayList<P> arr) {
        int r = arr.get(0).row;
        int c = arr.get(0).col;
        ArrayList<String> ans = new ArrayList<>();
        for(int i=0;i<arr.size();i++) {
            int row = arr.get(i).row;
            int col = arr.get(i).col;

            row -= r;
            col -= c;

            String s = row + "." + col;
            ans.add(s);
        }
        return ans;
    }
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        HashSet<ArrayList<String>> hashSet = new HashSet<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0) {
                    ArrayList<P> arrayList = new ArrayList<>();
                    dfs(grid, vis, i, j, arrayList);
                    ArrayList<String> stringArrayList = getStringList(arrayList);
                    hashSet.add(stringArrayList);
                }
            }
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        int grid[][] = {{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}};
        NumberOfDistinctIslands numberOfDistinctIslands = new NumberOfDistinctIslands();
        numberOfDistinctIslands.countDistinctIslands(grid);
    }
}
