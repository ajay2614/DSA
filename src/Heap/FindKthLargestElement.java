package Heap;

import java.util.PriorityQueue;

public class FindKthLargestElement {
    public static int findKthLargestBruteBetter(int[] nums, int k) {

        int n = nums.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>();


        for(int i=0;i<n;i++) {
            pq.add(nums[i]);

            if(pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }

    public static int findKthLargest(int[] nums, int k) {
        int ans = sortDescending(nums, 0, nums.length-1,k);
        return ans;
    }

    public static int sortDescending(int[] arr, int low, int high, int k) {
        int ans = 0;

        while(true) {
            int pi = partition(arr,low,high);

            if(pi == k - 1) {
                ans = arr[pi];
                break;
            }
            else if(pi < k - 1)
                low = pi + 1;
            else if(pi > k - 1)
                high = pi - 1;
        }

        return ans;
    }

    public static int partition(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int n = arr.length;
        while(i < j) {
            while(i < n && arr[i] >= arr[low])
                i++;
            while(arr[j] < arr[low])
                j--;

            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }

    public static void main(String[] args) {
        /**
         * BRUTE APPROACH
         *
         * SIMPLY USE A PRIORITY QUEUE AND WHENEVER PRIORITY QUEUE SIZE BECOMES MORE THAN K, REMOVE THE FIRST ELEMENT.
         * THIS APPROACH WOULD ALWAYS WORK, SUPPOSE WE HAVE TO GET 2ND HIGHEST ELEMENT FROM ARRAY 1 3 4 5
         *
         * THEN FIRSTLY 1 WILL GET STORED, THEN 3 THEN 4,SINCE HERE SIZE BECAME GREATER THEN K, THEN REMOVE 1, AFTERWARDS
         * 5, REMOVE 3, HERE. TOP IS INDEED KTH LARGEST ELEMENT NOW
         *
         * OPTIMAL APPROACH
         *
         * FOR THE OPTIMAL APPROACH WE WILL USE SIMILAR TO QUICK SORT APPROACH, IF WE HAVE TO FIND THE KTH HIGHEST ELEMENT
         * THEN WE WILL DO PARTITION IN SUCH A WAY THAT WE ARE SORTING THE ARRAY IN DESCENDING ORDER, SO WE WILL CHECK
         * FOR FIRST LOWEST ELEMENT THAN PIVOT FROM LEFT AND HIGHEST FROM RIGHT AND WILL SWAP THEM
         *
         * WE WILL GET THE PARTITION AND WILL CHECK IF IT IS EQUAL TO K-1, IF NOT THEN IF IT IS SMALLER THAN K-1,
         * THEN WE WILL HAVE LOW AS PI+1, MEANING THAT IT IS ON THE RIGHT SIDE AND FOR HIGHER THAN K-1 MEANING ON LEFT
         * SIDE WHERE BIGGER ELEMENTS THAN ELEMENT AT PI ARE PRESENT, AND THEN WE WILL RETURN ONCE PI = K-1.
         *
         */
        int arr[] = {2,1};

        findKthLargest(arr, 1);
    }
}
