package Recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class CombinationSum {
    /**
     * Time Complexity: O(2^t * k) where t is the target, k is the average length
     *
     * Reason: Assume if you were not allowed to pick a single element multiple times, every element will have a couple of options:
     * pick or not pick which is 2^n different recursion calls, also assuming that the average length of every combination generated
     * is k. (to put length k data structure into another data structure)
     *
     * Why not (2^n) but (2^t) (where n is the size of an array)?
     *
     * Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.
     *
     * Space Complexity: O(k*x), k is the average length and x is the no. of combinations
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(candidates, ans, new ArrayList<>(), 0, target, candidates.length);
        return ans;
    }

    public static void recursion(int[] arr, List<List<Integer>> ans, List<Integer> a, int ind, int target, int n) {
        if(ind == n) {
            if(target == 0) {
                ans.add(new ArrayList<>(a));
            }
            return;
        }

        if(arr[ind] <= target) {
            a.add(arr[ind]);
            recursion(arr, ans, a, ind, target - arr[ind], n);
            a.remove(a.size()-1);
        }

        recursion(arr, ans, a, ind+1, target, n);
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT GIVEN AN ARRAY, ALL THE ELEMENTS THAT CAN GIVE US SUM EQUAL TARGET,
         * IN THIS QUESTION ELEMENT REPEATING IS ALLOWED.
         *
         * FOR EG FOR BELOW ARRAY, 2 2 3 CAN BE ONE ANSWER FOR 7
         *
         * APPROACH
         *
         * WE WILL USE RECURSION, INSIDE RECURSION WE WILL CHECK FOR ARR[I] <= TARGET, IF THIS IS TRUE WE RUN RECURSION FOR SAME
         * INDEX, JUST SUBTRACT TARGET WITH ARR[I], WHY SAME INDEX AS WE CAN HAVE SAME INDEX VALUES, SO WE WILL RUN RECURSION
         * AND IF THIS STATEMENT ISN'T TRUE THEN COME OUT OF THIS IF AND RUN RECURSION FOR IND + 1 SO TO CHECK FOR DIFF VALUES
         * OR IF TARGET IS 0 OR NEGATIVE THEN TO EXHAUST IND,
         *
         * BASE CASE IF IND == N, IF THIS IS TRUE CHECK IF TARGET IS 0, THAT MEANS LIST CONTAINS ELEMENTS EQUAL TO TARGET
         *
         * NOTE : DON'T FORGET TO REMOVE ELEMENT SO THAT BACKTRACK CAN HAPPEN, FOR EG AFTER COMING OUT OF 1 3, WE WOULD REMOVE
         * 3, SO THAT ONE CAN CHECK WITH NEXT VALUES,
         *
         * DON'T USE I++, USE I+1, AS IT WAS GIVING STACKOVERFLOW, REASON NOT KNOWN.
         */
        int arr[] =  {2,3,6,7};
        int target = 7;

        combinationSum(arr, target);
    }
}
