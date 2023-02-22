package Trie;

public class LongestWordWithAllThePrefix {

    public static String completeString(int n, String[] a) {

        Trie1 trie1 = new Trie1();

        for(int i=0;i<n;i++) {
            trie1.insert(a[i]);
        }
        String ans = "";
        for(int i=0;i<n;i++) {
            if(trie1.checkIfAllPrefixExist(a[i])) {
                if(a[i].length() > ans.length() || (a[i].length() == ans.length() && a[i].compareTo(ans) < 0))
                    ans = a[i];
            }
        }

        if(ans.equals(""))
            return "None";
        return ans;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT FIND THE MAX LENGTH WORD OF WHICH ALL THE PREFIX ARE PRESENT IN THE TRIE
         *
         * FOR EG THERE IS AN INPUT T TO TOY, THEN TOY IS THE MAX LENGTH WORD AND ITS PREFIXES T AND TO EXIST
         * IF THERE EXISTS TWO WORDS OF SAME LENGTH WITH ALL THE PREFIXES THEN RETURN THE ONE WHICH IS LEXOGRAPHICALLY
         * SMALL
         *
         * WHAT FIRSTLY WE WILL DO IS INSERT ALL THE WORDS IN OUR TRIE
         *
         * NOW WE WILL INPUT FOR EVERY WORD AND CHECK IF EVERY NODE HAS END AS TRUE
         *
         * SUPPOSE FOR TOY, FIRST CHECK FOR T, THEN MOVE TO T'S LINK O AND CHECK IF O IS TRUE
         * IF IS THEN COMPARE WITH THE LENGTH WITH ANS VARIABLE, IF SAME THEN CHECK IF SMALLER LEXOGRAPHICALLY THEN INPUT.
         *
         * RETURN ANS.
         */
    }
}
