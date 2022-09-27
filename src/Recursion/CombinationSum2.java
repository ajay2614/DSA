package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
public class CombinationSum2 {
    public static List<List<Integer>> combinationSum2BruteForce(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        recursion(candidates, hashSet, new ArrayList<>(), 0, target, candidates.length);
        for (List<Integer> a : hashSet) {
            ans.add(a);
        }

        return ans;
    }

    public static void recursion(int[] arr, HashSet<List<Integer>> ans, List<Integer> a, int ind, int target, int n) {
        if(ind == n) {
            if(target == 0) {
                ans.add(new ArrayList<>(a));
            }
            return;
        }

        if(arr[ind] <= target) {
            a.add(arr[ind]);
            recursion(arr, ans, a, ind+1, target - arr[ind], n);
            a.remove(a.size()-1);
        }

        recursion(arr, ans, a, ind+1, target, n);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(candidates, target, ans, new ArrayList<>(), 0, candidates.length);
        return ans;
    }

    public static void findCombinations(int[] arr, int target, List<List<Integer>> ans, List<Integer> a, int ind, int n) {
        if(target==0) {
            ans.add(new ArrayList<>(a));
            return;
        }

        for (int i=ind;i<n;i++) {
            if(i!=ind && arr[i] == arr[i-1])
                continue;
            if (arr[i] > target)
               break;
            a.add(arr[i]);
            findCombinations(arr, target - arr[i], ans, a, i+1, n);
            a.remove(a.size()-1);
        }
    }

    public static void main(String[] args) {
        /**
         *
         * THE QUESTION STATES THAT GIVEN AN ARRAY, WE NEED TO FIND THE TARGET
         *
         * FOR EG FOR 4, POSSIBLE VALUES COULD BE 1,3 AND 2,2 (OF DIFFERENT INDEXES), 4
         *
         * MUCH LIKE THE SUBSETS 2, IN THIS QUESTION ALSO WE WILL PICK AND NOT PICK APPROACH AS BRUTE FORCE METHOD AND
         * SUBSEQUENCE APPROACH FOR OPTIMAL APPROACH
         *
         * BRUTE APPROACH
         *
         * WE WILL USE THE SIMILAR APPROACH AS COMBINATION SUM
         *
         * WE WILL CHECK FOR IF(ARR[I] <= TARGET), RUN RECURSION FOR THIS, BUT HERE WE INCREASE THE INDEX AS SAME INDEX ELEMENTS
         * ARE NOT ALLOWED
         *
         * IF THE FOLLOWING CONDITION ISN'T TRUE THEN RUN RECURSION FOR IND+1, AS IT WOULD EXHAUST AT BASE CASE WHICH IS N
         * WHICH CHECK WHETHER TARGET = 0.
         *
         * OPTIMAL APPROACH
         *
         * CALL RECURSION, THEN RUN FOR LOOP FROM I TO IND, IF, THE I != IND AND ARR[I] = ARR[I-1], MEANS WE HAVE A DUPLICATE
         * AND WE CANT CREATE SUBSEQUENCE OF THIS SO SKIP THIS, IF THE ARR[I] > TARGET, THEN BREAK AS NO USE FOR
         * RUNNING FOR THAT INDEX AS WE ALREADY HAVE THE ANSWER,
         * OR TARGET HAS ALREADY BECOME NEGETIVE,
         * OTHERWISE RUN RECURSION FOR WITH I + 1, AND TARGET - ARR[I]
         *
         * BASE CASE CHECK WHETHER TARGET IS 0 AND ADDS IN ANSWER IF IT IS.
         *
         * NOTE :  DON'T USE I++, USE I+1, AS IT WAS GIVING STACKOVERFLOW, REASON NOT KNOWN. DON'T FORGET TO REMOVE ELEMENT
         * WHILE BACKTRACKING
         */
        int arr[] = {1, 2, 2, 3, 4};
        combinationSum2(arr, 4);
    }
}
