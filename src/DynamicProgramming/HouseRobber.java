package DynamicProgramming;

public class HouseRobber {

    public static int rob(int[] nums) {

        int n = nums.length;

        int dp[] = new int[n+2];

        for(int i=n-1;i>=0;i--) {
            int p = nums[i] + dp[i+2];
            int np = dp[i+1];

            dp[i] =Math.max(p, np);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        /**
        USING DP TABULATION APPROACH, WE EITHER PICK OR WE DONT PICK.
         FOR EG SUPPOSE FOR ARRAY 2 5 1 8 9
         FOR HIGHEST DP AT INDEX 4, WE CAN EITHER CHOSE 9 + 1 RIGHT TO IT'S ADJACENT OR WE CAN CHOSE IT'S ADJACENT IF IT'S
         BIGGER, IN THIS WE CHOSE 9, FOR SERIES WHEN WE COME AT I 3, NOW WE CAN EITHER CHOSE 8 AND MAX VALUE TILL IT'S
         RIGHT TO I+1, AS IN THIS CASE 9 WOULD BE BIGGER WE ARE SURE THAT IN A SUBARRAY OF 8 AND 9 MAX WOULD BE 9,
         FOR I=2 WE CAN EITHER HAVE MAX VALUE OF IT'S ADJACENT OR IT'S VALUE + THE MAX VALUE OF RIGHT TO ADJACENT, AS IN THIS CASE
         WE WILL GET 10, SO CHOSE 10, NOW FOR 5 WE CAN EITHER CHOSE 5+9 OR 10 IN CASE OF NOT PICKING IT,SO IN THIS WE CHOSE 14,
         NOW WE CAN EITHER CHOSE 10+2 OR 14, SO ANSWER IS 14.
         */
        int arr[] = {2,1,1,2};

        rob(arr);
    }
}
