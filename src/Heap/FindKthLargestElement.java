package Heap;

import java.util.Collections;
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
        int arr[] = {2,1};

        findKthLargest(arr, 1);
    }
}
