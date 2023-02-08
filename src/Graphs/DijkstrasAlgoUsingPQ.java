package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class PairDijkstra {
    int w;
    int n;

    PairDijkstra(int w, int n) {
        this.w = w;
        this.n = n;
    }
}
public class DijkstrasAlgoUsingPQ {
    /**
     * Time Complexity: O( E log(V) ), Where E = Number of edges and V = Number of Nodes.
     *
     * Space Complexity: O( |E| + |V| ), Where E = Number of edges and V = Number of Nodes.
     */
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {

        ArrayList<ArrayList<PairDijkstra>> adj = new ArrayList<>();

        for (int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0;i<m;i++) {
            adj.get(edges[i][0]).add(new PairDijkstra(edges[i][2], edges[i][1]));
            adj.get(edges[i][1]).add(new PairDijkstra(edges[i][2], edges[i][0]));
        }


        PriorityQueue<PairDijkstra> pq = new PriorityQueue<>( (PairDijkstra a, PairDijkstra b) -> {
            if(a.w > b.w)
                return 1;
            if(a.w < b.w)
                return -1;
            if(a.n > b.n)
                return 1;
            if(a.n < b.n)
                return -1;
            return 0;
        });

        int djk[] = new int[n+1];
        int par[] = new int[n+1];

        for(int i=1;i<=n;i++) {
            djk[i] = Integer.MAX_VALUE;
            par[i] = i;
        }


        djk[1] = 0;
        pq.offer(new PairDijkstra(0,1));

        while(!pq.isEmpty()) {
            PairDijkstra p = pq.poll();
            int weight = p.w;
            int node = p.n;

            for (PairDijkstra nbr : adj.get(node)) {
                int nbrNode = nbr.n;
                int nbrWeight = nbr.w;

                if(nbrWeight + weight < djk[nbrNode]) {
                    djk[nbrNode] = nbrWeight + weight;
                    par[nbrNode] = node;
                    pq.offer(new PairDijkstra(nbrWeight + weight, nbrNode));
                }
            }
        }


        List<Integer> ans = new ArrayList<>();

        if(djk[n] == Integer.MAX_VALUE) {
            ans.add(-1);
            return ans;
        }
        int node = n;
        while (par[node] != node) {
            ans.add(node);
            node = par[node];
        }
        ans.add(1);
        Collections.reverse(ans);
        return ans;
    }

    public static void main(String[] args) {
        /**
         * DIJKSTRAS ALGO IS USED TO FIND SHORTEST PATH BETWEEN SOURCE AND DISTANCE
         *
         * IN THIS WHAT WE HAVE TO DO IS USE A PRIORITY QUEUE, WHY PQ?
         * EVEN THOUGH QUEUE CAN SOLVE THE SAME WE USE PQ BECAUSE IT IS SORT OF A GREEDY APPROACH, IT WILL CHECK THE SMALLEST
         * DISTANCE FIRST AND TAKE IT AS OPPOSE TO QUEUE WHICH WOULD HAVE TAKEN LONGER TOO AND THEN FURTHER THERE FOR WASTING
         * TIME, FOR EG 1 -> 2 -> 3 TAKE DISTANCE 7 AND 1 -> 4 ->3 TAKES 5, A QUEUE WOULD HAVE TAKE 123 PATH TOO AND THEN
         * PATHS FROM THERE TOO EVEN THOUGH THAT CAN BE EASILY AVOIDED USING 143, HENCE WE USE PQ FOR DIJSKTRA, IN CASE OF
         * ONLY UNIT DISTANCE OR CONSTANCE THERE IS NO NEED TO TAKE PQ, AS QUEUE WOULD AUTOMATICALLY HAVE THE SMALLEST FIRST
         *
         * IN THE ABOVE QUESTION WE HAVE TO RETURN THE NODES FROM WHICH IT WILL TRAVEL THE SHORTEST PATH
         * WE FIRST DECLARE PQ OF MIN HEAP AND THEN USE A PARENT ARRAY AND DIST ARRAY COMPARING PARENTS AND MIN DISTANCE
         * RESPECTIVELY, AFTER THE PQ IS EMPTY, WE WILL BE HAVING PARENTS OF EVERY NODE, MEANING NODE FROM WHERE IT COMES
         * SINCE PARENT OF FIRST NODE WAS MARKED AS 0, WE WILL HAVE ALL THE NODES IN LIST USING CONDITION, WHILE
         * PAR[NODE] != NODE, WE WILL ADD IT IN ANS AND SINCE NODES WERE ADDED IN REVERSE SIMPLY REVERSE THE ANS AND
         * RETURN
         */

        /**
         * TIME COMPLEXITY DERIVATION
         *
         * IN THE WORST CASE THE while(!pq.isEmpty()) WILL TAKE BIG O(V) WHERE V IS NUMBER OF VERTEX
         * PairDijkstra p = pq.poll() WILL TAKE LOG(HEAP SIZE)
         * IN THE WORST CASE PairDijkstra nbr : adj.get(node) WILL MEAN THAT WE WILL HAVE TO MULTIPLY
         * WITH V-1 EDGES
         *
         * SO IT WILL BECOME BIG O(V * (LOG(HEAPSIZE) + (LOG(HEAPSIZE) * V - 1))
         * IN WORST CASE EACH NODE WILL PUSH V-1 NODES EVERYTIME IN THE PQ SO TOTAL IS CLOSE TO V^2
         *
         * SIMPLIFYING      BIG O(V * (LOG(V^2) ( 1 * V -1))
         *                  BIG O(V * (2LOGV) * (V))
         *                  BIG O(V^2 * LOGV)
         * NOW TOTAL EDGES IN THE WORST CASE WILL BE EQUIVALENT TO (V-1) * (V), SINCE WORST CASE IS WHEN EACH NODE IS
         * CONNECTED TO V-1 NODES, (V-1) * (V) IS ALMOST EQUIVALENT TO E SO THE COMPLEXITY IS BIG O(E * LOGV)
         *
         *
         */
    }
}
