package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    /**
     * Time Complexity:  N! x N
     *
     * Space Complexity:  O(1)
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(ans, nums, nums.length, 0);
        return ans;
    }

    public void recursion(List<List<Integer>> ans, int arr[], int n, int ind) {

        if(ind == n) {
            List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
            ans.add(list);
            return;
        }

        for(int i=ind;i<n;i++) {
            swap(ind, i, arr);
            recursion(ans, arr, n, ind+1);
            swap(ind, i, arr);
        }

    }
    public void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        /**
         * THE APPROACH IS EXACTLY SAME TO THE APPROACH USED FOR KTH PERMUTATION BRUTE FORCE
         * WE WILL USE THE SAME SWAP, THEN RECURSIVE CALL FOR IND+1, AND THEN SWAP TO BACKTRACK,
         * WHEN IND == N, WE CONVERT THE ARRAY TO LIST AND STORE IN THE ANS.
         */
    }

}
