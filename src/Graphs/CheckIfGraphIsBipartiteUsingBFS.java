package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfGraphIsBipartiteUsingBFS {
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
    }
}
