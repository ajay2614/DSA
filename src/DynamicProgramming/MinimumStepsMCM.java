package DynamicProgramming;

public class MinimumStepsMCM {
    public static int mcmRecursive(int i, int j, int[] arr) {
        if(i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int steps = arr[i-1] * arr[k] * arr[j] + mcmRecursive(i,k,arr)
                    + mcmRecursive(k+1, j, arr);
            min = Math.min(steps, min);
        }
        return min;
    }

    public static int mcmMemo(int i, int j, int[] arr, int[][] dp) {
        if(i == j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for(int k=i;k<j;k++) {
            int steps = arr[i-1] * arr[k] * arr[j] + mcmMemo(i,k,arr,dp)
                    + mcmMemo(k+1, j, arr,dp);
            min = Math.min(steps, min);
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    public static int matrixMultiplication(int[] arr , int N) {
        int dp[][] = new int[N][N];
        for(int i=1;i<N;i++)
            dp[i][i] = 0;

        for(int i=N-1;i>=1;i--) {
            for(int j=i+1;j<N;j++) {
                int min = Integer.MAX_VALUE;
                for(int k=i;k<j;k++) {
                    int steps = arr[i-1] * arr[k] * arr[j] +
                            dp[i][k] + dp[k+1][j];
                    min = Math.min(steps, min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][N-1];
    }

    public static void main(String args[]) {
        /*
        --HARD

        THE QUESTION ASKS US FIND THE MINIMUM OPERATIONS/STEPS TO COMPUTE MCM



        UNDERSTANDING THE RECURSIVE WAY

        SUPPOSE MATRIX A1 = 10 * 20, A2 20 * 30
        NOTE TO REMEMBER TO COMPUTE THE ROWS AND COLUMNS FOR A1 * A2 WE GET 10 * 30, AS 20 IS COMMON AND IS NOT TAKEN ACC
        TO FORMULA

        TO COMPUTE OPERATIONS

        A1 * A2 = 10 * 20 * 30 OPERATIONS WILL BE REQUIRED ACC TO FORMULA

        SO WHAT WE WILL DO USING RECURSION IS INTRODUCE A LOOP FOR VARIABLE K
        K WOULD ACT AS A PARTITIONER BETWEEN MATRICES

        SUPPOSE WE HAVE BELOW ARRAY 10, 20, 30, 40, 50

        STEP TO DIVIDE THEM BETWEEN MATRICES IS A = 10 * 20, B = 20 * 30, PARTICULAR I = A[I] * A[I-1];
        K WOULD RUN FROM I(STARTING FROM 1) TO J-1
        IN THIS WAY WE CAN PARTION ABCD INTO SUPPOSE A BCD AS F(I-1,K,ARR) AND F(K+1, J, ARR)

        NOW UPON COMPUTING WE FIND DIMENSION(R/C) I-1 GIVES 10*20, K GIVES 20*30, BCD 30*40*40*50
        WHICH CAN BE FURTHER CLASSIFIED AS 10*20*50, WHICH IS JUST WHAT I-1,K,J ARE REPRESENTING
        HENCE TO FIND STEPS WE MULTIPLY A[I-1], A[K], A[J] & ADD F(I-1, K) AND F(K+1, J) AS WE NEED
        TO FIND MIN OPERATIONS THESE WOULD BE GIVING US, EG FOR BCD WE NEED TO FIND WHETHER B * CD OR BC * D
        IS GIVING MIN STEPS.

        BASE CASE IS IF (I==J) RETURN 0, AS I == J MEANS SINGLE MATRIX WHICH ALWAYS COMPUTE 0 OPERATIONS

        ----

        TABULATION

        FOR TABULATION AFTER TAKING DP[][] ARRAY WE SET ALL DP[I][I] = 0 AS IT WAS BASECASE IN RECURSION

        NOW WE CHOOSE I AND J AS IT WAS PASSED AS IN METHODS IN RECURSION WE NEED TO FIND THE WAY TO REPRESENT I & J

        SINCE WE KNOW I WAS RUNNING FROM 1 TO N-1
        WE WILL RUN I FROM N-1 TO 1
        WE WILL RUN J FROM I+1 TO N

        WHY RUNNING I BACKWARDS AND J FORWARDS, BECAUSE ITS CLEAR THAT I REPRESENTS LEFT SIDE AND J THE RIGHT SIDE, IT IS SORT OF LIKE A SLIDING WINDOW,
        SLIDING FROM LEFT TO RIGHT, IF IT WAS I RUNNING FROM 1 TO N-1 WE COULD HAVE COME WITH CASE A TRYING TO MULTIPLY CD, HENCE BREAKING OUR CASE

        WE REPRESENT MIN INSIDE LOOP SO THAT WE CAN GET MIN STEPS FOR EVERY DP[I][J];

        IN THE END WE RETURN DP[1][N-1], BECAUSE THIS IS BOTTOM UP APPROACH, IN TOP DOWN RECURSION APPROACH WE STARTED FROM I FROM 1 & J = N-1, HENCE
        WE WILL FIND ANSWER IN DP[1][N-1]
         */
        int arr[] = {10,20,30,40,50};
        matrixMultiplication(arr, arr.length);
    }
}
