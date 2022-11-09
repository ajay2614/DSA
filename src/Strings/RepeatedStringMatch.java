package Strings;

public class RepeatedStringMatch {
    public static int repeatedStringMatch(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();
        int ans = 1;
        StringBuilder stringBuilder = new StringBuilder(a);
        while(n1 < n2) {
            stringBuilder.append(a);
            n1 += a.length();
            ans++;
        }

        if(checkSubstring(stringBuilder.toString(),b))
            return ans;

        stringBuilder.append(a);
        ans++;

        if(checkSubstring(stringBuilder.toString(), b))
            return ans;

        return -1;
    }
    public static boolean checkSubstring(String a, String b) {
        int n1 = a.length();
        int n2 = b.length();

        for(int i=0;i<n1;i++) {
            if(a.charAt(i) == b.charAt(0) && i + n2 <= n1 && a.substring(i,i + n2).equals(b)) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        /**
         * IN THIS QUESTION GIVEN A STRING, WE NEED TO FIND HOW MANY TIMES WE NEED TO REPEAT STRING A, SO THAT B BECOMES
         * A SUBSTRING OF A.
         *
         * IF NOT RETURN -1;
         *
         * A SUBSTRING CAN BE A SUBSTRING OF A STRING EQUAL TO ITS LENGTH OR GREATER TO ITS LENGTH
         *
         * FIRST WE WILL TRY TO INCREASE THE STRING A TILL ITS LENGTH IS SMALLER THAN B LENGTH, FOR EG IN BELOW
         * WE CAN NEVER MAKE A SUBSTRING WITHOUT HAVING ITS LENGTH EQUAL OR GREATER TO B,
         *
         * RUN A LOOP TO CHECK WHEN A AND B CHARACTER MATCHES, IS B SUBSTRING OF A. IF NOT THEN WE CAN TRY TO REPEAT IT ONCE
         * MORE
         *
         * FOR EG FOR A AS ABCD AND CDABCDAB, IF WE HAVE INCREASED A AS ABCDABCD NOW ITS LENGTH IS EQ TO B LENGTH,
         * SINCE WE WERE UNABLE TO FIND SUBSTRING WE CAN TRY AND REPEAT IT ONCE MORE, NOW IT WOULD BECOME
         * ABCDABCDABCD, NOW WE SEE B IS SUBSTRING OF A, KEEP ANS VARIABLE TO CHECK INCREMENT AND RETURN THE TIMES YOU HAVE
         * REPEATED THE STRING
         *
         * WHY NOT WE REPEAT IT MORE THAN EQ TIMES B LENGTH, IN 1 GO, BECAUSE SAY FOR A AS a AND AA AS b
         * IF WE HAD REPEATED IT MORE THAN B LENGTH TIMES, THEN A WOULD BE AAA , AND ANS VARIABLE WOULD BE SHOWING WRONG VALUE.
         *
         * THIS IS WHY WE ARE FOLLOWING THESE STEPS, SO THAT WE DONT MISS OUT WHEN STRING B IS SAME AS STRING A(WHEN LENGTH IS
         * EQ) AND WE FOUND ANS.
         *
         */
        repeatedStringMatch("abc", "cabcabca");
    }
}
