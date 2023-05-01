package BinarySearch;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        long low = 0;
        long high = (int) n;


        while(low <= high) {
            long mid = low + (high-low)/2;

            long val = (mid) * (mid+1) / 2;

            if(val <= n) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return (int) high;
    }
}
