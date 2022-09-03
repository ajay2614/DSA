package Graphs;

import java.util.*;

class EdgePair {
    int u;
    int v;
    int weight;


    public EdgePair() {}
    public EdgePair(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public int getV() {
        return v;
    }

    public int getWeight() {
        return weight;
    }
}
public class KruskalsAlgo {
    public static int findParent(int u, int parent[]) {
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u], parent);
    }
    public static void union(int u, int v, int parent[], int rank[]) {
        if(rank[u] > rank[v]) {
            parent[v] = u;
        }
        else if(rank[v] > rank[u]) {
            parent[u] = v;
        }
        else {
            parent[v] = u;
            rank[u]++;
        }
    }
    public static void kruskalAlgo(ArrayList<EdgePair> adj, int V) {
        Collections.sort(adj, new Comparator<EdgePair>() {
            @Override
            public int compare(EdgePair o1, EdgePair o2) {
                int w1 = o1.getWeight();
                int w2 = o2.getWeight();

                if(w1 > w2)
                    return 1;
                if (w2 > w1)
                    return -1;
                return 0;
            }
        });

        int parent[] = new int[V];
        int rank[] = new int[V];
        Arrays.fill(rank, 0);
        for(int i=0;i<V;i++){
            parent[i]= i;
        }

        int costMst = 0;
        ArrayList<EdgePair> mst = new ArrayList<>();

        for(EdgePair it : adj) {
            if(findParent(it.getU(), parent) != findParent(it.getV(), parent)) {
                costMst += it.getWeight();
                mst.add(it);
                union(it.getU(),it.getV(), parent, rank);
            }
        }

        System.out.print("Total Cost -> " + costMst);
        System.out.println();
        for (EdgePair it : mst) {
            System.out.println("U -> " + it.getU() + "  V -> " + it.getV() + "  Weight -> " + it.getWeight());
        }

    }
    public static void main(String[] args) {
        int n = 5;
        ArrayList<EdgePair> adj = new ArrayList<EdgePair>();


        adj.add(new EdgePair(0, 1, 2));
        adj.add(new EdgePair(0, 3, 6));
        adj.add(new EdgePair(1, 3, 8));
        adj.add(new EdgePair(1, 2, 3));
        adj.add(new EdgePair(1, 4, 5));
        adj.add(new EdgePair(2, 4, 7));
        kruskalAlgo(adj, n);

    }

}
