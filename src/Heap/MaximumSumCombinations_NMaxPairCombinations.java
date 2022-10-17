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

class Subpair {
    int l;
    int r;

    public Subpair(int l, int r) {
        this.l = l;
        this.r = r;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
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
