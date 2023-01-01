package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pairgraph {
    int par;
    int chi;

    Pairgraph(int par, int chi) {
        this.par = par;
        this.chi = chi;
    }
}
public class DetectACyleInUndirectedGraphBFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];

        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                if(cycle(vis, i, adj))
                    return true;
            }
        }
        return false;
    }

    public boolean cycle(int[] vis, int src, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pairgraph> q = new LinkedList<>();
        q.offer(new Pairgraph(-1, src));
        vis[src] = 1;
        while(!q.isEmpty()) {
            Pairgraph p = q.poll();
            int parent = p.par;
            int child = p.chi;

            for(int i : adj.get(child)) {
                if(vis[i] == 0) {
                    q.offer(new Pairgraph(child, i));
                    vis[i] = 1;
                }
                else if(i != parent)
                    return true;
            }
        }
        return false;
    }
}
