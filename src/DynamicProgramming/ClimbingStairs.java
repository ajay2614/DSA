package DynamicProgramming;

public class ClimbingStairs {


    public static int countDistinctWayToClimbStair(long nStairs) {
        // Write your code here.
        int prevToPrev = 1;
        int prev = 1;
        int mod = 1000000007;
        //Using mod here because int value can exceed Integer.MAX

        for(long i=2; i<=nStairs; i++){
            int cur_i = (prevToPrev + prev) % mod;
            prevToPrev = prev;
            prev= cur_i;
            System.out.println(prev);
        }

        return prev;
    }
    public static void main(String[] args) {
        /*
        Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the
        “Nth” stair. At a time we can climb either one or two steps. We need to return the total number of
        distinct ways to reach from 0th to Nth stair.
         */

        /*
        This problem is same as Fibonacci Series
         */

        int value = countDistinctWayToClimbStair(5l);
        System.out.println(value);
    }
}
