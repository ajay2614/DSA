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

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO RETURN ALL THE SAFE NODES
         * SAFE NODES ARE THOSE IN WHICH EVERY POSSIBLE PATH MUST LEAD TO A TERMINAL NODE
         * A TERMINAL NODE IS THAT WHICH HAS 0 OUTDEGREE
         *
         * APART FROM USING CYCLE DETECTION METHOD WE CAN ALSO USE THIS WAY USING TOPO SORT
         *
         * NOW TOPO SORT SORTS ON THE BASIS THE INDEGREE, SINCE THE TERMINAL WOULD HAVE BEEN PLACED IN THE LAST SECTION
         * IN TOPO SORT AS IT WILL HAVE 0 OUTDEGREE, SO TO GET ALL THE NODES WE WILL REVERSE THE DIRECTIONS IN GRAPH
         * IN THIS WAY WE CAN GET THE TERMINAL NODE FIRST AS NOW IT WILL BE HAVING INDEGREE 0, WITH THIS WE CAN GET ALL THE
         * SAFE NODES BY SIMPLY USING Q AND THE CONCEPT OF TOPO SORT, AS SOON AS THE NODES INDEGREE WILL BECOME 0 IT WILL
         * BE ADDED IN QUEUE AND HENCE IN ANSWER, SINCE NODES IN CYCLIC PATH CAN'T BE INVOLVED IN TOPO SORT, IT WILL
         * NOT INCLUDE ANY NODE FROM CYCLIC PATH.
         *
         * IF THIS WILL ENCOUNTER CYCLE IT WILL NEVER PUSH IT IN Q AS INDEGREE WILL NOT BE 0
         *
         */
    }
}
