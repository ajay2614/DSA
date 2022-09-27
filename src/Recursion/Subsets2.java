package Recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
public class Subsets2 {

    public static List<List<Integer>> subsetsWithDupBruteForce(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> listHashSet = new HashSet<>();
        Arrays.sort(nums);
        recursion(new ArrayList<>(), listHashSet,nums, nums.length, 0);
        for (List<Integer> list: listHashSet) {
            ans.add(list);
        }
        return ans;
    }


    public static void recursion(List<Integer> a, HashSet<List<Integer>> ans, int[] arr, int n, int ind) {
        if(ind == n) {
            ans.add(new ArrayList<>(a));
            return;
        }
        a.add(arr[ind]);
        recursion(a, ans, arr, n, ind+1);
        a.remove(a.size()-1);
        recursion(a, ans, arr, n, ind+1);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        subsets(new ArrayList<>(), ans, nums, nums.length, 0);
        return ans;
    }


    public static void subsets(List<Integer> a, List<List<Integer>> ans,
                               int[] arr, int n, int ind) {

        ans.add(new ArrayList<>(a));

        for (int i = ind; i < n; i++) {
            if (i != ind && arr[i] == arr[i - 1])
                continue;

            a.add(arr[i]);
            subsets(a, ans, arr, n, i + 1);
            a.remove(a.size() - 1);
        }
    }
    public static void main(String[] args) {
        /**
         *
         * NOTE -- BASICALLY BOTH ARE PICK AND NOT PICK APPROACHES, AS WHEN WE WILL BACKTRACK IN THESE WE WILL
         * REMOVE THE ELEMENT WE HAD CHOSEN
         *
         * THE QUESTION STATES THAT GIVEN AN ARRAY WE NEED TO STORE ALL ITS UNIQUE SUBSETS AND THEN RETURN IN A LIST
         *
         * FOR EG FOR 1 2 2, IT WILL BE [] 1 12 122 2 22
         *
         * BRUTE APPROACH
         *
         * SINCE WE CAN GET ALL THE SUBSETS FROM RECURSION WE WILL APPLY RECURSION AND COLLECT EVERY SUBSET IN
         * A HASHSET SINCE WE WANT UNIQUE SUBSETS, AFTER THIS WE WILL ITERATE THROUGH SUBSET AND ADD IT IN ANS
         * LIST AND RETURN IT, DO MAKE SURE TO SORT ARRAY BEFORE RECURSION, OTHERWISE WE CAN HAVE DUPLICATE VALUES
         * FOR SOME TESTCASES, FOR EG FOR 41414, IT COULD HAVE SAME VALUES LIKE 4 1 AND 1 4.
         *
         * MAIN LOGIC USE IS FIRST ADD IN ARRAYLIST, AND THEN INCREASE THE INDEX BUT DO MAKE SURE TO REMOVE LAST ELEMENT
         * WHEN BACKTRACK
         *
         *
         * OPTIMAL APPROACH
         *
         * IN THE OPTIMAL APPROACH, WE WILL REMOVE THE USAGE OF HASHSET AND ALSO THUS TC FOR ITERATION OF IT WILL BE REMOVED
         *
         * APPROACH
         *
         * FIRST WE WILL SORT THE ARRAY AS WITHOUT SORTING OUR ALGO CAN NEVER WORK
         *
         * AFTER SORTING WE WILL RUN RECURSION, THE MODIFICATION WE WILL DO IS WE WILL RUN A FOR LOOP INSIDE RECURSION
         * THIS FOR LOOP IS MAKING SURE WE DO NOT COLLECT DUPLICATE SUBSETS AND WILL RUN FROM INDEX TO N.
         *
         * INSIDE THIS FOR LOOP OUR FIRST CONDITION IS
         *              if (i != ind && arr[i] == arr[i - 1])
         *                      continue;
         *
         * ARR[I] == ARR[I-1] IS CHECKING WHETHER THE PREVIOUS ELEMENT WAS SAME, IF IT IS SKIP BUT FOR THAT I != IND
         * SHOULD BE TRUE, WHY THIS STATEMENT, BECAUSE LETS ASSUME FOR 1 2 2 2 3, WHEN WE COME FOR 1ST INDEX THAT IS FIRST 2
         * WE WILL GO INTO LOOP AND CHECK, AS 2 2, IS A UNIQUE SUBSET HAD WE NOT USED THIS 2 2 WOULD NOT HAVE HAPPENED
         * AND THEN WHEN WE WILL GO FOR NEXT TWO WHEN INDEX IS SAME IT WILL NOT RUN AS 2 2 IS ALREADY CREATED
         *
         *
         * OTHER THAN THAT WE ARE FOLLOWING SAME METHOD AS OF RECURSION, ADD ELEMENT IN RECURSION, RUN RECURSION USING THAT FOR
         * NEXT INDEX, MAKE SURE NOT TO CONFUSE AND USE INDEX WHILE CALLING RECURSION, HERE I WILL BE USED AS IND IS CONSTANT,
         * AFTER THIS WHEN IT COMES OUT OF RECURSION REMOVE LAST ELEMENT.
         */
        int arr[] = {1,2,2};
        subsetsWithDup(arr);
    }
}
