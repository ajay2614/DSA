package Recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        if(s.equals(' ') || n == 0)
            return ans;
        recursion(ans, 0, n, new ArrayList<>(), s);
        return ans;
    }

    public static void recursion( List<List<String>> ans , int ind, int n,  List<String> a, String s) {
        if(ind == n) {
            ans.add(new ArrayList<>(a));
        }

        for(int i=ind; i < n; i++) {
            if(isPalindrome(ind, i, s)) {
                a.add(s.substring(ind, i+1));
                recursion(ans, i+1, n, a, s);
                a.remove(a.size()-1);
            }
        }
    }

    public static boolean isPalindrome(int i, int j, String s) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE ARE GIVEN A STRING, WE NEED TO FIND TOTAL PALINDROMES WE CAN HAVE
         * NOTE : WE NEED TO PASS THEM IN SUCH A LIST LIKE FOR AAB, A A B, WOULD BE ONE AND OTHER WOULD BE
         * AA B.
         *
         * APPROACH
         *
         * RECURSION
         *
         * THE APPROACH WE WILL PARTITION THE STRING FROM IND TO I, AND IF THAT SUBSTRING IS A PALINDROME WE WOULD ADD THAT
         * IN ARRAY LIST, AND THEN RUN RECURSION FROM I+1
         *
         * EXAMPLE FOR A A B B, WE HAVE IND 0 AND I 0, THE FIRST PARTITION WOULD BE FOR SINGLE 0TH ELEMENT A
         * AND THEN RUN RECURSION FROM I+1, FROM HERE WE RUN TILL N IS EXHAUSTED AND WHEN WE RETURN, IND WOULD BE 0 AND
         * I IS 1, WE CHECK FOR AA AND ITS PALINDROME AND WE RUN RECURSION THEN I+1,
         *
         * MAKE SURE TO REMOVE THE ELEMENT IN ORDER TO BACK TRACK.
         *
         */
        String s = "aabb";
        partition(s);
    }
}
