package Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslands2 {
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet disjointSet = new DisjointSet(rows * cols);
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        int[][] vis = new int[rows][cols];

        for(int[] operator : operators) {
            int r = operator[0];
            int c = operator[1];

            if(vis[r][c] == 1) {
                ans.add(cnt);
                continue;
            }

            vis[r][c] = 1;
            cnt++;
            int di[] = {1,0,-1,0};
            int dj[] = {0,-1,0,1};

            for(int i=0;i<4;i++) {
                int nRow = r + di[i];
                int nCol = c + dj[i];

                if(nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && vis[nRow][nCol] == 1) {
                    int adjNode = r * cols + c;
                    int adjNthNode = nRow * cols + nCol;

                    if(disjointSet.findUPar(adjNode) != disjointSet.findUPar(adjNthNode)) {
                        disjointSet.unionByRank(adjNode, adjNthNode);
                        cnt--;
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[][] = {{1,1},{0,1},{3,3},{3,4}};
        int n = 4;
        int m = 5;
        NumberOfIslands2 islands2 = new NumberOfIslands2();
        islands2.numOfIslands(n,m,arr);
    }
}
