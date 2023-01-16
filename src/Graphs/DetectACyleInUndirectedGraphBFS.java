package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pairgraph {
    int par;
    int chi;

    Pairgraph(int par, int chi) {
        this.par = par;
        this.chi = chi;
    }
}
public class DetectACyleInUndirectedGraphBFS {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];

        for(int i=0;i<V;i++) {
            if(vis[i] == 0) {
                if(cycle(vis, i, adj))
                    return true;
            }
        }
        return false;
    }

    public boolean cycle(int[] vis, int src, ArrayList<ArrayList<Integer>> adj) {
        Queue<Pairgraph> q = new LinkedList<>();
        q.offer(new Pairgraph(-1, src));
        vis[src] = 1;
        while(!q.isEmpty()) {
            Pairgraph p = q.poll();
            int parent = p.par;
            int child = p.chi;

            for(int i : adj.get(child)) {
                if(vis[i] == 0) {
                    q.offer(new Pairgraph(child, i));
                    vis[i] = 1;
                }
                else if(i != parent)
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         *
         * THE FOLLOWING PROGRAM IS USED TO CHECK IF THERE EXISTS A CYCLE OR NOT IN A UNDIRECTED GRAPH, WE WILL USE BFS HERE
         *
         * NOW IT COULD HAPPEN THAT THE GRAPH HAS CONNECTED COMPONENTS, SO THAT IS WHY WE WILL NOT USE THE DIRECT BFS IMPLEMENTATION
         * OVER HERE, WE WILL CHECK FOR EVERY NODE IF ITS VISITED NOT, IF NOT CALL BFS ON THAT, HAVE ITS PARENT AS -1
         * NOW USE WHILE TILL Q IS EMPTY, IF ADD EVERY ADJACENT NODE IF NOT VISITED, IF VISITED THAT MEANS IT CAN EITHER BE PARENT,
         * BECAUSE IT CAME FROM THERE, OR THE NODE WHICH HAS ALREADY BEEN COVERED PREVIOUSLY MEANING IT IS CREATING A CYCLE,
         * IF THAT'S THE CASE RETURN TRUE.
         *
         * NOW IN THE PARENT METHOD LOOP IF CYCLE COMES OUT TO BE TRUE IN CASE OF ANY NODE RETURN TRUE.
         *
         */
    }
}
