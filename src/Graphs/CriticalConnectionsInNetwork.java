package Graphs;

import java.util.ArrayList;
import java.util.List;

public class CriticalConnectionsInNetwork {
    /**
     * Same as Bridges
     */
    int timer = 1;
    public void dfs(int[] maxTime, int[] minTime, int vis[],List<List<Integer>> adj, List<List<Integer>> ans, int node, int parent) {
        vis[node] = 1;
        maxTime[node] = timer;
        minTime[node] = timer;
        timer++;

        for(int it : adj.get(node)) {
            /**
             * TAKING PARENT BECAUSE IF WE HADN'T TAKEN THIS EVERYTIME IT WOULD HAVE UPDATED MINTIMENODE
             * IN THE ELSE PART HENCE THERE WOULD NOT HAVE BEEN ANYWAY TO GET INTO THE MINTIME[IT] > TIME[NODE]
             * CONDITION
             */
            if(it == parent)
                continue;
            if(vis[it] == 0) {
                dfs(maxTime, minTime, vis, adj, ans, it, node);
                minTime[node] = Math.min(minTime[node], minTime[it]);
                if(minTime[it] > maxTime[node]) {
                    ans.add(List.of(node, it));
                }
            }
            else {
                minTime[node] = Math.min(minTime[node], minTime[it]);
            }
        }

    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> con : connections) {
            adj.get(con.get(0)).add(con.get(1));
            adj.get(con.get(1)).add(con.get(0));
        }
        int maxTime[] = new int[n];
        int minTime[] = new int[n];
        int vis[] = new int[n];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(maxTime, minTime, vis, adj, ans, 0, -1);
        return ans;
    }
}
