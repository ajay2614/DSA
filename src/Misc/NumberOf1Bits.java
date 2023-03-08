package Misc;

public class NumberOf1Bits {
    public int hammingWeight(int n) {

        int cnt = 0;
        for(int i=31;i>=0;i--) {
            int bit = n >> i & 1;
            if(bit == 1)
                cnt++;
        }
        return cnt;
    }
}
