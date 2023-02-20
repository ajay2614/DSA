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

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE GIVEN A 2D ARRAY REPRESENTING A STONES ROW AND COLUMN,
         * WE HAVE TO FIND TOTAL STONES THAT CAN BE REMOVED THAT HAVE SAME ROW OR SAME COLUMN
         *
         * HOW TO SOLVE?
         * WE WILL REPRESENT EVERY ROW AND COLUMN AS A NODE, EVERY TIME WE ENCOUNTER STONE POSITIONS
         * WE WILL UNITE THE ROW AND COLUMN USING DISJOINT SET.
         *
         * FOR ROWS, WE DON'T NEED ANY CONVERSION SUPPOSE THERE ARE 5 NODES, REPRESENTED FROM 0 TO 4, THEN WE WILL
         * TREAT ROWS AS THE SAME, BUT FOR COLUMNS WE WILL MARK THEM AS TOTAL ROWS + THAT PARTICULAR COLUMN
         * SO SUPPOSE THERE ARE 5 ROWS SO IN A 0 BASED INDEXING, MAX ROW WOULD BE 4, SO SUPPOSE FOR COLUMN 2 IT WILL BE
         * 2 + 4 + 1 = 6, SO NODE NUMBER 6 UNIQUELY IDENTIFIES COLUMN NUMBER 2.
         *
         * EG OF UNITING
         *
         * SUPPOSE FIRST ROW IS 0 AND FIRST COLUMN IS 0
         *
         * SO ROW WILL BE 0TH NODE AND COLUMN WILL BE 5TH NODE
         *
         * NOW UNITING THEM WILL MAKE 5TH PARENT AS 0.
         *
         * NOW SUPPOSE THERE IS A STONE AT 3RD ROW AND 0TH COLUMN
         *
         * SINCE 0TH COLUMN WILL AGAIN COME AS 5, SO WILL UNITE 3 BY 5TH UPAR WHICH IS 0
         *
         * SINCE A ROW OR COLUMN CAN REPEAT KEEP THEM IN SET
         *
         * SIMPLY ITERATE THE SET AND GET THE TOTAL COMPONENTS
         *
         * AFTER THAT SUBTRACT TOTAL STONES - COMPONENT THAT WILL GIVE US ANSWER
         *
         * AS A COMPONENT SAY 0 WILL HAVE CHILDREN WHICH CAN BE REMOVED AS PER QUESTION BY SIMPLY SUBTRACTING TOTAL WILL GIVE
         * US ANSWER, THAT IS WHY WE USED ABOVE STATEMENT.
         */
    }
}
