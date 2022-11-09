package InterviewQuestions.Amazon;

public class MaximizeCountOfSubstringsContainingAtLeast1VowelAnd1Consonant {
    public static int strengthOfString(String S) {
        int ans = 0;
        int N = S.length();

        // For checking at least 1 vowels
        // and 1 consonants
        boolean haveVowels = false;
        boolean haveConsonants = false;

        // Travel over the loop
        for (int i = 0; i < N; i++) {
            // Check current letter have
            // vowels or not
            if (S.charAt(i) == 'a' || S.charAt(i) == 'e'
                    || S.charAt(i) == 'i' || S.charAt(i) == 'o'
                    || S.charAt(i) == 'u')
                haveVowels = true;
            else
                haveConsonants = true;

            // Both the type of letter are present
            // then increase the ans count
            if (haveVowels == true
                    && haveConsonants == true) {
                ans += 1;
                haveVowels = false;
                haveConsonants = false;
            }
        }

        // Return the main ans
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        String S = "happybirthday";

        // Function Call
        int ans = strengthOfString(S);
        System.out.print(ans);

        /**
         * Input: S = “happybirthday”
         * Output: 3
         * Explanation: S can be divided as “ha”, “ppybi”, “rthday”
         *
         * Input: S = “geeksforgeeks”
         * Output 5
         * Explanation: S can be divided as “ge“, “ek“, “sfo“, “rge”, “eks”
         */
    }
}
