package Strings;

public class KMP {
    /**
     *
     * TC : BIG O(N+M)
     */
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        int[] lps = getLpsArray(needle, n2);
        int i = 0;
        int j = 0;

        while(i < n1 && j < n2) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            else if(j==0) {
                i++;
            }
            else {
                j = lps[j-1];
            }
        }

        if(j == n2)
            return i-j;
        return -1;
    }
    public static int[] getLpsArray(String pat, int n) {
        int lps[] = new int[n];
        int i = 0;
        int j = 1;

        while (j < n) {
            if(pat.charAt(i) == pat.charAt(j)) {
                i++;
                lps[j] = i;
                j++;
            }
            else if(i == 0) {
                lps[j] = 0;
                j++;
            }
            else {
                i = lps[i-1];
            }
        }

        return lps;
    }
    public static void main(String[] args) {

        String a = "ABCABCXYZABCABCA";

        getLpsArray(a, a.length());

        /**
         * VERY HARD
         *
         * HOW TO COMPUTE LPS ARRAY
         *
         * WHAT LPS ARRAY WILL REPRESENT IS AT EVERY STAGE HOW MANY ELEMENTS IN PREFIX ARE SAME AS SUFFIX
         *
         * FOR EG IF LPS[5] = 3, THIS MEANS FIRST 3 ELEMENTS OF PREFIX ARE SAME AS LAST 3 OF SUFFIX.
         * WHAT WE WILL DO IS USE TWO POINTERS I AND J, WHERE I WILL REPRESENT LENGTH AND J WOULD REPRESENT LAST ELEMENT
         * CHECKED AS A SUFFIX, NOW THIS LAST ELEMENT CAN BE STANDALONE OR HAVING A SUBSTRING.
         *
         * HOW TO COMPUTE, I WILL START FROM 0 AND J WILL START FROM 1, EVERY TIME A CHAR MATCHES, ADD
         * I + 1, IN THE LPS ARRAY FOR THAT J, AND INCREMENT J.
         *
         * FOR EG FOR ABOVE ARRAY FOR INDEX 0, WOULD BE 0 AS FOR 0 IS NOT SUFFIX AND ONLY PREFIX YET,
         * NOTE : IND 0 ALWAYS HAS LPS 0, NOW FOR 1, WOULD BE 0, FOR 2, WE HAVE I AND J HAVING SAME CHARACTER, IT MEANS
         * A IS ALSO A PREFIX AND SUFFIX IN THIS CASE, ADD I+1, IN THIS CASE WOULD BE 0+1, REPRESENT LENGTH OF PREFIX AND
         * SUFFIX AS 1, ALSO REPRESENTING THE FACT THAT HERE LPS[2] = 1, MEANS 1ST AND LAST ELEMENT FOR THIS SUBARRAY ARE SAME.
         * (HAVE COMMON PREFIX AND SUFFIX WHICH IS A). NOW B COMES AT IND 3, MEANS LPS[3] = I+1, AS I WAS 1 IT WOULD BE 2,
         * MEANING NOW WE HAVE AB AS PREFIX AND SUFFIX,
         * NOW WHEN B AT IND 4 COMES WE COMPARE WITH CHAR AT I, AS THEY DON'T MATCH WE CHECK LPS FOR CHAR AT I-1, WHICH HERE
         * WOULD LPS[1], AS LPS[1] = 0, IT MEANS WE CAN ONLY COMPARE IT WITH A AT 0
         *
         * FURTHER BREAKDOWN OF THIS STEP
         *
         * SUPPOSE FOR THE ABOVE INPUT ARRAY LPS[14] WOULD BE 6, MEANING FIRST SIX ARE EQUAL FROM J AS 9 TO 14 AS SUFFIX,
         * NOW IF IT WAS BRUTE WE WOULD HAVE MOVED BACK, BUT FOR THIS WE CAN SIMPLY CHECK LPS AT [6] WHICH IS 3, MEANS
         * FIRST 3 AND LAST 3 WERE EQUAL SO FROM THAT WE CAN MOVE OUR I POINTER CHECKING WHETHER ANY ELEMENT NOW IS EQUAL
         * TO CURRENT ELEMENT, REMOVING OUR NEED OF ENTIRE BACKTRACKING
         *
         * FURTHER EXPLANATION : https://youtu.be/jXUP-sAzXRQ
         *
         *
         *
         *
         */

        /**
         * FOR THE SECOND PART WE ARE USING THE SIMILAR LOGIC, IN THIS WE PLACE I ON STRING AND J ON STRING TO BE SEARCHED
         * IF CHAR MATCHES INCREMENT BOTH, ELSE IF J IS 0, WE CAN ONLY INCREMENT I, OTHERWISE WE WILL GET THE LPS FOR J-1,
         * IN THIS CASE IT WOULD REPRESENT THE CHARACTERS COVERED, WHEN J WILL BECOME M, SIMPLY RETURN I-J
         *
         * WHY I-J, SUPPOSE FOR SANDART AND SAND, I WOULD BE AT 4 AND J ALSO AT 4, SO 4-4 IS 0 STATING THE INDEX WHERE IT
         * FIRST OCCURS.
         */
    }
}
