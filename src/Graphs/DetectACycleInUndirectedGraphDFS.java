package Graphs;

import java.util.ArrayList;

public class DetectACycleInUndirectedGraphDFS {

    private boolean cycle(int[] vis, int par, int chi, ArrayList<ArrayList<Integer>> adj) {
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

    public static void main(String[] args) {
        /**
         * IN THE FOLLOWING PROGRAM WE WILL DETECT A CYCLE IN UNDIRECTED GRAPH USING DFS
         *
         * WE WILL USE A VISITED ARRAY, RUN A LOOP TO CHECK IF THE NODE IS UNVISITED CALL DFS ON IT, WE WILL PASS
         * PARENT PARAMETER AS -1 AS NO NODE WILL BE -1, AND CHILD AS THE ACTUAL NODE, MARK CHILD NODE AS VISITED AND NOW CHECK
         * FOR ADJACENT NODE, IF NOT VISITED CALL DFS ON IT WITH CHILD AS THE NODE AS PARENT AS THE SOURCE NODE, AS IT CAN RETURN
         * TRUE IN EARLIER STAGE OF RECURSION RETURN TRUE IF IT RETURNS TRUE, IF NOT VISITED IT MEANS IT CAN BE PARENT OR
         * SOME NODE WHICH HAS BEEN VISITED MEANING IT'S A CYCLE, SO IF NODE IS NOT EQUAL TO PARENT RETURN TRUE AS IT IS CYCLE.
         *
         */
    }
}
