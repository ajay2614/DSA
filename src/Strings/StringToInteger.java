package Strings;

public class StringToInteger {
    public static int myAtoi(String s) {
        if(s.equals(""))
            return 0;
        long ans = 0;
        int ind = 0;
        int n = s.length();
        int sign = 1;
        while (ind < n && s.charAt(ind) == ' ') {
            ind++;
        }
        if(ind < n && !Character.isDigit(s.charAt(ind))) {
            if(s.charAt(ind) == '-') {
                sign = -1;
                ind++;
            } else if (s.charAt(ind) == '+') {
                sign = 1;
                ind++;
            }
            else
                return 0;
        }

        for(int i=ind;i<n;i++) {
            if(!Character.isDigit(s.charAt(i)))
                break;
            else {

                ans = ans * 10;
                ans += s.charAt(i) - '0';

                if(ans > Integer.MAX_VALUE) {
                    if(sign == -1)
                        return Integer.MIN_VALUE;
                    else
                        return Integer.MAX_VALUE;
                }
                else if(ans < Integer.MIN_VALUE) {
                    if(sign == -1)
                        return Integer.MAX_VALUE;
                    else
                        return Integer.MIN_VALUE;
                }
            }
        }
        return sign * (int) ans;
    }
    public static void main(String[] args) {
        /**
         * IN THIS WE ARE GIVEN A STRING WE NEED TO FIND THE INT VALUE IF ANY PRESENT,
         * FOR EG THERE COULD BE STRING "HELLO 123", SINCE CHARACTERS IN THE BEGINNING ARE NOT INTEGER, WE WILL RETURN 0,
         * ELSE IF IT IS "123HELLO", THEN RETURN 123. SO WE WILL RETURN ALL THE INTEGER VALUE WE HAVE RECEIVED ONLY FROM
         * BEGINNING, THERE COULD BE SIGN OF - OR + IN FRONT SO WE WILL HAVE TO CONSIDER IT IN ANS,
         * THERE COULD BE WHITESPACES IN FRONT SO SIMPLY NEED TO REMOVE THEM FIRST BEFORE WE CALCULATE ANSWER.
         *
         *
         * START FROM BEGINNING, FIRST REMOVE ALL THE WHITESPACES.
         *
         * AFTER THIS CHECK IF FIRST CHAR IS SIGN, IF IT IS STORE IT IN A VARIABLE,
         * WHY NOT SIMPLY CHECKING IN FOR LOOP, HAVING AN IF CASE FOR IT, BECAUSE THERE COULD BE TESTCASE, HAVING "-+131"
         * SO THIS IS NOT VALID, ALSO "-1+3" ONLY MEANS -1 SO WE WILL TREAT THE SIGN UNLIKE OTHER WORD CHARACTER ONLY WHEN IT
         * IS IN BEGINNING(AFTER WHITESPACES), AFTER THIS SIMPLY RUN A LOOP, KEEP ON CALCULATING THE ANS TILL CHARACTERS ARE
         * DIGIT, THE MOMENT YOU ENCOUNTER AN ALPHABET, RETURN THE ANS * SIGN
         *
         * FOR CALCULATING THE DIGIT, MULTIPLY CURRENT ANS BY 10 AND ADD THE NEXT DIGIT,
         * EG FOR 14, FIRST IT WOULD BE 1, THEN 10 + 4.
         *
         * SINCE THERE IS A TEST CASE WHEN VAL EXCEEDS INT MAX, IF SIGN IS NEGATIVE RETURN INT MIN, OR IF IT BECOMES LESSER
         * THAN INT MIN, RETURN INT MAX IF SIGN IS - OR INT MIN IF  +.
         *
         */
        myAtoi("  -42");
    }
}
