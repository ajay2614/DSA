package Arrays;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FindOriginalArrayFromDoubledArray {
    public static int[] findOriginalArray(int[] A) {
       int n = A.length;

       if(n % 2 != 0)
           return new int[]{};
       int k=0;
       Map<Integer, Integer> treeMap = new TreeMap<>();
       int arr[] = new int[n/2];
       for (int i:A)
           treeMap.put(i, treeMap.getOrDefault(i, 0) + 1);

       for (int i : treeMap.keySet()) {
           if(treeMap.get(i) > treeMap.getOrDefault(2 * i, 0))
                return new int[]{};
           for(int j = 0;j<treeMap.get(i);j++) {
               arr[k++] = i;
               treeMap.put(2 * i, treeMap.get(2 * i) - 1);
           }
       }
       return arr;
    }

    public static boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int a : A)
            count.put(a, count.getOrDefault(a, 0) + 1);
        for (int x : count.keySet()) {
            if (count.get(x) == 0) continue;
            int want = x < 0 ? x / 2 : x * 2;
            if (x < 0 && x % 2 != 0 || count.get(x) > count.getOrDefault(want, 0))
                return false;
            count.put(want, count.get(want) - count.get(x));
        }
        return true;
    }



    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT THERE IS AN ARRAY GIVEN
         *
         * EG 1 2 3 4 6 8, IT IS A MODIFIED ARRAY, ACTUAL ARRAY HAD 1 3 4, MODIFIED ARRAY DOUBLED THE ACTUAL ARRAY AND IS UNSORTED
         * WE NEED TO FIND THE ACTUAL ARRAY.
         *
         * THE APPROACH WE WILL USE IS TO USE TREEMAP
         * FIRST ITERATE THROUGH ARRAY, ASSIGN EVERY ELEMENT IN HASHMAP ALONG SIDE THE TIME IT OCCURS, GET OR DEFAULT IS USED
         * ABOVE BECAUSE SAY WE CAME ACROSS ELEMENT FIRST TIME, SO IT DOESNT EXIST NOW, SO WE ADD 0+1, NEXT TIME
         * WE COME ACROSS SAME WE CHOSE ITS CURRENT FREQUENCY + 1.
         *
         * AFTER THIS WE WILL ITERATE THROUGH THE KEYSET OF THE TREEMAP, WHY WE DIDNT USE HASHMAP, BECAUSE IN TREEMAP
         * WHILE ITERATING THROUGH ITS KEYSET, WE WILL GET VALUES IN SORTED ORDER.
         *
         * AFTER THIS IF COMPARE CURRENT ELEMENT VALUE IN MAP WITH ITS DOUBLE, IF THE VALUE IS OF ITS DOUBLE IS LESS OR 0,
         * THEN RETURN EMPTY ARRAY, BECAUSE THAT MEANS ITS DOUBLE DOESNT EXIST AND ARRAY IS NOT MODIFIED.
         *
         * IF IT ISNT GREATER THAN 0, MEANS ITS DOUBLE DOES EXIST, KEEP ON ADDING THE CURRENT ELEMENT OF KEYSET IN THE
         * RETURN ARRAY, RUN LOOP TILL ITS OCCURANCES, ALSO KEEP ON REMOVING ITS DOUBLE FREQUENCY BY 1 ALSO
         *
         * WHY?, BECAUSE SAY 1 2 2 4, IF WE HADNT REMOVED IT, FOR 1, WHEN WE WOULD HAVE COME ACROSS 2, WE HAD RETURNED FALSE
         * EVEN THOUGH THE ACTUAL ARRAY IS 1 2.
         *
         * RETURN ARRAY IN END.
         *
         * THE 2ND QUESTION IS SAME AS 1, ONLY DIFF IS IF WE CAME ACROSS -VE VALUE, WE WILL CHECK FOR ITS HALF, IF PRESENT.
         */
        int arr[] = {2,1,2,1,1,1,2,2};

        canReorderDoubled(arr);
        findOriginalArray(arr);
    }
}
