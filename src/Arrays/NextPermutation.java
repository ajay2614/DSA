package Arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] arr) {
        int n = arr.length;
        if(arr == null || n <= 1)
            return;

        int ind = n-2;

        while (ind >= 0 && arr[ind] >= arr[ind+1]) {
            ind--;
        }

        if (ind >= 0) {
            int j = n-1;
            while (arr[j] <= arr[ind])
                j--;
            swap(ind, j, arr);
        }

        reverse(ind + 1, n-1,arr);
    }

    public static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int i, int j, int arr[]) {
        while (i < j) {
            swap(i, j, arr);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        /**
        THE QUESTION STATES THAT WE ARE GIVEN AN ARRAY, WE HAVE TO FIND ITS NEXT PERMUTATION, EG 1 2 3 -> 1 3 2

        THE APPROACH IS--

        1. FIRST WE WILL START FROM INDEX N-2, WE WILL COMPARE EVERY ELEMENT AT IND WITH ELEMENT AT IND + 1, WE KEEP
        SEARCHING TILL WE FIND AN ELEMENT AT IND SMALLER THAN ELEMENT AT IND+1;

        2. AFTERWARDS, WE RUN A J LOOP FROM LAST ELEMENT, AND WE FIND THE FIRST ELEMENT WHICH IS GREATER THAN THE ELEMENT
        AT IND, WHEN WE FIND THAT ELEMENT WE SWAP BOTH

        3. AFTER THIS WE REVERSE THE ELEMENTS FROM IND+1


        IN THIS WAY WE CAN FIND THE NEXT PERMUTATION, THE INTUITION BEHIND THIS IS THAT FOR EVERY SEQ OF NUMBERS,
        THERE IS AN INCREASING SEQUENCE, IRRESPECTIVE OF FROM WHERE IT IS, WE NEED TO FIND THE INDEX WHERE
        THE INCREASING SEQUENCE STOPS, FOR EG FOR 1 3 5 4 2, 3 IS THE ELEMENT THAT REPRESENT INDEX WHERE DECREASING SEQ STARTS

        --VERY IMP NOTE
        IN A WAY WE CAN SAY SUPPOSE FOR 1 2 3 , LAST PERM WOULD BE 3 2 1, SO FOR ANY ARR WE NEED TO IDENTIFY WHERE DECREASING
        SEQ IS STARTING, WE NEED TO CHANGE THE PREFIX, FOR SECOND STEP, WHY WE RUN J LOOP TO GET ELEMENT, BECAUSE BY THIS WAY
        ONLY WE CAN GET THE EXACT NEXT RANKING ELEMENT THAT NEEDS TO BE SWAPPED FOR THAT INDEX, AFTERWARDS, FOR EXACTLY NEXT
        RANK PERMUTATION WE DO LAST STEP OF REVERSE.
        --

        THERE COULD BE COUPLE OF EDGE CASES, SUPPOSE WHEN 1 2 3 IS ARR, IN THIS FIRST STEP WOULD FAIL AUTOMATICALLY,
        ONLY SECOND STEP WOULD WORK WHICH WILL SWAP AS 3 > 2, 3RD STEP WOULD ALSO FAIL AS I + 1 = N-1

        THERE COULD BE ANOTHER EDGE CASE, WHEN 3 2 1 IS IN ARR, IN THIS STEP I WOULD BECOME -1 IN FIRST STEP, 2ND STEP
        WONT RUN AS I IS SMALLER THAN ZERO AND HENCE WE WOULD REVERSE FROM 1ST TO LAST, WHICH WILL GIVE 1 2 3.
         */
        int arr[] = {1,2,3};
        int arr2[] = {1,4,5,3,2};
        int arr3[] = {1,3,5,4,2};
        int arr4[] = {3,2,1};
        nextPermutation(arr);
    }
}
