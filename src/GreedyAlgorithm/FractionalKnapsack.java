package GreedyAlgorithm;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
class ItemSort implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        double weightByValue1 = (double) o1.value/ (double) o1.weight;
        double weightByValue2 = (double) o2.value/ (double) o2.weight;

        if(weightByValue1 > weightByValue2)
            return -1;
        else if (weightByValue1 < weightByValue2)
            return 1;
       return 0;
    }
}
public class FractionalKnapsack {
    /**
     * TC : BIG O(N + LOG N)
     * SC : BIG O(1)
     */
    public static double fractionalKnapsack(int W, Item arr[], int n) {
        ItemSort itemSort = new ItemSort();
        Arrays.sort(arr, itemSort);

        double result = 0.0;
        for (int i=0;i<n;i++) {
            if(arr[i].weight <= W) {
                result += arr[i].value;
                W -= arr[i].weight;
            }
            else {
                double subValue = ((double) arr[i].value/ (double)arr[i].weight) * (double) W;
                result += subValue;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        /**
         * FRACTIONAL KNAPSACK
         *
         * GIVEN AN ARRAY WE NEED TO FIND OUT TOTAL VALUES WE CAN TAKE IN GIVEN WEIGHT BAG
         * VALUE BY WEIGHT IS ALLOWED, MEANING IF WE ARE LEFT WE VALUE 120 AND WEIGHT 30, BUT WE CAN ONLY TAKE WEIGHT OF 20
         * THEN WE CAN TAKE THE FRACTION AMOUNT OF THAT VALUE, 120/30 * 20 = 80, MEANS WE CAN TAKE 80
         *
         * STEPS, FIRST SORT THE ARRAY BASED ON WEIGHT BY VALUE, WHY? BECAUSE WE NEED TO GET THE MAXIMUM WEIGHT/VALUE
         * ITEM FIRST AS MORE THE MAX PROFIT.
         *
         * AFTER THIS RUN LOOP AND KEEP ON COLLECTING ITEMS TILL ARR[I].WEIGHT <= WEIGHT,
         * WHEN ARR[I].WEIGHT BECOMES GREATER THAN WEIGHT THIS MEANS WE CAN ONLY TAKE FRACTION AMOUNT HERE THEN
         * THEN GET THE ANSWER AS WRITTEN ABOVE, VALUE/WEIGHT * W LEFT
         *
         * BREAK THE LOOP AS WEIGHT BECAME 0 BECAUSE ONLY REASON IT ENTERED THIS LOOP WAS BECAUSE IT WAS LESS THAN THAT
         * ITEM WEIGHT
         *
         * RETURN THE ANSWER.
         */
        int values[] = {60,100,120};
        int weight[] = {10,20,30};
    }
}
