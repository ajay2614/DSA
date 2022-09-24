package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        if (o1.profit < o2.profit)
            return 1;
        else if(o1.profit > o2.profit)
            return -1;
        return 0;
    }
}
public class JobSequencingProblem {
    /**
     * Time Complexity: O(N log N) + O(N*M).
     * Space Complexity: O(M)
     */
    public static int[] jobScheduling(Job arr[], int n) {
        JobComparator jobComparator = new JobComparator();
        Arrays.sort(arr, jobComparator);

        int maxDeadline = arr[0].deadline;

        for (int i=1;i<n;i++) {
            maxDeadline = Math.max(arr[i].deadline, maxDeadline);
        }

        int deadlines[] = new int[maxDeadline+1];

        Arrays.fill(deadlines, -1);
        int total = 0;
        int num = 0;
        for (int i=0;i<n;i++) {
            int deadline = arr[i].deadline;
            for (int j=deadline;j>0;j--) {
                if(deadlines[j] == -1) {
                    deadlines[j] = arr[i].deadline;
                    total += arr[i].profit;
                    num++;
                    break;
                }
            }
        }
        return new int[]{num, total};
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE ARE GIVEN JOBS WITH PROFITS, AND DEADLINES, WE NEED TO FIND THE MAX PROFIT JOBS
         * WE CAN DO
         *
         * APPROACH
         * AS WE NEED TO FIND THE MAX PROFITS ONE, WE WILL SORT THESE JOBS BASED ON PROFIT
         * AFTER THIS WE WILL FIND MAX DEADLINE, AND CREATE ARRAY OF SIZE MAX DEADLINE+1, AND FILL IT WITH -1
         *
         * AFTER THIS WE WILL RUN A LOOP FOR THE ARRAY, AND RUN A J LOOP FROM DEADLINE OF THAT JOB TILL 1,
         * WHY NOT ZERO, BECAUSE NO JOB HAS DEADLINE OF 0, THAT IS WHY WE HAVE SIZE MAX DEADLINE + 1.
         * FILL THE DEADLINE ARR WITH THE DEADLINE AND INCREASE TOTAL PROFIT AND NUM
         *
         * REASON FOR FOLLOWING THE ABOVE STEPS IS BEACUSE WE EACH DEADLINE START FROM 1 TO THE DEADLINE GIVEN,
         * NOW IF THERE IS -1 IN ARR, MEANS THIS SLOT IS AVAILABLE AND WE CAN DO THE JOB AT THIS SLOT,
         * IN THIS WAY WE WILL BE ABLE TO FIND THE TOTAL PROFIT AND TOTAL NUMBER OF JOBS DONE.
         *
         */
        Job[] jobs = {new Job(1,4,20),new Job(2,1,10),new Job(3,1,40),new Job(4,1,30)};
        jobScheduling(jobs, 4);
    }

}
