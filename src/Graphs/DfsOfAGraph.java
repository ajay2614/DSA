package Graphs;

import java.util.ArrayList;

public class DfsOfAGraph {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(vis[i] == 0)
                dfs(adj, vis, ans, i);
        }
        return ans;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj, int vis[], ArrayList<Integer> ans, int ind) {
        vis[ind] = 1;
        ans.add(ind);

        for(int i : adj.get(ind)) {
            if(vis[i] == 0)
                dfs(adj, vis, ans, i);
        }
    }
}
