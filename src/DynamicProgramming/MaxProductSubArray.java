package DynamicProgramming;

public class MaxProductSubArray {
    public static int maxProductBruteForce(int[] nums) {

        int n = nums.length;
        int result = nums[0];
        for(int i=0;i<n;i++) {
            int product = nums[i];
            for(int j=i+1;j<n;j++) {
                result = Math.max(result, product);
                product = product * nums[j];
            }
            result = Math.max(result, product);
        }

        return result;
    }

    static int maxProductSubArray(int arr[]) {
        int prod1 = arr[0], prod2 = arr[0], result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(prod1 * arr[i], prod2 * arr[i]));
            prod2 = Math.min(arr[i], Math.min(prod1 * arr[i], prod2 * arr[i]));
            prod1 = temp;

            result = Math.max(result, prod1);
        }
        return result;
    }

    public static void main(String[] args) {
        /*
        THE QUESTION STATES THAT WE ARE GIVEN AN ARRAY, WE HAVE TO FIND THE SUBARRAY WITH MAX PRODUCT, FOR EG FOR GIVEN BELOW
        ARRAY, MAX PRODUCT IS 6, 2 * 3, BRUTE FORCE IS TO CHECK PRODUCT FOR EVERY ELEMENT BY RUNNING 2 LOOPS AND RETURN FINAL ANSWER.
        BRUTE FORCE

        RUN I LOOP FROM 0 T0 N, J FROM I+1 TO N, USE RESULT AND PRODUCT VARIABLE, DONT FORGET TO INTIALIZE RESULT WITH MAX OF RESULT
        AND PRODUCT AFTER EXITING J LOOP AS PRODUCT WAS UPDATED.

        OPTIMAL APPROACH -> THE FOLLOWING SOLUTION IS INSPIRED BY KADANE'S ALGO

        USE 3 VARIABLES, PRODUCT 1, PRODUCT 2 AND RESULT,
        WHY PRODUCT 1 & 2, BECAUSE WE ALSO HAVE NEGATIVE NUMBERS, SO TO TRACK SMALLER AND LARGER PRODUCT WE USE THESE

        PRODUCT1 WILL COMPUTE THE MAXIMUM VALUE BETWEEN CURRENT ARRAY ELEMENT AND PRODUCT OF CURRENT ELEMENT WITH PRODUCT 1 & 2
        , AND PRODUCT 2 WILL COMPUTE THE MINIMUM VALUE BETWEEN CURRENT ARRAY ELEMENT AND PRODUCT OF CURRENT ELEMENT WITH
        PRODUCT 1 & 2

        RESULT WILL GET MAX VALUE OF CURRENT RESULT AND PRODUCT1.



        IN KADANE'S WHEN WE ADD CURRENT ELEMENT AND COMPUTE WITH MAX, IF IT IS SMALLER THAN 0, WE SET

         */
        int arr[] = {2,3,-2,4};
        int arr2[] = {-3,-1,-1};

        maxProductSubArray(arr2);
        maxProductBruteForce(arr);
    }


}
