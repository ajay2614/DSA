package BinarySearch;

import java.util.ArrayList;
import java.util.Collections;

public class MedianInRowWiseSortedMatrix {

    //ONLY FOR ODD ROWS AND ODD COLUMNS

    /**
     * TC : BIG O(N*M LOG(N*M))
     * SC : BIG O(N*M)
     */
    static int medianBrute(int matrix[][], int r, int c) {

        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                arr.add(matrix[i][j]);
            }
        }

        Collections.sort(arr);
        int n = arr.size();
        return arr.get(n/2);
    }

    public static int getMedianAlsoBrute(ArrayList<ArrayList<Integer>> matrix) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(ArrayList<Integer> a : matrix) {
            for(int i : a) {
                arr.add(i);
            }
        }
        Collections.sort(arr);
        int n = arr.size();
        return arr.get(n/2);
    }

    /**
     * Time Complexity: O(row*log col) since the upper bound function takes log c time.
     *
     * Space Complexity: O(1) since no extra space is required.
     */
    public static int median(int matrix[][], int r, int c) {
        // code here
        int start = 0;
        int end = 2000;
        int n = r*c;

        while(start <= end) {
            int mid = start + (end - start)/2;
            int cntSmallerThanMid = 0;

            for(int i=0;i<r;i++) {
                int left = 0;
                int right = c-1;

                while(left <= right) {
                    int middle = left + (right-left)/2;

                    if(matrix[i][middle] <= mid) {
                        left = middle+1;
                    }
                    else{
                        right = middle-1;
                    }
                }
                cntSmallerThanMid += left;
            }

            if(cntSmallerThanMid <= n/2)
                start = mid+1;
            else
                end = mid-1;
        }
        return start;
    }

    public static void main(String[] args) {
        /**
         * https://www.youtube.com/watch?v=tFdBRcHLSGQ
         */

        /**
         *
         * BRUTE APPROACH
         * AS WE KNOW WE NEED TO FIND THE MEDIAN OF THE MATRIX AND THE ROWS AND COLUMNS ARE ALWAYS ODD, THEN WE CAN SIMPLY STORE
         * THE MATRIX IN AN ARRAY LIST AND THEN SORT IT.
         *
         * BINARY SEARCH SOLN
         *
         * APPROACH
         * WE ARE GIVEN ROW SORTED MATRIX, MEANS EVERY ROW IS SORTED, AND IN CONSTRAINTS WE ARE GIVEN THE VALUES STARTING FROM 0
         * AND ENDING TO SOME VALUE SAY 200.
         *
         * WE KNOW TOTAL ELEMENTS IN MATRIX WOULD BE R*C, LETS SAY N
         *
         * SO SINCE WE KNOW VALUE IS BETWEEN 0 AND 200, IF WE CAN CHECK FOR A VALUE WHICH HAS N/2 ELEMENTS ON LEFT AND N/2 ELEMENTS
         * ON ITS RIGHT, WE CAN GET THAT VALUE. WE WILL RUN A BINARY SEARCH START FROM 0 AND ENDING AT 200, AND WE WILL CHECK
         * AT EVERY STAGE HOW MANY ELEMENTS ARE SMALLER THAN THIS ELEMENT AND FOR CHECKING ALSO WE WILL USE BINARY SEARCH
         * AFTER GETTING THAT COUNT WE WILL SEE IF THAT COUNT IS SMALLER THAN OR EQUAL TO THE NUMBER, WHY EQUAL TO, BECAUSE
         * IT COULD HAPPEN FOR 1 3 5 5 6 6 7, IN THIS EG MEDIAN IS 5, SO 5 AT 3RD INDEX WAS EQUAL TO HENCE THIS CONDITION
         * IF IT IS SMALLER THAN OR EQUAL TO, MOVE LEFT BY MID+1, ELSE MOVE RIGHT BY MID-1
         *
         * STEPS
         *
         * HAVE START AS 0, END AS 200(MAX VALUE GIVEN). RUN A WHILE LOOP TILL START <= MID.
         * DECLARE A VARIABLE COUNT, RUN A FOR LOOP FOR EVERY ROW IN THE MATRIX, IN THE ROW, USE BINARY SEARCH
         * L = 0, R=COLUMN-1, AS WE ARE CHECKING VALUES USING 1ST AND LAST INDEX, NOW HAVE MIDDLE INDEX, AND CHECK
         * FOR A[I][MIDDLE] <= MID OF ABOVE START END. IF THAT IS SO MEANS ALL THE ELEMENTS ON THE LEFT SIDE OF THE A[I][MIDDLE]
         * ARE SMALLER BECAUSE EACH ROW IS SORTEDHENCE HAVE LEFT AS MIDDLE + 1, AND CHECK AGAIN. IN THE END WHEN LEFT PASSES
         * RIGHT, WE WILL BE HAVING EXACT VALUE OF THE ELEMENTS SMALLER IN LEFT VARIABLE.
         *
         * FOR EG FOR 1 2 6 7 9, AND SAY MID IS 8, HENCE FIRST ELEMENT WE CHECK IS 6, SO LEFT BECOMES 2 FROM 0,
         * NOW LEFT IS 2 AND RIGHT IS 4, MID BECOMES 3, 7 IS ALSO SMALLER HENCE LEFT BECOMES 4, MID BECOMES 4,
         * NOW ELEMENT AT 4 IS BIGGER HENCE HIGH BECOMES MID-1 AND LOOPS BREAK AND WE GET THE ANS 4 WHICH IS EXACT NUMBER OF
         * ELEMENTS SMALLER THAN OR EQUAL TO 8.
         *
         * GET ALL THE ELEMENTS AND CHECK THE COUNT WHETHER ITS SMALLER THAN OR EQUAL TO N/2. IF IT IS HAVE START AS MID+1, ELSE
         * END AS MID-1. IN THE END START WILL HAVE OUR ANSWER.
         */
        int arr[][] = {{1,3,5},{2,6,9},{3,6,9}};
        median(arr, 3,3);
    }
}
