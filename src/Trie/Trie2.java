package Trie;


/**
 * Time Complexity: O(N), where n denotes the length of the longest string that we are inserting.
 *
 * Space Complexity: O(1), since constant size array created for links.
 */
public class Trie2 {
    Node root;
    public Trie2() {
      root = new Node();
    }

    public void insert(String word) {
       Node node = root;

       for(int i=0;i<word.length();i++) {
           if(!node.contains(word.charAt(i))) {
               node.insert(word.charAt(i), new Node());
           }
           node = node.get(word.charAt(i));
           node.increasePreCount();
       }

       node.increaseWordCount();
    }

    public int countWordsEqualTo(String word) {

        Node node = root;
       for (int i=0;i<word.length();i++) {
           if(node.contains(word.charAt(i)))
               node = node.get(word.charAt(i));
           else
               return 0;
       }
       return node.getWordCount();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for (int i=0;i<word.length();i++) {
            if(node.contains(word.charAt(i)))
                node = node.get(word.charAt(i));
            else
                return 0;
        }
        return node.getPreCount();
    }

    public void erase(String word) {
        Node node = root;

        for (int i=0;i<word.length();i++) {
            if(node.contains(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.decreasePreCount();
            }
            else
                return;
        }
        node.decreaseWordCount();
    }

    public static void main(String[] args) {
        /**
         * ALMOST EVERYTHING IS SAME AS PART 1, ONLY CHANGE IS WE INTRODUCE WORD COUNT AND PREFIX COUNT IN THIS
         * SO AFTER EVERY INSERTION OF CHARACTER WE INCREASE THE PRE COUNT BY 1, AND AFTER EVERY WORD INSERTION WE INCREASE
         * WORD COUNT BY 1, SIMILARLY WE PRE BY 1 ON ITERATING THE NODES AND DELETE WORD COUNT WHEN ENTIRE TRAVERSAL IS DONE
         */
    }

}
