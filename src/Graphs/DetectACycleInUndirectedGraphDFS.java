package Graphs;

import java.util.ArrayList;

public class DetectACycleInUndirectedGraphDFS {

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];

        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                if(cycle(vis, -1, i, adj))
                    return true;
            }
        }
        return false;
    }

    public boolean cycle(int[] vis, int par, int chi, ArrayList<ArrayList<Integer>> adj) {
        vis[chi] = 1;
        for(int i : adj.get(chi)) {
            if(vis[i] == 0) {
                if(cycle(vis, chi, i, adj))
                    return true;
            }
            else if(i != par)
                return true;
        }
        return false;
    }
}
