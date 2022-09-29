package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char arr[][] = new char[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                arr[i][j] = '.';
            }
        }
        recursion(arr, ans, 0, n);
        return ans;
    }

    public void recursion(char[][] arr, List<List<String>>  ans, int col, int n) {
        if(col == n) {
            List<String> list= getList(arr);
            ans.add(list);
            return;
        }
        for(int i=0;i<n;i++) {
            if(check(arr, i, col, n)) {
                arr[i][col] = 'Q';
                recursion(arr, ans, col+1, n);
                arr[i][col] = '.';
            }
        }
    }
    public boolean check(char arr[][], int row, int col, int n) {
        int i = row;
        int j = col;

        while(i >= 0 && j >= 0) {
            if(arr[i--][j--] == 'Q')
                return false;
        }
        i = row;
        j = col;

        while (i < n && j >= 0) {
            if(arr[i++][j--] == 'Q')
                return false;
        }
        i = row;
        j = col;
        while (j >= 0) {
            if(arr[i][j--] == 'Q')
                return false;
        }
        return true;
    }

    public List<String> getList(char ch[][]) {
        List<String> list = new ArrayList<>();
        for(char c[] : ch) {
            String s = new String(c);
            list.add(s);
        }
        return list;
    }

    /**
     * THE QUESTION IS VERY INTERESTING, GIVEN AN INTEGER N, WE NEED TO FIND OUT ALL THE WAYS WE CAN HAVE N QUEENS
     * EVERY COLUMN HAS A QUEEN, WE NEED TO FIND THE WAYS WE CAN POSITION THEM SO THAT NO QUEEN CANCEL OTHER
     * NOW THE IMPORTANT THING TO NOTICE IS THAT WE NEED THE ANSWER IN FORM OF LIST<LIST<STRING>> WHERE
     * A LIST<STRING> HAS ALL THE POSITIONING OF QUEENS ROW WISE,
     *
     * SOMETHING LIKE THIS  [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]] IS GOING TO BE THE ANSWER,
     *
     * WE WILL SOLVE THIS USING RECURSION
     *
     * APPROACH IS TO SIMPLIFY THE QUESTION, WE USE A CHARACTER ARRAY, AND WE INPUT DOTS AT EVERY INDEX.
     *
     * NOW WE WILL RUN RECURSION FROM 0 TO NTH COLUMN,
     *
     * INSIDE RECURSION WE WILL RUN A FOR LOOP FOR ROW PLACEMENT, IN THIS LOGIC WE WILL SEE THAT WHETHER WE CAN ACTUALLY
     * SLOT A QUEEN. WE WILL RUN THIS FROM 0 TO N ROW, IF THERE IS ANY ROW WHERE WE CAN PLACE WE WOULD CALL RECURSION
     * FOR NEXT COLUMN INDICATING QUEEN HAS BEEN SUCCESSFULLY SLOTTED FOR THAT COLUMN,
     *
     * THE WAY WE WILL CHECK WHETHER THE GIVEN QUEEN CAN BE SLOTTED AT THAT PARTICULAR ROW COLUMN IS TO
     * EVALUATE ITS LEFT UP DIAGONAL, ITS LEFT DOWN DIAGONAL AND ITS SAME ROW FROM LEFT SIDE.
     *
     * WHY ARE WE CHECKING FROM LEFT, BECAUSE WE ARE PLACING A QUEEN COLUMN BY COLUMN, WE ARE SURE THAT RIGHT SIDE WOULD
     * BE EMPTY AS COLUMNS ARE INSERTED FROM LEFT TO RIGHT, ALSO EACH COLUMN WILL ONLY HAVE ONE QUEEN SO NO NEED TO CHECK
     * FOR SAME COLUMN, SO THAT IS WHY WE ARE CHECK ALL THE WAY QUEEN CAN ATTACK, WHICH IS SURELY FROM LEFT SIDES.
     *
     * AFTER THIS WHEN WE REACH BASE CASE IE COL == N, WE KNOW ALL THE QUEENS HAVE BEEN SLOTTED, THEN WE WILL
     * CONVERT 2D CHAR ARRAY IN 1D LIST OF STRING ANS STORE IT IN ANS.
     *
     * STEPS
     *
     * RUN RECURSION FROM COLUMN 0
     *
     * IN RECURSION RUN FOR LOOP FROM 0 TO N FOR DECIDING WHICH ROW CAN HAVE THE QUEEN
     *
     * CHECK FOR EVERY QUEEN WHETHER IT IS SAFE TO SLOT IN THAT ROW COLUMN, RUN A CHECK
     *
     * THE CHECK IS DONE IN THREE WAYS
     *
     * RUN A WHILE LOOP FOR LEFT UP DIAGONAL, RUN WHILE LOOP TILL I >= 0, J >= 0, AND J--, IF WE FOUND Q, MEANS
     * THAT Q CAN ATTACK HENCE FALSE FOR THAT ROW COLUMN
     *
     * NOTE: J WILL BE J >= 0, AND NOT J > 0, BECAUSE WE ARE USING 0 BASE INDEXING, NOT TO CONFUSE WITH A FOR LOOP.
     *
     * RUN A WHILE LOOP FOR LEFT DOWN DIAGONAL, RUN LOOP TILL I < N AND J >= 0, I++, J--
     * RUN A WHILE LOOP FOR LEFT SIDE, J >= 0, J--
     *
     * IF NO Q IS FOUND RETURN TRUE, MARK THAT ROW COLUMN AS Q AND RUN FOR NEXT COLUMN, MAKE SURE TO
     * MARK THAT ROW COLUMN BACK TO . ONCE RETURN FROM RECURSION SO THAT WE CAN SUCCESSFULLY BACKTRACK
     *
     * AFTER THIS IN RECURSION WHEN BASE CASE IS TRUE THAT IS COLUMN == N, THEN CONVERT CHAR ARRAY TO LIST
     *
     * ITERATE THROUGH CHAR ARRAY GETTING ROWS, SIMPLY CONVERT THAT INTO STRING AND ADD INTO LIST, AFTER THIS RETURN THE LIST
     *
     * ADD THE LIST INTO ANSWER.
     */

}
