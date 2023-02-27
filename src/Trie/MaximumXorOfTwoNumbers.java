package Trie;

class NodeBit {
    NodeBit[] links = new NodeBit[2];

    void insert(int i, NodeBit node) {
        links[i] = node;
    }

    public boolean contains(int i) {
        return links[i] != null;
    }
    NodeBit get(int i) {
        return links[i];
    }
}

class TrieNodeBit {
    NodeBit root;

    TrieNodeBit() {
        root = new NodeBit();
    }
    public void insertNode(int num) {
        NodeBit node = root;

        for(int i=3;i >= 0 ;i--) {
            int bit = num >> i & 1;
            if(!node.contains(bit)) {
                node.insert(bit, new NodeBit());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        NodeBit node = root;
        int maxNum = 0;

        for(int i=3;i>=0;i--) {
            int bit = num >> i & 1;
            if(node.contains(1 - bit)) {
                maxNum = maxNum | 1 << i;
                node = node.get(1 - bit);
            }
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }

}
public class MaximumXorOfTwoNumbers {
    public int findMaximumXORBrute(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                max = Math.max(nums[i] ^ nums[j], max);
            }
        }
        return max;
    }
    public int findMaximumXOR(int[] nums) {
        int n = nums.length;

        TrieNodeBit trie = new TrieNodeBit();

        for(int i=0;i<n;i++) {
            trie.insertNode(nums[i]);
        }

        int max = 0;

        for(int i=0;i<n;i++) {
            max = Math.max(trie.getMax(nums[i]), max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumXorOfTwoNumbers xorOfTwoNumbers = new MaximumXorOfTwoNumbers();

        int nums[] = {9,2};
        xorOfTwoNumbers.findMaximumXOR(nums);
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE MAXIMUM XOR BETWEEN TWO NUMBERS IN AN ARRAY
         *
         * THE BRUTE FORCE GIVES TLE
         *
         * THE OPTIMAL ONE IS DONE VIA TRIE
         *
         * THERE ARE PLENTY OF STEPS THAT WILL BE DONE IN THE ENTIRE APPROACH
         *
         * INSERT
         *
         * THE FIRST ONE IS HOW TO INSERT, IN THIS WE WILL BE STORING EVERY NUMBER'S BINARY FORM IN THE TRIE
         * LIKE WE USED NODE ARRAY IN A CLASS FOR WORDS WE USED 26 CHARACTERS AND SINCE BIT WILL ALWAYS BE EITHER 0 OR 1
         * WE USE 2.
         *
         * TO INSERT SINCE NUMBERS CAN BE UPTO 32 BIT, THE FIRST STEP WOULD BE TO GET THE ITH BIT FOR THE NUMBER
         * NOW SUPPOSE FOR 9 THE BINARY REPRESENTATION IS 1001, NOW IF WE HAVE TO GET IT'S 4TH BIT(WHICH IS 1)
         * WE WILL FIRST REMOVE THE 3 BITS FROM RIGHT, SHIFT RIGHT OPERATOR >> WILL HELP US WITH THAT,
         * AFTER REMOVING LAST 3 BITS 1001 WOULD BE 1, AND TO GET THIS WE WILL & 1, TO CHECK WHETHER IT IS 0 OR 1
         *
         * WHY NOT SIMPLY ASSIGNING THE BIT AND & IS NECESSARY?, BECAUSE SAY FOR 12, BINARY REPRESENTATION 1100
         * WE HAVE TO GET IT'S 3RD BIT SO WE SHIFT IT BY 2, SO IT BECOMES 11, NOW SINCE & WITH 1 WILL ALWAYS GIVE US
         * LAST BIT'S STATUS, AS ALL THE PREVIOUS IS 0, 11 & 01, WILL GET US THE LAST BIT SO & IS NECESSARY,
         * SIMPLY INSERT THE NODE IF NODE PRESENT AND GET THAT NODE LIKE PREVIOUS QUESTIONS FOR TRIE.
         *
         * GET MAX XOR VALUE WITH EACH NUMBERS
         *
         * NOW THE SECOND OPERATION IS TO GET THE MAX,
         * SINCE XOR GIVES 1 WHEN ONLY WHEN 0 ^ 1, ASSUME THERE IS 9 WITH XOR 1001,
         * NOW THE MAX NUMBER XOR WITH 9 CAN BE IN CASE OF ONLY 4 BIT IS 0110 WHICH IS 6,
         * AS WE CAN SEE FOR EVERY BIT WE HAVE TO LOOK FOR IT'S OPPOSITE SO THAT WE CAN HAVE THE MAX,
         * NOW SINCE OUR TRIE WILL ALREADY BE HAVING ALL THE NUMBERS, WHAT WE WILL DO IS THAT AT EVERY BIT OF 9
         * WE WILL CHECK IF OPPOSITE OF THAT BIT EXISTS SO THAT WE CAN GET THE NUMBER WITH WHICH OUR INPUT NUMBER HAS
         * THE MAXIMUM XOR.
         * HAVE
         * NOW THE FIRST STEP IS SAME AS PREVIOUS THAT IS TO GET THE BIT BY RIGHT SHIFT >>, AFTER THIS SEARCH
         * IN THE NODE WHETHER 1-BIT IS PRESENT, IF PRESENT THEN NOW WHAT WE WILL DO IS THE IS FOR THAT PLACE BIT GET
         * THE LEFT SHIFT FOR THAT PLACE BIT AND OR WITH THE ANSWER
         *
         * SUPPOSE MAXNUM IS 0, AND NOW THE BIT IS 3, SO WITH THIS IF WE GET THE 3 << 1 IT WILL BE 1000, AS THREE 0
         * WILL BE PLACED AFTER 1, AND NOW | WITH 0, WILL BE 1000
         * AFTER THAT GET THE NEXT NODE, WHICH WOULD BE FROM 1-BIT, AS SUPPOSE FOR 1001, WE FIRST FOUND 0 FROM 6,
         * NOW WE WILL CHECK FOR FURTHER NODES PRESENT IN FROM THIS 0 WHICH HAS THE POSSIBILITY OF HAVING 1 WHICH WILL BE
         * OPPOSITE TO 3RD BIT FOR 9, AS WE WILL BE CHECKING IF IT CONTAINS FROM THE NODE
         *
         * IF THERE IS NO OPPOSITE PRESENT TO BIT OF CERTAIN PLACE FOR THAT INPUT SIMPLY GET THE NODE FOR THAT BIT, THIS WORKS
         * BECAUSE IF IN CASE THAT NODE IS NOT HAVING THE OPPOSITE OF THAT BIT WITH IT, THEN WE CAN SIMPLY TAKE
         * THE NODE FROM THE ACTUAL BIT BECAUSE IT IS BOUND TO HAVE EITHER 0 IF IT DOESN'T HAVE 1 OR VICE VERSA
         *
         * SUPPOSE FOR 9 AND 2, 1001, WE CHECK AND FIND THAT 4TH BIT OF 9 HAS AN OPPOSITE IN 0 FOR 2 AS 2 IS
         * 0010, AFTER THIS WE CHECK FOR 3RD BIT OF 9 AND CHECK IF CURRENT NODE HAS OPPOSITE OF THAT BIT(0 IS 3RD BIT OF 9)
         * AS IT DOESN'T HAVE THEN WE CAN SIMPLY TAKE THE ACTUAL BIT PRESENT IN THE NODE WHICH IS 2'S 3RD BIT WHICH IS 0,
         *
         * NOW ALSO FOR MAXNUM FIRST TIME MAXNUM WOULD HAVE BECOME 1000, NOW IN SECOND TIME NO CHANGE IN MAXNUM
         * AS THE PATH WE HAVE TAKEN WHICH WAS FROM 0 WHICH WAS OPPOSITE TO 1 OF 9, HAD NO OPPOSITE FOR 3RD BIT
         * SO THE NEXT TIME IT WILL CHECK AGAIN AND WE WILL HAVE OPPOSITE FOR 2ND BIT OF 9 WHICH IS 1 FROM 2 AGAIN
         * SO NOW THE MAX NUM WILL BE 1000 | 1 << 1, 1 << 1 IS 10, SO SIMPLY OR WITH 1000 WILL GIVE 1010,
         *
         * THIS WAY WE CAN FIND THE MAX XOR FOR TWO NUMBERS
         *
         * WHY ARE WE RUNNING LOOP FROM 31 TO 0, BECAUSE IN QUESTION IT IS GIVEN 32 BIT NUMBER CAN BE, AND SINCE
         * FOR FOR GETTING 4TH BIT WE NEED RIGHTSHITFT WITH 3, AND FOR GETTING OR WITH MAXNUM WE NEED SO THAT WE CAN
         * ADD INTO OUR MAXNUM WE NEED LEFT SHIFT OF 1 WITH BIT PLACE - 1.
         *
         */
    }
}
