package Arrays;

/**
 *QUESTION
 * GIVEN AN ARRAY OF N NUMBERS WHICH CAN RANGE FROM (-10^7 TO 10^7). THE NUMBERS CAN HAVE UPTO 4 DIGITS AFTER DECIMAL POINT.
 * THE TASK IS TO TAKE INTEGRAL VALUES OF THESE N NUMBERS. WHEN YOU ARE TAKING VALUES MAKE SURE TO CEIL OR FLOOR OF A[I].
 * YOU HAVE TO SELECT IN SUCH A WAY SUM OF SELECTED NUMBERS GIVES RESULT 0.
 *
 * INPUT -> 4
 * 4.566 1.243 -2.434 -3.4
 * OUTPUT
 * 4 1 -2 -3
 * */
public class IntegralSumEqualToZero {

    public static int[] find(double[] arr, int n) {
        int ans[] = new int[n];
        int sum = 0;
        for (int i=0;i<n;i++) {
            ans[i] = (int) Math.ceil(arr[i]);
            sum += ans[i];
        }
        for (int i=0;i<sum;i++) {
            ans[i] = (int) Math.floor(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        /**
         * TO SOLVE THIS QUESTION WE REALIZE WHEN WE CEIL ALL THE NUMBERS IF SUM DOESN'T TURN OUT TO BE ZERO THEN THE SUM WILL BE
         * GREATER THAN ZERO, AND IF THIS IS THE CASE WE WILL DO FLOOR TILL THE SUM.
         *
         * FOR EG FOR BELOW ARRAY CEIL IS 5 2 -2 -3, WE SEE THAT SUM WILL NEVER BE LESS THAN ZERO AS NEGATIVE WILL ALWAYS DECREASE
         *
         * AS ABOVE SUM IS 2, WE RUN ANOTHER LOOP FROM O TO 2. SO 5 BECOMES 4, 2 BECOMES 1, FINAL ARRAY IS 4 1 -2 -3, WHICH INDEED
         * IS EQUAL TO ZERO
         **/
        double arr[] = {4.566, 1.243, -2.434, -3.4};

        find(arr, arr.length);
    }
}
