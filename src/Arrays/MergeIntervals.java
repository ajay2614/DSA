package Arrays;

import java.util.*;

public class MergeIntervals {

    /*
    Time Complexity: O(NlogN) + O(N). O(NlogN) for sorting and O(N) for traversing through the array.
    Space Complexity: O(N) to return the answer of the merged intervals.
     */
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {

                if(o1[0] > o2[0])
                    return 1;
                else if (o1[0] < o2[0]) {
                    return -1;
                }
                return 0;
            }
        });
        List<int[]> arrayList = new ArrayList<>();

        int first = intervals[0][0];
        int second = intervals[0][1];

        for(int[] i: intervals) {
            if(second >= i[0]) {
                second = Math.max(second, i[1]);
            }
            else {
                arrayList.add(new int[]{first,second});
                first = i[0];
                second= i[1];
            }
        }

        arrayList.add(new int[]{first,second});
        return arrayList.toArray(new int[0][]);

        /*
        can also be arrayList.toArray(new int[arrayList.size()][2]);
         */
    }

    public static void main(String[] args) {
        /*
        THE QUESTION STATES THAT WE ARE GIVEN 2D ARRAY WITH N ROWS AND J COLUMNS, WE HAVE TO RETURN 2 ARRAY, HAVING
        NO OVERLAPPING INTERVALS, FOR EG 1,3 AND 2,6  3 > 2, HENCE WE NEED TO MERGE THEM 1 6.

        THE APPROACH IS THAT WE WILL COMPARE  SECOND ELEMENT A OF ITH INDEX WITH FIRST ELEMENT B OF I+1 INDEX,
        IF A>=B THEN WE WILL ONLY ADD THE MAXIMUM OF A & OF 2ND ELEMENT OF I+1 INDEX.

        WHY MAX OF THESE TWO, BECAUSE WE CAN HAVE SOMETHING LIKE 1 4 & 2 3.

        WE WILL USE LIST<INT[]> SO THAT WE CAN EASILY RETURN IT AS 2D ARRAY.

        STEPS
        FIRST TAKE TWO VARIABLES AND GET A & B AND ENTER MATRIX[0][0] & [0][1] IN IT

        AFTERWARDS ITERATE THROUGH USING INT ARR[] : MATRIX, THIS WILL GIVE US MATRIX ROW WISE,
        COMPARE SECOND WITH ITERATORS FIRST INDEX, IF IT IS >= THEN UPDATE B WITH MAX AS STATED ABOVE
        ELSE ADD A & B IN LIST AND UPDATE A & B, WHY WE ARE ONLY ADDING IN ELSE -- BECAUSE 1 3 WILL GET COMPARED
        WITH 1 3 IN WHICH 3 WILL GET MAX, AFTERWARDS 1 3 WILL COMPARE WITH 2 6, HAD WE DONE THIS OUTSIDE IF ELSE
        THEN 1 3 WOULD ALSO HAVE ADDED, MAKING OUR ANSWER WRONG.

        ADD THE FIRST AND SECOND AFTER LOOP IS OVER BECAUSE LAST FIRST AND SECOND WERENT ADDED.

        RETURN AS ARRAY.

         */
        int arr[][] = {{1,3},{2,6},{8,10},{15,18}};
        int arr2[][] ={{1,4},{1,4}};
        merge(arr2);

    }
}
