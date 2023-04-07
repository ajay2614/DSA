package Strings;

public class AddStrings {
    public String addStrings(String num1, String num2) {

        int carry = 0;

        String ans = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while (i >= 0 || j >= 0 || carry != 0) {
            int a = 0;
            if (i >= 0) {
                a = num1.charAt(i) - '0';
                i--;
            }
            int b = 0;
            if (j >= 0) {
                b = num2.charAt(j) - '0';
                j--;
            }

            int c = a + b;
            c += carry;

            carry = c / 10;
            c = c % 10;

            ans = c + ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        String num1 = "456";
        String num2 = "77";

        AddStrings addStrings = new AddStrings();
        addStrings.addStrings(num1, num2);
    }
}
