package Graphs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Node implements Comparator<Node> {

    int weight;
    int vertex;

    Node(int vertex, int weight) {
        this.weight = weight;
        this.vertex = vertex;
    }
    Node(){}

    public int getWeight() {
        return weight;
    }

    public int getVertex() {
        return vertex;
    }

    @Override
    public int compare(Node n1, Node n2) {
        int w1 = n1.getWeight();
        int w2 = n2.getWeight();
        if(w1 > w2)
            return 1;
        if (w2 > w1)
            return -1;
        return 0;
    }
}
public class DijakstrasAlgoForShortestPathInUndirectedGraph {
    public static void shortestPath(int s, ArrayList<ArrayList<Node>> adj, int V) {

        int dist[] = new int[V];
        Arrays.fill(dist,100000);
        PriorityQueue<Node> pq = new PriorityQueue<>(V, new Node());
        pq.add(new Node(s,0));
        dist[s] = 0;

        while (pq.size()>0) {
            Node node = pq.poll();
            for(Node it : adj.get(node.getVertex())) {
                if(dist[node.getVertex()] + it.getWeight() < dist[it.getVertex()]) {
                    dist[it.getVertex()] = dist[node.getVertex()] + it.getWeight();
                    pq.add(new Node(it.getVertex(), dist[it.getVertex()]));
                }
            }
        }

        for (int i:dist) {
            System.out.println(i + " ");
        }
    }
    public static void main(String[] args) throws IOException {
        int n = 5;
        ArrayList<ArrayList<Node>> adj= new ArrayList<>();
        for (int i = 0; i < n ;i ++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(new Node(1, 2));
        adj.get(1).add(new Node(0, 2));

        adj.get(1).add(new Node(2, 4));
        adj.get(2).add(new Node(1, 4));

        adj.get(0).add(new Node(3, 1));
        adj.get(3).add(new Node(0, 1));

        adj.get(3).add(new Node(2, 3));
        adj.get(2).add(new Node(3, 3));

        adj.get(1).add(new Node(4, 5));
        adj.get(4).add(new Node(1, 5));

        adj.get(2).add(new Node(4, 1));
        adj.get(4).add(new Node(2, 1));

        shortestPath(0, adj, n);
    }

}
