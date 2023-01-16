package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BfsOfAGraph {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        ArrayList<Integer> ans = new ArrayList<>();
        int vis[] = new int[V];
        vis[0] = 1;
        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for(int i : adj.get(node)) {
                if(vis[i] == 0) {
                    vis[i] = 1;
                    q.offer(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * THE FOLLOWING PROGRAM IS USED TO FIND THE BFS OF AN UNDIRECTED GRAPH, WE WILL USE A QUEUE FOR THIS PROCESS, WE WILL
         * INSERT THE STARTING NODE IN THE QUEUE, NOW MARK IT AND RUN WHILE LOOP TILL QUEUE IS EMPTY, ADD THE NODE IN ANS DS AND THEN
         * TRAVERSE FOR EVERY OF ADJACENT NODES WHICH ARE UNVISITED AND MARK THEM VISITED AND ADD IN QUEUE.
         */
    }
}
