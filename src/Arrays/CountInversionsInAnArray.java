package Arrays;

public class CountInversionsInAnArray {
    public static int mergeSort(int arr[], int si, int ei) {
        int mid, invCount = 0;
        if(si < ei) {
            mid = si + (ei - si) / 2;
            invCount += mergeSort(arr, si, mid);
            invCount += mergeSort(arr, mid + 1, ei);
            invCount += merge(arr, si, mid, ei);
        }

        return invCount;

    }

    private static int merge(int arr[], int si, int mid, int ei) {

        int dummy[] = new int[ei - si + 1];

        int inv_count = 0;
        int ind1 = si;
        int ind2 = mid + 1;

        int x=0;

        while (ind1 <= mid && ind2 <= ei) {
            if(arr[ind1] <= arr[ind2])
                dummy[x++] = arr[ind1++];
            else {
                dummy[x++] = arr[ind2++];
                inv_count += mid - ind1 + 1;
            }
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
        return inv_count;
    }

    public static void main(String args[]) {
        /**
         * THE QUESTION STATES THAT WE HAVE TO FIND INVERSIONS, MEANS IF ARRAY IS 3 2 1, MEANS TIMES WHEN LEFT SIDE IS GREATER THAN
         * RIGHT, 3 IS GREATER THAN 1, 2 IS GREATER THAN 1, 3 IS GREATER THAN 2, SO 3 TIMES.
         *
         * WE CAN USE BRUTE FORCE APPROACH BUT IT WOULD TAKE BIG O(N*N)
         *
         * SO OPTIMAL APPROACH HERE IS USE MERGE SORT,
         *
         * AS WE KNOW IN MERGE SORT FIRST WE DIVIDE THEN CONQUER, SO DURING THE CONQUER PART WE OBSERVE THAT, SUPPOSE ARRAY
         * IS 5 4 3 2 1, EVERY TIME WHEN WE ENTER THE IF STATEMENT OF ARR[I] > ARR[J], LEFT SIDE IS BIGGER,
         * AND IF EXTREME LEFT IS BIGGER MEANS THE ENTIRE ARRAY WOULD BE BIGGER, BECAUSE FOR ARRAY 5 4 3, FIRST WE WOULD
         * GET 3 4 5, AND 2 1 WOULD BE 1 2, SO COMPARING 3 4 5 WITH 1 2, 3 IS BIGGER THAN 1 AND IT MEANS 4 IS ALSO BIGGER
         * AND 5 IS ALSO BIGGER, SO INV COUNT WOULD BE MID - IND1 + 1, WHICH MEANS FROM MID TILL IND1 EVERY ELEMENT + 1
         * FOR THE RIGHT ELEMENT WE ARE COUNTING. SO FOR 3 4 5 AND 1, IT WOULD BECOME 2 - 0 + 1,=3 WHICH IS CORRECT
         * AS 3 1 , 4 1 AND 5 1, ARE 3 INVERSIONS.
         *
         *HENCE WE WILL GET OUR ANSWER OFF THIS.
         */
        int arr[] = {5,4,3,2,1};

        System.out.println(mergeSort(arr, 0, arr.length-1));
    }
}
