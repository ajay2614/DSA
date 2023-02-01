package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class FlightGraph {
    int stops;
    int dis;
    int node;

    public FlightGraph(int stops, int dis, int node) {
        this.stops = stops;
        this.dis = dis;
        this.node = node;
    }
}
public class CheapestFlightsWithinKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Queue<FlightGraph> q = new LinkedList<>();

        q.offer(new FlightGraph(0,0,src));

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int arr[] : flights) {
            adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
        }

        int dist[] = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        while (!q.isEmpty()) {
            FlightGraph flightGraph = q.poll();
            int stops = flightGraph.stops;
            int dis = flightGraph.dis;
            int node = flightGraph.node;

            if(stops > k)
                break;

            for(Pair p : adj.get(node)) {
                if(dis + p.getWeight() < dist[p.getNode()]) {
                    dist[p.getNode()] = dis + p.getWeight();
                    q.offer(new FlightGraph(stops+1, dis + p.getWeight(), p.getNode()));
                }
            }
        }
        if(dist[dst] == (int) 1e9)
            return -1;
        return dist[dst];
    }

    public static void main(String[] args) {
        int flight[][] = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        findCheapestPrice(4, flight, 0, 3, 1);

        /**
         * IN THIS QUESTION WE ARE GIVEN A 2D ARRAY, HAVING EDGE AND EDGE CONNECTED ALONG WITH DISTANCE
         * WE HAVE TO FIND THE MIN DISTANCE FROM SOURCE TO NEIGHBOUR WITHIN K STOPS
         *
         * NOW AS IF WE HAD USED DIJKSTRA USING PQ IN WHICH MIN DISTANCE COMES UP, WE WOULD HAVE COMPLETELY IGNORED THE STOPS
         * SCENARIO WHICH THEN COULD HAVE WRONG ANSWER AS IT WILL THE PQ BY DIST,
         *
         * SO WE WILL USE SIMPLE QUEUE IN THIS, THIS QUEUE WILL HAVE STOPS ONE BY ONE SO NO NEED TO SORT IT AND ONCE
         * WE HAVE REACHED THE STAGE WHERE STOPS HAS INCREASED MORE THAN THE INPUT WE CAN BREAK AND RETURN THE ANSWER.
         *
         * WE WILL START WITH THE SRC NODE IN THE Q, HAVING DISTANCE 0 AND STOPS 0,
         * NOW COMPARE FOR THE DISTANCE OF ITS NEIGHBOURING NODES AND ADD IN THE QUEUE IF DIST IS SMALLER AND IF IT IS WITHIN STOPS
         * LIMIT.
         */

    }
}
