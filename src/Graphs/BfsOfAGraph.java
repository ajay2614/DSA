package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsOfAGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        ArrayList<Integer> ans = new ArrayList<>();
        int vis[] = new int[V];
        vis[0] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for(int i : adj.get(node)) {
                if(vis[i] == 0) {
                    vis[i] = 1;
                    q.offer(i);
                }
            }
        }
        return ans;
    }
}
