package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * CAN ALSO SAY USING KAHN'S ALGO
 * TC AND SC SAME AS TOPO
 */
public class DetectACycleInDirectedGraphUsingBFS {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] ind = new int[V];

        for(int i=0;i<V;i++) {
            for(int it:adj.get(i)) {
                ind[it]++;
            }
        }

        int cnt = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<V;i++) {
            if(ind[i]==0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int e = q.poll();
            cnt++;

            for(int i : adj.get(e)) {
                ind[i]--;
                if(ind[i] == 0) {
                    q.offer(i);
                }
            }
        }

        return cnt != V;
    }

    public static void main(String[] args) {
        /**
         * WE HAVE TO CHECK WHETHER THE GRAPH IS CYCLIC OR NOT, SIMPLY USE TOPO SORT AND COUNT THE EDGES IF TOTAL EDGES
         * FROM TOPO CHECK ARE NOT SAME AS TOTAL GRAPH IS ACYCLIC ELSE CYCLIC.
         */
    }
}
