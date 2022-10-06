package Recursion;

public class SolveSudoku {
    public void solveSudoku(char[][] board) {
        recursion(board, board.length, board[0].length);
    }

    public boolean recursion(char[][] board, int m, int n) {

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(board[i][j] == '.') {
                    for(char c='1';c<='9';c++) {
                        if(isPossible(i,j,board,c)) {
                            board[i][j] = c;
                            if(recursion(board, m, n))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPossible(int row, int col, char[][] board, char c) {

        for(int i=0;i<9;i++) {
            if(board[i][col] == c)
                return false;
            if(board[row][i] == c)
                return false;
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /**
         * SUDOKU
         *
         * THERE ARE 9 BLOCKS, EACH BLOCK HAVING 3 * 3 MATRIX, EACH ROW HAS 1-9, COLUMN HAS 1-9, AND BLOCK HAS 1-9
         *
         * TO FILL SUDOKU, WE MUST MAKE SURE THAT THE EMPTY PLACE IS FILLED BY A NUMBER WHICH ISN'T REPEATING IN
         * THAT ROW COLUMN OR BLOCK
         *
         * APPROACH
         *
         * WE WILL ITERATE THROUGH THIS 9 * 9 MATRIX, EVERYTIME WE HAVE A CHARACTER THAT IS EMPTY
         * WE WILL CHECK FOR EVERY CHARACTER, IF THE CHARACTER IS POSSIBLE TO PLACE THERE, THEN WE WILL UPDATE
         * THAT INDEX VALUE WITH THAT CHARACTER AND SIMPLY CALL RECURSION AGAIN, SINCE IT IS A BOOLEAN METHOD, WE WILL
         * RETURN TRUE IF THE NEXT RECURSION RETURNS TRUE, IF NOT WE WILL PLACE THAT CHARACTER AS EMPTY AND KEEP ON CHECKING
         * WITH THE REMAINING CHARACTERS, IF NONE OF THEM RETURNS TRUE WE WILL COME OUT OF THAT FOR LOOP AND RETURN FALSE,
         *
         * SINCE THERE CAN BE CASE WHEN ENTIRE SUDOKU IS FILLED, IN THIS CASE WE WILL NOT ENTER THE IF CHECK CHARACTER IS
         * EMPTY, SO RETURN TRUE IN THE END
         *
         * IS POSSIBLE METHOD
         *
         * AS WE HAVE TO CHECK FOR ROW COLUMN AND BLOCK
         *
         * WE WILL RUN FOR LOOP FROM I TO N
         *
         * TO CHECK FOR ROW WE WILL USE BOARD[ROW][I]
         * TO CHECK FOR COLUMN WE WILL USE BOARD[I][COL]
         *
         * TO CHECK FOR BLOCK WE WILL USE A BOARD[3 * ROW/3 + I/3][3 * COL / 3 + I % 3]
         *
         * BREAKDOWN OF ABOVE
         * WITH THE HELP OF ROW/3 WE WILL BE ABLE TO GET WHICH BLOCK OF ROW, WE NEED TO CHECK, AS IF WE VIEW FROM LEFT
         * WE SEE THREE BLOCKS, SOW FOR SAY ROW 5, 5/3 = 1, WOULD GIVE US ROW'S BLOCK
         *
         * NOW WHY MULTIPLYING WITH 3, AS THERE ARE THREE BLOCKS, TO GET THE STARTING ROW NUMBER OF THAT BLOCK WE DO MULTIPL
         * WITH 3, SO THIS WOULD GIVE US 3, WHICH IS INDEED THE STARTING ROW OF 3RD BLOCK, NOW WHY I/3, TO GET THE EXACT ROW IN
         * THAT BLOCK WE DO I/3, FOR EG FOR 4, I/3 WOULD 1, 3+1 = 4, MEANS 4TH ROW
         *
         * SIMILARLY FOR COLUMN COL/3 WILL GIVE US BLOCK OF THAT COLUMN, FOR EG FOR COLUMN 7, WE GET COLUMN 2, 3*2 = 6,
         * WHICH IS FIRST COLUMN OF THE 3RD BLOCK, NOW I%3 FOR 4%3, WE GET 1ST HENCE WE GET EXACT COLUMN AS 6TH.
         *
         *
         *
         */
    }
}
