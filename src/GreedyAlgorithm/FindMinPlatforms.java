package GreedyAlgorithm;

import java.util.Arrays;

public class FindMinPlatforms {
    public static int findPlatform(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int res = 1;
        int i = 1;
        int j = 0;

        int temp = 1;

        while (i < n && j < n) {
            if(arr[i] <= dep[j]) {
                temp++;
                i++;
            }
            else {
                temp--;
                j++;
            }

            res = Math.max(temp, res);
        }

        return res;
    }

    /**
     * THE QUESTION STATES THAT WE ARE GIVEN AN ARRIVAL ARRAY AND A DEPARTURE ARRAY OF TRAIN, WE NEED TO FIND THE MAX PLATFORM
     * REQUIRED FOR THE TRAINS
     *
     * APPROACH
     *
     * WE WILL SORT BOTH ARRIVAL ARRAY AND DEPARTURE ARRAY
     *
     * WE WILL TRAVERSE BOTH THE ARRAY USING I AND J POINTERS, NOW SUPPOSE WE HAVE
     * ARRIVAL[0] AS 12 AND DEP[0] AS 15, WE WILL INCREMENT PLATFORM, AND I, WHEN WE COME ACROSS
     * ARR[1] WITH 13, WE WILL COMPARE IT WITH DEP[0] AS WE CAN SEE ARR IS SMALL THAN DEP, IT MEANS IN A WAY A TRAIN
     * CAME AT PLATFORM AT 12 AND IS SUPPOSED TO LEAVE AT 15, SO TRAIN AT 13 CANT BE PLACED ON SAME PLATFORM HENCE WE WILL
     * INCREMENT RESULT, IF ARR IS GREATER THAN DEP, MEANS A PLATFORM IS EMPTY AS A TRAIN HAS LEFT, FOR THIS WE WOULD
     * DECREMENT PLATFORM AND INCREMENT J, WHY NOT INCREMENT I, BECAUSE WE NEED TO CHECK FOR THE PLATFORM WHERE IT CAN
     * BE PLACED, IT COULD HAPPEN THE NEXT DEP[J] IS ALSO SMALLER SO THAT IS WHY WE CHECK FOR IT AGAIN.
     *
     * NOTE THAT DEP TRAIN AT A TIME, ARR TRAIN CAN NOT SHARE SAME PLATFORM FOR IT, SO THAT IS WHY WE USE
     * ARR[I] <= ARR[J]
     *
     */
}
