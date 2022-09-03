package DynamicProgramming;

public class MaxCostForBurstBalloons {

    public static int maxCoinsRecursive(int[] nums) {
        int n = nums.length;

        int temp[] = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;

        for(int i=1;i<n+1;i++) {
            temp[i] = nums[i-1];
        }

        int dp[][] = new int[n+1][n+1];

        for(int i=0;i<=n;i++) {
            for(int j=0;j<=n;j++) {
                dp[i][j] = -1;
            }
        }

        return recursiveWayMemo(temp, 1, n, dp);
    }

    static int recursiveWayMemo(int arr[], int i, int j, int[][] dp) {

        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int max = Integer.MIN_VALUE;

        for(int k=i;k<=j;k++) {
            /*
            l m r are just for tracking purpose
             */
            int l = arr[i-1];
            int m = arr[k];
            int r = arr[j+1];

            int coins = arr[i-1] * arr[k] * arr[j+1] +
                    recursiveWayMemo(arr, i, k-1, dp) +
                    recursiveWayMemo(arr, k+1, j, dp);

            max = Math.max(max, coins);
        }

        dp[i][j] = max;

        return dp[i][j];
    }

    public static int maxCoinsTabu(int[] nums) {
        int n = nums.length;

        int temp[] = new int[n+2];
        temp[0] = 1;
        temp[n+1] = 1;

        for(int i=1;i<n+1;i++) {
            temp[i] = nums[i-1];
        }

        int dp[][] = new int[n+2][n+2];

        for(int i=n;i>=1;i--) {
            for(int j=1;j<=n;j++) {

                if(i > j) {
                    continue;
                }

                int max = Integer.MIN_VALUE;

                for(int k=i;k<=j;k++) {
                    /*
                    Tracking purpose
                     */
                    int l = temp[i-1];
                    int m = temp[k];
                    int r = temp[j+1];

                    int dpl = dp[i][k-1];
                    int dpr = dp[k+1][j];
                    int coins = temp[i-1] * temp[k] * temp[j+1] + dp[i][k-1]
                            + dp[k+1][j];
                    max = Math.max(coins, max);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    public static void main(String args[]) {
        /*
        --HARD

        THE QUESTION STATES THAT WE ARE GIVEN BALLOONS, AND WE HAVE TO BURST THEM TO COLLECT MAX COST
        A BALLOON WILL MULTIPLY BY LEFT AND RIGHT OF ELEMENT, IF NO ELEMENT OF RIGHT/LEFT IS PRESENT, MULTIPLY BY 1

        WHAT OUR APPROACH USING RECURSION WOULD BE TO PICK A SINGLE BALLOON AT ONCE AND HENCE FORM A RECURSION TREE,
        WE NEED TO USE ALL THE DIFFERENT WAYS TO GET THE MAXIMUM OF COINS

        STEPS TO DO THIS

        SUPPOSE AN ARRAY OF 3 4 5 8, FIRST WE WILL CLONE THIS TO TEMP ARRAY AND ADD 1 ON FIRST AND LAST AS THERE COULD
        BE STAGE WHEN LEFTMOST ELEMENT LIKE 3 OR RIGHTMOST ELEMENT LIKE 8 OR ANY ELSE WITH NO LEFT RIGHT ARE THERE,
        OUR APPROACH IS TO PICK SINGLE ELEMENT GET ITS COST AND THEN FIND FOR ITS LEFT AND RIGHT TO ADD UP COST

        SUPPOSE WE PICK 4, INTIALLY IT WILL MULTIPLY BY 1 & 1 AS IT IS FIRST ELEMENT WE HAVE PICKED
        FOR THAT WE USE FORMULA ARR[I-1] * ARR[K] * ARR[J+1] AND WE ADD
        F(I, K-1) & F(K+1, J) AS LEFT AND RIGHT SIDES

        NOW WHY WE ARE HAVING J+1, BECAUSE NO MATTER WHAT ELEMENT WE CHOSE FROM ITS LEFT FIRST, IT WOULD BE MULTIPLYING
        BY 4 AS IN A WAY WHAT WE ARE CHOOSING IS BURSTING BALLONS FROM LAST TO UPWARDS, 1*3*4 AND THEN 1*4
        AS 4 WOULD DEFINITELY BE THE RIGHT ELEMENT HERE, IF WE SAY WE DO
        F(K+1, J)

        THEN THIS 4 WOULD BE REPRESENTED BY A[I-1], AGAIN BECAUSE 4 WAS THE LAST TO BURST,
        HERE IT WOULD BE 4*5*1, AND SIMILARLY WE WILL FOLLOW,



        TABULATION

        IN TABULATION WHAT WE ARE GOING TO DO RUN FROM I=N TO 1 & J=1 TO N AS IT IS BOTTOM UP APPROACH
        WE WILL EVALUATE VALUES FOR EVERY SUBARRAY

        WHEN I=J, THEN WE ONLY NEED TO FIND VALUE FOR THAT ELEMENT EG FOR 3 5 8, WHEN I=3 & J=3
        THEN THIS MEANS BALLOON 8 BURST WHICH WOULD BE MULTIPLIED BY 5 AS IT LEFT AND 1 AS RIGHT

        WHEN SAY I=2 & J=3(ARRAY IS 1 3 5 8 1)

        THEN WE WILL CHECK WHICH ONE PRODUCES MAX VALUE WHEN BURST FIRST, EG WHEN 5 IS THE FIRST VALUE
        TO BURST IT WILL GIVE ANS DP[K+1][J] + 1 * 3 * 8 AS 5 IS ALREADY BURST

        THEN WHEN 3 IS FIRST VALUE TO BURST IT WILL GIVE DP[I][K-1] = 15, ITS INDIVIDUAL VALUE
        AND 5 WOULD GIVE 1 * 5 * 8 = 40, 55, 144 IS LARGER GIVEN BY 3 BURSTING FIRST

        HENCE WE CAN FIND FOR ALL THE VALUES.



         */
        /*
        https://www.youtube.com/watch?v=IFNibRVgFBo
         */
        int arr[] = {3,5,8};

        maxCoinsRecursive(arr);
        maxCoinsTabu(arr);


    }


}
