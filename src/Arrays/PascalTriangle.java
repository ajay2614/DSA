package Arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> pascalList = new ArrayList<>();
        for (int i=0;i<numRows;i++) {
            List<Integer> list = new ArrayList<>();
            if(i==0)
                list.add(1);
            else {
                list.add(1);
                for (int j=1;j<=i-1;j++) {
                    int val1 = pascalList.get(i-1).get(j);
                    int val2 = pascalList.get(i-1).get(j-1);
                    list.add(val1 + val2);
                }
                list.add(1);
            }
            pascalList.add(list);
        }
        return pascalList;
    }

    public static void main(String[] args) {
        /*
        WE HAVE TO CREATE A PASCAL TRIANGLE FROM GIVEN NUMBER OF ROWS
        EG FOR ROW 4 PASCAL WOULD BE
                1
              1   1
             1  2  1
            1  3  3  1

        AS WE CAN SEE THAT 0 INDEX FOR ROW AND N-1 WILL ALWAYS BE 1, SO WE WILL MARK IT INITALLY, FOR OTHER INDEXES
        WE WILL RUN A FOR LOOP AND GET VALUE FROM PREV[J] + PREV[J-1]
         */
        int numRows = 5;
        List<List<Integer>> pascalList = generate(numRows);
    }
}
