package Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetSums {
    public static ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        ArrayList<Integer> ans = new ArrayList<>();
        recursion(arr, ans, 0, 0, N);
        Collections.sort(ans);
        return ans;
    }

    public static void recursion(ArrayList<Integer> arr, ArrayList<Integer> ans, int ind, int sum, int n) {
        if(ind == n) {
            ans.add(sum);
            return;
        }

        recursion(arr, ans, ind+1, sum + arr.get(ind), n);
        recursion(arr, ans, ind+1, sum, n);
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE NEED TO FIND SUM OF SUBSETS AND RETURN IT IN A LIST
         *
         * FOR EG FOR 2 5, SUM WOULD BE 0, 2, 5, 7(2+5)
         *
         * WE WILL USE RECURSION, AS WE CAN SEE WE ARE FOLLOWING PICK AND NOT PICK APPROACH
         * WE WILL RUN RECURSION AND INCREASE INDEX, AND WILL ADD SUM ALONG WITH IT IN THE RECURSION, SUM
         * WOULD BE REPRESENTED AS
         *  sum + arr.get(ind)
         * FOR EG FOR 1 2 3, CURRENT INDEX IS 0, SO SUM+1, IND++ FOR RECURSION FOR NEXT INDEX.
         *
         * AND IN THE NOT PICK SIMPLY SUM, AS FOR 1 2 3, WE CHOSE NOT TO ADD 1 AND MOVE ALONG TO NEXT INDEX.
         *
         * MAKE SURE TO SORT THE ANS LIST AS ASKED IN THE QUESTION
         *
         */
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(5);
        subsetSums(arr, arr.size());
    }
}
