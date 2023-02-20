package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class ShortestPathInUndirectedGraphWithUnitWays {

    /**
     * Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’} + O(N + 2M) { for the BFS Algorithm} +
     * O(N) { for adding the final values of the shortest path in the resultant array} ~ O(N+2M).
     *
     * Where N= number of vertices and M= number of edges.
     *
     * Space Complexity:  O( N) {for the stack storing the BFS} + O(N) {for the resultant array} + O(N) {for the dist array
     * storing updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .
     *
     * Where N= number of vertices and M= number of edges.
     */
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }

        for(int arr[] : edges) {
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }

        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        int dist[] = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while(!q.isEmpty()) {
            int node = q.poll();

            for(int i : adj.get(node)) {
                if(dist[i] > dist[node] + 1) {
                    dist[i] = dist[node] + 1;
                    q.offer(i);
                }
            }
        }

        for(int i=0;i<n;i++) {
            if(dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
    public static void main(String [] args) {
        int arr[][] = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        /**
         * SIMPLY USE DIJKSTRA USING QUEUE IN THIS, AS THE WEIGHT IS ONE UNIT EVERYTIME HENCE NO NEED TO USE PRIORITY QUEUE.
         */
    }
}
