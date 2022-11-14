package DynamicProgramming;

public class LongestPalindromeSubstring {
    /**
     * TC : BIG O(N^3) (NOT SURE)
     */
    public String longestPalindromeBrute(String s) {
        int n = s.length();

        String ans = "";

        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if(check(i, j, s)) {
                    if(s.substring(i, j+1).length() > ans.length())
                        ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }

    public boolean check(int i, int j, String s) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

    /**
     * TC : BIG O(NM)
     */
    public static String longestPalindrome(String s) {

        int n = s.length();
        int dp[][] = new int[n][n];

        int end = 0;
        int start = 0;
        for(int i=0;i<n;i++) {
            dp[i][i] = 1;
        }

        for(int i=0;i<n-1;i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = 1;
                start = i;
                end=i+1;
            }
        }

        int k = 2;
        int row = 0;
        /**
         * CAN ALSO BE WRITTEN AS WHILE(I < N) WITH AN IF CHECK IF COL >= N THEN BREAK, WHY GREATER THAN BECAUSE AND NOT JUST ==
         * FOR SUPPOSE TEST CASE "A" HERE COL WOULD BE 2, BUT LENGTH WOULD HAVE BEEN 1, SO LOOP WOULD HAVE BEEN RUNNING
         * INDEFINITELY
         */
        while (k < n) {
            int col = row + k;

            while (col < n) {
                if(s.charAt(row) == s.charAt(col) && dp[row+1][col-1] == 1) {
                    dp[row][col] = 1;
                    start = row;
                    end = col;
                }
                row++;
                col++;
            }
            row = 0;
            k++;
        }
        return s.substring(start, end+1);
    }
    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WHAT WE HAVE TO DO IS TO GET THE LONGEST PALINDROMIC SUBSTRING
         *
         * APPROACH
         *
         * WE WILL USE DP TO SOLVE THIS QUESTION
         *
         * NOW WE REALIZE THAT A SUBSTRING IS PALINDROME, IF IT'S FIRST AND LAST CHARACTER ARE EQUAL AND THE STRING BETWEEN IS
         * A PALINDROME, FOR EG FOR ABBASD, ABBA IS PALINDROME, BECAUSE A AND A MATHCES AND SUBSTRING BB IS PALINDROME
         *
         * STEPS
         *
         * WE WILL USE START AND END VARIABLE INDICATING THE BEG AND END OF SUBSTRING WHICH IS LARGEST PALINDROME
         * WE WILL FIRST MARK EVERY SINGLE CHAR IN DP ARRAY AS 1, AS EVERY CHAR IS PALINDROME OF ITSELF.
         *
         * NOW WE WILL CHECK FOR LENGTH 2 CHARACTERS, WILL MARK DP[I][I+1] AS TRUE FOR EVERY CHAR AT I EQ AT I+1, MAKE SURE
         * TO ADD THE START AND END AS I AND I+1.
         *
         * NOW WE WILL CHECK FOR LENGTH 3 AND GREATER LENGTHS, HERE WE WILL APPLY THE LOGIC OF CHECKING FIRST AND LAST CHARACTER
         * AND SUBSTRING IN BETWEEN, SINCE TO GET THE SUBSTRING IN BETWEEN WE WOULD NEED TO CHECK THE DP TABLE
         * AT FIRST CHAR + 1, AND LAST CHAR -1, (FOR ABBA, WE NEED TO CHECK BB HENCE FIRST CHAR + 1 AND LAST -1),
         * SINCE WE WILL BE STARTING FROM LENGTH 3 CHAR, WE WOULD NEED A VARIABLE K REPRESENTING LENGTH,
         * THE ROW WILL START FROM 0 AND COL WILL START FROM ROW + LENGTH, RUN AN INNER LOOP TILL COL < N,
         * NOW CHECK IF FIRST AND LAST CHAR MATCH AND DP[ROW+1][COL-1] IS 1, IF IT IS MARK THIS DP[ROW][COL] AS 1 AND INCREASE
         * ROW AND COL, AND MARK START AND END AS ROW AND COL
         * AFTER EXITING THIS INNER LOOP MAKE ROW AS 0 AS WE WILL BE STARTING FOR GREATER THAN PREV LENGTH, ALSO INCREASE THE K
         * BECAUSE WE NEED TO INCREASE LENGTH
         * FOR EG FOR ABBACD, AFTER COMPLETING FOR LENGTH 3 ABA IT WILL BE CHECKING ABBA, IT IS FOR THIS REASON WE ARE
         * NOT APPLYING ANY EXTRA LOGIC ON START AND END AS START AND END WILL ALWAYS GET VALUE OF MAX LENGTH PALINDROME
         *
         * IN THE END RETURN SUBSTRING OF START, END+1.
         */
        String s = "aaaaa";
        longestPalindrome(s);
    }
}
