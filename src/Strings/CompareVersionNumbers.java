package Strings;

public class CompareVersionNumbers {
    /**
     * TC : BIG O(M+N)
     * SC : BIG O(1)
     */
    public static int compareVersion(String version1, String version2) {

        int i = 0;
        int j = 0;

        int n1 = version1.length();
        int n2 = version2.length();

        while(i < n1 || j < n2) {

            int num1 = 0;
            int num2 = 0;

            while (i < n1 && version1.charAt(i) != '.') {
                num1 = num1 * 10 + version1.charAt(i) - '0';
                i++;
            }
            while (j < n2 && version2.charAt(j) != '.') {
                num2 = num2 * 10 + version2.charAt(j) - '0';
                j++;
            }

            if(num1 > num2) {
                return 1;
            }
            if (num1 < num2)
                return -1;
            if(i < n1 && version1.charAt(i) == '.')
                i++;
            if(j < n2 && version2.charAt(j) == '.')
                j++;
        }
        return 0;
    }
    public static void main(String[] args) {
        compareVersion("0.1","1.1");
        /**
         * IN THIS QUESTION WE NEED TO COMPARE THE TWO VERSIONS
         * IF V1 > V2
         * RETURN 1
         * IF V1 < V2
         * RETURN 1
         * ELSE RETURN 0
         *
         * V1 AS 1.0.0 IS SAME AS V2 AS 1,
         * V1 WITH 1.0014 IS SAME AS V2 1.14
         *
         * SO WHAT WE NEED TO DO IS BEFORE DOT GET THE NUMBER FROM BOTH(IF PRESENT IN BOTH) AND THEN COMPARE
         *
         * SIMPLY RUN A LOOP AND GET THE NUM TILL DOT OR CHAR LENGTH IS NOT OVER, AFTER THIS COMPARE
         * RETURN ON THE BASIS OF THE QUESTION
         *
         *
         */
    }
}
