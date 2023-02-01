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
}
