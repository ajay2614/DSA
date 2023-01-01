package Graphs;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> ans  = new ArrayList<>();

        if(graph.length == 0 || graph[0].length == 0)
            return ans;

        int target = graph.length - 1;
        int src = 0;

        dfs(ans, new ArrayList<>(), src, target, graph);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> a, int src, int target, int[][] graph) {
        if(src == 0) {
            a.add(src);
        }
        if(src == target) {
            ans.add(new ArrayList<>(a));
            return;
        }

        for(int i : graph[src]) {
            a.add(i);
            dfs(ans, a, i, target, graph);
            a.remove(a.size()-1);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};

        System.out.println(graph.length);
        System.out.println(graph[0].length);
    }
}
