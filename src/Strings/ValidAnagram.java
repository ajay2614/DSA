package Strings;
import java.util.Arrays;
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        if(n1 != n2)
            return false;

        char sArr[] = s.toCharArray();
        char tArr[] = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        for(int i=0;i<n1;i++) {
            if(sArr[i] != tArr[i])
                return false;
        }
        return true;
    }

    /**
     *
     * TC : BIG O(N+M)
     */
    public boolean isAnagramDifferentApproach(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();

        if(n1 != n2)
            return false;

        int arr[] = new int[26];

        for(int i=0;i<n1;i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for(int i=0;i<n1;i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<26;i++) {
            if(arr[i] != 0)
                return false;
        }
        return true;
    }

    /**
     * TWO APPROACHES
     *
     * FIRST
     *
     * CREATE TWO CHAR ARRAYS, AND SORT THEM, THEN SIMPLY COMPARE THEM IF DIFFERENT RETURN FALSE;
     *
     * SECOND
     *
     * IN THIS CREATE AN ARRAY OF SIZE 26(SINCE TOTAL ALPHABETS ARE 26), NOW FOR FIRST STRING PUT 1 ON EVERY CHAR APPEARANCE,
     * NOW RUN ANOTHER LOOP TO DECREASE THE VALUE WITH SECOND STRING.
     *
     * NOW IF THEY WERE ANAGRAM IT IS SURE THAT WITH SECOND LOOP SAME CHAR WOULD BE MARKED 0, SO RUN A LOOP
     * FOR ALPHABETS, FROM 0 TO 25, IF ANY ALPHABET HAS 1 VALUE RETURN FALSE.
     */
}
