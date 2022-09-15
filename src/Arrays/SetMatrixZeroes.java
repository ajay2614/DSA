package Arrays;
import java.util.Arrays;
public class SetMatrixZeroes {
    /*
    Time Complexity: O(N*M + N*M)
    Space Complexity: O(N)
     */
    public static void setZeroesOptimalApproach(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int dummyCol[] = new int[m];
        int dummyRow[] = new int[n];

        Arrays.fill(dummyRow,-1);
        Arrays.fill(dummyCol,-1);


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == 0) {
                    dummyRow[i] = 0;
                    dummyCol[j] = 0;
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(dummyRow[i] == 0 || dummyCol[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /*
    Time Complexity: O(2*(N*M)), as we are traversing two times in a matrix,
    Space Complexity: O(1).
     */
    public static void setZeroesMostOptimal(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean isZero = false;

        for(int i=0;i<n;i++) {
            if(matrix[i][0] == 0)
                isZero = true;
            for(int j=1;j<m;j++) {
                if(matrix[i][j] == 0)
                    matrix[i][0] = matrix[0][j] = 0;
            }
        }

        for(int i = n-1;i>=0;i--) {
            for(int j = m-1;j>=1;j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(isZero)
                matrix[i][0] = 0;
        }
    }

    public static void main(String[] args) {
        /**
        WHAT WE HAVE TO DO IF WE FOUND ANY ZERO IN MATRIX, WE NEED TO CONVERT ITS ROWS AND COLUMNS TO 0

        IN INTERVIEW USE OPTIMAL APPROACH FIRST, AFTER THAT USE MOST OPTIMAL ONE

        OPTIMAL APPROACH IS VERY EASY AND BETTER THAN BRUTE FORCE FOR THIS QUESTION

        OPTIMAL APPROACH

        USE A DUMMY ROW AND DUMMY COLUMN, IF MATRIX[I][J] = 0, THEN MARK DUMMY ROW AND DUMMY COLUMN I & J INDEX = 0;

        RUN A LOOP AGAIN, IF DUMMY[I] OR DUMMY[J] = 0, THEN MATRIX[I][J] = 0;

        BETTER THAN OPTIMAL APPROACH, OUR INTUITION BEHIND THIS APPROACH IS RATHER THAN USING DUMMY ROW AND COLUMN
        WE MAKE OUR 0TH ROW AND 0TH COLUMN ACT AS DUMMY ROW AND COLUMN, WE USE A VARIABLE BOOLEAN TYPE ISCOLUMNZERO

        RUN LOOP FROM 0 TO N-1 FOR I, & FOR J FROM 1 TO M-1, IF MATRIX[I][0] IS ZERO THEN MARK ISCOLUMNZERO AS TRUE,

        IN JTH LOOP IF MATRIX[I][J] = 0, MATRIX[0][J] & MATRIX[I][0] IS ZERO.


        AFTER THIS RUN LOOP FOR I FROM N-1 TO 0 & M-1 TO 1 FOR J, IF(MATRIX[I][0] = 0 || MATRIX[0][J] = 0) THEN MARK
        MATRIX[I][J] = 0

        AND AFTER J LOOP CHECK IF ISCOLUMNZERO = TRUE, THEN MARK MATRIX[I][0] = 0;

        PURPOSE OF USING ISCOLUMNZERO

        SUPPOSE FOR ARRAY
        1 1 1
        1 0 1
        0 1 1

        WHEN WE WILL TRAVERSE THIS ARRAY, WE WILL FIND THAT ARR[2][0] HAS INDEED 0, IF WE HADNT USE THIS,
        THEN IN THE FINAL ANSWER WE WOULD NOT HAD BEEN ABLE TO SET THE 0TH COLUMN AS 0, AND IF WE HAD STARTED
        FROM 0TH COLUMN FOR J, THEN ARR[0][2] 1, WHICH DOES NOT HAVE 0 COLUMN OR ROW WITH IT, WOULD ALSO HAD TURNED
        TO ZERO
         */
        int arr[][] = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};

        setZeroesMostOptimal(arr);

    }
}
