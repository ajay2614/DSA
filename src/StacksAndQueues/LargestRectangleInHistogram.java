package StacksAndQueues;

import java.util.Stack;

public class LargestRectangleInHistogram {

    /*
    always start with brute force, then second best, use the best one only if required
     */

    public int largestRectangleAreaBruteForce(int[] heights) {
        int n = heights.length;
        int area = Integer.MIN_VALUE;
        for(int i=0;i<n;i++) {

            int boxes = 0;
            int left = i;
            int right = i;

            while(left >=0 && heights[i] <= heights[left]) {
                left--;
                boxes++;
            }

            while(right < n && heights[i] <= heights[right]) {
                right++;
                boxes++;
            }

            int sum = (boxes - 1) * heights[i];
            area = Math.max(sum, area);
        }
        return area;
    }

    public int largestRectangleArea2ndBestSolution(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int n = heights.length;
        int ls[] = new int[n];
        int rs[] = new int[n];

        for(int i=0;i<n;i++) {

            while(! st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if(st.isEmpty()) {
                ls[i] = 0;
                st.push(i);
            }
            else {
                ls[i] = st.peek() + 1;
                st.push(i);
            }
        }

        while(!st.isEmpty())
            st.pop();

        for (int i=n-1;i>=0;i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }

            if(st.isEmpty())
                rs[i] = n-1;
            else
                rs[i] = st.peek() - 1;
            st.push(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            max = Math.max(max, (rs[i] - ls[i] + 1) * heights[i]);
        }
        return max;
    }

    public int largestRectangleAreaBestSolution(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int n = heights.length;
        int max =Integer.MIN_VALUE;

        for(int i=0;i<=n;i++) {

            while (!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i] )) {

                int width = 0;
                /*
                GETTING ELEMENT TO BE EVALUATED
                 */
                int elementHeight = heights[st.peek()];
                st.pop();

                /*
                FINDING ITS LS, RS IS I AS WE KNOW THE LOOP ONLY WORKED BECAUSE OF THAT.
                 */

                if(st.isEmpty())
                    width = i;

                else
                    width = i - st.peek() - 1;

                max = Math.max(max ,width * elementHeight);
            }
            st.push(i);
        }
        return max;
    }

    public static void main(String[] args) {

        /*
        THE QUESTION STATES THAT WE ARE GIVEN A HISTOGRAM, WE HAVE TO FIND THE LARGEST AREA OF A RECTANGLE

        BREAKING DOWN QUESTION

        SUPPOSE AN ARRAY IS GIVEN 1 2 5 6, THEN THE BIGGEST RECTANGLE AREA WOULD BE 10
        WE CAN MOVE LEFT OR RIGHT UNTIL ELEMENT LEFT OR RIGHT IS GREATER, 1 FOR 2 WE CANT MOVE LEFT BUT
        CAN MOVE RIGHT AND IT WILL HAVE 3 BLOCKS OF 2, HENCE AREA IS 6, FOR 5 WE CAN MOVE RIGHT AND
        HENCE AREA IS 10, FOR 6 WE CANT MOVE RIGHT OR LEFT.


        BRUTE FORCE

        RUN A LOOP AND CHECK LEFT AND RIGHT TILL ELEMENTS ARE GREATER AND COMPUTE MAX.

        2ND BEST SOLUTION

        COMPUTE THE LEFT SMALLEST AND RIGHT SMALLEST,

        DECLARE TWO ARRAYS AND A STACK, ARRAYS FOR STORING LS AND RS FOR PARTICULAR INDEX AND STACK
        FOR STORING INDEXES.

        FOR LEFT SMALLEST RUN LOOP FROM I->N,
        RUN WHILE LOOP -> CHECK WHETHER STACK IS UNEMPTY AND INDEX ELEMENT IN STACK,
        THE ARRAY[OF STACK INDEX ELEMENT] >= ARRAY[CURRENT INDEX], IF SO, POP STACK

        CHECK WHETHER STACK IS EMPTY, IT MEANS IT DOES NOT HAVE ANY LEFT SMALLER,
        HENCE ADD 0 IN ARRAY, ELSE ADD STACK TOP + 1 INDEX

        SIMILARLY STORE FOR RIGHT SMALLEST, RUN LOOP BACKWARDS, USE SAME STACK, INSTEAD OF 0 ADD INDEX = N-1
        WHEN STACK IS EMPTY, SUGGESTING IT DOENT HAVE RIGHT SMALLER

        ELSE ADD STACK.TOP - 1.

        WHY LS IS TAKING TOP + 1 AND RS IS TAKING TOP - 1, AND IN ANSWER ADDING + 1, WHEN WE ARE COMPUTING,
        IT COULD HAPPEN SAY, ARR 2, 4, THEN WHEN FOR LS OF 4 IT WILL TAKE ST.PEEK() WHICH IS 0, IT WILL NOT ADD
        A LS, WHICH WAS 2

        SIMILARLY FOR RS, 4 WOULD BE HAVING RS = 1, 2 WOULD BE HAVING RS = 1, WHICH WOULD HAVE BEEN CORRECT
        ON FINAL ANSWER 1 - 1 WOULD TURN 0, HENCE WE TAKE WHAT WE ARE TAKING

        IN THE END RUN A FOR LOOP AND GET MAX, RS[I] - LS[I] + 1 * ARR[I]


        BEST SOLUTION

        IN THIS SOLUTION INSTEAD OF CREATING LS OR RS, WE WOULD USE STACK TO GET THE ANSWER,

        WHAT APPROACH WE WOULD FOLLOW IS WE WILL GET OUR LS FROM STACK, AND FOR RS WE WILL PUSH THE STACK TILL WE
        GET SMALLER THAN STACK TOP INDEX FOR ARRAY

        OUR HEIGHT ELEMENT TO BE EVALUATED, INDEX WOULD BE TOP OF STACK, THE INDEX OF LS WOULD BE FROM STACK
        , RS INDEX WOULD BE I, WIDTH WOULD BE RS - LS - 1, -1 BECAUSE ELEMENT UNDER EVALUATION IS TAKEN TWO TIMES IN
        A WAY WHILE EVALUATION OF ITS INDEX FOR RS AND LS, FOR MAX WE JUST DO HEIGHT * WIDTH,

        WHEN STACK IS EMPTY MEANS WE DONT HAVE ANY LS, FOR THIS TOTAL WIDTH IS JUST I.

        RUN A WHILE LOOP, WITH HAVING ABOVE CONDITIONS AND DO ALL ABOVE IN THAT, AFTER THIS PUSH I IN STACK,

        FOR LOOP RUNS TILL N, BECAUSE WE ALSO NEED TO GET VALUE FOR N-1 TH INDEX, AS IT WONT HAVE ANY FURTHER
        ELEMENTS TO COMPARE WITH
         */

    }
}
