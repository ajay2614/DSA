package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class FourSum {

    /**
     * Time Complexity: O(n³)
     * Reason: There are 2 nested loops and the front pointer as well as the right pointer (Third nested loop)
     *
     * Space Complexity: O(1), (Generally the space complexity that is used to return the answer is ignored)
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {

        int n = nums.length;
        List<List<Integer>> ansList = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return ansList;

        Arrays.sort(nums);

        for(int i=0;i<n;i++) {
            for (int j=i+1;j<n;j++) {
                long target2 = (long) target - (long) nums[i] - (long) nums[j];
                int left = j+1;
                int right = n-1;
                while(left < right) {
                    long leftAddRight = (long) nums[left] + (long) nums[right];
                    if(leftAddRight > target2) {
                        right--;
                    }
                    else if (leftAddRight < target2) {
                        left++;
                    }
                    else {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[left]);
                        ans.add(nums[right]);
                        ansList.add(ans);
                        int checkRepeatLeft = nums[left];
                        int checkRepeatRight = nums[right];
                        while(left < right && checkRepeatLeft == nums[left])
                            left++;
                        while (left < right && checkRepeatRight == nums[right])
                            right--;
                    }

                }
                while (j + 1 < n && nums[j] == nums[j+1]) {
                    j++;
                }
            }
            while (i + 1 < n && nums[i] == nums[i+1]) {
                i++;
            }
        }
        return ansList;
    }

    public static void main(String[] args) {
        /**
         * THIS QUESTION STATES THAT WE HAVE TO FIND ALL THOSE 4 ELEMENTS THAT FORM SUM EQUAL TO TARGET, HOWEVER ALL THESE
         * FOUR ELEMENTS MUST BE UNIQUE AND ALSO WE CAN'T REPEAT THE SERIES AGAIN.
         *
         * THE EASIEST SOLUTION IS ALSO THE MOST OPTIMAL SOLUTION IN THIS
         *
         * APPROACH, WE WILL SORT THE ARRAY FIRST, THEN WE WILL RUN A I * J LOOP, AND INSIDE J LOOP WE WILL RUN
         * A LEFT AND RIGHT POINTER APPROACH WHICH WILL COLLECT THE 3RD AND 4TH ELEMENT FOR US EQUALLING TARGET
         *
         * STEPS
         *
         * RUN I LOOP FROM O -> N
         * RUN J LOOP FROM I+1 -> N
         * HAVE A DUMMY TARGET WHICH IS ACTUAL TARGET - ARR[I] - ARR[J], BECAUSE WE WOULD BE USING THIS TARGET TO FIND THE 3RD AND
         * 4TH ELEMENT
         * RUN LEFT AND RIGHT POINTER FROM J+1 TO N, NOW IF DUMMY TARGET IS SMALLER THAN ARR[LEFT] + ARR[RIGHT], MEANS ELEMENT
         * IS SMALLER AND IS ON LEFT OR ELEE ITS ON RIGHT IF ITS GREATER, MOVE RIGHT POINTER FOR SMALLER AND LEFT FOR GREATER
         * IF IT IS NEITHER MEANS WE FOUND THE ANSWER, ADD ALL THE 4 ELEMENTS IN ARRAY LIST, NOW WE KNOW WE CANT HAVE SAME SERIES
         * AGAIN, HENCE WE WILL INCREMENT LEFT TILL A NEW ELEMENT IS THERE, SIMILARLY DECREMENT RIGHT TILL NEW ELEMENT IS THERE
         *
         * AFTER COMING OUT OF THIS WHILE LOOP, THAT IS WHEN LEFT IS EQUAL TO RIGHT, WE WILL ALSO DO RUN A WHILE LOOP FOR J
         * SO WE POINT TO THAT ELEMENT WHICH IS UNIQUE AND NOW SIMILAR TO PREVIOUS, EG 2 2 2 3, THEN WE NEED TO GET THIS TO 3,
         * WE USE J+1 TO COMPARE BECAUSE J++ WOULD INCREASE J IN NEXT INCREMENT.
         *
         * DO THE SAME FOR I.
         *
         */
    }
}
