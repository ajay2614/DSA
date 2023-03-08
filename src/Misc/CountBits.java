package Misc;

public class CountBits {
    public int[] countBits(int n) {

        int arr[] = new int[n+1];
        for(int i=1;i<=n;i++) {
            int a = i >> 1;
            int b = 1 & i;
            arr[i] = arr[i >> 1] + (1 & i);
        }
        return arr;
    }

    public static void main(String[] args) {
        CountBits c = new CountBits();
        c.countBits(5);

        /**
         * IN THIS WE ARE DOING RIGHT SHIFT OF I BY 1 TO GET THE TOTAL 0 FOR PREV NUMBER WHICH HAS 1 BIT LESS THAN THE CURRENT
         *
         * MEANING SUPPOSE FOR 4, THE BINARY FORM IS 1 0 0 , NOW 4 >> 1, WILL REMOVE THE LAST BIT AND GET THE NUMBER THERE
         * WHICH IS 2, 1 0, NOW SIMPLY BY CHECKING WHETHER 1 0 0 HAS 1 OR 0 BIT AT LAST, WE CAN GET TOTAL BITS
         * AS IT DOESN'T HAVE THEN WE CAN SIMPLY GET THE ACTUAL VALUE FOR THE ARR[1 >> I] WHICH HAD 1 TOTAL BIT.
         *
         * IT IS IN A WAY SORT OF DP APPROACH BY CALCULATING THE CURRENT VALUE BY USING PREV VALUES.
         */
    }
}
