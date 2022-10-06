package Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

public class WordBreak2 {
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

        String s = "a";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("b");

        wordBreakRecursionMemo(s, wordDict);
    }
}
