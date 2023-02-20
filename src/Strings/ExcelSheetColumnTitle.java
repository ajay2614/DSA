package Strings;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0) {
            int charNumber = (columnNumber-1) % 26;
            char ch = (char) (charNumber + (int) 'A');
            sb.append(ch);
            columnNumber = (columnNumber-1)/26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        convertToTitle(701);
    }
}
