package Graphs;

public class FloydWarshallAlgo {
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;


        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e8;
                }
                if(i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int k=0;k<n;k++) {
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(matrix[i][j] == (int) 1e8)
                    matrix[i][j] = -1;
            }
        }

        /**
         * for negetive cycle check, run for loop from 0 to n-1, if matrix[i][i] < 0,
         * meaning there is negetive cycle present.
         **/

    }
}
