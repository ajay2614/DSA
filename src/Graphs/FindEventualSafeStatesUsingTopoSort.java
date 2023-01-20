package Graphs;

import java.util.*;

public class FindEventualSafeStatesUsingTopoSort {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        int n = graph.length;
        for(int i=0;i<n;i++) {
            arr.add(new ArrayList<>());
        }
        /**
         REVERSING GRAPH
         */
        int[] indegree = new int[n];
        for(int i=0;i<n;i++) {
            for(int it : graph[i]) {
                arr.get(it).add(i);
                /**
                DOING THIS STEP BECAUSE WE HAVE TO GET INDEGREE OF EVERY NODE
                AS I IS EMERGING FROM A, IT MAY SEEM LIKE OUTDEGREE, BUT SINCE WE
                ARE REQUIRING THE INDEGREE FOR THE REVERSE GRAPH HENCE THIS IS
                TAKEN AS INDEGREE.
                */
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++) {
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for(int i: arr.get(node)) {
                indegree[i]--;
                if(indegree[i] == 0)
                    q.offer(i);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
