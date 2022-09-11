package Arrays;

public class Rotate2dArray {

    /*
    TC : O(N*N) + O(N*N)
     */
    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n-1 ;i++) {
            for(int j = i;j<m;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++) {
            for (int j=0;j<m/2;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][m - j - 1];
                matrix[i][m-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        /*
        THE QUESTION IS THAT WE NEED TO ROTATE ARRAY

        THE WAY IS TO FIRST GET THE TRANSPOSE, AND THEN RUN A FOR LOOP TO SWAP THE ELEMENTS

        TO GET TRANSPOSE WE RUN I FROM 0 TO N & J FROM I TO M. WHY J IS FROM I, BECAUSE OTHERWISE IT WOULD HAVE SWAPPED
        ALREADY PLACED ELEMENTS, SWAP A[I][J] WITH A[J][I].

        AFTERWARDS RUN LOOP TO SORT OF MIRROR THE 2D ARRAY

         */
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

        rotate(arr);
    }
}
