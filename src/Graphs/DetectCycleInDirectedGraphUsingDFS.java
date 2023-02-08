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

    public static void main(String[] args) {
        /**
         * IN THIS WE HAVE TO DETECT WHETHER THERE EXISTS A CYCLE IN A DIRECTED GRAPH USING DFS,SINCE IN DIRECTED GRAPH THERE CAN BE
         * INCOMING OR OUTGOING EDGES, WE WILL USE ANOTHER ARRAY ALONGSIDE A VISTED ARRAY TO TRACK WHETHER THE PATH IS COMPLETED
         * OR NOT FOR THAT NODE, IF THE PATH IS COMPLETED AND THEN ANOTHER NODE COMES TO IT, IT MEANS ITS A DIFFERENT PATH, LIKE
         * THE NODE IS COMING TO IT NOW.
         *
         * IF PATH ARRAY IS 1 AND VIS IS 1, MEANS THE NODE IS PRESENT IN THE SAME PATH SO RETURN TRUE.
         */
    }
}
