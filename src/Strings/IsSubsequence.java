package Strings;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int n = t.length();
        int m = s.length();
        int i = 0;
        int j = 0;
        while(i < n || j < m) {
            if(i == n) {
                return false;
            }
            if(j == m) {
                return true;
            }
            if(t.charAt(i) != s.charAt(j)) {
                i++;
            }
            else {
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isSubsequence("axc", "ahbgdc");
    }
}
