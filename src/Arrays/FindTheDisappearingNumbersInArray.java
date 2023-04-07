package Arrays;

import java.util.ArrayList;
import java.util.List;

public class FindTheDisappearingNumbersInArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n;i++) {
            int mark = Math.abs(nums[i]) - 1;
            if(nums[mark] > 0) {
                nums[mark] *= -1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++) {
            if(nums[i] > 0) {
                ans.add(i+1);
            }
        }
        return ans;
    }
}
