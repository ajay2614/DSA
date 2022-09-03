package Graphs;

import java.util.ArrayList;

public class ArticulationPoint {
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int node, int parent, int[] tin, int[] lin, int vis[], int timer, int isArticulation[]) {
        vis[node] = 1;
        lin[node] = tin[node] = timer++;
        int child = 0;

        for(int i:adj.get(node)) {
            if(i == parent)
                continue;
            if(vis[i] == 0) {
                dfs(adj, i, node, tin, lin, vis, timer, isArticulation);
                lin[node] = Math.min(lin[node], lin[i]);

                if(lin[i] >= tin[node] && parent != -1)
                    isArticulation[node] = 1;
                child++;
            }
            else
                lin[node] = Math.min(tin[i], lin[node]);
        }
        if(parent == -1 && child > 1)
            isArticulation[node] = 1;
    }
    public static void printArticulation(ArrayList<ArrayList<Integer>> adj, int n) {
        int tin[] = new int[n];
        int lin[] = new int[n];
        int vis[] = new int[n];
        int isArticulation[] = new int[n];
        for (int i=0;i<n;i++) {
            if(vis[i] == 0)
                dfs(adj, 0, -1, tin, lin, vis, 0, isArticulation);
        }

        for (int i : isArticulation)
            System.out.println(i);
    }
    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

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

        printArticulation(adj, n);
    }
}
