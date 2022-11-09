package Strings;

public class ReverseWordsInAString {
    public static String reverseWords(String s) {
        int n = s.length();
        int i=0;

        String ans = "";
        while(i < n) {
            while(i < n && s.charAt(i) == ' ')
                i++;
            if(i==n)
                break;
            int j=i;

            StringBuilder stringBuilder = new StringBuilder();
            while(j<n && s.charAt(j) != ' ') {
                stringBuilder.append(s.charAt(j));
                j++;
            }

            if(ans.length() == 0)
                ans = stringBuilder.toString();
            else
                ans = stringBuilder.toString() + " " + ans;

            i = j;
        }


        return ans;
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION GIVEN A STRING OF SENTENCE WE NEED TO REVERSE IT, FOR EG FOR BELOW ANS WOULD BE "BLUE IS SKY THE"
         *
         * APPROACH
         *
         * WE WILL WHILE LOOP TILL I < N, SINCE THERE MIGHT BE BLANK SPACES IN THE BEGINNING AND THE END RUN I TILL S.CHAR AT
         * I IS BLANK SPACE, AFTER THIS ASSIGN A VARIABLE J AND RUN TILL IT IS SMALLER THAN N AND CHAR IS NOT BLANK SPACE AND
         * KEEP ON ADDING CHARS IN A TEMP STRING,
         * AFTER THIS CHECK IF ANS STRING IS EMPTY IF IT IS ONLY ADD THE TEMP STRING, ELSE APPEND IT IN SUCH A WAY THAT
         * TEMP COMES AT FRONT OF THE ANS SEPERATED BY SPACE;
         * AFTER THIS ASSIGN I AS J.
         *
         */
        String str = "the sky is blue";
        reverseWords(str);
    }
}
