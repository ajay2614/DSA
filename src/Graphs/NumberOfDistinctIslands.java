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

        /**
         * IN THIS QUESTION, WE ARE GIVEN A 2D ARRAY OF 0s AND 1s, NOW WE HAVE TO COUNT TOTAL NUMBER OF DISTINCT COMPONENTS
         * OF 1, MEANING SUPPOSE A COMPONENT HAVING 1 AT 0TH ROW 0TH COL, 1ST ROW 0TH COL, 0TH ROW 1ST COL AND
         * LIKE 1 1, AND AN ANOTHER IS ON 3RD ROW 3RD COL, 3RD ROW 4TH COL, AND 4TH ROW 3RD COL, WHICH IS IDENTICAL TO THE
         *      1
         *  PREVIOUS, SO WE CAN SAY THEY ARE IDENTICAL AND NOT DISTICT SO BOTH OF THESE WILL BE COUNTED AS 1,
         *
         *  SIMPLY USE A BFS OR DFS TO TRAVERSE WHEN YOU ENCOUNTER 1 AND MARK 1S AS VISITED AND ALSO STORE THEM IN AN ARRAY
         *  LIST IN THE FORM OF PAIR, NOW AFTER THAT CONVERT THIS LIST CORDINATES INTO A STRING, FIRST GET THE INITIAL ROW AND COL,
         *  AND NOW SUBTRACT EVERY ROW WITH THAT INTIAL ROW AND SAME FOR COLUMN, WITH THIS SAY ROW WAS 3 AND COL WAS 3
         *  SO FOR ROW 3-3 = 0, AND COL IS ALSO SAME WHICH IS 0, SIMILARLY FOR 3RD ROW 4TH COL 3-3 = 0 AND 4-3 = 1, WHICH IS
         *  0 1, WHICH SHOWS THE SAME AS OF THE 1ST COMPONENT, THIS WAY WE CAN GET THESE CORDINATES IN THE FORM OF STRING AND STORE
         *  IT IN HASHSET, AFTER THAT SIMPLY COUNT THE SIZE OF HASHSET AND RETURN AS ANS.
         */
    }
}
