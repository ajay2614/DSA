package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathInWightedUndirectedGraph {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        ArrayList<ArrayList<PairDijkstra>> adj = new ArrayList<>();

        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<=n;i++) {
            adj.get(edges[i][0]).add(new PairDijkstra(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new PairDijkstra(edges[i][2], edges[i][1]));
        }


        PriorityQueue<PairDijkstra> pq = new PriorityQueue<>( (PairDijkstra a, PairDijkstra b) -> {
            if(a.w > b.w)
                return 1;
            if(a.w < b.w)
                return -1;
            if(a.n > b.n)
                return 1;
            if(a.n < b.n)
                return -1;
            return 0;
        });

        int djk[] = new int[n+1];
        int par[] = new int[n+1];
        for(int i=0;i<=n;i++) {
            djk[i] = Integer.MAX_VALUE;
        }


        djk[1] = 0;
        pq.offer(new PairDijkstra(0,1));

        while(!pq.isEmpty()) {
            PairDijkstra p = pq.poll();
            int weight = p.w;
            int node = p.n;

            for (PairDijkstra nbr : adj.get(node)) {
                int nbrNode = nbr.n;
                int nbrWeight = nbr.w;

                if(nbrWeight + weight < djk[nbrNode]) {
                    djk[nbrNode] = nbrWeight + weight;
                    par[nbrNode] = node;
                    pq.offer(new PairDijkstra(nbrWeight + weight, nbrNode));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        int node = n;
        while (par[node] != node) {
            ans.add(node);
            node = par[node];
        }
        ans.add(1);//NODE IS 1 BECAUSE STARTING NODE IS 1 AND NOT 0
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        /**
         * SIMPLY DONE VIA DIJKSTRA
         */
    }
}
