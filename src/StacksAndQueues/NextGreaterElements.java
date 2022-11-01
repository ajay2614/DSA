package StacksAndQueues;

import java.util.Stack;

public class NextGreaterElements {
    public static int[] nextGreaterElementsBrute(int[] nums) {
        int n = nums.length;

        int arr[] = new int[n];

        for(int i=0;i<n;i++) {
            boolean x = false;
            for(int j=i+1;j<2 * n;j++) {
                if(nums[j % n] > nums[i]) {
                    arr[i] = nums[j % n];
                    x = true;
                    break;
                }
            }
            if(!x)
                arr[i] = -1;
        }

        return arr;
    }
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        Stack<Integer> st = new Stack<>();
        int arr[] = new int[n];
        for(int i=2 * n-1 ; i >=0; i--) {
            while(!st.isEmpty() && nums[i%n] >= st.peek()) {
                st.pop();
            }

            if(i < n) {
                if(!st.isEmpty())
                    arr[i] = st.peek();
                else
                    arr[i] = -1;
            }
            st.push(nums[i%n]);
        }
        return arr;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE NEED TO FIND THE NEXT GREATER ELEMENT ON THE RIGHT AND IF THERE IS NOT ANY ELEMENT IN THE
         * RIGHT THEN START CHECKING FROM INDEX 0, WHICH FIRST ELEMENT FROM INDEX 0 THAT IS GREATER THAN IT AND IF THERE IS NONE
         * RETURN -1, RETURN ARRAY FOR ALL THE ELEMENTS, ELEMENT GREATER THAN IT.
         *
         * FOR EG FOR 1 3 2, THE RESULTING ARRAY WOULD BE 3 -1 3.
         *
         * BRUTE APPROACH RUN A NESTED FOR LOOP,
         * FOR I RUN FROM 1 TO N, AND FROM J RUN FROM I+1 TO 2N, AND CHECK IF NUMS[J%N] > NUMS[I], THIS WAY WHAT WE HAVE DONE
         * IS BASICALLY CREATED A DUMMY ARRAY, 1 3 2 1 3 2, ONCE IF WE HAVE FOUND A NUMBER GREATER THAN NUMS[I] THEN BREAK AS NO
         * NEED TO TRAVERSE FORWARD, UPDATE THE BOOLEAN VARIABLE SO THAT WE CAN TRACK WHETHER WE HAVE FOUND AND IF NOT FOUND
         * UPDATE -1 FOR THAT ARR[I]
         *
         * OPTIMAL APPROACH
         *
         * RATHER THAN USING A NESTED LOOP WE WILL TRY TO WORK THIS USING A FOR LOOP AND WHILE LOOP INSIDE, ALONG WITH USING
         * A STACK, SO THE APPROACH HERE WOULD BE THAT WE WILL START FROM EXTREME RIGHT SIDE AND UPDATE THE ELEMENT IN STACK
         * , NEXT TIME WE WILL CHECK IF STACK IS NOT EMPTY AND IF THE CURRENT ELEMENT IS SMALLER THAN STACK ELEMENT, THEN WE WILL
         * DO NOTHING AND IF I < N (I IS STARTED FROM 2N-1 TO 0, THE REASON IS SAME AS BRUTE SO WE CAN COVER THE LEFT ELEMENTS
         * TOO) WE WILL UPDATE IT IN THE ANS ARRAY, NEXT IF THE ELEMENT COMES OUT TO BE GREATER THAN STACK ELEMENTS THEN WE WILL
         * REMOVE THE ELEMENT TILL STACK IS EMPTY, IN THIS WAY WE WILL HAVE THE MOST RECENT MAX ELEMENT ON THE RIGHT SIDE,
         * FOR EG FOR 1 3 2, 3 WOULD REMOVE 2 AND AFTER THIS WE WILL CHECK IF STACK IS NOT EMPTY, WE WILL UPDATE THAT AS THE
         * NEXT GREATER ELEMENT FOR ARRAY INDEX ELSE WE WILL UPDATE ARR[I] AS -1, SO WE CAN SEE A PATTERN HERE COVERING 2 THINGS
         *
         * FIRSTLY WE ARE UPDATING THE ORDER AS ASCENDING ORDER, LIKE 2 4 5, SO IF 1 COMES IT WILL FAIL THE FIRST WHILE CONDITION
         * AND WE CAN SIMPLY UPDATE 1 NEXT GREATER AS 2, BUT SAY IF 3 COMES THEN WE WILL POP 2, AND 4 WILL GET UPDATED AS NEXT
         * GREATER AND IF SAY 6 COMES WE WILL POP ALL ELEMENTS MEANING NO ONE WAS BIGGER THEN 6 AND UPDATE -1,
         *
         * SECONDLY WE ARE PLACING IN STACK WHICH IS BOUND TO BE ASCENDING ORDER ENSURED BY THE FIRST WHILE LOOP.
         *
         */
        int arr[] = {1,2,1};
        nextGreaterElementsBrute(arr);
    }

}
