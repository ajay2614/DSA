package StacksAndQueues;

import java.util.Stack;

public class MaximumOfMinimumForEveryWindowSize {
    public static int[] maxOfMin(int[] arr, int n) {

        int ls[] = new int[n];
        int rs[] = new int[n];

        ls[0] = -1;
        rs[n-1] = n;

        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++) {

            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty())
                ls[i] = -1;
            else
                ls[i] = st.peek();

            st.push(i);
        }
        st = new Stack<>();
        st.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if(st.isEmpty())
                rs[i] = n;
            else
                rs[i] = st.peek();

            st.push(i);
        }

        int ans[] = new int[n];

        for(int i=0;i<n;i++) {
            int len = rs[i] - ls[i] - 1;
            ans[len-1] = Math.max(ans[len-1], arr[i]);
        }

        for(int i=n-2;i>=0;i--) {
            ans[i] = Math.max(ans[i], ans[i+1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {10,20,30,50,10,70,30};

//      Output: 70 30 20 10 10 10 10

        /**
         * HARD QUESTION
         *
         * IN THIS WE ARE GIVEN AN ARRAY, FOR AN ARRAY WE NEED TO FIND MAX OF MIN OF EVERY WINDOW SIZE
         *
         * MEANS THAT FOR EG IF WINDOW SIZE IS 1 EVERY ELEMENT CAN BE COVERED INDIVIDUALLY BY WINDOW, MAX OF THIS WINDOW
         * IS 70
         * WHEN WINDOW SIZE IS 2, THEN WINDOW WOULD BE 10 AND 20, MIN HERE IS 10, IN THIS CASE 30 AND 50, 30 WOULD BE
         * GREATEST OF MINIMUMS.
         *
         * LIKE THIS WE HAVE TO RETURN ARRAY FOR EVERY WINDOW SIZE.
         *
         * APPROACH
         *
         * THE FIRST STEP WE WILL APPLY IS TO GET AN ELEMENTS LEFT SMALLER AND RIGHT SMALLER
         * WHY THIS? BECAUSE LETS SAY FOR ABOVE ARRAY IND 2, 30, 20 AT IND 1 IS ITS LEFT SMALLER AND 10 AT IND 4 IS ITS SMALLER
         * , THAT MEANS 30 CAN NOT BE MIN WITH 20 AND 10 WINDOW, SO IT CAN ONLY BE MIN FOR LENGTH R-L-1, WHICH IS
         * 4-1-1 = 2, IT MEANS ONLY WHEN LENGTH IS 2, THAT IS WHEN 30 AND 50 ARE TOGETHER ONLY THEN IT CAN BE MIN.
         *
         * MAKE SURE WE CHECK BY ADDING IND IN STACK UNLIKE LEFT SMALLER QUESTION WHERE WE ADDED ELEMENTS. IF THERE IS NO R SMALLER
         * HAVE N AND IF NO LEFT SMALLER HAVE 1, BECAUSE LETS SAY FOR 10,LENGTH WOULD BE R = 7 AND L = -1, SO
         * 7 + 1 - 1 = 7,SO 10 WOULD BE A POSSIBLE VALUE WHEN WINDOW SIZE IS 7.
         *
         * AFTER GETTING L SMALLER AND R SMALLER HAVE AN ARRAY DECLARED WHICH WOULD TAKE MAX ARR[LEN], SINCE
         * WE NEED TO GET MAX OF ALL MIN LENGTH VALUES, STARTING FROM 0 TO N-1, GET AN ELEMENT LEFT SMALLER AND RIGHT SMALLER
         * EVALUATE ITS LENGTH, FOR WHICH IT CAN BE MIN, AND ADD THE MAX IN ARRAY, FOR EG 50 WOULD BE HAVING LENGTH 1 AND 70 ALSO
         * BUT SINCE 70 IS MAX WE ADD THAT,
         *
         * NOTE : MAKE SURE WHILE ADDING IN ANS ARRAY, ADD LIKE ANS[L-1] AS L IS FROM 1 TO 7, BUT ARRAY IS 0 BASED INDEXING
         *
         * NOW AFTER THIS THERE WOULD BE POSSIBLE THAT FOR SOME LENGTHS, ANS WOULD NOT BE THERE, SO IN THIS CASE SINCE THE WORST
         * CASE WOULD BE MIN OF LENGTH+1, LIKE FOR LENGTH 6, WORST VALUE WOULD BE 10 WHICH WAS OF LENGTH 7, SO SIMPLY RUN A LOOP
         * AND ADD MAX OF ARR[I],ARR[I+1].
         *
         */
    }
}
