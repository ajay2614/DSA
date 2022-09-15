package Arrays;

public class Pow {
    /**
     *  Time Complexity: O(log n)
     *  Space Complexity: O(1)
     */
    public double myPow(double x, int n) {

        double ans = 1.0;
        long nn = n;

        if(nn < 0)
            nn = -1 * nn;

        while(nn > 0) {
            if(nn % 2 == 1) {
                ans *= x;
                nn = nn-1;
            }
            else {
                x *= x;
                nn = nn/2;
            }
        }

        if(n < 0)
            ans = 1.0 / ans;
        return ans;
    }
    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE HAVE TO FIND POWER, EG X = 2, N = 4, THEN 2 ^ 4 IS WHAT WE NEED TO FIND
         *
         * BRUTE APPROACH
         *
         * WE CAN USE BRUTE APPROACH, TAKE DUMMY VARIABLE AND STORE N, IF N < 0, THEN FIRST MULTIPLY DUMMY BY -1,
         * AFTER THIS TAKE ANS VARIABLE RUN LOOP TILL N > 0, DECREMENT N EVERY TIME, IN THE END IF THE N WAS SMALLER
         * THAN 0 THAN RETURN ANS AS 1.0/ANS, DO REMEMBER TO TAKE N AS LONG AND NOT INT, WHY BECAUSE
         * IF N WAS INT_MIN VALUE THAN MULTIPLYING BY -1 IT WILL OVERFLOW,
         *
         * BETTER APPROACH
         *
         * AS WE KNOW 2 ^ 4 CAN ALSO BE WRITTEN AS 2 * 2 ^ 2, WHICH IS 4 ^ 2, AND 4 ^ 2 CAN ALSO BEW WRITTEN AS
         * (4 * 4) ^ 1, SO WE TAKE ANS VARIABLE, RUN WHILE TILL NN > 0, IF NN % 2 == 0, THEN X CAN ALSO BE WRITTEN AS
         * X * X, AS 2 ^ 4, 4 IS EVEN HENCE IT CAN BE WRITTEN AS (2 * 2) ^ 2, AND IF NN % 2 == 1, THEN IT CAN BE WRITTEN
         * AS ANS *= X, WHICH IS JUST LIKE EVALUATING 4 * 4,
         *
         * ANOTHER EG
         *
         * WE TAKE 2 ^ 6
         *
         * FIRST 6 % 2==0, SO X BECOMES 2 * 2 = 4, AND N BECOMES 3
         * ANS BECOMES 4 AND N BECOMES 2,
         * X BECOMES 4 * 4, N BECOMES 1
         * ANS BECOMES 64 N BECOMES 0
         *
         * HENCE PROVEN, THIS METHOD WORKS
         *
         */
    }
}
