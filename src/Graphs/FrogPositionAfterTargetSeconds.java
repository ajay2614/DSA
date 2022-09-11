package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * QUESTION
 * Given an undirected tree consisting of n vertices numbered from 1 to n. A frog starts jumping from vertex 1.
 * In one second, the frog jumps from its current vertex to another unvisited vertex if they are directly connected.
 * The frog can not jump back to a visited vertex. In case the frog can jump to several vertices,
 * it jumps randomly to one of them with the same probability. Otherwise, when the frog can not jump to any unvisited vertex,
 * it jumps forever on the same vertex.
 */
public class FrogPositionAfterTargetSeconds {
    public static double frogPosition(int n, int[][] edges, int t, int target) {

        ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<>();
        if (n == 1) return 1.0;
        for(int i = 0; i <= n ; i++) adjListArray.add(new ArrayList<>());
        for (int[] edge : edges) {
            adjListArray.get(edge[0]).add(edge[1]);
            adjListArray.get(edge[1]).add(edge[0]);
        }

        return dfs(1, t, target, new boolean[n + 1], adjListArray);
    }

    private static double dfs(int node, int t, int target, boolean[] visited, ArrayList<ArrayList<Integer>> adjListArray) {
        if (node != 1 && adjListArray.get(node).size() == 1 || t == 0) {
            if (node == target)
                return 1;
            else return 0;
        }
        visited[node] = true;
        double res = 0.0;
        for (int child : adjListArray.get(node)) {
            if (visited[child]) continue;
            res += dfs(child, t - 1, target, visited, adjListArray);
        }
        if (node != 1)
            return res * 1.0 / (adjListArray.get(node).size() - 1);
        else
            return res * 1.0 / (adjListArray.get(node).size());
    }
    public static void main(String[] args) {
        /**
         * BREAKDOWN OF QUESTION
         *
         * THE QUESTION GIVES US T, THIS T MEANS NUMBER OF SECONDS AFTER WE REACH THE TARGET, ALSO YOU MAY CALL T AS LEVEL
         * EG T IS 2, MEANS OUR TARGET IS AT 2ND LEVEL WHICH IS TRUE FOR BELOW TEST CASE 1->2->4
         * TIME EVALUATION OR RESULT EVALUATION ACCORDING TO QUESTION IS 1 / CHILD IT HAS, SUPPOSE FOR BELOW TEST CASE
         * TARGET IS 4, NOW 1 HAS 3 CHILD SO ANSWER IS 1/3 , GOING FOR 2, IT HAS TARGET AND 2 CHILD, SO WE ONLY
         * MULTIPLY 1/3 WITH 1/2 AS WE DONT NEED TO TRAVEL TO 1s OTHER 2 CHILDREN BECAUSE WE ARLEADY HAVE OUR TARGET.
         *
         * SO BASICALLY THIS QUESTION IS ASKING TOTAL TIME IT WOULD TAKE TO GET THE TARGET AND TIME EVALUATION IS AS
         * DISUCSSED ABOVE.
         *
         * APPROACH AND STEPS
         *
         * FIRST WE WILL ADD ALL THE ELEMENTS IN ARRLIST OF ARRLIST, AS IT UNDIRECTED GRAPH WE WILL ADD BOTH PARENT NODE
         * FOR CHILD LIST AND CHILD NODE FOR PARENT LIST
         *
         * WE WILL USE DFS APPROACH, WE WILL ALSO USE VISITED ARRAY,
         *
         * FIRST EDGE CASE WE USE IS TO CHECK IF T==0 OR ARRAYLIST.SIZE == 1 AND THIS IS ONLY NODE !=1 AS IT CAN HAPPEN
         * NODE HAS SAY 1 SIZE, EG 1->2 AND 2-> 3 AND 4 AND 4 IS TARGET, OUR ANSWER WOULD GET ERROR SO TO AVOID IT,
         * WHY ARRAYLIST.SIZE == 1, AS FROM BELOW 7 DOESNT HAVE ANY CHILD, IT WILL ONLY HAVE PARENT 1, HENCE ITS SIZE IS 1,
         * WE WOULD NEED TO CHECK IF ITS THE TARGET BECAUSE HAD WE GONE INSIDE IT WOULD HAVE RETURN 0 AS IT DOESNT HAVE ANY CHILD,
         * WHY T==0, AS QUESTION STATES, IF WE GET T=0 WE NEED TO CHECK IF IF WE HAVE OUR TARGET, BECAUSE QUESTION STATES OUR
         * TARGET EXISTS AT T LEVEL OR T TIME , WE RETURN 1 IF WE HAVE OUR TARGET, ELSE 0
         *
         * AFTER THIS WE MARK CURRENT INDEX ON VISITED AS 1.
         * WE RUN LOOP TO CHECK ALL ITS CHILD NODES, AND EVALUATE ANSWER,
         *
         * REMEMBER WHILE RETURN ANSWER RETURN RES * 1 /ADJ.GETSIZE(IND); ONLY IF NODE IS 1, ELSE RES * 1/ADJ.GETSIZE(IND) -1.
         *
         * WHY ABOVE STATEMENT, BECAUSE AS NODE 1 DOESNT HAVE A PARENT, IT IS ONLY STORING CHILD, WHILE RETURNING ANSWER OF ANY
         * CHILD WE ARE ALSO HAVING PARENT IN THAT LIST, AND WE DONT NEED TO ADD PARENT ATQ, FOR EG FOR BELOW 2 WOULD BE HAVING
         * 1 4 & 6 IN ITS LIST, TIME EVALUATION OF 2 SHOULD BE 1 * 1/2 FOR 2 AS IT HAS 2 NODES.
         */
        int edges[][] = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        int t = 2, target = 4;
        int n=7;

        frogPosition(n,edges,t,target);
    }
}
