package Strings;

public class RomanToInt {
    public int romanToInt(String str) {
        int n = str.length();
        int sum = 0;
        for(int i=0;i<n;i++) {
            if(str.charAt(i) == 'I')
                sum += 1;
            else if(str.charAt(i) == 'V') {
                if(i != 0 && str.charAt(i-1) == 'I')
                    sum += 3;
                else
                    sum += 5;
            }
            else if(str.charAt(i) == 'X') {
                if(i != 0 && str.charAt(i-1) == 'I')
                    sum += 8;
                else
                    sum += 10;
            }
            else if(str.charAt(i) == 'L') {
                if(i != 0 && str.charAt(i-1) == 'X')
                    sum += 30;
                else
                    sum += 50;
            }
            else if(str.charAt(i) == 'C'){
                if(i != 0 && str.charAt(i-1) == 'X')
                    sum += 80;
                else
                    sum += 100;
            }
            else if(str.charAt(i) == 'D'){
                if(i != 0 && str.charAt(i-1) == 'C')
                    sum += 300;
                else
                    sum += 500;
            }
            else if(str.charAt(i) == 'M'){
                if(i != 0 && str.charAt(i-1) == 'C')
                    sum += 800;
                else
                    sum += 1000;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        /**
         * Symbol       Value
         * I             1
         * V             5
         * X             10
         * L             50
         * C             100
         * D             500
         * M             1000
         * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
         *
         * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
         *
         * I can be placed before V (5) and X (10) to make 4 and 9.
         * X can be placed before L (50) and C (100) to make 40 and 90.
         * C can be placed before D (500) and M (1000) to make 400 and 900.
         * Given a roman numeral, convert it to an integer.
         *
         *
         * GIVEN THE DATA ABOVE SIMPLY USE IF CASES TO CHECK WHETHER THE ABOVE CASE COMES TRUE THEN ADD LESSER VAL TO SUM OR
         * SIMPLY ADD VALUE TO SUM, EG IF C IS BEFORE D ADD 300 FROM D, AS C WAS HAVING 100 ELSE ADD 500.
         *
         */
    }
}
