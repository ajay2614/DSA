package Graphs;

import java.util.ArrayList;

public class DfsOfAGraph {
    private void dfs(ArrayList<ArrayList<Integer>> adj, int vis[], ArrayList<Integer> ans, int ind) {
        vis[ind] = 1;
        ans.add(ind);

        for(int i : adj.get(ind)) {
            if(vis[i] == 0)
                dfs(adj, vis, ans, i);
        }
    }
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int vis[] = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<V;i++) {
            if(vis[i] == 0)
                dfs(adj, vis, ans, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * THE FOLLOWING PROGRAM IS USED TO PRINT DFS OF AN UNDIRECTED GRAPH
         *
         * SINCE DFS USING CONCEPT OF RECURSION, WE WILL USE RECURSION HERE. WE WILL USE A VISITED ARRAY TO MARK THE VISITS OF GRAPH
         * IF A NODE IS UNVISITED CALL DFS FOR IT, NOW IN THE DFS METHOD, RECURSE AND CALL SAME DFS METHOD FOR EVERY NODE WHICH IS UNVISITED
         */
    }

}
