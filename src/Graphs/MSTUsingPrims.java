package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
class Par {
    int node;
    int wt;

    Par(int node, int wt) {
        this.node = node;
        this.wt = wt;
    }
}
public class MSTUsingPrims {
    static int spanningTree(int V, int E, int edges[][]){

        int vis[] = new int[V];

        ArrayList<ArrayList<Par>> arr = new ArrayList<>();
        for(int i=0;i<V;i++) {
            arr.add(new ArrayList<>());
        }
        /**
         * CONVERSION IS MANDATORY AS THE INPUT ARRAY HAS ONLY ONE SIDE, FO EG 1 2 5, MEANS 1 IS CONNECTED WITH 2 WITH 5 WEIGHT,
         * BUT 2 1 5 IS NOT AVAILABLE.
         */
        for (int a[] : edges) {
            arr.get(a[0]).add(new Par(a[1],a[2]));
            arr.get(a[1]).add(new Par(a[0],a[2]));
        }

        PriorityQueue<Par> pq = new PriorityQueue<>((a, b) -> {
            if(a.wt > b.wt)
                return 1;
            if(a.wt < b.wt)
                return -1;
            return 0;
        });

        pq.add(new Par(0,0));
        int sum = 0;
        while(!pq.isEmpty()) {
            Par pair = pq.poll();
            int wt = pair.wt;
            int node = pair.node;

            if(vis[node] == 1)
                continue;

            sum += wt;
            vis[node] = 1;
           for(Par p : arr.get(node)) {
               int adjW = p.wt;
               int adjN = p.node;

               if(vis[adjN] == 0) {
                   pq.add(new Par(adjN, adjW));
               }
           }
        }
        return sum;
    }

    public static void main(String[] args) {
        int v = 3;
        int e = 3;
        int arr[][] = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        spanningTree(v,e, arr);
    }
}
