package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Pair {
    int node;
    int weight;
    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    int getNode() {
        return this.node;
    }

    int getWeight() {
        return this.weight;
    }
}
public class ShortestPathDirectedGraph {
    public static void topo(int node,ArrayList<ArrayList<Pair>> adj,boolean vis[], Stack stack) {
        vis[node] = true;
        for(Pair it : adj.get(node)) {
            if(vis[it.getNode()] == false) {
                topo(it.getNode(), adj, vis, stack);
            }
        }
        stack.add(node);
    }
    public static void shortestPath(int s, ArrayList<ArrayList<Pair>> adj, int V) {

        Stack stack = new Stack();
        int dist[] = new int[V];

        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);

        for (int i=0;i<V;i++) {
            if (!visited[i])
                topo(i, adj, visited, stack);
        }

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;

        while (!stack.isEmpty()) {
            int node = (int) stack.pop();
            if(dist[node] != Integer.MAX_VALUE) {
                for (Pair it : adj.get(node)) {
                    if (dist[node] + it.getWeight() < it.getNode()) {
                        dist[it.getNode()] = dist[node] + it.getWeight();
                    }
                }
            }
        }

        for (int i=0 ; i<V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }


    }
    public static void main(String[] args) throws IOException {
        int n = 6;
        ArrayList<ArrayList<Pair>> adj= new ArrayList<>();
        for (int i = 0; i < n ;i ++) {
            adj.add(new ArrayList<Pair>());
        }
        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(4,1));
        adj.get(1).add(new Pair(2,3));
        adj.get(2).add(new Pair(3,6));
        adj.get(4).add(new Pair(2,2));
        adj.get(4).add(new Pair(5,4));
        adj.get(5).add(new Pair(3,1));
        shortestPath(0, adj, n);
    }
}
