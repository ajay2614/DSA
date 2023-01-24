package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
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
}
