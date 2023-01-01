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
}
