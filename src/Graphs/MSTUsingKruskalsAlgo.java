package Graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MSTUsingKruskalsAlgo {
    static int spanningTree(int V, int E, int edges[][]){
        DisjointSet disjointSet = new DisjointSet(V+1);
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] > o2[2])
                    return 1;
                if(o1[2] < o2[2])
                    return -1;
                return 0;
            }
        });

        int weight = 0;
        for (int arr[] : edges) {
            if(disjointSet.findUPar(arr[0]) != disjointSet.findUPar(arr[1])) {
                weight += arr[2];
                disjointSet.unionByRank(arr[0], arr[1]);
            }
        }
        return weight;
    }

}
