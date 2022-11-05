package StacksAndQueues;

import java.util.Stack;

public class CelebrityProblem {
    public static int celebrityBrute(int M[][], int n) {

        int cCol = -1;
        for(int i=0;i<n;i++) {
            boolean x = true;
            for(int j=0;j<n;j++) {
                if(M[i][j] == 1) {
                    x = false;
                    break;
                }
            }

            if(x) {
                cCol = i;
                break;
            }
        }

        if(cCol == -1)
            return -1;

        int row = 0;

        while(row < n) {
            if(cCol == row) {
                row++;
                continue;
            }
            if(M[row++][cCol] != 1)
                return -1;
        }
        return cCol;
    }

    int celebrity(int M[][], int n) {

        Stack<Integer> stack = new Stack<>();

        for (int i=0;i<n;i++) {
            stack.push(i);
        }
        while(stack.size() > 1) {
            int num1 = stack.pop();
            int num2 = stack.pop();

            if(M[num1][num2] == 1)
                stack.push(num2);
            else
                stack.push(num1);
        }

        int possibleCelebrityCol = stack.pop();

        for (int i=0;i<n;i++) {
            if(M[possibleCelebrityCol][i] != 0)
                return -1;
            if(i == possibleCelebrityCol)
                continue;
            else if (M[i][possibleCelebrityCol] != 1)
                return -1;
        }
        return possibleCelebrityCol;
    }
    public static void main(String[] args) {
        /**
         * IN THIS PROBLEM WE ARE GIVEN A 2D ARRAY, IN THESE THERE COULD BE A CELEBRITY, A CELEBRITY IS THAT PERSON
         * WHO KNOWS NO ONE AND EVERY ONE KNOWS THEM, FOR EG BELOW ARRAY, ROWS REPRESENT AND INDIVIDUAL AND COLUMNS REPRESENT
         * WHETHER THEY KNOW THE PERSON OR NOT, FOR EG 1ST ROW PERSON KNOWS SECOND ROW AND DOES NOT KNOW THIRD ROW.
         *
         * 0 1 0
         * 0 0 0
         * 0 1 0
         *
         * SINCE 1ST ROW AND 3RD ROW KNOWS 2ND AND 2ND DOES NOT KNOW ANYONE, 2ND IS CELEBRITY
         *
         * BRUTE APPROACH
         *
         * FIND A ROW HAVING ALL THE ZEROES, IF THERE ARE ALL THE ZEROES, MEANS THERE IS A POSSIBILITY THAT ROW IS CELEBRITY,
         * SO TO MAKE SURE THAT IS THE CASE, ITERATE EVERY ROW FOR THAT COLUMN EXCEPT THE POSSIBLE ROW COL, AND CHECK IF THAT IS
         * 1, IF EVERY VAL COMES OUT TO BE 1, MEANS THAT IS CELEBRITY.
         *
         * OPTIMAL APPROACH
         *
         * ADD ALL THE VALUES FROM 0 TO N-1 IN A STACK, AND THEN UNTIL STACK HAS THE POSSIBLE CELEBRITY(SIZE > 1)
         * RUN WHILE, COMPARE FIRST TWO VALUES IN THE STACK, IF ARR[NUM1][NUM2] = 1, MEANS NUM2 CAN BE A CELEBRITY, AS NUM1
         * SO PUSH THAT NUM2 BACK IN STACK, IN THE END WHEN FINAL ELEMENT IS LEFT, THAT IS POSSIBLE CELEBRITY
         * RUN FOR LOOP LIKE WE DID IN BRUTE AND CHECK IF ALL VALUES HAVING THAT NUM AS COLUMN ARE 1, IF IT IS THEN RETURN
         * THAT NUM AS CELEBRITY ELSE -1.
         *
         * WHY THIS WORKS EVEN THOUGH THERE COULD BE CASE SAY IN STACK FOR 0 1 2, 1 KNOWS 2 AND 2 DOES NOT KNOW 1,
         * SO POP 1, AND COMPARE 0 AND 2 AND 2 KNOWS 0 AND 0 DOES NOT KNOW 2, SINCE WE ARE CHECKING FINALLY WHETHER EVERY ROW
         * HAS THAT COLUMN AS 1, WE ARE MAKING SURE WHETHER IT IS A CELEB OR NOT.
         *
         *
         */
        int arr[][] =  {{0, 1 ,0}, {0, 0, 0}, {0, 1, 0}};
        int n = 3;
        celebrityBrute(arr, n);
    }
}
