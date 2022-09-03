package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {
    public static List<Integer> largestDivisibleSubset(int[] nums) {

        int n = nums.length;
        int dp[] = new int[n];
        int hashArr[] = new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++) {
            hashArr[i] = i;
            for(int j=0;j<i;j++) {
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hashArr[i] = j;
                }
            }
        }

        int answer = -1;
        int lastIndex = -1;

        for(int i=0;i<n;i++) {
            if(answer < dp[i]) {
                answer = dp[i];
                lastIndex = i;
            }
        }
        List<Integer> ansList = new ArrayList<>();
        ansList.add(nums[lastIndex]);
        while(hashArr[lastIndex] != lastIndex) {
            lastIndex = hashArr[lastIndex];
            ansList.add(nums[lastIndex]);
        }

        return ansList;
    }

    public static void main(String args[]) {

        /*
        WHAT THIS QUESTION STATES THAT WE HAVE TO FIND THOSE SUBSETS WHICH ARE DIVISIBLE BY ONE OR OTHER,
        LET'S SAY 2 AND 4, IN THIS 4 IS DIVISIBLE BY 2.

        FIRST WE NEED TO UNDERSTAND THAT SUBSET IN ARRAY [1,3] MEANS 1 IS SUBSET 3 IS SUBSET 1,3 IS SUBSET AND 3,1 IS ALSO SUBSET
        UNLIKE SUBSEQUENCE WE CAN TAKE IT IN ANY ORDER.

        NOW WE HAVE TO FIND AND ALSO PRINT THOSE SUBSETS WHICH ARE DIVISIBLE, TO SOLVE THIS WE WILL USE SAME APPROACH
        LIKE LIS PRINT APPROACH, SAME HASH AND DP ARRAY WILL BE USED TO STORE LENGTH AND INDEXES RESPECTFULLY,

        STEPS
        FIRST SORT THE ARRAY

        THEN USE DP AND HASH ARRAY AND RUN IND AND PREVINDEX LOOP, SAME WAY FROM LIS, ONLY DIFF IN FOR LOOP
        WE WILL USE ARR[J] % ARR[I]

        REASON WHY WE SORT ARRAY, BECAUSE IF ARRAY HAS 16, 8 THEN 16 % 8 != 0 BUT 8%16 == 0, SO THAT WE DON'T MISS
        ANY SUBSET

        WHY WE DON'T USE ARR[IND] > ARR[PREV], AS ARRAY IS SORTED, NO SENSE IN USING

        RETURN ARRAY LIST FROM HASH ARRAY THE SAME WAY AS IN LIS.
         */
        int[] Arr  = {1,16,7,8,4};

        System.out.println("The maximum profit by selling the stock is "+ largestDivisibleSubset(Arr));
    }
}
