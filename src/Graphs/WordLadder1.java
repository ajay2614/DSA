package Graphs;

import java.util.*;
import java.util.stream.Collectors;

class PairString {
    String s;
    int steps;

    PairString(String s, int steps) {
        this.s = s;
        this.steps = steps;
    }
}
public class WordLadder1 {

    /**
     *
     * TC : BIG O (N * WORDLENGTH * 26), BECAUSE IN WORST CASE OUR QUEUE WILL RUN N TIMES BECAUSE IF THE ELEMENT IS
     * NOT IN SET IT WILL NEVER GO IN QUEUE, WORDLENGTH * 26 IS INNER NESTED LOOP INSIDE QUEUE.
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {


        Set<String> stringSet = new HashSet<>();

        for(String str : wordList) {
            stringSet.add(str);
        }
        stringSet.remove(beginWord);

        Queue<PairString> queue = new LinkedList<>();
        queue.offer(new PairString(beginWord,1));
        while (!queue.isEmpty()) {
            PairString pairString = queue.poll();
            String s = pairString.s;
            int steps = pairString.steps;
            if(s.equals(endWord))
                return steps;
            for(int i=0;i<s.length();i++) {
                char[] temp = s.toCharArray();
                for(char ch='a';ch<='z';ch++) {
                    temp[i] = ch;
                    String tempString = new String(temp);
                    if(stringSet.contains(tempString)) {
                        stringSet.remove(tempString);
                        queue.offer(new PairString(tempString, steps+1));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] s = {"hot","dot","dog","lot","log","cog"};
        List<String> strings = Arrays.stream(s).collect(Collectors.toList());
        ladderLength("hit", "cog", strings);
    }

}
