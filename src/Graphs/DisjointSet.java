package Graphs;

import java.util.ArrayList;

public class DisjointSet {
    //FOR UNION BY RANK
    ArrayList<Integer> rank = new ArrayList<>();
    //ULTIMATE PARENT
    ArrayList<Integer> uP = new ArrayList<>();
    //FOR UNION BY SIZE
    ArrayList<Integer> size = new ArrayList<>();

    DisjointSet(int n) {
        //Iterating from 0 to N because the input could be 0 based or 1 based indexing, so this will support both
        for(int i=0;i<=n;i++) {
            rank.add(0);
            uP.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node) {
        if(uP.get(node) == node) {
            return node;
        }
        /**
         * PATH COMPRESSION IS OCCURING HERE
         * AS WE CAN SEE RATHER THAN USING RECURSION IF THE ULTIMATE PARENT WAS UPDATED PREVIOUSLY WE JUST GET THAT FROM LIST AND CHECK
         * FOR IT.
         */
        int ultimateParent = findUPar(uP.get(node));
        uP.set(node, ultimateParent);
        return uP.get(node);
    }

    public void unionByRank(int node1, int node2) {
        int uPar1 = findUPar(node1);
        int uPar2 = findUPar(node2);
        if (uPar1 == uPar2)
            return;

        if(rank.get(uPar1) > rank.get(uPar2)) {
            uP.set(uPar2, uPar1);
        } else if (rank.get(uPar1) < rank.get(uPar2)) {
            uP.set(uPar1, uPar2);
        }
        else {
            uP.set(uPar2, uPar1);
            rank.set(uPar1, rank.get(uPar1)+1);
        }
    }

    public void unionBySize(int node1, int node2) {
        int uPar1 = findUPar(node1);
        int uPar2 = findUPar(node2);
        if (uPar1 == uPar2)
            return;

        /**
         * INSTEAD OF USING ELSE IF, WE CAN SIMPLY USE ELSE TOO.
         */
        if(size.get(uPar1) > size.get(uPar2)) {
            uP.set(uPar2,uPar1);
            size.set(uPar1, size.get(uPar1) + size.get(uPar2));
        } else if (size.get(uPar1) < size.get(uPar2)) {
            uP.set(uPar1, uPar2);
            size.set(uPar2, size.get(uPar1) + size.get(uPar2));
        }
        else {
            uP.set(uPar2, uPar1);
            size.set(uPar1, size.get(uPar1) + size.get(uPar2));
        }
    }

    /**
     * REMOVE THIS MAIN WHEN USING DISJOINT SET AS OBJECT IN SOME OTHER CLASS
     */

    public static void main (String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        /**
         * CONFUSION CAN ARISE THAT WHY ARE WE NOT USING PARENT LIST RATHER USING RECURSION AGAIN, THIS IS BECAUSE
         * IT CAN HAPPEN LIKE ABOVE FOR 7 PARENT IS 6, BUT 6 WHICH WAS HAVING ULTIMATE PARENT 6 AFTER UNION BY 5 GOT ULTIMATE PARENT 4.
         */
        if(ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        }
        else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if(ds.findUPar(3) == ds.findUPar(7)) {
            System.out.println("Same");
        }
        else
            System.out.println("Not Same");
    }

}
