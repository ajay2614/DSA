package Strings;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        String ans = "";
        int minLength = Integer.MAX_VALUE;
        int n = strs.length;
        for(int i = 0;i<n;i++) {
            minLength = Math.min(strs[i].length(), minLength);
        }
        int i = 0;
        while(i < minLength) {
            char a = strs[0].charAt(i);
            boolean isSame = true;
            for(int j=1;j<n;j++) {
                if(a != strs[j].charAt(i)) {
                    isSame = false;
                    break;
                }
            }
            if(!isSame)
                break;
            ans += strs[0].charAt(i);
            i++;
        }
        return ans;
    }


    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE HAVE TO FIND THE LONGEST COMMON PREFIX
         * SUPPOSE FOR BELOW ARRAY FL WOULD BE LONGEST COMMON
         *
         * FIRST WE WILL FIND THE MIN LENGTH ARRAY
         *
         * AFTER THIS WE WILL RUN TILL SMALLEST ARRAY LENGTH, THIS IS DONE THERE COULD BE CASE WHERE STRING IS
         * F AND OTHER STRINGS ARE FLO AND FL, SINCE IF WE HAD USED ANY RANDOM STRING TO ITERATE, WE WOULD HAVE BEEN OUT OF
         * BOUNDS WHILE CHECKING FOR F, RUN A NESTED LOOP FROM I TO MIN ARRAY LENGTH AND FROM 0 ARR.LENGTH-1 FOR TRACKING
         * OTHER ARRAY STRINGS, CHECK WHETHER THE CHAR AT I == ARRAY STRING CHAR AT I, IF IT IS I++, AND CHECK AGAIN FOR
         * ALL ARRAY ELEMENTS, THE STAGE WHERE CHAR AT I IS NOT EQUAL, BREAK OUT AND RETURN RESULTANT STRING.
         *
         */
        String arr[] = {"flower","flow","flight"};
        longestCommonPrefix(arr);
    }
}
