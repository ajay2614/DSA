package Heap;

import java.util.*;

class Pair {
    int sum;
    int left;
    int right;

    public Pair(int sum, int left, int right) {
        this.sum = sum;
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

}

public class MaximumSumCombinations_NMaxPairCombinations {
    public static ArrayList<Integer> bruteApproach(ArrayList<Integer> A, ArrayList<Integer> B, int C) {
        ArrayList<Integer> ans = new ArrayList();
        int n = A.size();
        int m = B.size();

        for(int i=0;i<n;i++) {
            int element = A.get(i);
            for(int j=0;j<m;j++) {
                ans.add(element + B.get(j));
            }
        }

        Collections.sort(ans, Collections.reverseOrder());

        while(ans.size() > C) {
            ans.remove(ans.size()-1);
        }
        return ans;
    }
    public static ArrayList<Integer> optimalApproach(ArrayList<Integer> A, ArrayList<Integer> B, int C) {

        Collections.sort(A);
        Collections.sort(B);

        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((Pair p1, Pair p2) -> {
            if(p1.getSum() > p2.getSum())
                return -1;
            else if (p1.getSum() < p2.getSum())
                return 1;
            return 0;
        } );

        HashSet<String> hashSet = new HashSet<>();

        int n = A.size();
        int m = B.size();


        Pair temp = new Pair(A.get(n-1) + B.get(m-1), n-1, m-1);
        priorityQueue.add(temp);
        hashSet.add(new StringBuilder(temp.getLeft() + "|" + temp.getRight()).toString());
        ArrayList<Integer> ans = new ArrayList<>();

        while(C-- > 0) {
            Pair p = priorityQueue.poll();
            ans.add(p.getSum());
            if (p.getLeft()-1 >= 0 && p.getRight() >= 0) {
                int l = p.getLeft()-1;
                int r = p.getRight();

                String str = l + "|" + r;

                if(!hashSet.contains(str)) {
                    priorityQueue.add(new Pair(A.get(l) + B.get(r), l, r));
                    hashSet.add(str);
                }

            }

            if (p.getRight()-1 >= 0 && p.getLeft() >= 0) {
                int l = p.getLeft();
                int r = p.getRight()-1;

                String str = l + "|" + r;

                if(!hashSet.contains(str)) {
                    priorityQueue.add(new Pair(A.get(l) + B.get(r), l, r));
                    hashSet.add(str);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT GIVEN TWO ARRAYS WE NEED TO FIND THE MAX VALUE THEIR SUM CAN MAKE, AND WE NEED TO
         * ONLY STORE K MAX, MEANS FIRST K SUMS OF TWO ARRAYS.
         *
         * BREAKDOWN
         *
         * FOR EG FOR BELOW QUESTION, HIGHEST SUM WOULD BE 12(7+5), THEN 12(8+4) AND SO ON
         *
         * BRUTE APPROACH
         *
         * SIMPLY ADD ALL THE SUM IN AN ARRAY LIST, BY RUN FOR LOOP AND THEN SORT, AND RUN A LOOP TILL K BECOMES
         * 0, AND THEN RETURN THAT LIST.
         *
         *
         * OPTIMAL APPROACH
         *
         * IF WE SORT BOTH THE ARRAYS, SUCH THAT
         * ARRAY A IS 1 2 4 5
         * ARRAY B IS 3 6 7 8
         *
         * ONE THING WE REALIZE THAT THE HIGHEST SUM WILL ALWAYS BE OF BIGGEST ELEMENT IN A + BIGGEST ELEMENT IN B,
         * SO TO STORE THIS BASED ON ITS SUM WE CREATE A PRIORITY QUEUE OF TYPE PAIR WHERE PAIR IS CLASS DECLARED
         * HAVING SUM, LEFT INDEX AND RIGHT INDEX, SO ONCE AFTER THIS STORE THE FIRST SUM AS WELL AS LEFT AND
         * RIGHT INDEX IN THAT PRIORITY QUEUE, SINCE IN THIS APPROACH LEFT AND RIGHT INDEX MAY REPEAT WE CREATE HASHSET
         * OF STRING, STRING WHICH WILL HAVE LEFT AND RIGHT INDEX, WHY NOT USE HASHMAP, BECAUSE LEFT INDEX CAN HAVE MULTIPLE
         * RIGHT INDEX, SAY L1 IS 3 AND R1 IS 3, THEN L1 IS 3 AND R1 IS 2.
         *
         * AFTER THIS WE ARE SURE THAT THE SECOND MAX SUM WOULD EITHER BE OF A[N-1] + B[M-2] OR A[N-2] + B[M-1]
         *
         * WHY BECAUSE LETS CHECK 1 2 4 5 AND 3 6 7 8, IF WE COMPARE 8 + 4 AND 7 + 5, WILL ALWAYS BE BIGGER THAN
         * 7 + 4, BECAUSE THESE ARE SUM OF 1 HIGHEST IN A AND SECOND HIGHEST AND 2ND HIGHEST IN B AND 1ST HIGHEST IN B
         * AND SECOND HIGHEST IN B WILL DEFINITELY BE BIGGER THAN 2ND HIGHEST IN A AND 2ND HIGHEST IN B
         *
         * WE CAN CHECK FOR ANY EXAMPLE SAY 1 2 3 AND 15 16 17, 17 + 2 AND 3 + 16 ARE BIGGER THAN 2  + 16,
         *
         * SO TO IPLEMENT THIS WE WILL RUN A WHILE LOOP TILL K IS GREATER THAN 0,
         *
         * WE WILL GET THE FIRST PAIR OF PRIORITY QUEUE, ADD ITS SUM IN THE ARRAY LIST AND THEN WILL EVALUATE FOR
         * L-1 R AND L R-1, WE WILL USE IF STATEMENT TO CHECK WHETHER L-1 OR R IS NOT SMALLER THAN 0 AND SET
         * DOESN'T ALREADY CONTAINS THESE INDEXES, AS THE PRIORITY INDEX IS SORTING BASED ON THE SUM, WE WILL GET
         * THE HIGHEST SUM PAIR NEXT TIME AND WE CAN HENCE EVALUATE FOR REMAINING SUCH AS WHERE L AND R IS 2 OR L
         * IS 1 AND R IS 3.
         *
         * IN THE END RETURN THE ARRAY LIST.
         */
        int []A = { 1,5,4,2 };
        int []B = { 7,8,3,6 };
        int C = 4;

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        Arrays.stream(A).forEach(o -> a.add(o));
        Arrays.stream(B).forEach(o -> b.add(o));
        optimalApproach(a,b,C);
    }

}
