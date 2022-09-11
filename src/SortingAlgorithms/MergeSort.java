package SortingAlgorithms;

public class MergeSort {
    /**
     *
     * TC BIG O(NLOGN), WHY?
     * BECAUSE WHENEVER WE DIVIDE THE ARRAY INTO 2K ELEMENTS THE COMPLEXITY IS LOG N, AND DURING MERGE WE ARE
     * HAVING COMPLEXITY OF N, SO TOTAL IS BIG O(NLOGN)
     *
     */
    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei)
          return;
        int mid = si + (ei-si)/2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        merge(arr, si, mid, ei);

    }

    private static void merge(int arr[], int si, int mid, int ei) {

        int dummy[] = new int[ei - si + 1];

        int ind1 = si;
        int ind2 = mid + 1;

        int x=0;

        while (ind1 <= mid && ind2 <= ei) {
            if(arr[ind1] <= arr[ind2])
                dummy[x++] = arr[ind1++];
            else
                dummy[x++] = arr[ind2++];
        }

        while (ind1 <= mid) {
            dummy[x++] = arr[ind1++];
        }
        while (ind2 <= ei){
            dummy[x++] = arr[ind2++];
        }

        for (int i=0,j=si;i<dummy.length && j<=ei;i++,j++) {
            arr[j] = dummy[i];
        }
    }

    public static void main(String[] args) {
        /**
         * THE FOLLOWING SORTING ALGO, MERGE SORT USES THE DIVIDE AND CONQUER APPROACH, WE DIVIDE ARRAY INTO SMALLER SUBARRAYS
         * AND THEN MERGE THEM ONE BY ONE
         *
         * STEPS
         *
         * FIRST WE WILL DIVIDE ARRAYS INTO SUBARRAYS TILL THEY ARE DIVIDED INTO SINGLE ELEMENTS, AFTER THIS, WE WILL PASS
         * THEM INTO CONQUER METHOD WHICH WILL HAVE TWO DIFFERENT SUBARRAYS, NOW OBJECTIVE IS TO SORT THEM
         *
         * FOR SORTING WE WILL USE TWO DIFFERENT POINTERS, ONE STARTING FROM LEFT INDEX TILL MID, AND OTHER FROM MID+1 TILL
         * END, AND A DUMMY ARRAY HAVING SIZE ENDING INDEX - STARTING INDEX + 1.
         *
         * RUN A WHILE LOOP TO CHECK IF ARR[STARTINDEX] IS GREATER OR ARR[ENDINDEX], WHICHEVER IS SMALLER ADD IN DUMMY ARRAY
         * AND INCREASE DUMMY ARRAYS INDEX AS WELL AS THE INDEX OF END OR START WHICH WAS GREAT
         *
         * AFTER THIS WE KNOW EITHER STARTINDEX HAS COLLAPSED OR ENDINDEX HAS COLLAPSED, THIS MEANS ONE OF THE INDEX MAY STILL
         * BE LEFT HENCE RUN A WHILE LOOP FOR BOTH ADDING IN DUMMY ARRAY
         *
         * LASTLY ADD THE ELEMENTS FROM DUMMY ARRAY TO ORIGINAL ARRAY AT THE SPECIFIC INDEXES.
         *
         */
        int arr[] = {9,4,2,1,7,6,5,3};
        mergeSort(arr,0, arr.length-1);
    }
}
