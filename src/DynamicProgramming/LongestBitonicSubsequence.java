package DynamicProgramming;

import java.util.Arrays;

public class LongestBitonicSubsequence {

    public static int longestBitonicSequence(int[] nums, int n) {
        int Lis[] = new int[n];
        Arrays.fill(Lis, 1);
        int Lds[] = new int[n];
        Arrays.fill(Lds, 1);

        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && Lis[i] < Lis[j] + 1)
                    Lis[i] = Lis[j] + 1;
            }
        }

        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>i;j--) {
                if(nums[i] > nums[j] && Lds[i] < Lds[j] + 1)
                    Lds[i] = Lds[j] + 1;
            }
        }
        int max = 0;

        for(int i=0;i<n;i++) {
            max = Math.max(max, Lis[i] + Lds[i] - 1);
        }

        return max;
    }

    public static int minimumMountainRemovals(int[] nums) {

        int n = nums.length;
        int Lis[] = new int[n];
        Arrays.fill(Lis, 1);
        int Lds[] = new int[n];
        Arrays.fill(Lds, 1);

        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && Lis[i] < Lis[j] + 1)
                    Lis[i] = Lis[j] + 1;
            }
        }

        for(int i=n-1;i>=0;i--) {
            for(int j=n-1;j>i;j--) {
                if(nums[i] > nums[j] && Lds[i] < Lds[j] + 1)
                    Lds[i] = Lds[j] + 1;
            }
        }
        int max = 0;

        for(int i=0;i<n;i++) {
            if(Lis[i] > 1 && Lds[i] > 1)
                max = Math.max(max, Lis[i] + Lds[i] - 1);
        }

        return n - max;
    }

    public static void main(String args[]) {

        /*
        QUESTION ASKS TO FIND LONGEST BITONIC SUBSEQUENCE, WHAT BITONIC SUBSEQUENCE IS THE ELEMENTS FIRST STRICTLY INCREASE,
        THEN STRICTLY DECREASE, WE NEED TO FIND MAX LENGTH OF THESE

        NOW LONGEST BITONIC SUBSEQUENCE CAN ALSO BE LONGEST INCREASING SUBSEQUENCE OR LONGEST DECREASING SUBSEQUENCE

        STEPS TO FIND LBS ARE --

        FIRST FIND THE LIS

        THEN FIND LDS - TO FIND LDS SIMPLY START INDEX FROM BACKWORDS RATHER THAN FORWARD LIKE LIS, OTHERWISE EVERYTHING IS SAME

        EVENTUALLY TRAVERSE THROUGH BOTH LIS AND LDS ARRAY ADDING VALUES OF LIS[IND] & LDS[IND] AND SUBTRACT 1

        WHY SUBTRACT BECAUSE LETS SAY INDEX 3 HAS LIS 2 & LDS 3 THEN THAT LIS AND LDS FOR THAT INDEX WOULD BE ADDING LENGTH OF THAT
        INDEX TWICE SO SUBTRACT 1, AND COMPUTE FOR MAX.
         */

        /*
        NOTE --

        QUESTION ON LEETCODE -> Minimum Number of Removals to Make Mountain Array

        THIS QUESTION FOLLOWS SAME APPROACH AS OF LBS

        THE ONLY DIFF IS IN THIS WE NEED TO DO TWO THINGS

        FIRST IS THAT THIS QUESTION DOESN'T ALLOW STRICTLY LIS OR LDS AS ANSWERS

        SO TO MAKE SURE WE ARE TAKING A STRICTLY INCREASING THEN DECREASING WE NEED TO USE IF LOOP
        WHILE COMPUTING MAX, IF(LIS[I] > 1 && LDS[I] > 1) ONLY THEN COMPUTE MAX

        ALSO, FINAL ANS WOULD BE ARR.LENGTH - MAX WHICH IS ANSWER TO FIND MIN NUMBERS TO FIND MOUNTAIN ARRAY.
         */
        int arr[] = {4,10,4,3,8,9};

        System.out.println(longestBitonicSequence(arr, arr.length));
    }
}
