package Recursion;

import java.util.ArrayList;

public class RatInAMaze {

    public static void recursion(int[][] m, int n, int arr[][], int i, int j,
                                 ArrayList<String> ans, String str) {
        if (i == n - 1 && j == n - 1) {
            ans.add(str);
            return;
        }

        if (i + 1 < n && arr[i + 1][j] == 0 && m[i + 1][j] == 1) {
            arr[i][j] = 1;
            recursion(m, n, arr, i + 1, j, ans, str + 'D');
            arr[i][j] = 0;
        }
        if (j + 1 < n && arr[i][j + 1] == 0 && m[i][j + 1] == 1) {
            arr[i][j] = 1;
            recursion(m, n, arr, i, j + 1, ans, str + 'R');
            arr[i][j] = 0;
        }
        if (i - 1 >= 0 && arr[i - 1][j] == 0 && m[i - 1][j] == 1) {
            arr[i][j] = 1;
            recursion(m, n, arr, i - 1, j, ans, str + 'U');
            arr[i][j] = 0;
        }
        if (j - 1 >= 0 && arr[i][j - 1] == 0 && m[i][j - 1] == 1) {
            arr[i][j] = 1;
            recursion(m, n, arr, i, j - 1, ans, str + 'L');
            arr[i][j] = 0;
        }
    }

    public static ArrayList<String> findPathBetter(int[][] m, int n) {
        int arr[][] = new int[n][n];
        ArrayList<String> ans = new ArrayList<>();
        if(m[0][0] == 1) {
            int di[] = {+1, 0, -1, 0};
            int dj[] = {0, +1, 0, -1};
            recursionBetter(m,arr,0,0,n,di,dj,"",ans);
        }
        return ans;
    }

    public static void recursionBetter(int m[][], int arr[][], int i, int j, int n,
                                 int di[], int dj[], String str, ArrayList<String> ans) {
        if(i == n-1 && j == n-1) {
            ans.add(str);
            return;
        }

        String a = "DRUL";
        for(int ind = 0;ind < 4; ind++) {
            int nexti = i + di[ind];
            int nextj = j + dj[ind];

            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && arr[nexti][nextj] == 0
                    && m[nexti][nextj] == 1) {
                arr[i][j] = 1;
                recursionBetter(m, arr, nexti, nextj, n, di, dj, str + a.charAt(ind), ans);
                arr[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE NEED TO FIND THE DIRECTIONS A RAT TAKE IN REACHING THE END OF 2D ARRAY,
         * THE GIVEN 2D ARRAY HAS 0s AND 1s, 0 MEANS WE ARE NOT ALLOWED TO VISIT AND 1 MEANS WE CAN.
         *
         * APPROACH
         *
         * WE WILL USE RECURSION AT EVERY STEP AND WILL USE A 2ND ARRAY AS A FORM OF TRACKER
         *
         * BRUTE APPROACH
         *
         * CALL RECURSION IF 0,1 2D ARRAY 0TH ROW AND 0TH COLUMN HAS 1, CALLING THIS BECAUSE NO POINT IN TRAVERSING IF THE FIRST
         * STEP IS NOT ALLOWED TO VISIT.
         *
         * HAVE FOUR IF CASES UP DOWN LEFT RIGHT
         *
         * FOR DOWN, CHECK IF I+1 < N AND THAT POSITION IS UNVISITED USING VISIT ARRAY AND CHECK IF 0, 1 ARRAY HAS 1 AT THAT INDEX
         * IF IT IS THEN ADD D TO STRING AND MARK THE VISIT AT CURRENT I,J AS TRUE AND CALL RECURSION FOR I+1,J
         * FOR UP, CHECK I-1 >= 0, CALL RECURSION FOR I-1, J , ADD U TO STRING
         * FOR LEFT, CHECK J-1 >=0 , CALL RECURSION FOR I,J-1, ADD L TO STRING
         * FOR RIGHT CHECK J+1 < N, CALL RECURSION FOR I, J+1, ADD R TO STRING
         *
         * MAKE SURE TO MARK VISIT[I][J] AS FALASE ONCE WHEN RETURN ON BACKTRACK
         *
         * BASE CASE
         * WHEN I+1 IS N AND J+1 IS N, MEANS WE HAVE REACHED THE FINAL INDEX AND HENCE ADD THE RESULT STRING TO ANS
         * THE ABOVE STATEMENT IS SAME FOR I == N-1, J == N-1.
         *
         * BETTER APPROACH
         *
         * AS THE ABOVE APPROACH IS USING LOT OF IFS AND IS LONG ITS BETTER TO USE 2 DUMMY ARRAYS DI DJ TO TRACK THE CURRENT
         * INDEX
         *
         * AS WE KNOW WHEN DOWN DI HAS 1 AND DJ AS 0, WHICH IS SIMPLY BECAUSE I MOVES BY 1, SIMILALRY FOR OTHER POSITIONS
         * DI AND DJ WOULD BE CARRYING 1S AND 0S
         *
         * NOW RATHER THAN 4 DIFFERENT IF CASES USE A SINGLE IF, RUN A LOOP FOR IND 0-3, DEFINE A STRING REPRESENTING
         * THE POSITIONS IN DI DJ, EG
         *             int di[] = {+1, 0, -1, 0};
         *             int dj[] = {0, +1, 0, -1};
         *
         *             FOR ABOVE ARRAY THE POSITIONS STRING WOULD BE DRUL
         *
         * GET THE CHAR TO BE ADDED IN STRING FROM CHAR AT THAT INDEX
         * GET THE NEXTI AND NEXTJ BY ADDING THE IND TO I & J
         *
         * OTHER STEPS ARE SAME LIKE CHECKING NEXTI & NEXTJ ARE GREATER THAN OR EQ TO 0 OR SMALLER THAN N, MARKING
         * CURRENT INDEX AS VISITED, CALLING RECURSION FOR NEXTI,NEXTJ AND MARKING VISIT ARRAY AS FALSE FOR I J WHILE BACKTRACKING
         *
         */
    }
}
