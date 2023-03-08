package Trie;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaxXorWithAnElementFromArray {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {

        for(int i=0;i<queries.size();i++) {
            queries.get(i).add(i);
        }
        Collections.sort(arr);
        Collections.sort(queries, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
               return o1.get(1).compareTo(o2.get(1));
            }
        });

        TrieNodeBit trie = new TrieNodeBit();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0;i<queries.size();i++) {
            ans.add(-1);
        }
        int ind = 0;
        int n = arr.size();
        for(int i=0;i<queries.size();i++) {

            int xi = queries.get(i).get(0);
            int ai = queries.get(i).get(1);
            int pos = queries.get(i).get(2);
           while (ind < n && arr.get(ind) <= ai) {
               trie.insertNode(arr.get(ind));
               ind++;
           }
           if(ind != 0)
               ans.set(pos, trie.getMax(xi));
        }
        return ans;
    }

    public static void main(String[] args) {

        int arr2D[][] = {{1,3},{5,6},{1,1}};

        int arr[] = {0, 1, 2, 3, 4};

        ArrayList<ArrayList<Integer>> arrayList2D = Arrays.stream(arr2D)
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .collect(Collectors.toCollection(ArrayList::new)))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<Integer> arrayList = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));

        maxXorQueries(arrayList, arrayList2D);

        /**
         * THIS QUESTION IS SIMILAR TO PREVIOUS ONE, ONLY IN THIS WE ARE GIVEN XI AND AI, WHERE XI IS THE NUM AND
         * AI IS A LIMIT, SO IF IN ARRAY OF 1 2 3 4 5, XI IS 1 AND AI IS 3, THEN 1 CAN ONLY HAVE XOR TILL 3, AND RETURN THE
         * MAX XOR OF THIS.
         *
         * SINCE WE HAVE TO RETURN IN THE SAME SEQUENCE THEY CAME IN ARRAY INPUT THEIR INDEX IN THE ARRAYLIST, SO SIMPLY INPUT
         * THEIR INDEX FIRSTLY.
         *
         * AFTER THIS SORT THEM ON THE BASIS OF AI, AND THEN RUN A FOR LOOP AND USE A VARIABLE IND AND INCREMENT IT TILL <= AI
         * AND < QUERIES SIZE. THEN SIMPLY FIND THE MAXXOR OF XI WITH THE ALREADY PRESENT NUMBERS DONE AS IN PREVIOUS QUESTION.
         */
    }
}
