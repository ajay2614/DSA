package Arrays;

import java.util.HashSet;
import java.util.Arrays;

public class IntersectionOfTwoArrays {
    /**
     *
     * TC : BIG O(NLOGN)
     * SC : BIG O(N) + O(N) (Set and ans array)
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;

        int i=0;
        int j=0;

        HashSet<Integer> set = new HashSet<>();
        while(i < n1 && j < n2) {
            if(nums1[i] > nums2[j]) {
                j++;
            }
            else if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                if(!set.contains(nums1[i])) {
                    set.add(nums1[i]);
                }
                i++;
                j++;
            }
        }

        int ans[] = new int[set.size()];
        i=0;
        for(Integer k : set) {
            ans[i++] = k;
        }
        return ans;
    }

    /**
     *
     * TC : BIG O(N)
     * SC : BIG O(N) + O(N) + O(N) (Both set and ans array)
     */
    public int[] intersectionOptimal(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> intersection = new HashSet<>();

        for(int i=0;i<n1;i++) {
            set.add(nums1[i]);
        }

        for(int i=0;i<n2;i++) {
            if(set.contains(nums2[i]))
                intersection.add(nums2[i]);
        }

        int ans[] = new int[intersection.size()];
        int i = 0;
        for(Integer val : intersection) {
            ans[i++] = val;
        }
        return ans;
    }
}
