package Graphs;

import java.util.HashSet;

public class MakingLargeIsland {
    public int largestIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        DisjointSet disjointSet = new DisjointSet(n * m);

        for(int row=0;row<n;row++) {
            for(int col=0;col<n;col++) {
                if(grid[row][col] == 0)
                    continue;

                int di[] = {1,0,-1,0};
                int dj[] = {0,1,0,-1};

                for(int i=0;i<4;i++) {
                    int nRow = di[i] + row;
                    int nCol = dj[i] + col;

                    if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                        int nodeInTermOf1dIndex = row * m + col;
                        int nthNodeInTermOf1dIndex = nRow * m + nCol;

                        //NO NEED TO CHECK FOR UPAR AS IT WILL BE CHECKED BY THE METHOD ITSELF
                        disjointSet.unionBySize(nodeInTermOf1dIndex, nthNodeInTermOf1dIndex);
                    }
                }
            }
        }

        int max = 0;
        for(int row=0;row<n;row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 1)
                    continue;

                int di[] = {1,0,-1,0};
                int dj[] = {0,1,0,-1};

                HashSet<Integer> set = new HashSet<>();
                for(int i=0;i<4;i++) {
                    int nRow = di[i] + row;
                    int nCol = dj[i] + col;

                    if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1) {
                        int nthNodeInTermOf1dIndex = nRow * m + nCol;
                        set.add(disjointSet.findUPar(nthNodeInTermOf1dIndex));
                    }
                }

                int size = 0;
                for (int i : set) {
                    size += disjointSet.size.get(i);
                }
                max = Math.max(max, size + 1);
            }
        }

        /**
         * THE BELOW CASE IS ONLY USED WHEN THERE WAS NO 0 IN THE ARRAY, WE CAN USE THE BELOW SNIPPET TOO
         * BUT JUST IN CASE IF 0 DOESN'T BECOME UPAR WE CHOSE TO DO IT IN LOOP.
         *   if(max == 0) {
         *    max = disjointSet.size.get(0);
         *  }
         */
        if(max == 0) {
            for (int i = 0; i < n * m; i++) {
                disjointSet.size.get(disjointSet.findUPar(i));
            }
        }
        return max;
    }
}
