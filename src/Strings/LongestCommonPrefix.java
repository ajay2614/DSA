package Strings;

public class LongestCommonPrefix {

    /**
     *
     * TC : BIG O(NM)
     */
    public static String longestCommonPrefixBrute(String[] strs) {
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        int n = strs.length;
        for(int i = 0;i<n;i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        int i = 0;
        while(i < minLength) {
            char a = strs[0].charAt(i);
            boolean isSame = true;
            for(int j=1;j<n;j++) {
                if(a != strs[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame)
                break;
            ans += strs[0].charAt(i);
            i++;
        }
        return ans;
    }

    /**
     * BIG O(N)
     * BIG O(1)
     */
    public static String longestCommonPrefix(String[] strs) {

        int n = strs.length;
        if(n == 0)
            return "";
        String smallest = strs[0];
        String largest = strs[0];

        for(int i=1;i<n;i++) {
            if(strs[i].compareTo(smallest) < 0)
                smallest = strs[i];
            else if(strs[i].compareTo(largest) > 0)
                largest = strs[i];
        }

        int start = 0;
        int end = 0;
        for (int i=0;i<smallest.length();i++) {
            if(smallest.charAt(i) == largest.charAt(i))
                end++;
            else
                break;
        }
        return smallest.substring(start, end);
    }


    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE LONGEST COMMON PREFIX
         * SUPPOSE FOR BELOW ARRAY FL WOULD BE LONGEST COMMON
         *
         * FIRST WE WILL FIND THE MIN LENGTH ARRAY
         *
         * AFTER THIS WE WILL RUN TILL SMALLEST ARRAY LENGTH, THIS IS DONE THERE COULD BE CASE WHERE STRING IS
         * F AND OTHER STRINGS ARE FLO AND FL, SINCE IF WE HAD USED ANY RANDOM STRING TO ITERATE, WE WOULD HAVE BEEN OUT OF
         * BOUNDS WHILE CHECKING FOR F, RUN A NESTED LOOP FROM I TO MIN ARRAY LENGTH AND FROM 0 ARR.LENGTH-1 FOR TRACKING
         * OTHER ARRAY STRINGS, CHECK WHETHER THE CHAR AT I == ARRAY STRING CHAR AT I, IF IT IS I++, AND CHECK AGAIN FOR
         * ALL ARRAY ELEMENTS, THE STAGE WHERE CHAR AT I IS NOT EQUAL, BREAK OUT AND RETURN RESULTANT STRING.
         *
         */

        /**
         * OPTIMAL APPROACH
         *
         * WE WILL SIMPLY HAVE LEXICOGRAPHICALLY SMALLEST STRING AND LARGEST STRING BY USING COMPARE TO
         * FOR EVERY ARRAY INDEX WITH INITIALLY KEEPING SMALLEST AND LARGEST AS 0TH INDEX STRING.
         *
         * NOW AFTER THIS WE WILL SIMPLY MATCH THE CHARACTERS MATCHING, AFTER THIS SIMPLY RETURN THIS AS SUBSTRING
         * OF 0 AND CHARACTERS MATCHING
         *
         * WHY THIS WILL ALWAYS WORK,
         * SUPPOSE FOR BELOW ARRAY FLIGHT IS SMALLEST LEXICOGRAPHICALLY AND FLOWER IS LARGEST, ONCE AFTER COMPARE TO
         * WE CAN SIMPLY COMPARE THEIR CHARACTERS MATCHING WHICH ARE FIRST 2, SINCE A CONFUSION MIGHT ARISE THAT FLOW
         * WAS SMALLER, WHAT IF ANY OTHER SMALLER STRING SAY FL WAS THERE, THEN IT WAS BOUND TO BECOME SMALLEST BY LEXICOGRAPHICAL
         * COMPARISON.
         *
         */
        String arr[] = {"flower","flow","flight"};
        longestCommonPrefixBrute(arr);
        longestCommonPrefix(arr);
    }
}
