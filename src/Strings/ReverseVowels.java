package Strings;

import java.util.ArrayList;
import java.util.Arrays;

enum Vowels {
    a, e, i, o, u, A, E, I, O , U;
}
public class ReverseVowels {
    public String reverseVowels(String s) {

        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] arr = s.toCharArray();
        int n = arr.length;
        int left = 0;
        int right = n-1;

        while (left < right) {
            if (vowels.contains(arr[left]) && vowels.contains(arr[right])) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else if (vowels.contains(arr[left]))
                right--;
            else
                left++;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        /**
         * IN THIS QUESTION WE ARE GIVEN VOWELS WE NEED TO REVERSE THEM
         *
         * SIMPLY USE TWO POINTER APPROACH, RUN FROM LEFT TO RIGHT, WHEN BOTH ARE VOWELS REPLACE, ELSE WHEN ONE IS VOWEL
         * THEN DONT CHANGE IT'S POINTER, DECREASE OR INCREASE THE OTHER POINTER.
         *
         */
    }
}
