package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfGraphIsBipartiteUsingBFS {
    /**
     * Tc and Sc same as BFS
     *
     */
    private static boolean bfs(int col[], int graph[][], int src) {
        col[src] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        while(!q.isEmpty()) {
            int ele = q.poll();

            for(int i : graph[ele]) {
                if(col[i] == 0) {
                    col[i] = col[ele] == 1 ? 2 : 1;
                    q.offer(i);
                }
                else if(col[i] == col[ele])
                    return false;
            }
        }
        return true;
    }
    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int col[] = new int[n];

        for(int i=0;i<n;i++) {
            if(col[i] == 0) {
                if(!bfs(col, graph, i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int graph[][] = {{1,2,3},{0,2},{0,1,3},{0,2}};
        isBipartite(graph);
        /**
         * A BIPARTITE GRAPH IS THAT GRAPH IN WHICH SAY
         * 1 -> 2 -> 3, AND SAY WE ASSIGN COLOUR A TO 1 AND B TO 2 AND A TO 3, SINCE NO NEIGHBOURING NODE HAS SAME
         * COLOUR THE FOLLOWING GRAPH IS BIPARTITE
         *
         * TO CHECK WE WILL USE BFS APPROACH HERE SIMPLY TRAVERSE THROUGH GRAPH USING BFS AND ASSIGN A COLOUR ARRAY
         * IF AT ANY POINT TWO NODES HAVE THE SAME COLOUR RETURN FALSE
         *
         */
    }
}
