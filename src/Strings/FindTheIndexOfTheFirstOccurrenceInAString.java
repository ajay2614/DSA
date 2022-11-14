package Strings;

public class FindTheIndexOfTheFirstOccurrenceInAString {
    /**
     *
     * BIG O (N*M)
     */
    public static int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();

        int i = 0;

        while(i < n1) {
            while(i < n1 && haystack.charAt(i) != needle.charAt(0)) {
                i++;
            }

            if(i + n2 <= n1 && haystack.substring(i,i+n2).equals(needle))
                return i;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION SIMPLY INCREMENTING IND TILL THE FIRST CHAR IS NOT MATCHED, AFTER IT MATCHES
         * CHECK FOR SUBSTRING FROM I TO N2, IF THE MATCH RETURN I
         * THIS IS SIMPLY A BRUTE APPROACH, THE BETTER ALGOS ARE RABIN KARP AND KMP.
         */
        strStr("mississippi","issip");
    }
}
