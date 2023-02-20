package Graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {

        int mod = (int) 1e9 + 7;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int arr[] : roads) {
            adj.get(arr[0]).add(new Pair(arr[1], arr[2]));
            adj.get(arr[1]).add(new Pair(arr[0], arr[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.offer(new Pair(0,0));

        int dis[] = new int[n];
        int ways[] = new int[n];

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[0] = 0;
        ways[0] = 1;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            for(Pair pair : adj.get(p.node)) {
                if(p.weight + pair.weight < dis[pair.node]) {
                    dis[pair.node] = p.weight + pair.weight;
                    ways[pair.node] = ways[p.node];
                    pq.offer(new Pair(pair.node , dis[pair.node]));
                } else if (p.weight + pair.weight == dis[pair.node]) {
                    ways[pair.node] = (ways[pair.node] + ways[p.node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE TOTAL NUMBER OF WAYS TO REACH THE SHORTEST PATH,
         * THE APPROACH IS THAT WE WILL KEEP DIST ARRAY AND ALSO A NEW WAYS ARRAY TO KEEP TRACK OF WAYS
         *
         * WE WILL USE THE DIJKSTRA ALGO TO FIND THE SHORTEST DISTANCE BETWEEN NODES, NOW WHEN WE WILL
         * GET A SHORTER DISTANCE WE WILL SIMPLY ADD THE WAYS TO REACH THAT NODE = WAYS TAKEN TO REACH PREV NODE
         * FROM WHERE SHORTEST DISTANCE HAS EMERGED, ELSE IF WE SEE THAT DISTANCE TO REACH A NODE FROM PREV NODE IS
         * EQUAL TO THE DISTANCE ARRAY FOR THAT INDEX, IT MEANS FROM SOME OTHER NODE WE HAD ALSO REACHED IN SAME DISTANCE,
         * SO IN THIS CASE ADD THE CURRENT WAYS OF THE NODE AND WAYS FROM THE PREV NODE, SINCE ANS CAN BE BIG WE
         * HAVE TO RETURN IT MODULO GIVEN.
         */
    }
}