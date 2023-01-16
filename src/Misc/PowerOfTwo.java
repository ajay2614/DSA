package Misc;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        return n> 0 && (n & n-1) == 0;
    }
    public static void main(String args) {
        /**
         * WE ARE ASKED TO FIND WHETHER 2 ^ M == N, NOW BIT WISE 2 ^ 0 = 1, 2 ^ 1 = 10, 2 ^ 2 = 100, AND
         * FOR EG 2 ^ 2 WHICH IS 4 IS EQ TO 100, AND 3 IS EQ TO 011, SO IF N & N-1, == 0 MEANS IT IS DIVISIBLE BY 2
         * CHECKING FOR > 0 BECAUSE 2 CAN NEVER HAVE ANY POWER EQ TO 0, AND THERE ARE NEGATIVE NUMBERS IN TEST CASES
         */
    }
}
