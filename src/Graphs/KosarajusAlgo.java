package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class KosarajusAlgo {

    public static void dfs(int[] vis, int i,  ArrayList<ArrayList<Integer>> adj) {
        vis[i] = 1;

        for(int it : adj.get(i)) {
            if(vis[it] == 0)
                dfs(vis, it, adj);
        }
    }
    //TOPO SORT
    public static void finishTime(Stack<Integer> st,  ArrayList<ArrayList<Integer>> adj,
                                  int i, int[] vis) {
        vis[i] = 1;

        for(int it : adj.get(i)) {
            if(vis[it] == 0) {
                finishTime(st, adj, it, vis);
            }
        }

        st.push(i);
    }

    public static int getAns(int V,  ArrayList<ArrayList<Integer>> adj) {

        Stack<Integer> st = new Stack<>();
        int vis[] = new int[V];

        for(int i=0;i<V;i++) {
            if(vis[i] ==0) {
                finishTime(st, adj, i, vis);
            }
        }

        Arrays.fill(vis, 0);

        ArrayList<ArrayList<Integer>> tr = new ArrayList<>();
        for(int i=0;i<V;i++) {
            tr.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++) {
            for(int it : adj.get(i)) {
                tr.get(it).add(i);
            }
        }
        int cnt = 0;
        while(!st.isEmpty()) {
            int ele = st.pop();

            if(vis[ele] == 0) {
                cnt++;
                dfs(vis, ele, tr);
            }
        }

        return cnt;
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        return getAns(V, adj);
    }
    public static void main(String args[]) {

        /**
        BENEFITS OF USING THIS ALGO
        * THIS ALGO HELPS US TO FIND STRONGLY CONNECTED COMPONENTS
        * EG. 1 IS DIRECTED TO 2 AND 2 IS DIRECTED TO 3 AND 3 IS DIRECTED TO 1, THIS IS A STRONGLY CONNECTED COMPONENT
        * MEANING EVERY COMPONENT CAN REACH TO OTHER COMPONENT, A STRONGLY CONNECTED COMPONENT CAN ALSO BE SINGLE.
         */
        int n = 7;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(3).add(2);
        adj.get(3).add(5);
        adj.get(4).add(6);
        adj.get(5).add(4);
        adj.get(6).add(5);
        KosarajusAlgo kosarajusAlgo = new KosarajusAlgo();
        kosarajusAlgo.kosaraju(n, adj);

        /**
         * IN THIS QUESTION WE HAVE TO USE THE KOSARAJUS ALGO TO GET A STRONGLY CONNECTED COMPONENT
         * WHAT IS A SCC ?
         * A COMPONENT IN WHICH WE CAN REACH FROM ONE NODE TO ANY OTHER NODE IN THAT COMPONENT, FOR EG
         * 1 -> 2 -> 3 -> 1
         *         APPROACH TO SOLVE KOSARAJUS ALGO
         *         1. APPLY TOPOLOGICAL SORT
         *         2. AFTER THIS TRANSPOSE THE ADJACENCY LIST
         *         3. AFTER THIS USE A DFS METHOD TO PRINT EVERY SCC.
         *
         * THE IDEA BEHIND APPROACH IS THAT IF WE CAN REVERSE THE DIRECTIONS OF THE EDGES WE CAN SEPERATE THE SCCS
         * HOW THIS WORKS
         *
         * WE WILL FIRST USE THE LOOSE TOPO SORT USING DFS AND STACK WHICH WILL HAVE THE NODES BASED ON THEIR INDEGREE
         *
         * AFTER THIS WE WILL REVERSE THE DIRECTIONS
         *
         * NOW WE WILL USE DFS TO TRAVERSE BY POPPING OUT FROM STACK, HOW THIS WILL ALWAYS WORK
         * SUPPOSE  1 -> 2 -> 3 -> 1, BUT 3 -> 4, THEN BY REVERSING AND 3 <- 4, NOW WHEN 4 WILL TRY TO GO TO 3 IT WILL ALREADY
         * BE VISITED, SUPPOSE IF THE CASE WAS  1 -> 2 -> 3 -> 1 BUT 3 <- 4, IN THIS CASE 4 WILL BE ON THE TOP OF STACK
         * FROM TOPO SORT, SO WHEN REVERSING 3 -> 4 3 WILL NOT BE ABLE TO AS 4 WOULD ALREADY BE VISITED HENCE TOPO SORT PART
         * IS CRUCIAL FOR THIS.
         *
         *
         */
    }

}
