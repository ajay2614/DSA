package Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {

        int n = digits.length;
        for(int i=n-1;i>=0;i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int arr[] = new int[n+1];
        arr[0] = 1;
        return arr;
    }

    /**
     * THE QUESTION IS THAT THERE IS ARRAY GIVEN SAY 1 2 3, WE NEED TO GET ITS NEXT VALUE THAT IS 1 2 4
     *
     * STEPS RUN A LOOP FROM N-1 TO 0, IF ANY NUMBER IS SMALLER THAN 9, THEN ADD 1 TO IT AND RETURN
     *
     * FOR EG FOR ABOVE 1 2 3, 3 IS SMALLER HENCE SIMPLY ADD 1, IF NOT THEN ENTER 0 AT THAT INDEX, MEANS IT WAS A 9
     *
     * EVERYTIME A NUM SMALLER THAN 9 COMES WE WILL ADD 1 TO IT AND RETURN, THIS WILL ALWAYS WORK WHEN THERE IS
     * A NUM SMALLER THAN 1, FOR EG FOR 8 9 9, FIRST 9 AND SECOND WOULD BECOME ZERO, NOW 8 COMES SO ADD 1 TO IT AND
     * RETURN.
     *
     * THE LAST CASE IS WHEN ALL WERE 9, MEANS THE OUTPUT ARRAY WOULD BE N+1 SIZE, SIMPLY PUT 1 IN ZERO INDEX
     * AS THIS CAN ONLY HAPPEN IF ALL DIGITS WE 9, FOR EG 9 9 9 9 WOULD REQUIRE 1 0 0 0 0
     *
     */
}
