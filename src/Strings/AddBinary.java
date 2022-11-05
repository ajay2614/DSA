package Strings;

public class AddBinary {
    public static String addBinary(String a, String b) {

        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        String ans = "";
        while(i >= 0 || j >= 0 || carry != 0) {
            int n1 = 0;
            int n2 = 0;
            if(i >= 0) {
                if(a.charAt(i) == '1');
                    n1 = 1;
                i--;
            }
            if(j >= 0) {
                if(b.charAt(j) == '1')
                    n2 = 1;
                j--;
            }

            if(n1 + n2 + carry == 0) {
                ans = "0" + ans;
                carry = 0;
            }
            else if(n1 + n2 + carry == 1) {
                ans = "1" + ans;
                carry = 0;
            }
            else if(n1 + n2 + carry == 2) {
                ans = "0" + ans;
                carry = 1;
            }
            else if(n1 + n2 + carry == 3){
                ans = "1" + ans;
                carry = 1;
            }
        }
        return ans;
    }

    public static String addBinaryBetterApproach(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if(i >= 0)
                sum += a.charAt(i--) - '0';
            if(j >= 0)
                sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            sb.append(sum%2);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        addBinaryBetterApproach("1010", "1011");
        /**
         * BASICALLY WHAT ARE DOING IN THIS QUESTION IS TO ADD CHAR AT I AND J AND CARRY,
         * 3 CASES CAN ARISE WHEN N1 AND N2 IS 1 AND CARRY IS 1, IN THAT CASE CARRY WOULD BECOME 1 AND DIGIT THAT WOULD BE
         * ADDED IS SUM%2 WHICH IS 3%2 = 1.
         * SIMILARLY FOR 2 0 WOULD BE ADDED AND 1 WOULD GO IN CARRY
         * AND FOR 1 O WOULD BE ADDED IN CARRY AND 1 WOULD BE ADDED IN ANS.
         */
        /**
        First, create result name string and initially it is empty & in the end we gonna return it as our aswer

        StringBuilder res = new StringBuilder();

        int i = a.length() - 1; // we crete i pointer for string a and we have to start adding from right to left
        int j = b.length() - 1; // similar pointer j for string b
        int carry = 0; // we create a carry, as we have to consider it as well

        Step 2:
        iterate over the loop until the both condition become false

        while(i >= 0 || j >= 0){
            int sum = carry; // initialise our sum with carry;

            Now, we subtract by '0' to convert the numbers from a char type into an int, so we can perform operations on the
            numbers

            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';

            taking carry;
            carry = sum > 1 ? 1 : 0; getting carry depend on the quotient we get by dividing sum /
            2 that will be our carry. Carry could be either 1 or 0

            if sum is 0 res is 1 & then carry would be 0;
            if sum is 1 res is 1 & carry would be 0
            if sum is 2 res is 0 & carry would be 1
            if sum is 3 res is 1 & carry would be 1

            res.append(sum % 2); // just moduling the sum so, we can get remainder and add it into our result

         */
    }
}
