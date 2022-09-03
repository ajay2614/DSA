package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajusAlgo {

    public static void topoSort(ArrayList<ArrayList<Integer>> adj, int node, int[] vis, Stack<Integer> stack) {
        vis[node] = 1;
        for (int i : adj.get(node)) {
            if (vis[i] == 0)
                topoSort(adj, i, vis, stack);
        }
        stack.add(node);
    }

    public static void transpose(ArrayList<ArrayList<Integer>> transpose, ArrayList<ArrayList<Integer>> adj, int n) {
        for (int i = 0 ; i < n; i++) {
            for (int it : adj.get(i))
                transpose.get(it).add(i);
        }
    }

    public static void reDfs(ArrayList<ArrayList<Integer>> transpose, int node, int[] visit) {
        visit[node] = 1;
        System.out.print(" " + node + " ->");
        for (int it: transpose.get(node)) {
            if (visit[it] == 0)
                reDfs(transpose, it, visit);
        }
    }
    public static void kosaraju(ArrayList<ArrayList<Integer>> adj, int n) {
        int visit[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<n;i++) {
            if (visit[i] == 0)
                topoSort(adj,i,visit, stack);
        }

        Arrays.fill(visit, 0);
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for (int i = 0 ; i< n; i++) {
            transpose.add(new ArrayList<>());
        }

        transpose(transpose, adj, n);

        while (stack.size() > 0) {
            int node = stack.pop();
            if (visit[node] == 0) {
                System.out.print("NEW SCC : ");
                reDfs(transpose, node, visit);
                System.out.println();
            }

        }

    }

    public static void main(String args[]) {

        /*
        BENEFITS OF USING THIS ALGO
        * THIS ALGO HELPS US TO FIND STRONGLY CONNECTED COMPONENTS
        * EG. 1 IS DIRECTED TO 2 AND 2 IS DIRECTED TO 3 AND 3 IS DIRECTED TO 1, THIS IS A STRONGLY CONNECTED COMPONENT
        * MEANING EVERY COMPONENT CAN REACH TO OTHER COMPONENT, A STRONGLY CONNECTED COMPONENT CAN ALSO BE SINGLE.


        APPROACH TO SOLVE KOSARAJUS ALGO
        1. APPLY TOPOLOGICAL SORT
        2. AFTER THIS TRANSPOSE THE ADJACENCY LIST
        3. AFTER THIS USE A DFS METHOD TO PRINT EVERY SCC.


         */
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());

        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(4);
        adj.get(6).add(5);
        kosaraju(adj, n);
    }

}
