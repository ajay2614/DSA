package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];

        for(int i=n-1;i>=0;i--) {
            for(int j=i-1;j>=-1;j--) {

                int np = dp[i+1][j+1];
                int p = 0;
                if(j==-1 || nums[i] > nums[j])
                    p = 1 + dp[i+1][i+1];

                dp[i][j+1] = Math.max(np,p);
            }
        }
        return dp[0][0];
    }

    public static int lengthOfLISBestSolution(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    public static void lengthofLISBestSolutionAndPrintLIS(int[] nums) {
        int n = nums.length;
        int max = 1;
        /*
        i & j are currentInd and prevInd
         */
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int hash[] = new int[n];

        for(int i=0;i<n;i++) {
            hash[i] = i;
            for(int j=0;j<i;j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    hash[i] = j;
                    max = Math.max(dp[i], max);
                }
            }
        }

        System.out.println("Max Length LIS -> " + max);

        int lastIndex = -1;
        int temp = -1;
        ArrayList<Integer> lisList = new ArrayList<>();

        for (int i=0;i<n;i++) {
            if (dp[i] > temp) {
                temp = dp[i];
                lastIndex = i;
            }
        }

        lisList.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex) {
            lastIndex = hash[lastIndex];
            lisList.add(nums[lastIndex]);
        }
        System.out.println("LIS IS -> ");
        for (int i = lisList.size() - 1; i >= 0; i--) {
            System.out.print(lisList.get(i) + " -> ");
        }

    }

    static int getAnsRecursiveWay(int arr[], int n,  int ind, int prev_index,int[][] dp){

        // base condition
        if(ind == n)
            return 0;

        if(dp[ind][prev_index+1]!=-1)
            return dp[ind][prev_index+1];

        int notTake = 0 + getAnsRecursiveWay(arr,n,ind+1,prev_index,dp);

        int take = 0;

        if(prev_index == -1 || arr[ind] > arr[prev_index]){
            take = 1 + getAnsRecursiveWay(arr,n,ind+1,ind,dp);
        }

        return dp[ind][prev_index+1] = Math.max(notTake,take);
    }


    static int longestIncreasingSubsequenceRecursion(int arr[], int n){

        int dp[][]=new int[n][n+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);

        return getAnsRecursiveWay(arr,n,0,-1,dp);
    }

    public static int lISUsingBinarySearch(int arr[], int n) {

        int lengthArr[] = new int[arr.length];
        int length = 1;
        lengthArr[0] = arr[0];

        for (int i=1;i<n; i++) {
            if(arr[i] <= lengthArr[0])
                lengthArr[0] = arr[i];
            else if(arr[i] > lengthArr[length-1])
                lengthArr[length++] = arr[i];
            else {
                /*
                BINARY SEARCH
                WHY LENGTH - 1, BECAUSE WHILE INSERTING LAST ELELMENT WE USED LENGTH++ HENCE WE NEED TO CHECK FOR 1 LENGTH LESSER
                 */
                lengthArr[binarySearch(0, length - 1, arr[i], lengthArr)] = arr[i];
            }
        }
        return length;
    }

    public static int binarySearch(int l, int r, int key, int arr[]) {
        /*
        WHY R-L > 1
        BECAUSE WE ARE SHRINKING SPACE TILL L & R ARE SEPERATED BY ELEMENTS, EG FOR 2 4 6, AND KEY = 3
        L = 0
        R = 2
        MID = 1

        AS ARR[MID] > KEY, R = 1
        NOW AS R - L > 1, WE RETURN R WHERE PREVIOUSLY 4 WAS AND HENCE REPLACE IT BY KEY 3
         */
        while (r - l > 1) {
            int m = l + (r - l)/2;
            if(arr[m] >= key)
                r = m;
            else
                l = m;
        }
         return r;
    }



    public static void main(String args[]) {
        /*
        RECURSION AND TABU/MEMO APPROACH
        The Question States that we need to find longest increasing subsequence from an array of numbers
        meaning for arr like 1,5,2,9 = 159 will be longest of length 3 - which we have to return
        the first basic approach is recursion, so in recursion
        we will have two options, whether we don't pick and pick, we can only pick if the prev element is smaller
        so for this we will use an index and prev index to keep track of number, now since we can't have prev for
        first we will use -1, hence in terms of recursion we will start as
        f(0-> index, -1 -> prev, arr, n)

        notTake = f(ind + 1, prev, arr, n) Why prev here, since we are not taking this hence index remain prev
        take = f(ind +1, ind, arr, n) only choose when arr[prev] < arr[ind] as it is LIS

        return max(notTake, take).

        now when we use a dp array for tabu or memo, a situation arises, since we have to return dp[0][-1]
        as we know we can't use -1 for array index, hence we will do co-ordinate change for prev, meaning we will
        use n + 1 * n + 1 dp array, for every prev upon time of insertion(not when comparing arr[ind] & arr[prev])
        we will increment by 1.
         */

        /*
        TABU WOULD GIVE TC AS N*N AND SC AS N*N
        BUT THE BEST APPROACH IS EASIER AND GIVES SC N

        HOW TO DO

        1st simply fill answer arr with 1, as every subsequence will atleast give 1.
        simply run a for loop and for every ind i, run loop for comparing array elements till that i using prev ind j,
        example for arr 1,5,6 for 5(ind-1) run till(0-1).
        if(arr[i] > arr[j] && dp[i] < 1 + dp[j])

        why 1 + dp[j] -> 1 because it is adding length and this will help us to choose the max one and not recent one
        as an example
        5, 6, 4, 8
        when choosing for 8, 5 & 6 and 1 will get us length 3, but 4 & 8 would have got 2.
        use max variable to track highest value
        return max.
         */

        /*
        HOW TO PRINT

        USE THE SAME BEST SOLUTION EXCEPT THIS TIME INITIALIZE ANOTHER ARRAY, CALLED HASH ARRAY, WHILE RUNNING THE FOR LOOP FOR I
        PUT HASH[I] = I AND IN THE J LOOP IF STATEMENT ADD THE PREV INDEX AT I INDEX.

        WHY PREV INDEX, BECAUSE WITH THE HELP OF PREVIOUS INDEX WE CAN BACKTRACK TO KNOW WHICH INDEX ELEMENT IS COMING FROM
        WHY HASH[I] = I, BECAUSE WITH THIS IF AN SUBSEQUENCE IS STARTING FROM LET'S SAY 1 WE CAN MATCH THE VALUE IN THE END.

        AFTER DOING ABOVE TWO, GET THE INDEX FOR THE MAX SUBSEQUENCE LENGTH IN DP ARRAY, AFTER THIS INITALIZE AN ARRAY LIST
        AND ADD THE ARR[IND], THE IND IS THE INDEX WE FOUND FROM ABOVE STEP.

        NOW RUN A WHILE LOOP WHICH COMPARES HASH[INDEX] = INDEX, RUN IT TILL THIS CONDITION IS TRUE
        IN THIS DO -> INDEX = HASH[INDEX] AND ADD IN ARRLIST ARR[IND] ELEMENTS.

        WHEN THE LAST INDEX ARRIVES ABOVE STATEMENT GETS TRUE AND WE ADD ALL THE LIS ELEMENTS IN ARRAY LIST,
        FOR EG -> FOR HASH ARRAY OF 0 0 2 3 2, WE GET THE INDEX 4 FROM DP AND AFTER THIS  WE GO
        HASH[4] = 2 -> LAST INDEX BECOMES 2 , LIST ADDS ARR[2]
        HASH[2] = 0 -> LAST INDEX BECOMES 0 , LIST ADDS ARR[0]
        HASH[0] = 0 -> WHILE STATEMENTS GETS TRUE, LOOP BREAKS

        PRINT ARRLIST IN REVERSE AND WE GET OUR ANSWER
         */

        /*
        LIS USING BINARY SEARCH
        THIS IS THE BEST SOLUTION, NOT THE ABOVE ONE, BECAUSE THIS GETS COMPLETED IN BIG O OF NLOGN AND NOT N*N

        STEPS TO DO THIS, FIRST CREATE A TEMP ARRAY, NOW USING THIS ARRAY INITIALIZE TEMP[0] = ARR[0]
        AFTER THIS RUN A FOR LOOP FROM 1 TO N-1

        IF FOUND ANY ELEMENT WHICH IS SMALLER THAN TEMP[0], INIT TEMP[0] WITH THAT ELEMENT
        ELSE IF FOUND ANY ELEMENT WHICH IS GREATER THAN LAST ELEMENT IN THAT ARR, INIT THAT ELEMENT IN THAT ARRAY AT LENGTH + 1 FROM LAST ELEMENT INDEX

        ELSE WHAT WE WILL DO IS RUN A BINARY SEARCH TO CHECK WHERE THAT ELEMENT NEED TO BE INSERTED IN TEMP ARRAY

        AFTER COMPLETION RETURN LENGTH, WHICH WE WERE USING IN A VARIABLE

         */

        int arr[] = {4,10,4,3,8,9};

        lengthofLISBestSolutionAndPrintLIS(arr);

        System.out.println();
        System.out.println(lISUsingBinarySearch(arr, arr.length));
    }
}
