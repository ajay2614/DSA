package Graphs;

import java.util.*;

public class WordLadderTwo {
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {

        Set<String> set = new HashSet<>();

        for(String s : wordList) {
            set.add(s);
        }

        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        ArrayList<String> arrayListBegin = new ArrayList<>();
        ArrayList<String> usedOnLevel = new ArrayList<>();
        arrayListBegin.add(startWord);
        usedOnLevel.add(startWord);
        Queue<ArrayList<String>> q = new LinkedList<>();

        q.offer(arrayListBegin);
        int level = 0;
        while (!q.isEmpty()) {
            ArrayList<String> arrayList = q.poll();
            if(arrayList.size() > level) {
                level++;
                for(String s : usedOnLevel) {
                    set.remove(s);
                }
                usedOnLevel.clear();
            }
            String word = arrayList.get(arrayList.size()-1);
            if(word.equals(targetWord)) {
                if(ans.size() == 0)
                    ans.add(new ArrayList<>(arrayList));
                else if(ans.get(0).size() == arrayList.size())
                    ans.add(new ArrayList<>(arrayList));
            }
            else {
                for (int i = 0; i < word.length(); i++) {
                    char[] tempWord = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        tempWord[i] = ch;
                        String temp = new String(tempWord);
                        if (set.contains(temp)) {
                            arrayList.add(temp);
                            q.offer(new ArrayList<>(arrayList));
                            usedOnLevel.add(temp);
                            arrayList.remove(arrayList.size() - 1);
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        /**
         * UNLIKE THE PART 1 HERE WE HAVE TO RETURN LIST OF LIST HAVING MIN WORD TO REACH THE LAST WORD
         *
         * HERE WE WILL USE TWO LIST A USEDONLEVEL LIST TO TRACK THE WORD ADDED ON EACH LEVEL, EG
         * BAT ON FIRST, PAT AND BOT IN SECOND, QUEUE CONTAINING ARRAY LIST AND SET HAVING EACH WORDS
         *
         * THE REASON WHY WE ARE USING USED ON LEVEL LIST IS TO TRACK EVERY WORDS ADDED IN LIST THIS BECAUSE
         * UNLIKE WORD LADDER 1 WHERE WE DELETE WORD FROM SET IN INNER LOOP IF WE DID THE SAME
         * FOR EG FOR BAT WE CAN MAKE BAT PAT AND BAT BOT, FROM BAT PAT WE CAN MAKE BAT PAT POT, BUT
         * FROM BAT BOT ALSO WE COULD HAVE INCLUDED POT WHICH WOULD NOT HAVE HAPPENED IF WE HAD REMOVED IT FROM SET
         * SO USING LEVEL VARIABLE EVERYTIME ARRAYLIST SIZE BECOMES BIGGER THAN LEVEL, MEANS WE HAVE ADDED ONE EXTRA
         * ELEMENT SO SIMPLY AT THAT STAGE WE CAN REMOVE FROM THE USEDONLEVEL LIST.
         */
    }
}
