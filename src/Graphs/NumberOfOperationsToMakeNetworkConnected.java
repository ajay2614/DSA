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

    }
}
