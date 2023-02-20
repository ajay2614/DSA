package Graphs;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DisjointSet disjointSet = new DisjointSet(n);
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(i != j && isConnected[i][j] == 1) {
                    disjointSet.unionByRank(i,j);
                }
            }
        }

        int cnt = 0;
        for(int i=0;i<n;i++) {
            if(disjointSet.findUPar(i) == i)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE GIVEN EDGES IN THE FORM OF 2D ARRAY
         * EG [[1,1,0],[1,1,0],[0,0,1]], IN THIS FOR NODE 0(I=0) [1,1,0], MEANS 0 IS CONNECTED TO ITSELF, WHICH
         * , 0 IS CONNECTED TO 1, AND 0 IS NOT CONNECTED TO 2.
         *
         * WE HAVE TO FIND OUT TOTAL PROVINCES, NODES THAT ARE DIRECTLY OR INDIRECTLY CONNECTED BELONG TO THE SAME
         * PROVINCE. SO INDIRECTLY WE HAVE TO FIND THE TOTAL COMPONENTS.
         *
         * SIMPLY ITERATE THROUGH 2D ARRAY, AND WHEN ARR[I][J] = 1, UNITE I AND J USING DISJOINT SET,
         * I != J BECAUSE NO NEED TO UNITE SAME NODES, AFTER THAT SIMPLY COUNT TOTAL COMPONENT.
         */
    }
}
