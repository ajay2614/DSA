package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindEventualSafeStatesUsingCycleDetection {
    private boolean dfsCheck(int[] vis, int pathVis[], int node, List<Integer> ans , int[][] graph) {
        vis[node] = 1;
        pathVis[node] = 1;

        for(int i : graph[node]) {
            if(vis[i] == 0) {
                if(dfsCheck(vis, pathVis, i, ans, graph))
                    return true;
            }
            else if(pathVis[i] == 1)
                return true;
        }
        ans.add(node);
        pathVis[node] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int vis[] = new int[n];
        int pathVis[] = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<n;i++) {
            if(vis[i] == 0) {
                dfsCheck(vis, pathVis, i, ans, graph);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
