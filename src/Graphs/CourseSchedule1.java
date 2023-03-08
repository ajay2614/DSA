package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule1 {

    /**
     * TC AND SC SAME AS TOPO SORT
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
        int cnt = 0;
        while(!q.isEmpty()) {
            int ele = q.poll();
            cnt++;

            for(int i : adj.get(ele)) {
                ind[i]--;
                if(ind[i] == 0)
                    q.offer(i);
            }
        }

        return cnt == numCourses;
    }
    public static void main(String[] args) {

        /**
         * THE QUESTION STATES THAT THERE ARE COURSES FOR EG 1->0, THIS MEANS TO TAKE COURSE 1 WE SHOULD HAVE FINISHED COURSE 0
         * AS WE KNOW USING TOPOSORT WE CAN SORT A GRAPH BASED ON ITS INDEGREE, SO WE WILL SIMPLY USE THIS
         * ONLY CHANGE WILL BE HERE 0TH INDEX SHOULD BE COMPLETED AFTER 1ST INDEX MEANS 1->0, BUT WE NEED TO SORT BASED ON INDE
         * GREE SO WE WILL SIMPLY ADD AS ABOVE IN WHILE MAKING ADJ LIST
         *
         *
         */
    }
}
