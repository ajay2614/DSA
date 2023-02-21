package Trie;
class Node {
    Node[] links = new Node[26];
    boolean flag = false;
    int wordCount = 0;
    int preCount = 0;
    public boolean contains(char ch) {
        return links[ch - 'a'] != null;
    }

    public void insert(char ch, Node node) {
        links[ch-'a'] = node;
    }

    public Node get(char ch) {
        return links[ch - 'a'];
    }

    public void setFlag() {
        flag = true;
    }
    public boolean isEnd() {
        return flag;
    }

    public void increaseWordCount() {
        wordCount++;
    }
    public void increasePreCount() {
        preCount++;
    }
    public void decreaseWordCount() {
        wordCount--;
    }
    public void decreasePreCount() {
        preCount--;
    }

    public int getWordCount() {
        return wordCount;
    }
    public int getPreCount() {
        return preCount;
    }
}
public class Trie1 {
    Node root;
    public Trie1() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i=0;i<word.length();i++) {
            if(!node.contains(word.charAt(i))) {
                node.insert(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }

        node.setFlag();
    }

    public boolean search(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++) {
            if(!node.contains(word.charAt(i)))
                return false;
            node = node.get(word.charAt(i));
        }

        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;

        for (int i=0;i<prefix.length();i++) {
            if(!node.contains(prefix.charAt(i)))
                return false;
            node = node.get(prefix.charAt(i));
        }

        return true;
    }

    public static void main(String[] args) {
        Trie1 trie1 = new Trie1();

        trie1.insert("apple");

        /**
         * HOW TRIE WORKS
         *
         * WE HAVE CREATED A NODE CLASS WHICH ITSELF HAS AN INSTANCE VARIABLE CALLED LINKS WHICH IS SIMPLY ARRAY
         * OF NODE TYPE WHICH WILL TAKE 26 CHARACTERS
         *
         * INSERT
         *
         * THE IDEA IS THAT ONCE WE HAVE TO INSERT FOR A PARTICULAR OBJECT OF TRIE, WE WILL ASSIGN A NEW NODE IN IT
         * ONCE AFTER THIS FOR INSERTION WE WILL INSERT THE NODE IN THE INDEX ACC TO IT'S ALPHABETICALLY ORDER
         * IN THE LINKS ARRAY, AND AFTER THAT WE WILL GET THE NODE FROM THAT LINKS ARRAY AND PROCEED FORWARD WITH
         * INSERTING OTHER CHAR WORDS
         *
         * SO SUPPOSE WE HAVE TO INSERT THE WORD APPLE THE SORT OF HIERARCHY WOULD BECOME WHICH WILL LOOK LIKE
         *
         * ROOT.LINKS[0](BECAUSE IT'S A)
         *                              NODE A LINKS[11]
         *                                              NODE P LINKS[11]
         *                                                              AND SO ON
         *
         * SINCE WE NEED TO MARK THE END WE WILL ASSIGN THE END AS TRUE FOR LAST NODE.
         *
         * SEARCH
         *
         * SIMPLY KEEP CHECKING WHETHER CHAR EXISTS IN THE NODE'S LINKS STARTING FROM ROOT AND CHECKING FIRST CHAR
         * IF AT ANY POINT IT DOESN'T RETURN FALSE AND IF AT THE END THE FLAG IS FALSE MEANING THE NODE HAS FURTHER NODES
         * CONNECTED TO IT'S LINKS SO RETURN FALSE ELSE TRUE;
         *
         * STARTS WITH
         * CHECK FOR EVERY CHAR OF WORD LIKE SEARCH HERE HOWEVER THE DIFFERENCE IS THE WORD NEED TO HAVE FLAG AS TRUE
         * OR END AS TRUE AS WE ARE ONLY CHECKING IF A WORD STARTS WITH GIVEN WORD OR NOT
         *
         *
         */
    }
}
