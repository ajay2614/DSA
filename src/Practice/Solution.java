package Practice;
import java.util.*;

public class Solution {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] preCount = new int[numCourses];
        for(int i = 0; i<graph.length;i++)graph[i] = new ArrayList<Integer>();
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
            preCount[p[0]]++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0;i<preCount.length;i++){
            if(preCount[i]==0)q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            for(int n : graph[node]){
                preCount[n]--;
                if(preCount[n]==0)q.offer(n);
            }
        }
        for(int num : preCount)if(num>0)return false;
        return true;
    }

    public static void main(String[] args) {

        int num = 2;
        int arr[][] = {{0,1}};
        System.out.println(canFinish(num, arr));
    }
}
