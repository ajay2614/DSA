package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplicationsToReachEnd {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair> queue = new LinkedList<>();

        int dist[] = new int[100000];
        int mod = 100000;

        Arrays.fill(dist, (int) 1e9);
        dist[start] = 0;
        /**
         * WEIGHT IS STEPS
         * NODE IS NUM
         */
        queue.offer(new Pair(start,0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int steps = pair.getWeight();
            int num = pair.getNode();

            for (int i=0;i<arr.length;i++) {
                int newNum = (num * arr[i]) % mod;
                if(newNum == end)
                    return steps + 1;
                /**
                 * CAN ALSO BE WRITTEN AS  if(dist[newNum] == (int) 1e9) AS STEPS WILL ALWAYS BE ONE BY ONE
                 * AND THIS CONDITION WILL ALWAYS BE FALSE EXCEPT FOR THE FIRST TIME.
                 */
                if(steps + 1 < dist[newNum]) {
                    queue.offer(new Pair(newNum, steps+1));
                    dist[newNum] = steps + 1;
                }
            }
        }
        return -1;
    }
}
