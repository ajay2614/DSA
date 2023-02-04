package Strings;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        StringBuilder sB = new StringBuilder();

        for(int i=0;i<s.length();i++) {
            if((s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) ||
                    (s.charAt(i) - '0' >= 17 && s.charAt(i) - '0' <= 42) ||
                    (s.charAt(i) - '0' >= 49 && s.charAt(i) - '0' <= 74)) {
                sB.append(s.charAt(i));
            }
        }
        return checkPalindrome(sB.toString().toLowerCase());
    }
    public boolean checkPalindrome(String str) {
        int i=0;
        int j =str.length()-1;

        while (i < j) {
            if(str.charAt(i++) != str.charAt(j--))
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println('a' - '0');
        String s = "ab_a";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        validPalindrome.isPalindrome(s);

    }
}
