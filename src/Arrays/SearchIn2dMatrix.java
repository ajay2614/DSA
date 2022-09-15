package Arrays;

public class SearchIn2dMatrix {

    /**
     * TC -> BIG O(N*N)
     * SC -> BIG O(1)
     */
    public static boolean searchMatrixBruteForce(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++){
                if(matrix[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    /**
     *  TC -> BIG O(N)
     *  SC -> BIG O(1)
     */
    public boolean searchMatrix2ndBestSoln(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0;
        int j = m-1;


        while(i < n && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] < target) {
                i++;
            }
            else
                j--;
        }
        return false;
    }

    /**
     * TC -> O(log(m*n))
     * SC -> O(1)
     */
    public static boolean searchMatrixBestSoln(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int si = 0;
        int ei = n*m - 1;

        while(si <= ei) {
            int mid = si + (ei-si)/2;

            int row = mid/m;
            int column = mid%m;

            if(matrix[row][column] == target) {
                return true;
            }
            else if(matrix[row][column] > target) {
                ei = mid-1;
            }
            else {
                si = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        /**
         * BRUTE APPROACH
         *
         * IN BRUTE APPROACH WE WILL SIMPLY SEARCH FOR TARGET RUNNING I*J LOOP TO FIND ANSWER, IF PRESENT RETURN TRUE
         *
         * 2ND BEST APPROACH
         *
         * IN THIS APPROACH, WE OBSERVE THAT ELEMENTS DOWNWARDS ARE BIGGER AND LEFTWARDS ARE SMALLER, HENCE WE WILL
         * START FROM 0 ROW AND N-1 COLUMN, IF ELEMENT IS BIGGER INCREASE ROW, ELSE DECREASE COLUMN, RUN TILL WE
         * FIND OUR TARGET OR UNTIL I < N OR J >= 0
         *
         * BEST APPROACH
         *
         * THIS APPROACH WILL ONLY WORK IF ENTIRE MATRIX IS SORTED, NOT JUST ROW AND COLUMN WISE, AS WE OBSERVE THE ENTIRE
         * ARRAY IS SORTED, WE CAN APPLY A BINARY SEARCH, BUT AS WE DONT HAVE A 1D ARRAY TO STORE WE WOULD NEED TO MANIPULATE
         * THIS ARRAY IN SUCH A WAY WE CAN APPLY LOW AND HIGH POINTERS AND HENCE BINARY SEARCH TO IT, WE WILL TAKE STARTING
         * INDEX AS 0 AND ENDING INDEX AS M * N - 1, WHY THIS BECAUSE HAD WE TAKEN AN ACTUAL ARRAY THE END INDEX WOULD HAD BEEN
         * SAME, AS AN EG ASSUME LOWER ARRAY, IF CONSIDERED 1 ARRAY IT WOULD HAD SIZE OF M*N AND HENCE LAST INDEX IS M*N-1
         *
         * NOW WE WILL RUN TILL SI <= EI, NOT TO GET ANY ROW OR COLUMN AT PARTICULAR INDEX, WE FIRST FIND MID
         * AND AFTER THIS TO FIND ROW WE DO MID/M AND FOR COLUMN WE DO MID%M, AND RUN OUR BINARY SEARCH TILL ANSWER IS FOUND
         *
         */
        int matrix[][] = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};

        searchMatrixBestSoln(matrix, 30);
    }
}
