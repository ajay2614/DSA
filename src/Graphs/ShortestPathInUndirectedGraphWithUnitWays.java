package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class ShortestPathInUndirectedGraphWithUnitWays {
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

    }
}
