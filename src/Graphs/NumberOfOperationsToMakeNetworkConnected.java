package Graphs;

public class NumberOfOperationsToMakeNetworkConnected {
    public int makeConnected(int n, int[][] connections) {

        DisjointSet disjointSet = new DisjointSet(n);
        int extraEdge = 0;
        int totalEdges = connections.length;
        for(int i=0;i<totalEdges;i++) {
            if(disjointSet.findUPar(connections[i][0]) == disjointSet.findUPar(connections[i][1]))
                extraEdge++;
            else {
                disjointSet.unionBySize(connections[i][0], connections[i][1]);
            }
        }

        int totalComponents = 0;
        for(int i=0;i<n;i++){
            if(disjointSet.findUPar(i) == i) {
                totalComponents++;
            }
        }

        if(extraEdge >= totalComponents-1)
            return totalComponents-1;
        return -1;
    }

    public static void main(String[] args) {
        int arr[][] = {{0,1},{0,2},{1,2}};
        NumberOfOperationsToMakeNetworkConnected numberOfOperationsToMakeNetworkConnected = new NumberOfOperationsToMakeNetworkConnected();
        numberOfOperationsToMakeNetworkConnected.makeConnected(4, arr);

        /**
         * IN THIS QUESTION WE ARE GIVEN AN ARRAY AND N NODES, FROM 0 TO N-1, SUPPOSE FOR THE ABOVE 0 IS CONNECTED TO
         * 1 AND 2, AND 1 IS CONNECTED TO 0 AND 2, AND 2 IS CONNECTED TO 0 AND 1, IT IS AN UNDRECTED GRAPH,
         *
         * WHAT WE NEED TO FIND IS WHETHER UPON REMOVING SOME EDGE/EDGES, WHETHER WE CAN CONNECT THE NODES
         * SUCH AS ALL NODES CAN REACH/GET CONNECTED BY ONE ANOTHER, FOR EG IN ABOVE THE IF WE REMOVE EDGE BETWEEN
         * 1 AND 2 AND USE THAT EDGE TO CONNECT TO 3(SINCE THERE ARE NODES FROM 0 TO N-1, 3 IS ALONE).
         *
         * SO WHAT WE CAN FIGURE OUT IS THAT FOR N NODES TO CONNECT THERE SHOULD BE N-1 TOTAL EDGES
         * SUCH THAT EVERY NODE IS CONNECTED BY ONE ANOTHER, SIMILARLY WE CAN FIND THAT IF THERE ARE TWO COMPONENTS
         * TO CONNECT THEM WE NEED 1 EDGE, SO TO CONNECT N COMPONENTS WE NEED N-1 EDGES.
         *
         * WHAT WE CAN DO IS USING DISJOINT SET UNITE THE NODES AND IF THERE COMES A POINT THEY ALREADY HAVE SAME PARENT
         * WE WILL COUNT THAT EDGE AS EXTRA, AS FOR O 1 1 2 1 3, THERE ARE 3 EDGES FOR 3 NODES, BUT WE CAN EVEN USE
         * 2 TO CONNECT THEM SO 1 WILL BE COUNTED AS EXTRA, AFTER THAT WE CAN SIMPLY CHECK TOTAL COMPONENTS AND IF
         * TOTAL COMPONENTS - 1 <= EXTRA EDGES, WE CAN SAY WE CAN CONNECT THEM.
         *
         */

    }
}
