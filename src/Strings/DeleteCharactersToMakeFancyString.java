package Strings;

public class DeleteCharactersToMakeFancyString {
    public String makeFancyString(String s) {

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        char someChar = s.charAt(0);
        int cnt = 1;
        sb.append(someChar);
        for(int i=1;i<n;i++) {
            if(s.charAt(i) == someChar) {
                cnt++;
            }
            else {
                someChar = s.charAt(i);
                cnt = 1;
            }

            if(cnt < 3) {
                sb.append(someChar);
            }
        }
        return sb.toString();
    }
}
