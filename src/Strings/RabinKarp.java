package Strings;

public class RabinKarp {

    /**
     * Time Complexity:
     *
     * The average and best-case running time of the Rabin-Karp algorithm is O(n+m), but its worst-case time is O(nm).
     *
     * The worst case of the Rabin-Karp algorithm occurs when all characters of pattern and text are the same as the
     * hash values of all the substrings of txt[] match with the hash value of pat[].
     */
    public static int rabinKarp(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();

        if(n1 < n2)
            return -1;

        int alphabets = 26;

        long actualHashCode = rabinKarpHashCode(needle, alphabets);

        long possibleHashCode = rabinKarpHashCode(haystack.substring(0,n2), alphabets);

        if(possibleHashCode == actualHashCode && haystack.substring(0,n2).equals(needle))
            return 0;
        for(int i=1;i<n1-n2+1;i++) {
            long prev = haystack.charAt(i-1) * (long) Math.pow(alphabets,n2-1);
            possibleHashCode = (possibleHashCode - prev) * alphabets + haystack.charAt(i+n2-1);

            if(possibleHashCode == actualHashCode && haystack.substring(i,i+n2).equals(needle))
                return i;
        }
        return -1;
    }

    public static long rabinKarpHashCode(String s, int alphabets) {
        int n = s.length();

        long res = 0;
        int j = n-1;
        for(int i=0;i<n;i++) {
            res += s.charAt(i) * (long) Math.pow(alphabets, j--);
        }
        return res;
    }


    public static void main(String args[]) {
        rabinKarp("ababcaababcaabc", "ababcaabc");

        /**
         * RABIN KARP IS AN OPTIMIZED METHOD OF MATCHING SUBSTRING.
         *
         * SINCE IN BRUTE APPROACH WE USED TO COMPARE IF FIRST CHAR MATCHES, AND THEN RUN ANOTHER LOOP BUT SINCE IF THE PATTERN
         * DIDN'T MATCH WE USED TO MOVE BACK TO THE IND, SO TO REMOVE THIS WE USE RABIN KARP
         *
         * IN RABIN KARP THE APPROACH IS SUPPOSE THERE IS PATTERN P, WE WILL GENERATE HASHCODE FOR IT, AND THEN WHILE
         * FINDING IN STRING WE COMPARE THE SUBSTRINGS HASHCODE(ONLY WILL FIND FIRST SUBSTRING HASHCODE AND THEN WILL KEEP
         * ON ADDING OR SUBTRACTING IN THAT HASHCODE BASED ON THE ALPHABET), AND WILL ONLY COMPARE SUBSTRING TO PATTER ONLY WHEN
         * THE HASHCODE MATCHES. THIS WAY LOT OF STEPS WOULD BE REDUCED.
         *
         * STEPS
         *
         * GENERATING HASHCODE.
         *
         * SUPPOSE THERE IS A STRING A B C,
         * WHAT WE WILL DO IS FIRST GET THE ASCII VALUE OF THE CHARACTER
         * AND AFTER THIS SINCE THE LENGTH IS 3, SO INITIALLY WE WILL DECLARE A VARIABLE SAY J AND ITS VALUE WILL BE LENGTH - 1
         * WE WILL MULTIPLY THE FIRST CHARACTER ASCII VALUE BY ALPHABETS POWER J, SO FOR A VALUE WOULD BE
         *
         * ASCII VALUE OF A * 26 ^ 2
         * AFTER THIS WE WILL DECREMENT J FOR NEXT VALUE
         *
         * AT EVERY STAGE WE WOULD WE WILL CALCULATE ASCII VALUE AND MULTIPLY WITH 26 ^ J
         * SO FOR B IT WOULD BE
         *
         * ASCII VALUE OF B * 26 ^ 1 ADD IT TO ANS AND SO ON.
         *
         * MATCHING HASHCODE
         *
         * INITIALLY GET HASHCODE OF THE SUBSTRING(0,LENGTH OF PATTERN), CHECK IF IT MATCHES THE HASHCODE AND SUBSTRING IS SAME AS
         * PATTERN, IF IT IS RETURN TRUE
         * ELSE
         * RUN A FOR LOOP FROM 1 TO LENGTH OF STRING - LENGTH OF PATTERN, WHY LENGTH OF STRING - LENGTH OF  PATTERN
         * AS SUPPOSE FOR STRING A B C D, L IS 4, AND PATTERN IS B C D, LENGTH IS 3, AS THE WINDOW WOULD COVER 3 AT A TIME MEANING
         * WINDOW WILL BE GENERATED TWICE SO 4 - 3 = 1, AND SINCE IT IS 0 BASE INDEXING HENCE THE VALUE 1.
         *
         * AS THE FIRST SUBSTRING DIDN'T MATCH, TO CHECK FOR NEXT SUBSTRING WHAT WE WOULD NEED TO DO IS REMOVE THE FIRST CHARACTER
         * ENTIRE HASH VALUE (A * 26 ^ 2)
         * WHICH IS CHARACTER AT INDEX - 1, AND MULTIPLY THE ALPHABET(26)
         * FOR EG A B C WASN'T EQUAL TO B C D HASH VALUE, SO REMOVE A HASH VALUE, NOW SINCE WE NEED TO MAINTAIN
         * THE ORDER THE FIRST ELEMENT HAS LENGTH-1, AND SINCE B HAS LENGTH-2, B * 26 ^ 1, SO SINCE BCD WOULD NEED
         * TO HAVE B AS B * 26 ^ 2, HENCE WE MULTIPLY ALPHABET AND ADD THE ASCII VALUE OF I + LENGTH - 1, (FOR EG FOR
         * B C D, SINCE WE HAVE B AND C VALUE TO ADD D ASCII VALUE, WE NEED TO GET D FIRST WHICH WOULD BE 1 + PATTERN LENGTH -1
         * (1 + 2) WHICH IS INDEED WHERE IT IS.
         *
         * IF THE HASHVALUE MATCHES COMPARE BOTH THE STRING AND RETURN TRUE OR FALSE.
         */
    }
}
