package Arrays;

import java.util.HashMap;

public class TwoSum {
    /**
     *  TC BIG O(N*N)
     *  SC BIG O(1)
     */
    public static int[] twoSumBruteApproach(int[] nums, int target) {

        int n = nums.length;

        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                if(nums[i] + nums[j] == target)
                    return new int[]{i,j};
            }
        }

        return new int[]{0};
    }
    /**
     *  TC BIG O(N)
     *  SC BIG O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++) {
           if(hashMap.containsKey(target - nums[i]))
               return new int[]{i, hashMap.get(target - nums[i])};
           else
               hashMap.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         * THIS QUESTION STATES THAT GIVEN AN ARRAY RETURN INDEXES OF THE 2 ELEMENTS WHOSE SUM IS EQUAL TO TARGET
         *
         * EG 2 5 8 7, AND TARGET IS 10, THEN ASNWER IS 0 & 2, WHICH REPRESENT 2 AND 8 WHICH FORM A 10
         *
         * BRUTE APPROACH IS RUN I & J LOOP ADD NUMS[I] AND NUMS[J] AND CHECK IF ITS EQUAL TO THE ANSWER.
         *
         * A SLIGHT BETTER APPROACH WOULD BE TO USE HASHMAP, BUT IT WOULD GIVE BIG O N SPACE,
         *
         * RUN I LOOP TILL N-1, CHECK IF TARGET - ARR[I] IS A KEY PRESENT IN HASHMAP, IF IT ISN'T ADD
         * CURRENT ELEMENT AS KEY AND ITS INDEX AS HASHMAP,
         * THIS WAY FOR ARR 2 5 8 7, FIRST 2 AND 0 GETS ADDED, NOW WHEN WE WILL COME TO 2ND INDEX, TARGET - ARR[I] IS PRESENT
         * MEANS WE HAVE THE ELEMENT WHICH CAN FORM SUM EQUAL TARGET.
         */
    }
}
