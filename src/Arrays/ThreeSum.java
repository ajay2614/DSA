package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ThreeSum {


    /**
     * Same Logic As 4 sum
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++) {
            int target = nums[i];

            int left = i+1;
            int right = n-1;

            while (left < right) {
                int add = nums[left] + nums[right];
                if(add + target < 0) {
                    left++;
                }
                else if(add + target > 0){
                    right--;
                }
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);

                    ans.add(temp);
                    int l = nums[left];
                    int r = nums[right];
                    while(left < right && nums[left] == l)
                        left++;
                    while(left < right && nums[right] == r)
                        right--;
                }
            }
            while(i+1 < n && nums[i+1] == nums[i])
                i++;
        }
        return ans;
    }
}
