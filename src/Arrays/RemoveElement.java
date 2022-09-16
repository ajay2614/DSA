package Arrays;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int m = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != val)
                nums[m++] = nums[i];
        }
        return m;
    }


    public static void main(String[] args) {
        int arr[] = {0,1,2,2,3,0,4,2};
        removeElement(arr, 2);
    }
}
