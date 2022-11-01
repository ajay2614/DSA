package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {
    public boolean wordBreakRecursion(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        for(int i=0;i<s.length();i++) {
            String lPart = s.substring(0, i+1);
            if(wordDict.contains(lPart) && wordBreakRecursion(s.substring(i+1), wordDict))
                return true;
        }
        return false;
    }

    HashMap<String,Boolean> map = new HashMap<>();
    public boolean wordBreakMemo(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;
        if(map.containsKey(s))
            return map.get(s);
        for(int i=0;i<s.length();i++) {
            String lPart = s.substring(0, i+1);
            if(wordDict.contains(lPart) && wordBreakMemo(s.substring(i+1), wordDict)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
   }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;

        boolean dp[] = new boolean[s.length() + 1];
        dp[s.length()] = true;
        int n = s.length();

        for(int i=n-1;i>=0;i--) {
            for(int j=i;j<n;j++) {
                String part = s.substring(i, j+1);
                if(wordDict.contains(part) && dp[j+1] == true){
                    dp[i] = true;
                    /*passing testcases without break too, but we will use break as for eg leetcode, it would check for leet
                    which is from i as 0 and j as 3 and will check from j+1 if it is true, if it is it will update
                    dp[i] and since no point in checking for leetc or leetco so we are breaking.
                    */
                    break;
                }
            }
        }
        return dp[0];
    }
    public static void main(String args[]) {
        /**
         * THE QUESTION STATES THAT GIVEN A STRING AND LIST OF STRING, WE NEED TO FIND IF THE COMPLETE STRING IS MADE OF
         * THE WORDS IN DICTIONARY
         * FOR EG LEETCODE IS MADE OF LEET CODE, HENCE WE WILL RETURN TRUE HERE
         *
         * ANOTHER EG "catsandog", wordDict = ["cats","dog","sand","and","cat"]
         *
         * THE ABOVE WILL RETURN FALSE, EVEN THOUGH IT LOOKS TRUE, AS CATS AND OG, MEANS OG ISNT IN DICT,
         * SIMILARLY FOR CAT SAND OG, SO FALSE HERE
         *
         * APPROACH
         *
         * WE WILL FIRST USE RECURSION
         * WE WILL DO PARTITION, AND EVERY TIME WE GET A SUBSTRING WHICH IS PRESENT IN THE DICT, WE WILL CHECK
         * FOR SUBSTRING FROM I+1
         *
         * FOR ABOVE WE WILL USE MEMOIZATION TO IMPROVE TC
         * USE HASHMAP OF STRING AND BOOLEAN, IF STRING IS PRESENT RETURN ITS VALUE, ELSE PUT IN MAP BEFORE RETURNING ANS
         *
         *
         * DP TABU
         *
         * WE WILL START FROM END, RUN A I LOOP AND J LOOP, RUN I FROM END TILL 0, AND J FROM I TO N, CHECK FOR SUBSTRING
         * IF DICT CONTAINS THAT SUBSTRING AND DP[J+1] IS TRUE, WHY DP[J+1]
         *
         * FOR EG LEETCODE, WHEN LEETCODE, WHEN WE CHECK LEFT PART LEET, IT IS TRUE AS IT IS IN DICT, FOR CHECKING
         * RIGHT PART WE CHECK FROM DP[J+1]
         */
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");

        wordBreak("leetcode", dict);
    }
}
