package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingKahnsAlgo {
    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int ind[] = new int[V];


        for(int i=0;i<V;i++) {
            for(int it : adj.get(i)) {
                ind[it]++;
            }
        }

        int ans[] = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(ind[i] == 0) {
                q.offer(i);
            }
        }
        int i=0;
        while(!q.isEmpty()) {
            int ele = q.poll();
            ans[i++] = ele;

            for(int it : adj.get(ele)) {
                ind[it]--;
                if(ind[it] == 0) {
                    q.offer(it);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * CAN ALSO BE SAID AS THE BFS TOPOLOGICAL SORTING
         *
         * SIMPLY USE AN ARRAY AND GET THE INDEGREE OF EVERY ELEMENT, FOR THIS SIMPLY RUN FOR 0 TO N NODES
         * AND CHECK THEIR ADJACENT, IF ITS ADJACENT MEANS THE DIRECTION IS TOWARDS THAT NODE HENCE INCREASE ITS INDEGREE BY 1
         *
         * GET ALL THE THE ELEMENTS WITH INDEGREE 0 IN QUEUE NOW POP THE ELEMENT AND CHECK FOR THEIR ADJACENT
         * AND DECREASE INDEGREE BY 1 AND IF IT IS 0 THEN PUSH IN QUEUE.
         *
         * ALSO HELPS CHECKING THE CYCLE IN A GRAPH
         */
    }
}
