package Arrays;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    /**
     * Time Complexity: O( N2 )
     *
     * Space Complexity: O(N) where N is the size of HashSet taken for storing the elements
     */
    public static int lengthOfLongestSubstringBruteForce(String s) {
        int n = s.length();
        if(n==0)
            return 0;
        int max = 0;

        for (int i=0;i<n;i++) {
            HashSet<Character> hashSet = new HashSet<>();
            int count = 0;
            for (int j=i;j<n;j++) {
                if(!hashSet.contains(s.charAt(j))) {
                    hashSet.add(s.charAt(j));
                    count++;
                }
                else {
                    break;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    /**
     * Time Complexity: O( 2*N ) (sometimes left and right both have to travel complete array)
     *
     * Space Complexity: O(N) where N is the size of HashSet taken for storing the elements
     */
    public int lengthOfLongestSubstringSecondBestSoln(String s) {
        int n = s.length();
        if(n==0)
            return 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int l = 0;

        for(int r = 0; r < n ; r++) {
            if(set.contains(s.charAt(r))) {
                while(l < r && set.contains(s.charAt(r))) {
                    set.remove(s.charAt(l));
                    l++;
                }
            }
            set.add(s.charAt(r));
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
    /**
     * Time Complexity: O( N )
     *
     * Space Complexity: O(N) where N is the size of HashMap taken for storing the elements
     */
    public int lengthOfLongestSubstringBestSoln(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        int r = 0;
        int l = 0;
        int max = 0;
        while(r < n) {
            if(map.containsKey(s.charAt(r)))
                //l coming to either +1 position for eg in abca, l coming to b
                //or l staying where it is for eg in abcaabc, l was at 4 but b is in 1 that means current substring is
                //not even considering that b so simply take l
                l = Math.max(map.get(s.charAt(r)) + 1, l);

            map.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String args[]) {
        /**
         * THE QUESTION STATES THAT FIND THE LENGTH OF LONGEST SUBSTRING WHICH HAS UNIQUE CHARACTERS
         *
         * MEANS ABCABCDE, ABCDE HAS MAX LENGTH AS IT HAS ALL UNIQUE CHARACTERS AND ALSO IT HAS HIGHEST LENGTH AS COMPARED TO
         * ABC.
         *
         * BRUTE FORCE APPROACH
         * IN THE BRUTE FORCE RUN A I * J LOOP, HAVE A VARIABLE COUNT, AND A HASHSET,
         * RUN J LOOP FROM I, KEEP ON ADDING THE CHARACTERS IN HASHSET AND INCREASE COUNT EVERY TIME A NEW ELEMENT IS ADDED,
         * IF THERE EXISTS A CHARACTER, THEN BREAK THE LOOP J, COMPARE WITH MAX. RETURN MAX
         *
         * 2ND MOST OPTIMAL SOLUTION
         *
         * WE CHOSE A LEFT POINTER, WE RUN LOOP FOR RIGHT POINTER, IF WE COME ACROSS ANY CHARACTER THAT'S REPEATING,
         * THEN WE WILL RUN A WHILE LOOP FOR L, CHECKING TILL L<R && HASHSET CONTAINS(CHAR AT R),
         *
         * WE WILL KEEP ON INCREASING THE POINTER L, AND REMOVING ELEMENTS TILL CHAR AT R ISNT THERE IN SET
         *
         * IN THE END CALCULATE MAX WHICH WILL BE MAX OF EITHER L-R + 1 OR MAX
         *
         * BREAKDOWN OF THIS APPROACH
         *
         * WHAT OUR IDEA OF THIS APPROACH IS EVERYTIME WE COME A ACROSS AN ELEMENT THAT'S REPEATING WE WILL DELETE OUR SUBSTRING
         * LENGTH TILL THAT ELEMENT AND REMAINING WE CAN USE IN ANSWER
         *
         * FOR EG FOR B C A A C D E , WE KNOW THAT ACDE IS MAX AS BCA IS SMALLER AND BCAA DOEST HAVE UNIQUE CHARACTER
         *
         * TILL R 2, OUR MAX LENGTH WOULD BE 3 AND THE CHARACTERS IN SET WOULD BE BCA,
         *
         * NOW WHEN WE GET A AT R3 WE KNOW THAT THIS ELEMENT IS REPEATING HENCE WE WANT TO FIND WHERE THE OCCURANCE OF
         * LAST A WAS BEFORE CURRENT A SO WE CAN REMOVE AND GET THE LENGTH
         *
         * WE WILL RUN L FROM 2 TILL SET IS EMPTY, HENCE AFTER THIS WE WILL ADD CURRENT A IN THE SET AND GET LENGTH.
         *
         *
         * BEST/OPTIMAL SOLUTION
         *
         * THE BEST APPROACH IS ALMOST SAME AS 2ND BEST, THE ONLY DIFF IS THAT WHEN WE WERE RUNNING WHILE LOOP FROM L
         * WE WERE TAKING EXTRA BIG O(N), EG IN B C A A C D E, HAD WE KNOWN A AT 2 WHEN WE CAME ACROSS R3 THAT IS A ON
         * 3RD INDEX, WE WOULD HAVE JUST TAKEN THAT LEFT RATHER THAN TRAVERSING ALL THE ELEMENTS TILL THAT LEFT.
         *
         * HOW TO DO:
         *
         * IN THIS WE WILL USE A HASHMAP INSTEAD OF HASHSET, NOW WE WILL RUN A WHILE LOOP FROM R TO N-1
         * EVERYTIME WHEN WE SEE ANY ELEMENT WHICH IS ALREADY PRESENT AT HASHET WE WILL UPDATE LEFT
         * AS MAX (LEFT + 1, SET.CHARACTER CURRENT VALUE)
         *
         * WHY LEFT AS THIS , LETS SAY WE HAVE B C A A B, WHEN A IS GOING TO COME OF 3RD INDEX,
         * WE WOULD UPDATE LEFT AS MAX OF CHAR AT (R) IN MAP + 1, OR LEFT, SO LEFT WOULD BE 3,
         * AND WE WOULD UPDATE MAP, S.CHARATR AND R
         * NOW WHEN WE COME ACROSS B, PREVIOUS APPROACH WOULD HAVE MADE US TRAVERSE THE LOOP BUT NOW WE
         * KNOW THAT TO EVALUATE LEFT WE JUST NEED TO GET THE MAX OF LEFT, OR THE VALUE IN HASHMAP + 1,
         * LEFT WOULD BECOME 4, AND HENCE OUR ANSWER WOULD BE 5-4+1, 2, WHICH IS THE LENGTH
         *
         * BUT MAX WOULD BE 3 OF BCA AT FIRST.
         *
         *
         *
         */

        /**
         * WHY TAKE MAX OF map.get(s.charAt(r)) + 1, l AND NOT JUST MAP.GET(S.CHARAT(R) + 1)
         *
         * POSSIBLE TEST CASE ABBA : NOW HERE WHEN WE WILL REACH A OF 3RD INDEX, L WOULD BE 3 AND S.CHARAT(R) WOULD BE 1
         * SO WE CAN SIMPLY TAKE L AS THAT SUBARRAY IS NOT HAVING ANY REPEATING CHARACTER.
         */
        String s = "aab";
        lengthOfLongestSubstringBruteForce(s);
    }
}
