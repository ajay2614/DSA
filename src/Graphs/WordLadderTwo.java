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
}
