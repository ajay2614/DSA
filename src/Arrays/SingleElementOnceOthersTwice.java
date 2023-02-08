package Arrays;

import java.util.HashSet;

public class SingleElementOnceOthersTwice {
    public int singleNumberBrute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
            }
            else {
                set.add(i);
            }
        }

        for(Integer i : set) {
            return i;
        }
        return 0;
    }

    /**
     *
     * XOR APPROACH
     * SINCE EVERY NUMBER WILL MULTIPLY BY ITSELF AND GET CANCELLED ONLY REMAINING WILL BE THAT APPEARED ONCE
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i : nums) {
            ans ^= i;
        }
        return ans;
    }
}
