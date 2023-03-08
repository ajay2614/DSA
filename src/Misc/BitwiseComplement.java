package Misc;

public class BitwiseComplement {
    public static int bitwiseComplement(int n) {
        if(n == 0)
            return 1;
        int ans = 0;
        int multi = 1;
        while(n > 0) {
            int binaryDigit = n % 2 == 0 ? 1 : 0;
            ans = binaryDigit * multi + ans;
            multi *= 2;
            n /= 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION GIVEN A NUMBER SAY 5, WE HAVE TO CONVERT INTO IT'S BITWISE COMPLEMENT
         * SO FOR 5 BINARY REPRESENTATION IS 101, SO ITS BITWISE COMPLEMENT WOULD BE 010, WHICH IS
         * 2,
         *
         * FIRST WE WILL COMPARE TILL NUM > 0,
         * WE GET THE FIRST DIGIT BY SIMPLY USING % 2, AS IF ITS 5 IT WILL LEAVE 1, NOW THIS 1, THE BITWISE COMPLEMENT
         * WOULD BE 0, TO CONVERT BACK WE MULTIPLY BY 2 ^ POWER OF THE INDEX OF THAT DIGIT, SINCE
         * FOR 0TH INDEX THIS VALUE WILL BE 1, SO WE START BY HAVING THE MULTI VARIABLE AS 1, AND AFTERWARDS
         * KEEP MULTIPLYING MULTI BY 2 INDICATING THE 2 ^ POWER OF INDEX, AND AT THE SAME TIME DIVIDE THE ACTUAL NUMBER BY
         * 2.
         *
         * EG TO CONVERT A BINARY TO DECIMAL
         *
         * 1 0 1 0 =
         * 0 * 2 ^ 0 = 0
         * 1 * 2 ^ 1  + 0 = 2
         * 0 * 2 ^ 2 + 2
         * 1 * 2 ^ 3 + 2 = 10
         *
         *
         *
         * EG TO CONVERT DECIMAL TO BINARY
         *
         * 5 =
         * 5 % 2 = 1, 5 / 2 = 2
         * 2 % 2 = 0, 2 / 2 = 1
         * 1 % 2 = 1, 1 / 2 = 0
         * HENCE 101
         *
         *
         *
         *
         */
        System.out.println(1 & 1);
        bitwiseComplement(5);
    }
}
