package Misc;

public class ReverseBits {
    public int reverseBits(int n) {

        int reversed = 0;

        for(int i=0,j=31;i<32 && j >=0;i++,j--) {
            int bit = n >> i & 1;
            reversed = reversed | bit << j;
        }

        return reversed;
    }

    public static void main(String[] args) {
        int n = 1101;
        ReverseBits reverseBits = new ReverseBits();

        reverseBits.reverseBits(n);
    }
}
