package Strings;

import java.util.Locale;

public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int ans = 0;
        for(int i=0;i<n;i++) {
            int currentColumn = columnTitle.charAt(i) - 'A' + 1;
            ans = ans * 26 + currentColumn;
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "ZY";
        titleToNumber(s);
    }
}
