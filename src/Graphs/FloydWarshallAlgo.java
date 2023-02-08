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

        /**
         * A COMMON DOUBT ARISES THAT WHY IS K PLACED THE OUTERMOST
         * As this solution is based on dp the subproblems as mentioned need to be solved below
         * Since smaller sub-problems need to be solved first and the sub-problems size is controlled by k so we should
         * always put k in the outermost for loop (As k governs which vertices you are permitted to use internal to your
         * path from source i to destination j). The order of i and j are irrelevant but k must go first as it controls
         * the size of the sub-problems.
         *
         * https://stackoverflow.com/questions/27700629/why-does-order-of-3-loops-in-floyd-warshall-matters
         */
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

    public static void main(String[] args) {
        /**
         * FLOYD WARSHALL ALGO IS ALSO USED TO GET MIN DISTANCE BETWEEN SOURCE AND DESTINCATION
         * IT CAN WORK FOR BOTH DIRECTED AND UNDIRECTED AND IT CAN ALSO FIND OUT IF THERE EXISTS A NEGATIVE CYCLE
         *
         * HOW IT WORKS ?
         *
         * IN THIS FIRST WE MARK EVERY NODE IN THE GRAPH AS A HIGH VALUE WHICH WAS INPUT AS -1(IT APPLIES FOR THE ABOVE QUESTION,
         * CAN BE DIFFERENT FOR OTHERS), NOW WE WILL MARK THE SRC TO SRC NODE AS 0 IN THE DISTANCE 2D ARRAY.
         * AS WE REQUIRE NO DISTANCE FROM SOURCE TO SOURCE.
         *
         * NOW RUN 3 LOOPS, ONE NESTED IN OTHER, WITH TC AS N^3, WHAT WE WILL DO IS NOW GET THE MIN DISTANCE
         * THAT IS BY COMPARING DISTANCE BETWEEN 1 NODE TO OTHER IN SUCH A WAY SUPPOSE
         * WE HAVE TO CHECK MIN DISTANCE FROM 0 TO 2, NOW FOR THIS TO HAPPEN WE WILL FIRST HAVE TO GO FROM O TO 1, AND
         * THEN O TO 2, SO USING matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]), WE CAN
         * UPDATE MIN DISTANCE FOR OTHERS AND SO ON
         *
         * ONCE AFTER THIS IF A NEGATIVE CYCLE IS PRESENT WE WILL RUN LOOP AGAIN AND CHECK WHETHER [I][I] < 0, SINCE
         * SRC TO SRC CAN NEVER BE SMALLER THAN 0 BUT IF THERE IS NEGATIVE CYCLE IT WOULD HAVE MADE IT ZERO VIA ABOVE
         * SO WE CAN CHECK IF THERE IS INDEED A NEGATIVE CYCLE.
         *
         *
         *
         */
    }
}
