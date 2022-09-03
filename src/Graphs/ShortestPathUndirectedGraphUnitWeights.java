package Graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathUndirectedGraphUnitWeights {

    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src, int v) {
        int dist[] = new int[v];

        for(int i=0; i< v; i++)
            dist[i] = Integer.MAX_VALUE;

        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        dist[src] = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int i:adj.get(node)) {
                if(dist[node] + 1 < dist[i]) {
                    dist[i] = dist[node] + 1;
                    queue.add(i);
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException
    {

        int V = 9;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
            adj.add(i, new ArrayList<Integer>());
        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(6);
        adj.get(3).add(0);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(6);
        adj.get(8).add(7);

        int arr[] = shortestPath(adj, 0, V);

        for (int i=0;i<V;i++) {
            System.out.println(arr[i]);
        }

    }
}

