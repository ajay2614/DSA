package Graphs;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Arrays;
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
/**
 * TC : BIG O(N+E) WHERE N IS NUMBER OF NODES AND E IS NUMBER OF EDGES
 * PREFERRED OVER DIJKSTRAS FOR ACYCLIC GRAPH BECAUSE OF ITS COMPLEXITY, AS WITH THIS APPROACH WE ARE FINDING ANSWER SEQUENTIALLY
 * AS FOR EG 0 WITH 0 INDEGREE IS ALREADY COMPUTED BEFORE SAY 1 WITH INDEGREE 1.
 *
 */
public class ShortestPathInDirectedAcyclicGraphAlsoHasAlternateTopo {
    public void dfs(Stack<Integer> stack, int vis[], int node, ArrayList<ArrayList<Pair>> adj) {
        vis[node] = 1;

        for(Pair pair : adj.get(node)) {
            if (vis[pair.getNode()] == 0)
                dfs(stack, vis, pair.getNode(), adj);
        }
        stack.add(node);
    }
    public int[] shortestPath(int N,int M, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<N;i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] arr : edges) {
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
        }

        Stack<Integer> topo = new Stack<>();
        int[] vis = new int[N];
        for(int i=0;i<N;i++) {
            if(vis[i] == 0) {
                dfs(topo, vis, i, adj);
            }
        }
        int dis[] = new int[N];
        Arrays.fill(dis, (int) 1e9);
        /**
         * DISTANCE HERE IS 0 BECAUSE WE NEED TO FIND PATH FROM SOURCE AND SOURCE IS MENTIONED 0
         */
        dis[0] = 0;
        while (!topo.isEmpty()) {
            int node = topo.pop();

            for(Pair p : adj.get(node)) {
                if(dis[p.getNode()] > dis[node] + p.getWeight()) {
                    dis[p.getNode()] = dis[node] + p.getWeight();
                }
            }
        }

        for(int i=0;i<N;i++) {
            if(dis[i] == (int) 1e9) {
                dis[i] = -1;
            }
        }

        return dis;
    }
    public static void main(String[] args) {
        int[][] arr= {{0, 1, 2},{2, 1, 2}, {2, 4, 2} ,{1, 4, 8} ,{1, 3, 6}};
        ShortestPathInDirectedAcyclicGraphAlsoHasAlternateTopo s = new ShortestPathInDirectedAcyclicGraphAlsoHasAlternateTopo();
        s.shortestPath(5,5,arr);

        /**
         * IN THIS QUESTION AS THE NAME SUGGESTS WE HAVE TO FIND SHORTEST PATH IN A DIRECTED ACYCLIC GRAPH
         *
         * TO SOLVE THIS WE CAN USE TOPO SORT SO TO FIRST CATEGORISE NODES ACC TO THEIR INDEGREE
         * AND THEN SIMPLY USING DISTANCE ARRAY PULL OUT FROM TOPO STACK AND COMPARE DISTANCES AND ADD IN DISTANCE ARRAY
         *
         * AFTER THAT SIMPLY POP ELEMENTS FROM STACK AND CHECK FOR DISTANCES FOR THEIR ADJACENT NODES.
         * SINCE WITH THE HELP OF TOPO WE KNOW WHAT THE NEXT NODE IS TO BE FROM SOURCE SO AND FOR THE ABOVE COMPLEXITY
         * REASON WE USE THIS ALGO.
         */
    }
}
