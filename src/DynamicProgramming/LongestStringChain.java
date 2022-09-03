package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    public static int longestStrChain(String[] words) {

        int n = words.length;
        Arrays.sort(words, (s1, s2) -> {
            if(s1.length() > s2.length())
                return 1;
            else if(s2.length() > s1.length())
                return -1;
            return 0;
        });

        System.out.println(words[0]);

        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=0;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(isPossible(words[i], words[j]) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

    public static boolean isPossible(String a, String b) {
        if(a.length() != b.length() + 1)
            return false;
        int first = 0;
        int second = 0;

        while(first < a.length()) {
            if(second < b.length() && a.charAt(first) == b.charAt(second)) {
                first++;
                second++;
            }
            else
                first++;
        }

        if(first == a.length() && second == b.length())
            return true;

        return false;
    }

    public static void main(String args[]){

        /*
        THE QUESTION STATES THAT WE ARE GIVE A STRING ARRAY AND WE NEED TO FIND LONGEST STRING CHAIN,
        STRING CHAIN IS LIKE A, BA, BCA, BDA, BDCA, MEANING FROM ONE TRANSITION TO OTHER ONLY ONE NEW CHAR IS INTRODUCED,
        EG A TO BA, B IS INTRODUCED

        WE HAVE TO DO IT THE SAME WAY WE DID LONGEST DIVISIBLE SUBSET OR LONGEST INCREASING SUBSEQUENCE

        STEPS

        FIRST SORT THE WORDS ARRAY, AS WE NEED WORDS IN SORTED ORDER TO GET RIGHT ANSWER, SORT USING COMPARATOR

        AFTER THIS IN PREV INDEX LOOP, IF STATEMENT INTRODUCE A BOOLEAN METHOD WHICH TAKES CURRENT STRING AND PREV STRING

        NOW IN THIS BOOLEAN METHOD CHECK IF CURRENT STRING LENGTH IS EQUAL TO PREV STRING LENGTH + 1
        EG BA AND A, IF NOT SATISFIED MEANS IT ISN'T FOLLOWING LONGEST STRING CHAIN PROPERTY

        AFTER THIS CREATE A OUTER LOOP STARTING FROM VARIABLE FIRST 0 AND RUN TILL FIRST < STRING LONGER.LENGTH
        IN THIS OUTER LOOP CREATE AN INNER LOOP, WHICH CHECKS FOR SECOND 0 TILL SECOND < STRING SHORTER.LENGTH
        AND ALSO IF LONGER.CHAR[FIRST] == SHORTER.CHAR[SECOND],
        IF SATISFIED FIRST & SECOND ARE INCREMENTED ELSE ONLY SECOND IS INCREMENTED

        THE PURPOSE OF THIS PART IS TO CHECK WHETHER BOTH THE STRINGS ARE ONLY SEPARATED VIA 1 INDIVIDUAL CHAR

        EG AB AND ABC ARE SEPARATED BY C ONLY IT WILL CHECK A & A, THEN B & B AND THEN IT WILL COME OUT OF LOOP

        ULTIMATELY WE CHECK IF BOTH THE FIRST IS EQUAL TO LONGER STRING LENGTH & SECOND IS EQUAL TO SHORTER STRING LENGTH

        WE CAN ALSO SAY PURPOSE OF THESE TWO LOOPS WAS TO EXHAUST THE INDEXES FOR BOTH STRING AND IF THEY MATCHED THEIR LENGTH THEN
        RETURN TRUE

        AFTER THAT UPDATE MAX SAME WAY AS IN LIS.

         */
        String[] words = {"a","b","ba","bca","bda","bdca"};
        longestStrChain(words);

    }
}
