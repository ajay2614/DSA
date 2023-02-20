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

        /**
         * IN THIS QUESTION THERE IS A BEGIN WORD GIVEN AND AN END WORD, EACH WORD IN THE INPUT ARRAY DIFFER THEIR ADJACENT BY
         * 1 CHAR, WE HAVE TO FIND THE MIN STEPS TO REACH FROM BEGIN WORD TO END WORD USING ONLY WORDS IN THE LIST
         *
         * SIMPLY USE A HASHET AND STORE EVERY LIST WORD IN IT, AFTER THIS USE A QUEUE AND A CLASS HAVING STEPS AND
         * STRING IN IT, NOW RUN TILL QUEUE IS NOT EMPTY, GET THE WORD FROM QUEUE,
         *
         * IF THE WORD IS LAST WORD MEANS WE HAVE REACHED OUR DESTINATION, SIMPLY RETURN THE STEPS HERE
         * RUN A LOOP TILL WORD LENGTH, AND CHANGE EVERY CHARACTERS WITH CHAR FROM A AND Z LOOP WISE, MEANING
         * IF WORD IS HIT, THEN FIRST SWITCH H WITH EVERY CHAR AND CHECK IF IT EXISTS IN SET IF IT DOES THEN ENTER IT IN
         * QUEUE ALONG WITH CURRENT WORD STEP + 1.
         */
    }

}
