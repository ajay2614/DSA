package Strings;

public class MaximumOccuringCharacterInAString {
    public static char getMaxOccuringChar(String line) {
        int arr[] =  new int[26];

        for(int i=0;i<line.length();i++) {
            arr[line.charAt(i) - 'a']++;
        }

        int max = arr[0];
        int ch = 0;
        for(int i=1;i<26;i++) {
            if(arr[i] > max) {
                ch = i;
                max = arr[i];
            }
        }

        return (char) (ch + (int) 'a');
    }

    public static void main(String[] args) {
        String s = "ajaysharma";
        getMaxOccuringChar(s);
    }

}
