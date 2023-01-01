package Graphs;

import java.util.ArrayList;

public class DetectCycleInDirectedGraphUsingDFS {
    public boolean cycle(int dfs[], int vis[], int src, ArrayList<ArrayList<Integer>> adj) {
        dfs[src] = 1;
        vis[src] = 1;

        for(int i : adj.get(src)) {
            if(vis[i] == 0) {
                if(cycle(dfs, vis, i, adj))
                    return true;
            }
            else if(dfs[i] == 1) {
                return true;
            }
        }
        dfs[src] = 0;

        return false;
    }

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int vis[] = new int[V];
        int dfs[] = new int[V];

        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                if(cycle(dfs,vis,i,adj))
                    return true;
            }
        }
        return false;
    }
}
