package Misc;

public class HappyNumber {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = compute(slow);
            if(slow == 1)
                return true;
            fast = compute(compute(fast));
            if(fast == 1)
                return true;
        } while(slow != fast);

        return false;
    }
    public int compute(int n) {
        int value = 0;

        while(n > 0) {
            int i = n % 10;
            value += i * i;
            n /= 10;
        }

        return value;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        happyNumber.isHappy(19);
    }
}

