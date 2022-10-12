package BinarySearch;

public class NthRoot {

    /**
     * TC : BIG O(N) * BIG O(LOG(M * 10^D))
     *
     * BIG O(N) IS BECAUSE WE ARE USING MULTIPLY METHOD, O(LOG(M * 10^D)), HERE WE KNOW FOR BS, LOG(N) IS THE COMPLEXITY,
     * AS WE ARE SEARCHING LIKE 1.1,1.2,1.3 TILL M PLACES HENCE IT BECOMES M*10, AND AS WE ALSO HAVE DECIMAL PLACES, HENCE
     * IT 10^D.
     *
     * SC : BIG O(1)
     */
    private static double multiply(double number, int n) {
        double ans = 1.0;
        for(int i = 1;i<=n;i++) {
            ans = ans * number;
        }
        return ans;
    }
    public static double findNthRootOfM(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-8;

        while((high - low) > eps) {
            double mid = (low + high) / 2.0;
            if(multiply(mid, n) < m) {
                low = mid;
            }
            else {
                high = mid;
            }
        }
        return low;
    }

    /**
     * IF ONLY SQUARE ROOT IS REQUIRED
     *
     * TC : BIG O(LOGN)
     * SC : BIG O(1)
     */

    public int mySqrt(int x) {
        int start = 1;
        int end = x;

        while(start <= end) {
            int mid = (start + end)/2;

            if(mid <= x/mid) {
                start = mid+1;
            }
            else {
                end = mid-1;
            }
        }
        return end;
    }
    public static void main(String[] args) {
        /**
         * TO FIND THE N ROOT OF ANY NUMBER WE WILL USE BINARY SEARCH APPROACH
         *
         * APPROACH
         * WHAT WE WILL DO IS USE THE MAX VALUE GIVEN IN CONSTRAINT, AND FROM THIS WE WILL SET IT AS HIGH, AND
         * WE WILL SET LOW AS 1.
         *
         * NOW WE WILL DECLARE AN EPS, WHICH IS DECIMAL PLACE UP TO WHICH WE WANT THE ANSWER TO BE SAME, FOR EG
         * 1E-8 MEANS 1O^-8, MEANS 7 PLACES UPTO WHICH ANS IS SAME, WE WILL RUN BINARY SEARCH WHILE HIGH - LOW > EPS
         * MEANS LOW AND HIGH TILL THEY ARE NOT DIFFERENT AFTER 7 DECIMAL PLACES.
         *
         * NOW THE MAIN INTUITION IS THAT WE WILL BE GET THE ROOT VALUE SAY WE ARE CHECKING OF 27 WITH N AS 3,
         * WE WILL CHECK OF MID OF 200 AND 1, 100, AND MULTIPLY IT NTH TIMES, IF IT IS BIGGER THAN THE ACTUAL VALUE WHICH IT IS
         * WE WILL HAVE HIGH AS MID, ELSE LOW AS MID
         *
         * IN THE ANSWER WE WILL RETURN EITHER LOW OR HIGH, BOTH WOULD BE ACCEPTED.
         *
         * STEPS
         *
         * RUN TILL HIGH - LOW > EPS
         *
         * GET MID, MULTIPLY IT NTH TIMES, CHECK IF IT IS SMALLER THAN EQUAL TO NUMBER, HAVE LOW = MID, ELSE
         * HIGH = MID.
         *
         *
         * TO FIND ONLY SQUARE ROOT
         *
         * APPROACH
         *
         * HAVE START = 1, END = INPUT NUMBER
         * RUN WHILE(START <= END), GET MID, IF MID * MID <= X, START = MID+1, ELSE END = MID-1
         *
         * TO PREVENT OVERFLOW WE CAN (mid <= x/mid)
         *
         * RETURN END IF WE NEED TO FIND THE FLOOR VALUE, AS END WOULD CROSS START AND IT WOULD HAVE BECOME SMALLER,
         * IF WE HAVE TO FIND CEIL VALUE THEN RETURN START.
         *
         */
        int n = 4;
        findNthRootOfM(2, 4);
    }
}
