package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        /**
         * i < numCourses because the prerequisites are having numbers from 0 to numCourses-1
         */
        for(int i=0;i<numCourses;i++) {
            adj.add(new ArrayList<>());
        }

        /**
         * Done because the question states that if a row of 2d array is [0,1], it means that 1 comes before 0
         * or we can say that 1 -> 0, 1 is directed to 0, hence to make graph the right way.
         */

        for(int i=0;i<prerequisites.length;i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int ind[] = new int[numCourses];

        for(int i=0;i<numCourses;i++) {
            for(int it : adj.get(i)) {
                ind[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++) {
            if(ind[i] == 0)
                q.offer(i);
        }
        int ans[] = new int[numCourses];
        int i=0;
        while(!q.isEmpty()) {
            int ele = q.poll();
            ans[i++] = ele;

            for(int it : adj.get(ele)) {
                ind[it]--;
                if(ind[it] == 0)
                    q.offer(it);
            }
        }
        if(i != numCourses)
            return new int[]{};
        return ans;
    }

    public static void main(String[] args) {
        /**
         * SAME AS 1ST PART ONLY DIFFERENCE IS IF IT IS TRUE RETURN ORDER TOO
         */
    }
}
