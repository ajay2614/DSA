package Strings;

public class CountAndSay {
    /**
     * NOT SURE
     * TC = O(1 + 2 + ... + 2^n) = O(2^n)
     * SC = O(2^n)
     */
    public static String countAndSay(int n) {
        if(n == 1)
            return "1";
        String res = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        int cnt = 1;
        char num = res.charAt(0);

        for(int i=1;i<res.length();i++) {
            char cur = res.charAt(i);

            if(num == cur)
                cnt++;
            else {
                ans.append(cnt + "" + num);
                cnt = 1;
                num = cur;
            }
        }

        ans.append(cnt + "" + num);
        return ans.toString();
    }

    public static void main(String[] args) {
        /**
         * COUNT ANS SAY MEANS
         *
         * FOR 1 AS INPUT, WE WOULD SIMPLY RETURN 1,
         * FOR 2 AS INPUT, WHAT THIS WOULD MEAN IS PREV VALUE AND THE TIME IT APPEARS, SINCE 1 APPEARS 1 TIME
         * SO WE WOULD SAY ONE 1, HENCE THE OUTPUT WOULD BE 11
         * FOR 3 AS INPUT, PREV WOULD BE 11, SO THIS MEANS TWO1, 21
         * FOR 4 IT WOULD BE 1211
         * FOR 5 IT WOULD BE 111221
         *
         *
         * APPROACH
         *
         * AS WE ARE APPEARING A PATTERN, FOR EVERY VALUE WE NEED ITS PREV VALUE, SO WE WILL RUN A RECURSION
         * WHEN N = 1, SIMPLY RETURN 1.
         *
         * AFTER THIS SIMPLY USE A COUNTER AND COUNT TILL NEXT VALUE IS DIFF, AND ADD IT TO STRING
         * DO REMEMBER TO ADD AT LAST AS SAY FOR 1211, IN N AS 5, LAST 11 WOULD HAVE BEEN LEFT IN THE FOR LOOP.
         */
        countAndSay(5);
    }
}
