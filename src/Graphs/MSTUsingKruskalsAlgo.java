package Graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MSTUsingKruskalsAlgo {
    static int spanningTree(int V, int E, int edges[][]){
        DisjointSet disjointSet = new DisjointSet(V+1);
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] > o2[2])
                    return 1;
                if(o1[2] < o2[2])
                    return -1;
                return 0;
            }
        });

        int weight = 0;
        for (int arr[] : edges) {
            if(disjointSet.findUPar(arr[0]) != disjointSet.findUPar(arr[1])) {
                weight += arr[2];
                disjointSet.unionByRank(arr[0], arr[1]);
            }
        }
        return weight;
    }

    public static void main(String[] args) {
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
         * THE KRUSKALS ALGO USES THE DISJOINT SET TO FIND THE MINIMUM SPANNING TREE
         *
         * FIRST WE WILL SORT THE GRAPH BASED ON WEIGHT
         *
         * NOW SIMPLY COMPARE ONE EDGE OF GRAPH WITH THE ANOTHER, FROM MY UNDERSTANDING SINCE IN THIS UNDIRECTED GRAPH
         * WE ARE COMPARING EDGE BY EDGE, WHETHER THE NODE IS ALREADY SHARING ULTIMATE PARENT WITH OTHER NODE IN AN EDGE
         * WE DON'T NEED TO CREATE A NEW ADJACENCY ARRAY IN WHICH WE ARE DIRECTED SAY EDGE FROM 1->2 AND 2->1, AS
         * WHEN WE WILL COMPARE THE EDGE OF 1 AND 2, WE WILL CHECK IF BOTH ALREADY BELONG TO SAME PARENT OR NOT.
         *
         * EG O->1 WITH WIEGHT 5, 1->2 WITH WEIGHT 3 AND O->2 WITH WEIGHT 1
         *
         * AFTER SORTING VIA WEIGHT WE WILL HAVE 0->2, 1->2, 0->1
         *
         * NOW COMPARE EDGE 1, CHECK IF 0 OR 2 HAVE SAME PARENT, SINCE THEY DON'T HAVE UNITE THEM, NOW 2 PARENT IS 0
         * USING DISJOINT SET, NOW COMPARE 1 AND 2 WHICH IS NEXT EDGE, SINCE 1 PARENT IS ITSELF AND 2 PARENT IS 0, MEANS
         * THIS EDGE CAN ALSO BE ADDED, NOW FOR 0 AND 1, 1 PARENT IS ALREADY 0 SO THIS EDGE CAN'T BE ADDED.
         *
         * ANOTHER THING TO NOTICE IS THAT IF ONE NODE IS ALREADY LINKED WITH OTHER NODE, IT CANNOT BE LINKED AGAIN WITH
         * SOME OTHER AND FORM CYCLE
         *
         * FOR EG 1->2 AND 0->1 THEN O CANNOT CONNECT TO 2 AND FORM CYCLE.
         */
    }

}
