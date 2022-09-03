package DynamicProgramming;

import java.util.Arrays;

public class PartitionArrayForMaximumSum {
    public static int recursion(int i, int arr[], int k, int n) {
        if(i==n)
            return 0;
        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int len = 0;
        for(int j=i;j<(Math.min(i+k,n));j++) {
            len++;
            max = Math.max(arr[j], max);
            int sum = ((len * max) + recursion(j+1, arr, k, n));
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public static int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        return recursionMemo(0, arr, k, n, dp);
    }

    public static int recursionMemo(int i, int arr[], int k, int n, int dp[]) {
        if(i==n)
            return 0;
        if(dp[i] != -1)
            return dp[i];

        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int len = 0;
        for(int j=i;j<(Math.min(i+k,n));j++) {
            len++;
            max = Math.max(arr[j], max);
            int sum = ((len * max) + recursionMemo(j+1, arr, k, n, dp));
            maxSum = Math.max(maxSum, sum);
        }
        return dp[i] = maxSum;
    }

    public static int maxSumAfterPartitioningTabu(int[] arr, int k) {
        int n = arr.length;
        int dp[] = new int[n + 1];

        dp[n] = 0;

        for(int i=n-1;i>=0;i--) {
            int max = Integer.MIN_VALUE;
            int maxSum = Integer.MIN_VALUE;
            int len = 0;
            for(int j=i;j<(Math.min(n, i+k));j++) {
                len++;
                max = Math.max(arr[j], max);
                int sum = (len * max) + dp[j+1];
                maxSum = Math.max(maxSum, sum);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        /*
        THE QUESTION STATES THAT WE NEED TO FIND THE MAX SUM, IN ARRAY WHERE WE CAN PARTITION TILL K INDEX, AND
        IN THESE GAPS WE NEED TO GET THE MAX ELEMENTS IN THIS K GAP AND GET ANSWER, EG IF K IS 2 AND IF ARRAY IS 1 7 10 9,
        THE PARTITION WILL BE AMONG 1 7 AND 10 9, AND AMONG THIS WHEN WE SELECT MAX VALUE, IT WOULD BE
        7 FOR 1ST PARTITION AND 10 FOR NEXT, 7 7 10 10, HENCE FINAL ANSWER WOULD BE 34.


        THE APPROACH TO DO IT IN RECURSION, IS TO BREAK INTO SMALLER INDIVIDUAL PARTITION, AND HENCE FIND ANSWER,
        FOR INDIVIDUAL PARTITION AND ADD WITH L * MAX.

        EG FOR

        0 I AND 0 J

        1 * 1 + MAX SUM WE WILL GET FROM RIGHT PARTITION ( 1 & 7 10 9)

        FOR 0 I AND 1 J

        2 * 7 + MAX SUM WE WILL GET FROM RIGHT PARTITION(10 9)

        WE WILL RUN A LOOP INSIDE FUNC, WHICH RUNS FROM I TO I+K, NOTE THAT WE NEED TO USE MATH.MIN(I+K,N)
        IN LOOP, SO THAT I+K DOES NOT PASS N,

        WE NEED LENGTH VARIABLE, MAX VARIABLE, AND MAX SUM VARIABLE,

        WORKING

        AS ITS RECURSION, IT WILL REACH LAST VALUE OF 10 WHEN I IS 3,

        LENGTH VARIABLE WOULD BE 1 FOR THIS CASE AS 9 IS ALONE ONE, ANSWER IT WOULD RETURN IS 10, BASICALLY
        ITS LIKE HAVING ANSWER OF {9}.

        NOW FOR I=2, IT CAN HAVE TWO CONDITIONS, EITHER GO WITH  MAX WOULD BE 10 IN FIRST CASE
        ADDING 10 * 1 + 9(LAST SUB PROBLEM RETURNED ANSWER) OR 10 * 2 (LENGTH IS 2, AND I == N, )
        SO 10 * 2 + 0 = 20, MAX OF THESE 2 IS 20.

        NOW SIMILARLY FOR 7, 7 * 1 + 20 = 27
        OR 10 * 2 + 10 = 30, IT RETURNS 30

        FOR 1 IT IS 1 * 1 + 30
        OR
        7 * 2 + 20 = 34

        HENCE, WE GET OUR ANSWER AS 54.



        --
        TABULATION IS SAME WAY, JUST WE RUN I FROM N-1 TO 0, AND INSTEAD OF PASSING FUNCTION WE USE DP[J+1];

         */

        int arr[] = {1,15,7,9,2,5,10};

        maxSumAfterPartitioning(arr, 3);
        System.out.println(maxSumAfterPartitioning(arr, 2));
    }
}
