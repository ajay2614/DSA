package SortingAlgorithms;

public class QuickSort {
    /**
     * TC : BIG O(N*N) IN WORST CASE
     *      BIG 0(NLOGN) IN AVERAGE
     *
     *      WHEN WILL BIG O(N*N) WHEN THE COMPLETE ARRAY IS SORTED ASCENDING OR DESCENDING AND IN THIS CASE IF WE CHOOSE
     *      PIVOT AS FIRST OR LAST ELEMENT
     *
     *      WHY BIG O(N*N) BECAUSE SAY ARRAY IS 1 2 3 4 5, THEN FIRSTLY WE WILL TAKE 5 AS PIVOT
     *      AFTER PARTITION THE ARRAY WOULD BE 1 2 3 4, AND 1 2 3 , AND 1 2, AS WE CAN SEE
     *      AT EVERY STAGE IN THE PARTITION WE ARE RUNNING LOOP WHICH MAKES N AND SINCE WE ARE MOVING DOWN N LEVELS IN
     *      THIS CASE, THAT'S WHY COMPLEXITY IS BIG O(N*N) IN THIS CASE.
     *
     * SC : BIG O(1)
     */
    public static void sort(int arr[], int low, int high) {
        if(low < high) {

            int partitionIndex = partitionAlternate(arr,low,high);

            sort(arr,low,partitionIndex-1);
            sort(arr,partitionIndex+1,high);
        }
    }

    public static int partition(int arr[], int low, int high) {

        int ind = low-1;
        int pivot = arr[high];
        for(int i=low;i<high;i++) {
            if(arr[i] < pivot) {
                ind++;

                int temp = arr[i];
                arr[i] = arr[ind];
                arr[ind] = temp;
            }
        }

        ind++;

        int temp = pivot;
        arr[high] = arr[ind];
        arr[ind] = temp;

        return ind;
    }

    public static int partitionAlternate(int arr[], int low, int high) {

        int pivot = arr[low];
        int i = low;
        int j = high;
        int r = arr.length;

        while (i < j) {
            while (i < r && arr[i] <= pivot)
                i++;
            while (arr[j] > pivot)
                j--;

            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[j];
        arr[j] = pivot;
        arr[low] = temp;

        return j;
    }

    public static void main(String[] args) {
        /**
         * APPROACH
         *
         * IN QUICK SORT OUR MAIN APPROACH IS TO SET AN ELEMENT AS PIVOT AND THEN GET THAT ELEMENT ON ITS ACTUAL PLACE/INDEX
         * (THE PLACE IT WOULD BE WHEN ARRAY IS SORTED) AFTER THIS DO THE SAME STEP FOR LEFT PARTITION AND RIGHT PARTITION
         *
         * STEPS
         *
         * FOR SORTING A PARTITION OR FULL ARRAY WHAT WE WILL DO IS PASS A LOW INDEX AND HIGH INDEX,
         * FROM A PARTITION METHOD GET THE PARTITION INDEX WHICH IS JUST THE INDEX FOR THE ELEMENT THAT HAS BEEN KEPT
         * IN IT'S PLACE AND THEN CALL THE SAME METHOD FOR LOW, PARTITION INDEX -1 AND PARTITION INDEX + 1 AND HIGH
         *
         * WHY -1 AND +1 AND NOT ACTUAL, BECAUSE THAT INDEX ALREADY HAS SORTED ELEMENT, NO NEED FOR THAT AND FIND FOR LEFT
         * AND RIGHT PARTITION
         *
         * PARTITION METHOD
         *
         * IN THIS WE WILL TAKE AN IND WHICH WOULD BE FINALLY RETURNED AS PARTITION INDEX, INITIALLY KEEP THIS AS LOW-1,
         *
         * RUN A FOR LOOP FROM LOW TO HIGH, EVERYTIME WHEN AN ARRAY ELEMENT COMES WHICH IS SMALLER THAN PIVOT
         * ELEMENT THEN
         *
         * INCREASE IND BY 1
         * SWAP ARR[IND] AND ARR[I]
         *
         * AFTER THIS LOOP INCREASE IND BY 1 AND REPLACE PIVOT ELEMENT WITH ARR[IND] BECAUSE ARR[IND] WOULD BE THE ACTUAL PLACE
         * PIVOT NEEDS TO BE.
         *
         * THIS PARTITION WAY WILL ALWAYS PLACE THE PIVOT ELEMENT ON IT'S CORRECT PLACE
         *
         * FOR EG FOR 1 3 9 8 7, WE TAKE 7 AS PIVOT AND IND AS -1 BECAUSE LOW IS 0.
         *
         * 1 WILL GET REPLACED BY ITSELF
         * 3 WILL GET REPLACED BY ITSELF
         * 9 WILL HAVE NO CHANGE FIRST
         * 8 WILL HAVE NO CHANGE
         *
         * AS IND IS ON 2 AND LOOP HAS ENDED HENCE FOR LAST INDEX WE WILL INCREASE IT BY 1, AND REPLACE IT WITH 7
         *
         * HENCE THE ARRAY IS NOW 1 3 7 8 9
         *
         * ANOTHER EXAMPLE
         *
         * 1 2 8 9 6 7
         * 1 WILL GET REPLACED BY ITSELF
         * 2 WILL GET REPLACED BY ITSELF
         * 8 WILL HAVE NO CHANGE
         * 9 WILL HAVE NO CHANGE
         * 8 AND 6 WILL BE SWAPPED
         *
         * 7 WILL GET SWAPPED BY 9,
         *
         * SO THE PATTERN WE ARE FOLLOWING HERE IS EVERY TIME WE HAVE THE SMALLER ELEMENT REPLACE IT WITH ELEMENT AT IND+1,
         * AND FOR LARGER ELEMENT DO NOTHING.
         *
         *
         * IN PARTITION ALTERNATE
         *
         * THE APPROACH HERE IS HAVE PIVOT  AT SAY FRONT, THEN CHECK FROM LAST, KEEP ON INCREASING INDEX TILL WE FIND
         * FIRST SMALLEST FROM RIGHT, AND SAME FROM LEFT JUST HERE WE ARE LOOKING FOR FIRST BIGGEST, IF I HAS NOT CROSSED
         * J THEN SWAP
         *
         * IN THE END SWAP JTH ELEMENT WITH PIVOT ELEMENT.
         */
        int arr[] = {3,2,1,5,6,4};

        sort(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
