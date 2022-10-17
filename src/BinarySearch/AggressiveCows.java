package BinarySearch;
import java.util.Arrays;
public class AggressiveCows {

    /**
     * Time Complexity: O(N*log(M)).
     *
     * Reason: For binary search in a space of M, O(log(M))  and for each search, we iterate over max N stalls to check. O(N).
     *
     */
    public int largesMinDistance(int[] position, int cows) {
        int n = position.length;
        Arrays.sort(position);
        int low = 1;
        int high = position[n-1] - position[0];

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(isPossible(mid, position, cows))
                low = mid+1;
            else
                high = mid-1;
        }
        return high;
    }

    public boolean isPossible(int minDistance, int positions[], int cows) {
        int n = positions.length;
        int cowsPlaced = 1;
        int lastVisited = positions[0];

        for(int i=1;i<n;i++) {
            if(positions[i] - lastVisited >= minDistance){
                cowsPlaced++;
                lastVisited = positions[i];
            }
            if(cowsPlaced == cows)
                return true;
        }
        return false;
    }

    /**
     *
     * THE QUESTION STATES THAT GIVEN AN ARRAY, WHERE ELEMENTS REPRESENT DISTANCES, AND GIVEN K AMOUNT OF COWS
     * FIND THE LARGEST MINIMUM DISTANCE THE COWS CAN BE PLACED
     *
     * BRUTE AND OPTIMAL APPROACH ARE SIMILAR
     *
     * BRUTE APPROACH: Time complexity: O(n* m)
     *
     * INITIALLY SORT THE ARRAY
     *
     * RUN A FOR LOOP FROM MINIMUM DISTANCE WHICH IS 1, BECAUSE THE MINIMUM DISTANCE COWS CAN HAVE BETWEEN THEM IS 1,
     * AND RUN THIS LOOP TILL MAXIMUM DISTANCE WHICH IS LAST DISTANCE OF SORTED ARRAY - FIRST DISTANCE, BECAUSE
     * SAY THE CASE IN WHICH THERE ARE ONLY TWO COWS, SO THE LARGEST MINIMUM DISTANCE BETWEEN THEM WOULD BE 1ST ELEMENT
     * AS THE COW1 WOULD BE HERE AND LAST ELEMENT WHERE COW2 WOULD BE.
     *
     * RUN THE ABOVE LOOP AND FOR EVERY DISTANCE CHECK WHETHER IT IS POSSIBLE TO PLACE THE K COWS THERE, PASS THE CURRENT
     * I FROM THIS LOOP TO METHOD, WHICH IS SIMPLY OUR MIN DISTANCE, HAVE A VARIABLE MAX, AND STORE THE MIN VALUE IN THAT
     * EVERYTIME WHEN ISPOSSIBLE RETURNS TRUE
     *
     * HOW TO CHECK?
     *
     * HAVE COWCOUNT AS 1, AND LASTCOWPLACED AS ARR[1] BECAUSE WE PLACE THE FIRST COW AT THIS POSITION
     * NOW ITERATE FOR THE DISTANCE ARRAY GIVEN, CHECK WHETHER ARR[I] + LASTPLACED >= MINDISTANCE, IF IT IS MEANS WE CAN PLACE
     * THE COW IN A DISTANCE EQUAL TO OR MORE THAN IT FROM THE ARRAY, HENCE INCREASE THE COW COUNT AND HAVE THE LAST PLACED
     * AS ARR[I]
     *
     * CHECK IF COWS ARE EQUAL TO TOTAL COWS, MEANS WE HAVE SUCCESSFULLY PLACED COWS WHEN MIN DISTANCE WHICH WAS TO KEPT BETWEEN
     * THEM WAS I, RETURN TRUE
     *
     * IF LOOP COMPLETES AND WE COME OUT OF IT, MEANS WE WERE UNABLE TO PLACES COWS WHEN MIN DISTANCE WAS TO BE KEPT I
     *
     *
     * OPTIMAL APPROACH
     *
     * NOW SINCE WE KNOW IF WE CHECK FOR SOME HIGHER VALUE, SAY WHEN MINDISTANCE IS 4, AND IF WE WERE UNABLE
     * TO PLACE COWS WITH THIS MIN DISTANCE, THIS MEANS WE CAN OBVIOUSLY NOT PLACE COWS WITH DISTANCE HIGHER THAN 4,
     * SO IN THIS CASE SCENARIO WE CAN USE BINARY SEARCH
     *
     * INSTEAD OF RUNNING A LOOP, HAVE LOW AS 1, AND HIGH AS ARR[N-1]-ARR[0], WHICH WAS OUR MAX DISTANCE IN BRUTE APPROACH
     * RUN TILL LOW<=HIGH, GET MID AND CHECK IF VALUE WITH THAT IS POSSIBLE, IF IT IS POSSIBLE, MEANS WE CAN CHECK FOR HIGHER
     * VALUES AND HENCE LOW WILL BECOME MID+1, AND IF NOT MEANS CHECKING FOR HIGHER VALUES IS WASTE OF TIME HENCE HAVE HIGH
     * = MID-1. IN THE END RETURN HIGH.
     *
     *  WHY HIGH?
     *
     *  SAY INSTEAD ON RETURNING HIGH WE KEEP A VARIABLE RES TO TRACK THE MAX VALUE, WE KNOW WE WILL UPDATE RES ONLY WHEN
     *  MIN IS POSSIBLE, AND ALONGSIDE THIS WE UPDATE LOW AS MID + 1, SO IN THE LAST WHEN LOW WILL BECOME MID + 1, AND
     *  IT WILL CROSS HIGH, IT IS OBVIOUS THAT RES AND HIGH WOULD BE HAVING SAME VALUE
     *
     */
}
