package Arrays;
import java.util.Arrays;
import java.util.HashSet;

public class FindDuplicate {

    public static int findDuplicateBruteForce(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);
        int repeating = 0;
        for(int i=1;i<n;i++) {
            if(nums[i] == nums[i-1]){
                repeating = nums[i];
                break;
            }
        }

        return repeating;
    }

    public static int findDuplicateBruteForceSpace(int[] nums) {
        int n = nums.length;

        HashSet<Integer> hashSet = new HashSet<>();
        int repeating = 0;
        for(int i=0;i<n;i++) {
           if(!hashSet.contains(nums[i]))
               hashSet.add(nums[i]);
           else{
               repeating = nums[i];
               break;
           }
        }

        return repeating;
    }

    public static int findDuplicate(int nums[]) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while (slow != fast);

        fast = nums[0];

        while (slow!=fast) {
            slow=nums[slow];
            fast=nums[fast];
        }
        return slow;
    }
    public static void main(String[] args) {
        /**
         * THE OPTIMAL APPROACH IS BASED ON FLOYED LINKED LIST CYCLE DETECTION ALGORITHM
         *
         * STEPS
         *
         * ASSIGN TWO POINTERS SLOW, WITH ARR[0], AND FAST WITH SAME
         *
         *WRITE A DO STATEMENT, RUN SLOW BY BY 1 STEP, WHICH IS VALUE AT ITS CURRENT VALUE AS INDEX, ARR[SLOW], AND FAST
         * BY TWO STEP, WHICH MEANS FIRST RUN IT BY ITS VALUE AS INDEX, AND HAVE THE RESULT OF THAT AS INDEX
         *
         * EG FOR 1 3 4 2 2
         *
         * SLOW WOULD BE 1 AND SO WOULD BE FAST, RUN SLOW BY 1 STEP MEANS IT IS NOW 3, WHICH IS ARR[1]
         * FOR FAST IT IS FIRST VALUE AT 1ST INDEX, WHICH IS 3, THEN AT 3RD INDEX WHICH IS 2.
         *
         * RUN THIS WHILE FAST!=SLOW, MEANS RUN IT TILL THEY DONT COLLIDE, WHY DO IS USED AND NOT WHILE, BECAUSE WITH WHILE
         * AS INITIALLY BOTH ARE AT 0, IT WOULD FAIL
         *
         * AFTER FIRST COLLISION, HAVE FAST AS 0TH INDEX AGAIN, AND RUN TILL 2ND COLLISION, WHEN WE ARRIVE AT SECOND COLLISION,
         * THE RESULT SLOW OR FAST BOTH WOULD BE HAVING DUPLICATE NUMBER.
         *
         * INTUITION
         *
         * NOW HAVING A SINGLE DUPLICATE NUMBER AND NUMBERS ARE 1 TO N, WE ARE BOUND TO GET A COLLISION BETWEEN FAST AND SLOW
         *
         * TILL FIRST COLLISION DISTANCE TRAVELLED BY FAST POINTER = 2A AND SLOW POINTER A,
         *
         * NOW TILL NEXT COLLISION DISTANCE TRAVELLED BY BOTH IS X, AS BOTH ARE MOVING ONE STEP AT A TIME, NOW AS FIRST COLLISION
         * HAD DISTANCE BETWEEN THEM AS A, SO THE DISTANCE BETWEEN DUPLICATE AND FIRST COLLISION IS A-X AS X WAS DISTANCE TILL
         * DUPLICATE
         * NOW IF WE COMPARE BOTH DISTANCE OF SLOW AND FAST DURING 2ND COLLISION WITH A, WE HAVE A-X+X = A, THIS MEANS THAT BOTH
         * ARE BOUND TO MEET AT DUPLICATE D
         *
         * CHECK DIAGRAM FOR BETTER UNDERSTANDING
         */
        int arr[] = {1,3,4,2,2};
        findDuplicate(arr);
        findDuplicateBruteForce(arr);

   }
}
