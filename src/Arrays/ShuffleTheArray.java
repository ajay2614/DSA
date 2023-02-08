package Arrays;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int len = nums.length;

        int arr[] = new int[len];
        int x = 0;
        int y = 1;
        for(int i=0;i<n;i++) {
            arr[x] = nums[i];
            x += 2;
        }

        for(int i=n;i<len;i++) {
            arr[y] = nums[i];
            y+=2;
        }

        return arr;
    }
}
