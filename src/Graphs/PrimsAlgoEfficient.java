package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Nodes implements Comparator<Nodes> {

    int weight;
    int vertex;

    Nodes(int vertex, int weight) {
        this.weight = weight;
        this.vertex = vertex;
    }
    Nodes(){}

    public int getWeight() {
        return weight;
    }

    public int getVertex() {
        return vertex;
    }

    @Override
    public int compare(Nodes n1, Nodes n2) {
        int w1 = n1.getWeight();
        int w2 = n2.getWeight();
        if(w1 > w2)
            return 1;
        if (w2 > w1)
            return -1;
        return 0;
    }
}

public class PrimsAlgoEfficient {
    public static void primsAlgo(ArrayList<ArrayList<Nodes>> adj, int n) {
        int[] dist = new int[n];
        int[] parent = new int[n];
        boolean[] vis = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(vis, false);
        PriorityQueue<Nodes> priorityQueue = new PriorityQueue<>(n, new Nodes());
        priorityQueue.add(new Nodes(0,0));

        dist[0] = 0;

        while(!priorityQueue.isEmpty()) {
            Nodes nodes = priorityQueue.poll();
            vis[nodes.getVertex()] = true;
            for(Nodes it : adj.get(nodes.getVertex())) {
                if(!vis[it.getVertex()] && it.getWeight() < dist[it.getVertex()]) {
                    dist[it.getVertex()] = it.getWeight();
                    parent[it.getVertex()] = nodes.getVertex();
                    priorityQueue.add(new Nodes(it.getVertex(), it.getWeight()));
                }
            }
        }

        System.out.print(" ");
        for (int i=1; i < n; i++) {
            System.out.print(parent[i] + " ");
        }


        System.out.println();

        for (int i=0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }


    }
    public static void main(String args[]) {
        int n = 5;
        ArrayList<ArrayList<Nodes>> adj = new ArrayList<ArrayList<Nodes> >();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Nodes>());

        adj.get(0).add(new Nodes(1, 2));
        adj.get(1).add(new Nodes(0, 2));

        adj.get(1).add(new Nodes(2, 3));
        adj.get(2).add(new Nodes(1, 3));

        adj.get(0).add(new Nodes(3, 6));
        adj.get(3).add(new Nodes(0, 6));

        adj.get(1).add(new Nodes(3, 8));
        adj.get(3).add(new Nodes(1, 8));

        adj.get(1).add(new Nodes(4, 5));
        adj.get(4).add(new Nodes(1, 5));

        adj.get(2).add(new Nodes(4, 7));
        adj.get(4).add(new Nodes(2, 7));

        primsAlgo(adj, n);

    }
}
