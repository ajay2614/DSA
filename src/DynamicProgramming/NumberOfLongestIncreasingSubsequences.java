package DynamicProgramming;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequences {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(count,1);

        int max = 1;

        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    count[i] = count[j];
                }
                else if(nums[i] > nums[j] && dp[i] == dp[j] + 1)
                    count[i] += count[j];
            }

            max = Math.max(dp[i], max);
        }

        int ans = 0;
        for(int i=0;i<n;i++) {
            if(max == dp[i]) {
                ans += count[i];
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        /*
        QUESTION ASKED US TO FIND NUMBER OF LIS

        STEPS

        SINCE WE KNOW FOR LIS IN THE FOR LOOP DP(I) < DP(J) + 1 IS USED TO TELL WHETHER THE CURRENT NUMBER ON J WAS
        PART OF INCREASING SUBSEQUENCE OR NOT

        FOR GETTING NUMBER OF LIS

        WE WILL USE A COUNT ARRAY, INITIALLY WE INITALIZE IT TO 1, AS EVERY ARRAY ELEMENT HAS ATLEAST LIS 1

        IN THE FOR LOOP WHICH CHECKS AND IF IT IS INSERTS IN DP LIS,  DP(I) < DP(J) + 1 && ARR[I] > ARR[J]
        CONDITION WE ADD COUNT[I] = COUNT[J], THIS IS USED TO GET US COUNT FOR THAT PARTICULAR J INDEX ELEMENT

        ANOTHER FOR STATEMENT WE ADD IS DP[I] == 1 + DP[J] && ARR[I] > ARR[J]

        WHY DP[I] == 1 + DP[J] ?

        BECAUSE SUPPOSE A CASE OF ARRAY 1 5 4 6

        WHEN WE COME ACROSS 6 AS OF I AND 5 AS OF J, DP[I] = 2(MEANING LENGTH OF 2), NOW WHEN WE COME ACROSS 4
        LIS CASE FAIL AS 4 WASNT PART OF INCREASING SUBSEQUENCE, BUT SINCE DP[I] = 3 == DP[J] + 1, SUGGESTING
        WE FOUND ANOTHER ELEMENT FORM SUBSEQUENCE OF LENGTH 3, HENCE WE INCREMENT COUNT[I] += COUNT[J].
        USE A MAX FOR MAX LENGTH

        INT THE END INIT A VARIABLE COUNT = 0;

        AND CHECK FOR MAX LENGTH, IF DP[I] = MAXLENGTH, VARIABLE COUNT += COUNT[I], THIS GIVES US TOTAL COUNT,
        THIS IS USED BECAUSE IT CAN HAPPEN ELEMENTS AT DIFF INDEXES, ARE FORMING LIS OF SAME LENGTH, SO TO FIND
        TOTAL COUNT.

        */
        int arr[] = {1,5,4,3,2,6,7};

        System.out.println(findNumberOfLIS(arr));

    }
}
