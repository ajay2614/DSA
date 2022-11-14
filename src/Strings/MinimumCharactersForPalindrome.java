package Strings;

public class MinimumCharactersForPalindrome {

    /**
     * TC : BIG O(N)
     */
    public static int minCharsforPalindrome(String str) {
        int ans = 0;
        int n = str.length();
        int i=0;
        int j=n-1;
        int trim = n-1;
        String tempString = "";

        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            }
            else {
                /**
                 IN A WAY WE ARE ASSUMING WHENEVER THE CHAR AT LEFT DOES NOT MEET RIGHT WE ADD THE CHARACTER AT LEFT
                 **/
                ans++;
                tempString += str.charAt(trim);
                trim--;
                j = trim;
                i = 0;
            }
        }

        String ansString = tempString + str;
        System.out.println(ansString);
        return ans;
    }
    /**
     * TC : BIG O(N)
     */
    public static int getMinimumCharactersCount(String s) {
        int initialLength = s.length();
        StringBuilder sb = new StringBuilder(s);
        s = s + "#" + sb.reverse().toString();
        int n = s.length();
        int lps[] = new int[n];

        int i=0;
        int j=1;

        while(j < n) {
            if(s.charAt(i) == s.charAt(j)) {
                lps[j] = i+1;
                i++;
                j++;
            }
            else if(i==0) {
                j++;
            }
            else {
                i = lps[i-1];
            }
        }
        return initialLength - lps[n-1];
    }

    public static void main(String[] args) {
        /**
         * IN THIS WHAT WE NEED TO DO IS ADD THE CHARACTERS ON THE LEFT TO MAKE A PALINDROME
         *
         * FOR EG FOR A B C, WE NEED TO MAKE IT AS C B A B C
         *
         * WE CAN SIMPLY DO THIS BY USING TWO POINTER APPROACH, SIMPLY COMPARE LEFT AND RIGHT CHARACTERS,IF THEY MATCH
         * INCREASE L AND DECREASE R, USE A VARIABLE TRIM INITIALLY AT LENGTH - 1, WHENEVER THE STRING DON'T MATCH
         * REPLACE ADD THE CHAR FROM TRIM IN A TEMP STRING, DECREMENT TRIM, AND NOW R WOULD BE TRIM AND L WOULD BE 0( 0
         * HERE WOULD MEANS SUPPOSE FOR A B C WHEN A AND C DON'T MATCH WE ADD C AT FRONT, NOW R WOULD BE AT B AND AS I
         * WOULD BE 0, MEANS IT WOULD BE AT A AND NOT AT C WHICH WE HAVE ADDED. AT THE END SIMPLY ADD TEMP STRING WITH INPUT
         * AND RETURN
         *
         * FOR EG FOR A A B A, A AND A MATCHES AT 0 AND 3, NOW L IS 1 AND R IS 2, A AND B DON'T MATCH ADD A IN FRONT
         * (FROM TRIM), DECREMENT TRIM AND NOW J IS AT 2(TRIM), TEMP IS A, COMPARE A AT 0 WITH B AT 2, THEY DON'T MATCH
         * HAVE TRIM CHAR AND ADD TO TEMP (NOW A B), COMPARE A AT 0 WITH A AT 1,
         *
         * COME OUT OF LOOP TEMP STRING IS A B, ADDING IT TO AABA, WE GET A B A A B A, WHICH IS PALINDROME.
         *
         * BASICALLY WHENEVER THE CHARACTER DON'T MATCH WE WE MAKE A PAIR OF CHAR AT TRIM STARTING FROM LAST IN THE FRONT
         *
         *
         */

        /**
         * THE TWO POINTER SOLUTION IS NOT VALID FOR COUNTING THE MINIMUM CHARACTERS THAT NEED TO BE INSERTED IN FRONT,
         * FOR THIS WE NEED TO USE THE KMP ALGORITHM
         *
         * THE APPROACH IS THAT USING KMP ALGO WE CAN FIND LONGEST PREFIX SUFFIX AT LEFT, USING THAT WE CAN SIMPLY SEE
         * THE MIN COUNT REQUIRED
         *
         * STEPS
         *
         * FIRST REVERSE THE STRING AND ADD IT TO THE ACTUAL STRING ALONG WITH A SPECIAL CHARACTER
         *
         * AFTER THIS SIMPLY CALCULATE LPS, WE CAN SIMPLY SUBSTRACT THE LONGEST PREFIX SUFFIX WITH THE TOTAL LENGTH OF ACTUAL
         * STRING
         *
         * FOR EG BAABCD, IN THIS WE NEED TO GET 2 CHARACTERS IN FRONT.
         *
         * NOW WE CAN OBSERVE BAAB IS PALINDROME, SO USING REVERSE OF THIS STRING, WE CAN SEE
         * BAABCD#DCBAAB, THE LONGEST PREFIX WHICH IS SUFFIX IS BAAB, SO WE CAN SIMPLY SUBSTRACT LONGEST PREFIX SUFFIX
         * WITH THE ACTUAL LENGTH, WHICH WAS 6 GIVING US RIGHT ANS.
         *
         */
        minCharsforPalindrome("aeacaa");
        getMinimumCharactersCount("aaaa");
    }

}
