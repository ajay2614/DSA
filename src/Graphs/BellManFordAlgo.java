package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class BellManFordAlgo {
    /**
    ANOTHER ALGO WHICH FINDS SHORTEST DISTANCE BETWEEN EdgePairS
    WHY TO USE THIS ALGO WHEN WE HAVE DIJKSTRAS ALGO
    BECAUSE THIS ALGO HELPS US TO EVEN HAVE NEGETIVE EDGES IN GRAPH
    THOUGH IT CANNOT WORK FIND NEGETIVE CYCLE BUT IT DOES HELP US TO DETECT IT

    STEPS
    1. RELAX ALL EDGES FOR N-1 TIMES, MEANS FOR EVERY ITERATION CHECK IF A SHORTER DIST EXISTS
    2. FOR Nth TIME CHECK AGAIN IF THERE IS ANY RELAXATION, THAT MEANS WE HAVE A NEGETIVE CYCLE IN GRAPH
     */

    public static void bellmanFord(ArrayList<EdgePair> adj, int distance[], int n) {

        for (int i=1;i<=n-1;i++){
            for (EdgePair edgePair : adj) {
                int u = edgePair.getU();
                int v = edgePair.getV();
                int w = edgePair.getWeight();
                if (distance[u] + w < distance[v])
                    distance[v] = distance[u] + w;
            }
        }


        boolean flag = false;
        for (EdgePair edgePair : adj) {
            int u = edgePair.getU();
            int v = edgePair.getV();
            int w = edgePair.getWeight();
            if (distance[u] + w < distance[v]) {
                System.out.println("NEGETIVE CYCLE");
                flag = true;
                break;
            }
        }

        if (!flag) {
            for (int i = 0; i < n; i++) {
                System.out.print(distance[i] + " ");
            }
        }
    }
    public static void main(String args[]) {
        int n = 6;

        //EDGE PAIR DEFINED IN KRUSKALS ALGO CLASS

        ArrayList<EdgePair> adj = new ArrayList<>();

        int distance[] = new int[n];

        //REMEMBER, NOT TO TAKE INTEGER.MAX HERE BECAUSE ON ADDITION WITH WEIGHT IT WILL GO INTO MINUS

        Arrays.fill(distance, 100000);
        distance[0] = 0;
        adj.add(new EdgePair(3, 2, 6));
        adj.add(new EdgePair(5, 3, 1));
        adj.add(new EdgePair(0, 1, 5));
        adj.add(new EdgePair(1, 5, -3));
        adj.add(new EdgePair(1, 2, -2));
        adj.add(new EdgePair(3, 4, -2));
        adj.add(new EdgePair(2, 4, 3));

        bellmanFord(adj, distance, n);
    }
}
