package Arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class CountSubArraysWithXor {

    /**
     * Time Complexity: O(N2)
     * Space Complexity: O(1)
     */
    public static int subarraysXorBrute(ArrayList<Integer> arr, int x) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<arr.size();i++) {
            int xor = 0;
            for(int j=i;j<arr.size();j++){
                xor = xor ^ arr.get(j);
                if(xor == x)
                    count++;
            }
        }
        return count;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */

    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        for(int i=0;i<arr.size();i++) {
            xor = xor ^ arr.get(i);
            if(xor == x)
                count++;

            if (map.get(xor ^ x) != null)
                count+=map.get(xor ^ x);

            if (map.get(xor) != null)
                map.put(xor, map.get(xor) + 1);
            else
                map.put(xor, 1);
        }
        return count;
    }

    public static void main(String[] args) {
        /**
         * THIS QUESTION STATES THAT GIVEN AN ARRAY, WE NEED TO FIND ALL THE SUBARRAYS WHICH GIVE XOR EQUAL TO SOME VALUE
         *
         * BRUTE APPROACH
         *
         * THE BRUTE APPROACH USES KADANE'S ALGO TO FIND ALL THE SUBARRAY, RUNS I*J LOOP, EVERYTIME WE HAVE A VALUE EQUAL TO
         * TARGET WE INCREMENT COUNT
         *
         * OPTIMAL APPROACH
         * THIS APPROACH IS SIMILAR TO PREVIOUS LARGESTSUBARRAYSUM0
         *
         * APPROACH
         *
         * LETS ASSUME THAT THERE IS AN ARRAY, K IS FOR THE GIVEN XOR WE NEED TO FIND
         *
         *         XOR
         *  ----------------------
         *  ------ ---------------
         *    K         Y
         *
         *  WE KNOW THAT Y ^ K IS XOR, SIMILARLY WE CAN FIND XOR ^ Y
         *
         *  LETS TAKE AN EXAMPLE ARRAY 4 2 2 6
         *
         *  THE FIRST SUBARRAY CONSISTING OF 4 AND COMPLETE ARRAY GIVES XOR 2, 4 ^ 2 = 6 MEANING WE ARE BOUND TO GET
         *  XOR OF 6 FROM 2 2 6 SUBARRAY.
         *  SO WE NEED TO FIND COUNT Y, BY DOING X ^ K
         *
         *  STEPS TO FIND ANSWER
         *
         *  WE WILL USE A HASHMAP WHICH WILL STORE XOR GIVEN BY SOME SUBARRAY AND TIMES IT APPEARS
         *  WITH THE HELP OF TIMES WE WOULD BE ABLE TO FIND AMOUNT OF COUNT
         *
         *  WE WILL ITERATE IN FOUR LOOP,
         *
         *  EVERYTIME WE WILL GET XOR VALUE EQUAL K WE WILL INCREMENT BY COUNT, WHY? BECAUSE THAT MEANS THAT ENTIRE SUBARRAY
         *  IS EQUAL TO TARGET VALUE
         *
         *  EG 4 ^ 2 = 6, SO 1ST TIME WE WILL INCREMENT COUNT
         *
         *  AFTER THIS WE WILL CHECK WHETHER THE VALUE EXISTS IN HASHMAP, AS WRITTEN ABOVE XOR ^ K = Y, WHY ARE WE CHECKING AMOUNT
         *  OF TIMES TOO, BECAUSE
         *  EG FOR 4 2 2 6, 4 GIVES XOR VALUE 4, AND 4 2 2 ALSO GIVES 4, HENCE IT MEANS WE CAN GET TWO SUBARRAYS WITH TARGET VALUE
         *
         *  THAT IS TRUE AS 4 ^ 2 ^ 2 ^ 6 GIVES 2 ^ TARGET 6 GIVES 4, NOW IN PREVIOUS DIAGRAM WE CAN SEE WE GOT 2 AS COMPLETE XOR
         *  WITH TARGET 6 GIVES US XOR 4, AS 4 HAS ALREADY BEEN THERE WE KNOW IT IS ONLY THERE BECAUSE THERE
         *  EXISTS 6 VALUE OF XOR, WHICH IS TRUE AS 4 XOR WITH 2 ^ 2 ^ 6, GIVES 2, 4 ^ 2 ^ 2 XOR WITH 6 GIVES 6.
         *
         *                2
         *          -------------
         *          --- ---------
         *          4      6
         *
         *  AFTER INCREMENTING COUNT WITH XOR, WE ALSO NEED TO ADD THE XOR VALUE TILL THAT SUBARRAY.
         *  IF IT EXISTS WE NEED TO INCREMENT ITS OCCURANCES BY 1,ELSE JUST PUT IT
         *
         */

        /**
         *
         * ABOVE APPROACH SIMPLY MEANS SUPPOSE TOTAL XOR IS 4 AND A SUBARRAY K IS HAVING XOR 6 AND OTHER SUBARRAY IS HAVING
         * XOR 2, THEN BY XOR 4 ^ 6 WE GET 2, WE JUST NEED TO FIND HOW MANY 2S WE HAVE GOT SO FAR, THAT WOULD GIVE
         * US TOTAL COUNT OF XOR HAVING 6.
         *
         */
    }
}
