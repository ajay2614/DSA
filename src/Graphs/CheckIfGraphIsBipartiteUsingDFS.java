package Graphs;

public class CheckIfGraphIsBipartiteUsingDFS {
    /**
     * TC AND SC SAME AS DFS
     * EXPLAINED IN CHECK USING BFS, ONLY APPROACH IS DFS HERE
     */
    private boolean dfs(int c, int src, int[] col, int graph[][]) {
        col[src] = c;


        for(int i : graph[src]) {
            if(col[i] == 0) {
                if(!dfs((c == 1 ? 2 : 1), i, col, graph))
                    return false;
            }
            else if(col[i] == c)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int col[] = new int[graph.length];

        for(int i=0;i<graph.length;i++) {
            if(col[i] == 0) {
                if(!dfs(1, i, col, graph))
                    return false;
            }
        }
        return true;
    }
}
