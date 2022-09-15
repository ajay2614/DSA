package Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class MajorityElement2 {

    public List<Integer> majorityElementBrute(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int count = 1;
        int element = nums[0];

        for(int i=1;i<n;i++) {
            if(nums[i] != element) {
                if(count > n/3) {
                    ans.add(nums[i-1]);
                }
                count = 1;
                element = nums[i];
            }
            else {
                count++;
            }
        }

        if(count > n/3)
            ans.add(nums[n-1]);
        return ans;
    }

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int num1 = -1;
        int num2 = -1;

        int count1 = 0;
        int count2 = 0;

        for (int i = 0; i < n; i++) {
            if (num1 == nums[i])
                count1++;
            else if (num2 == nums[i])
                count2++;
            else if (count1 == 0) {
                num1 = nums[i];
                count1++;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++) {
            if (num1 == nums[i])
                count1++;
            else if (num2 == nums[i])
                count2++;
        }

        if (count1 > n / 3)
            ans.add(num1);
        if (count2 > n / 3)
            ans.add(num2);

        return ans;
    }

    public static void main(String[] args) {
        /**
         * UNLIKE THE PREVIOUS MAJORITY ELEMENT WHERE WE HAD TO FIND THE ONLY ELEMENT GREATER THAN N/2, HERE WE CAN HAVE
         * 2 ELEMENTS OCCURRING MORE THAN N/3 TIMES.
         *
         * BRUTE APPROACH I USED IS SORT THE ARRAY FIRST AND THEN WHEN A NEW NUMBER COMES IN CHECK PREVIOUS COUNT AND IF IT
         * WAS GREATER THAN N/3 ADD IT INTO LIST
         *
         * OPTIMAL APPROACH
         *
         * AS WE KNOW WE CAN HAVE MAX OF 2 ELEMENTS OCCURRING MORE THAN N/3 TIMES, HENCE WE CAN TAKE 2 SEPERATE COUNTERS
         * AND 2 SEPARATE VARIABLES FOR 2 DIFF ELEMENTS, THE APPROACH IS SAME AS N/2 ONE, IT ALSO FOLLOWS
         * MOORE VOTING ALGO
         *
         * STEPS
         *
         * ITERATE THROUGH LOOP, IF COUNT 1 IS 0 ASSIGN CURRENT ELEMENT AS NUM1, ELSE DO SAME FOR COUNT 2 AND NUM 2, IF
         * NUM1 IS EQUAL TO CURRENT ELEMENT INCREASE COUNT SAME FOR NUM2, IF A DIFF ELEMENT COMES FROM NUM1 AND NUM2
         * DECREMENT BOTH COUNT1 AND COUNT2.
         *
         * AFTER THIS WE WILL GET TWO MAJORITY OCCURING ELEMENTS BUT WE WONT ADD IN LIST STRAIGHTAWAY, AS WE HAVE TO MAKE
         * SURE THERE LENGTH IS GREATER THAN N/2, HENCE CHECK HOW MANY TIME NUM1 AND NUM2 OCCURS
         *
         * WHY WE USE IF AND ELSE AND NOT IF AND IF IN THIS LOOP, IT COULD HAPPEN THAT ARRAY ELEMENTS ARE -1
         * SO INITIALLY SINCE WE SET BOTH NUM1 AND NUM2 AS -1, COUNT1 AND COUNT2 WOULD HAVE INCREASED FOR BOTH SINCE
         * SO USE IF AND ELSE
         *
         * IN THE END CHECK FOR COUNT1 AND 2 IF THEY ARE BIGGER THAN N/3 ADD IN LIST.
         *
         */
    }

}
