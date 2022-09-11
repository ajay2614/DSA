package Arrays;
import java.util.*;
public class MergeTwoSortedArray {
    /*
    TIME COMPLEXITY -> BIG O(N*M)
    SC -> BIG O(1)
     */
    public static void mergeBruteForce(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        while (i < m) {
            if(nums1[i] <= nums2[0]){
                i++;
            }
            else {
                int temp = nums2[0];
                nums2[0] = nums1[i];
                nums1[i] = temp;
                i++;

                int first = nums2[0];

                /*
                Following Insertion Sort
                 */

                for(j=1;j<n && nums2[j] < first; j++) {
                    nums2[j-1] = nums2[j];
                }
                nums2[j-1] = first;
            }
        }

        int ind = 0;
        for (int k=m;k<nums1.length;k++) {
            nums1[k] = nums2[ind++];
        }

    }
    /*
    TC->BIG O(N+M)LOG(N+M)
    SC->BIG O(1)
     */

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int value = m + n;
        int gap = value / 2;
        if (value % 2 != 0)
            gap++;
        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < value) {
                if (j < m && nums1[i] > nums1[j]) {
                    int temp = nums1[i];
                    nums1[i] = nums1[j];
                    nums1[j] = temp;
                } else if (j >= m && i < m && nums1[i] > nums2[j - m]) {
                    int temp = nums1[i];
                    nums1[i] = nums2[j - m];
                    nums2[j - m] = temp;
                } else if (j >= m && i >= m && nums2[i - m] > nums2[j - m]) {
                    int temp = nums2[i - m];
                    nums2[i - m] = nums2[j - m];
                    nums2[j - m] = temp;
                }
                i++;
                j++;
            }

            if (gap == 1) {
                gap = 0;
            } else {
                if (gap % 2 != 0)
                    gap = gap / 2 + 1;
                else
                    gap = gap / 2;
            }
        }

        int ind = 0;
        for (int k = m; k < nums1.length; k++) {
            nums1[k] = nums2[ind++];
        }
    }


    public static void main(String[] args) {
        /*
        THE QUESTION STATES THAT WE HAVE TO MERGE TWO SORTED ARRAYS.

        BRUTE APPROACH

        NOW IN THIS APPROACH WHAT WE DO IS WE COMPARE EVERY ELEMENT OF ARR WITH ARR2, IF THERE IS AN ELEMENT FOUND WHICH IS BIGGER
        IN ARR1 THAN ARR2, WE SWAP IT, AND WE SORT 2ND ARRAY.
        WE KEEP DOING THIS PROCESS UNTIL INDEX I < N;

        SHELL SORT/GAP APPROACH

        THIS APPROACH IS BASED ON SHELL SORT, IN THIS WE TAKE A VARIABLE GAP WHICH IS SUM OF N & M / 2. DO REMEMBER THAT WHENEVER
        N+M IS ODD, WE HAVE TO ADD 1 TO GAP, AS 4+3 = 7 / 2 WOULD HAVE BEEN 3, BUT WE NEED GAP TO BE 4

        RUN A WHILE LOOP FOR GAP, WHILE GAP > 0
        NOW HAVE I AS 0, AND J AS GAP
        RUN A WHILE LOOP, WHILE J < M+N

        WRITE EDGE CASES, IF J < M, MEANS WE ARE STILL AT ARRAY 1, AND WE WOULD BE COMPARING ARRAY 1 ELEMENTS FOR THIS GAP
        IF(ARR1[I] > ARR1[J]) -> SWAP

        IF(J>=M && I<M) MEANS I IS IN ARRAY1 AND J IS NOW IN ARRAY2,
        IF(ARR1[I] > ARR2[J-M] -> SWAP, WHY J-M, BECAUSE J HERE IS ALSO HAVING VALUE OF M IN IT, AND IT IS NOW IN ARRAY2, SO
        IT WOULD BE ERROR IF IT WAS ARR2[J]

        IF(J>=M && I>=M) MEANS BOTH I & J ARE IN ARRAY2
        IF(ARR2[I-M] > ARR2[J-M]) SWAP.

        DO REMEMBER TO INCREMENT I & J EVERYTIME IN END OF THIS WHILE LOOP OF J, AND UPDATE GAP AS GAP = GAP/2, ADD 1 IF GAP WAS
        ODD.

        MY ANALYSIS OF THIS APPROACH
        intuition is shell short, which we normally use in place of insertion sort when we know that some of the
        successive elements are already sorted.

        WITH THIS APPROACH WE ARE LIKE CONSIDERING BOTH ARRAYS AS 1, AND HENCE SORTING THEM.S
         */
        int arr1[] = {1,2,3,0,0,0} ;
        int arr2[] = {2,5,6};

        mergeBruteForce(arr1, 3, arr2,3);
    }
}
