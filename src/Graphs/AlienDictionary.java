package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    /**
     *
     * Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary, ‘len’ is the length up
     * to the index where the first inequality occurs, K = no. of nodes, and E = no. of edges.
     *
     * Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array, and O(K) for the queue data structure
     * used in BFS(where K = no.of nodes), O(K) for the answer array and O(K) for the adjacency list used in the algorithm.
     */
    private ArrayList<Integer> topoSort(int k, ArrayList<ArrayList<Integer>> adj) {

        int ind[] = new int[k];
        for(ArrayList<Integer> arr : adj) {
            for (Integer i : arr) {
                ind[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<k;i++) {
            if(ind[i] == 0)
                q.offer(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for(Integer i : adj.get(node)) {
                ind[i]--;
                if(ind[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return ans;
    }
    public String findOrder(String [] dict, int N, int K) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<K;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++) {
            String s1 = dict[i];
            String s2 = dict[i+1];
            int l = Math.min(s1.length(), s2.length());
            int j = 0;
            while (j < l && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }
            if(j < l) {
                adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
            }
        }
        ArrayList<Integer> topo = topoSort(K, adj);
        StringBuilder stringBuilder = new StringBuilder("");

        for(Integer i : topo) {
            stringBuilder.append((char) (i + (int) ('a')));
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE GIVEN AN ARRAY OF STRINGS, HAVING WORDS SUCH AS "baa","abcd","abca","cab","cad"
         *
         * THESE ARE SOME RANDOM WORDS IN ALPHABETICAL ORDER FROM ALIEN DICTIONARY
         * WHAT WE CAN SEE HERE IS IF WE COMPARE BAA AND ABCD, B COMES BEFORE A,
         * IF WE COMPARE ABCD AND ABCA, THIS MEANS D COMES BEFORE A AND SO ON
         *
         * HOW TO SOLVE THIS?
         *
         * WHAT WE KNOW IS THAT WE CAN REPRESENT THESE CHARS AS INTEGER BY SUBTRACTING WITH 'a' SO
         * WE WILL COMPARE 1 STRING WITH THE NEXT AND SO ON TILL THERE IS A DIFFERENT CHARACTER AND PLACE THEM IN AN
         * ADJACENCY LIST FOR EG WHEN WE COMPARE baa AND abcd, B COMES BEFORE A, SO POINT 2 -> 1, AFTER CREATING THIS LIST
         * WE WILL SORT THIS LIST USING TOPOLOGICAL SORT
         *
         * AFTER SORTING SIMPLY CONVERT THESE INT BACK TO CHARACTER AND ADD IN STRING
         */
    }
}
