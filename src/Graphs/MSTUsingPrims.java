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

        /**
         * GIVEN AN UNDIRECTED GRAPH WE NEED TO FIND THE MST FOR THAT GRAPH
         *
         * SPANNING TREE DEFINITION
         * A tree in which we have n nodes and n-1 edges and all nodes are reachable from each other.
         *
         * MST DEFINITION
         * A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected,
         * edge-weighted undirected graph that connects all the vertices together, without any cycles and with the
         * minimum possible total edge weight.
         *
         * IN PRIMS ALGORITHM WE USE A PRIORITY QUEUE WHICH WILL SORT BASED ON THE DISTANCE AND VISTIED ARRAY TO CHECK
         * IF NODE IS REPEATING OR NOT
         *
         * FIRST DEFINE PQ WHICH SORTS BASIS OF WEIGHT
         *
         * NOW START FROM 0TH NODE, GET ADJACENT NODES OF 0 AND ADD THEM IN PQ IF THEIR DISTANCE IS 0
         *
         * NOW ON THE BASIS OF PQ GET THE SMALLEST WEIGHT NODE AND MARK IT VISITED, THE REASON WHY WE MARK IT VISITED
         * OUTSIDE AND NOT INSIDE WHILE ADDING IN PQ IS THAT SUPPOSE 0 HAS NEIGHBOURING EDGE 1 WITH DIST 4 AND 2 WITH DIST 2
         * NOW 2 IS ALSO CONNECTED TO 1 WITH DISTANCE 1, SO IF WE ADD IT IN PQ,WE WILL SURELY GET THE DIST 1 NODE 1 AS PQ
         * WILL SORT, IF DONE OTHERWISE WE WOULD HAVE GOTTEN WRONG ANSWER.
         */
    }
}
