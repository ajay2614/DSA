package Arrays;

public class RotateArray {
    /**
     * TC : BIG O(N)
     * SC : BIG O(N)
     */
    public void rotateBrute(int[] nums, int k) {
        int n = nums.length;

        k %= n;

        int arr[] = new int[n];
        int j = 0;
        for(int i=0;i<n;i++) {
            if(i >= n-k) {
                arr[j++] = nums[i];
            }
        }

        int i=0;
        while(j < n) {
            arr[j++] = nums[i++];
        }

        for(i=0;i<n;i++) {
            nums[i] = arr[i];
        }
    }

    /**
     * TC : BIG O(N)
     * SC : BIG O(1)
     */
    public static void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
    }

    public static void reverse(int[] arr, int l, int r) {
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT WE NEED TO ROTATE AN ARRAY BY K MOVEMENTS, FOR EXAMPLE FOR THE BELOW ARRAY
         * 1ST MOVEMENT WOULD BE 7 1 2 3 4 5 6
         * 2ND WOULD BE 6 7 1 2 3 4 5
         * 3RD WOULD BE 5 6 7 1 2 3 4
         *
         * BRUTE APPROACH
         *
         * WE CAN SIMPLY USE A 2ND ARRAY, STORE K ELEMENT FROM THE END, AND THEN 0 TO N-K ELEMENTS
         * AFTERWARDS, SIMPLY PLACE THE ELEMENTS BACK IN THE FIRST ARRAY.
         *
         * OPTIMAL APPROACH
         *
         * SINCE ABOVE WOULD TAKE BIG O(N) SC, WE CAN DECREASE IT BY USING OPTIMAL APPROACH
         *
         * SIMPLY REVERSE THE ENTIRE ARRAY
         *
         * 7 6 5 4 3 2 1,
         *
         * NOW REVERSE 0 TO K-1 ELEMENTS,
         *
         * 5 6 7 4 3 2 1
         *
         * NOW REVERSE K TO N-1 ELEMENTS
         *
         * 5 6 7 1 2 3 4
         */
        int arr[] = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(arr, k);
    }
}
