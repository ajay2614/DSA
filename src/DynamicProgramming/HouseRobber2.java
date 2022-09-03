package DynamicProgramming;

import java.util.ArrayList;

/*
Also Covering Maximum Sum of Non Adjacent Elements
 */
public class HouseRobber2 {

    public static long houseRobber(int[] valueInHouse) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        int n = valueInHouse.length;
        if(n == 1)
            return valueInHouse[0];

        for(int i=0;i<n;i++) {
            if(i!=0)
                arr1.add(valueInHouse[i]);
            if(i!=n-1)
                arr2.add(valueInHouse[i]);
        }

        long value = Math.max(getValue(arr1), getValue(arr2));
        return value;
    }

    /*
    This method is solution of Max Sum of non adjacent Elements
     */
    public static long getValue(ArrayList<Integer> arr) {
        long prev = arr.get(0);
        long prevBefore = 0;
        int n = arr.size();

        for(int i=1;i<n;i++){
            long pick = arr.get(i) + prevBefore;
            long notPick = 0 + prev;

            long cur = Math.max(pick, notPick);
            prevBefore = prev;
            prev = cur;
        }
        return prev;
    }

}
