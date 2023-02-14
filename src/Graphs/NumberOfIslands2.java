package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet disjointSet = new DisjointSet(rows * cols);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        int[][] vis = new int[rows][cols];

        for(int[] operator : operators) {
            int r = operator[0];
            int c = operator[1];

            if(vis[r][c] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[r][c] = 1;
            cnt++;
            int di[] = {1,0,-1,0};
            int dj[] = {0,-1,0,1};

            for(int i=0;i<4;i++) {
                int nRow = r + di[i];
                int nCol = c + dj[i];

                if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && vis[nRow][nCol] == 1) {
                    int adjNode = r * cols + c;
                    int adjNthNode = nRow * cols + nCol;

                    if(disjointSet.findUPar(adjNode) != disjointSet.findUPar(adjNthNode)) {
                        disjointSet.unionByRank(adjNode, adjNthNode);
                        cnt--;
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,1},{0,1},{3,3},{3,4}};
        int n = 4;
        int m = 5;
        NumberOfIslands2 islands2 = new NumberOfIslands2();
        islands2.numOfIslands(n,m,arr);

        /**
         * IN THIS QUESTION WE ARE GIVEN A CORDINATES, IN ARRAYLIST HAVING ROWS AND COLUMNS WE NEED TO FIND AT EVERY STAGE HOW
         * MANY COMPONENTS ARE PRESENT, IF AN ELEMENT AND AN ELEMENT WHICH IS ADJACENT TO IT IN 4 DIRECTIONS, THEN THESE TWO
         * ELEMENT BELONG TO SAME COMPONENT
         *
         * THE IDEA BEHIND IS EVERY TIME WE GET AN NEW ELEMENT FROM CORDINATES, WE INCREASE THE COUNT AND CHECK
         * IT'S ADJACENT SIDES NOW THE AMOUNT OF ELEMENTS WE ENCOUNTER ON ITS ADJACENT SIDES, WE UNITE THEM USING DISJOINT SET
         * WITH THIS WE DECREASE THE COUNT AS SUPPOSE AN ELEMENT WHICH IS INTRODUCED WE INCREASE IT'S COUNT BY 1 RT NOW
         * IT DOESN'T HAVE ANY ELEMENT ADJACENT PRESENT WHEN WE INTRODUCE A NEW ELEMENT AND INCREASE THE COUNT, SINCE
         * PREV WAS ADJACENT WE DECREASE COUNT BY 1.
         *
         * NOW SINCE TO GET THE CORRECT USING DISJOINT SET WE NEED TO GET ALL THE ELEMENTS IN THE FORM OF A NUMBER RATHER
         * THAN THEIR 2D CORDINATES, SO TO CONVERT EVERY ROW AND ADJACENT ROW WHILE CHECKING WE USE
         *
         *    int adjNode = r * cols + c;
         *    int adjNthNode = nRow * cols + nCol;
         *
         *    FOR EG ROW 0 COL 2 TOTAL COLUMN 5, THEN 0 * 5 + 2 = 2;
         */
    }
}
