package GreedyAlgorithm;

public class MinimumNumberOfCoins {
    /**
     * TC : BIG O(N)
     * SC : BIG O(N)
     */
    public static int findMinimumCoins(int amount) {

        int arr[] = {1000, 500, 100, 50, 20, 10, 5, 2, 1};
        int res = 0;
        int i=0;
        while (amount > 0) {
            if(amount < arr[i])
                i++;
            else {
                amount -= arr[i];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * THE QUESTION STATES THAT GIVEN A PRICE WE HAVE TO FIND MINIMUM CURRENCY NOTES WE CAN HAVE FOR THAT AMOUNT
         * CURRENCY NOTES ARE OF 1000, 500, 100, 50, 20, 10, 5, 2, 1
         *
         * APPROACH WE WILL USE AN ARRAY OF THE ABOVE NOTES
         *
         * AFTER THIS WE WILL RUN A WHILE LOOP, AMOUNT > 0 AND RESULT TO GET NUMBER OF NOTES USED,
         * WE WILL RUN THROUGH NOTES ARRAY AND IF AMOUNT IS SMALLER THAN THE NOTE WE WILL INCREASE INDEX, ELSE WE WILL
         * DECREASE THE AMOUNT BY THAT INDEX NOTE AND INCREASE RESULT BY 1.
         *
         * WHY NOT INCREASE INDEX IN ELSE, BECAUSE LETS SAY FOR A CASE 40, 20 CAME UP, WE CAN GET ANOTHER 20 TO
         * GET THE RESULT, HAD WE INCREASED THE NOTE AT INDEX WOULD HAVE BECOME 10.
         */
        int amount = 70;
        findMinimumCoins(amount);
    }
}
