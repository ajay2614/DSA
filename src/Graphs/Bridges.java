package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class Bridges {

    public static void getBridges(int node, int parent, ArrayList<ArrayList<Integer>> adj, int[] lin, int[] tin, boolean vis[], int timer) {
        vis[node] = true;
        tin[node] = lin[node] = timer++;

        for(int i : adj.get(node)) {
            if (i == parent)
                continue;
            if(vis[i] == false) {
                getBridges(i, node, adj, lin, tin, vis, timer);
                lin[node] = Math.min(lin[i], lin[node]);
                if(lin[i] > tin[node])
                    System.out.println(i + " -> " + node);
            }
            else
                lin[node] = Math.min(lin[node], tin[i]);
        }
    }

    public static void printBridges(ArrayList<ArrayList<Integer>> adj, int n) {
        boolean vis[] = new boolean[n];

        //lin stands for LOWEST TIME OF INSERTION
        //tin stands for TIME OF INSERTION

        int tin[] = new int[n];
        int lin[] = new int[n];

        Arrays.fill(vis, false);
        int timer = 0;
        for(int i = 0;i<n;i++) {
            if(!vis[i]) {
                getBridges(i, -1, adj, lin, tin, vis, timer);
            }
        }
    }

    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);

        adj.get(0).add(2);
        adj.get(2).add(0);

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(1).add(3);
        adj.get(3).add(1);

        adj.get(3).add(4);
        adj.get(4).add(3);

        printBridges(adj, n);
    }
}
