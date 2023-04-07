package Misc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        for(int i=left;i<=right;i++) {
            if(checkIfSelfDivides(i))
                ans.add(i);
        }
        return ans;
    }

    public boolean checkIfSelfDivides(int number) {
        int num = number;
        while(num > 0) {
            int i = num % 10;
            if(i == 0 || number % i != 0)
                return false;
            num = num / 10;
        }
        return true;
    }
    public static void main(String[] args) {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        selfDividingNumbers.selfDividingNumbers(707,708);

        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);

        Iterator<Integer> it = a.iterator();


        while (it.hasNext()) {
            Integer i = it.next();

            if(i == 3) {
                it.remove();
            }
        }
    }
}
