package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

public class WordBreak2 {

    /**
     *
     * TIME COMPLEXITY : EXPONENT(NOT SURE)
     *
     * SPACE COMPLEXITY : (NOT SURE)
     *
     */
    public static List<String> wordBreakRecursive(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if(wordDict.contains(s))
            ans.add(s);
        int n = s.length();
        for(int i=0;i<n;i++) {
            String leftPart = s.substring(0,i+1);
            if(wordDict.contains(leftPart)) {
                List<String> result = wordBreakRecursive(s.substring(i+1), wordDict);
                for (String str : result) {
                    ans.add(leftPart + " " + str);
                }
            }
        }
        return ans;
    }

    static HashMap<String, List<String>> map = new HashMap<>();


    /**
     *
     * TIME COMPLEXITY : In worst case time complexity will be O(m*2^n), where n - length of string and m is the average length
     * of words in dict. And worst case occur when each character in input is in dictionary.
     *
     * SPACE COMPLEXITY : (NOT SURE)
     *
     */
    public static List<String> wordBreakRecursionMemo(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        if(wordDict.contains(s))
            ans.add(s);
        if(map.containsKey(s))
            return map.get(s);
        int n = s.length();
        for(int i=0;i<n;i++) {
            String leftPart = s.substring(0,i+1);
            if(wordDict.contains(leftPart)) {
                List<String> result = wordBreakRecursionMemo(s.substring(i+1), wordDict);
                for (String str : result) {
                    ans.add(leftPart + " " + str);
                }
            }
        }
        map.put(s,ans);
        return ans;
    }


    public static void main(String[] args) {
//        String s = "pineapplepenapple";
//        List<String> wordDict = new ArrayList<>();
//        wordDict.add("apple");
//        wordDict.add("pen");
//        wordDict.add("applepen");
//        wordDict.add("pine");
//        wordDict.add("pineapple");
        /**
         * https://www.youtube.com/watch?v=jQJyWcRPEpE
         */

        /**
         * GIVEN A DICTIONARY, WE NEED TO FIND THE TOTAL SENTENCES WE CAN MAKE STARTING FROM FIRST LETTER,
         * MEANS THAT FOR EG
         * "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
         *
         * THE ANSWERS WOULD BE "pine apple pen apple","pineapple pen apple","pine applepen apple", NOTICE THAT
         * IN EVERY SENTENCE WE START FROM PINE, AND NOT HAVE A SINGLE SENTENCE LIKE APPLE.
         *
         * TO DO THIS QUESTION WE WILL START FROM 0 TO N, WE WILL TAKE LEFT SUBSTRING FROM 0 TO I+1 AND CHECK
         * IF THE SUBSTRING IS PRESENT IN WORD DICT, THEN WE WILL CALL RECURSION FOR I+1, THE FOLLOWING RECURSION
         * WOULD RETURN US A LIST, AS IN THE QUESTION WE NEED SPACES BETWEEN WE WILL ITERATE THAT LIST AND ADD
         * IN OUR ANS, LEFT PART + " " + LIST ITERATION, AS THE TEMP LIST IS ALREADY HAVING SPACED WE DONT NEED
         * TO DO ANYTHING WITH THAT
         *
         * EG FOR ABOVE TEMP LIST WOULD GIVE US apple pen apple AND WE ARE ALREADY HAVING PINE AS LEFT PART
         * SO SIMPLY pine apple pen apple, ANOTHER STRING THAT THIS TEMP RESULT WOULD BE HAVING IS applepen apple
         * WHICH WILL BECOME pine applepen apple, AND ADD IN ANSWER.
         *
         * TO IMPROVE TIME COMPLEXITY WE WILL USE A HASHMAP OF STRING AND LIST AS THERE ARE REPETITIONS FOR STRINGS
         * IN ABOVE SIMPLY CHECK IF STRING IS ALREADY IN HASHMAP, IF YES THEN RETURN OR ADD THE STRING ALONG WITH ANS
         * LIST BEFORE RETURNING ANS.
         */

        String s = "a";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("b");

        wordBreakRecursionMemo(s, wordDict);
    }
}
