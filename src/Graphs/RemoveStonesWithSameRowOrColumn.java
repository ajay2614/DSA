package Graphs;

import java.util.HashSet;

public class RemoveStonesWithSameRowOrColumn {
    public int removeStones(int[][] stones) {

        int maxRow = 0;
        int maxCol = 0;

        for(int arr[] : stones) {
            maxRow = Math.max(maxRow, arr[0]);
            maxCol = Math.max(maxCol, arr[1]);
        }

        /**
         * QUESTION MAY ARISE THAT WHY ARE WE NOT GETTING ERROR FOR MAXROW + MAXCOL +1 AS SIZE SHOULD BE +2
         * SINCE IT IS 0 BASED INDEXING, THIS IS BECAUSE IN DISJOINT SET WE INIT OUR CONSTRUCTOR WITH <= N.
         */
        DisjointSet disjointSet = new DisjointSet(maxRow + maxCol + 1);
        HashSet<Integer> hashSet = new HashSet<>();
        for(int arr[] : stones) {
            int row = arr[0];
            int col = arr[1] + maxRow + 1;

            disjointSet.unionBySize(row, col);
            hashSet.add(row);
            hashSet.add(col);
        }

        int cnt = 0;
        for(int node : hashSet) {
            if(disjointSet.findUPar(node) == node) {
                cnt++;
            }
        }
        //TOTAL STONES - COMPONENTS
        int n = stones.length;
        return n-cnt;
    }
}
