package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
TOUGH AND IMPORTANT
 */
public class FindKthPermutation {

    public static String getPermutationBrute(int n, int k) {
        List<String> ans = new ArrayList<>();
        String s = "";
        for(int i=1;i<=n;i++) {
            s += i;
        }
        recursion(s.toCharArray(), 0, n, ans);
        Collections.sort(ans);
        return ans.get(k-1);
    }

    public static void recursion(char[] s, int ind, int n, List<String> ans) {
        if(ind == n) {
            String str = new String(s);
            ans.add(str);
            return;
        }
        for(int i=ind;i<n;i++) {
            swap(s, ind, i);
            recursion(s, ind+1, n, ans);
            swap(s, ind, i);
        }
    }

    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }


    public String getPermutation(int n, int k) {

        List<Integer> arr = new ArrayList<>();
        int fact = 1;
        for(int i=0;i<n;i++) {
            fact *= i;
            arr.add(i);
        }
        arr.add(n);
        String ans = "";
        k = k-1;
        while (true) {
            ans += arr.get(k/fact);
            arr.remove(k/fact);
            if(arr.size() == 0)
                break;
            k = k % fact;
            fact = fact / arr.size();
        }
        return ans;
    }

    public static void main(String args[]) {
        /**
         * THE QUESTION STATES THAT GIVEN AN N AND K WE NEED TO FIND TH KTH PERMUTATION
         * FOR EG FOR N = 3, 2ND PERMUTATION WOULD BE 1 3 2.
         *
         * BRUTE FORCE APPROACH
         *
         * THE BRUTE FORCE APPROACH FOLLOWS RECURSION
         *
         * THE OBJECTIVE IS TO CREATE EVERY RECURSION FOR GIVEN N, AND THEN STORE IT IN A LIST, ONCE AFTER THAT AFTER
         * SORTING THE LIST, WE ARE SURE THAT K-1 IS THE KTH PERMUTATION WE WANT
         *
         * WHY K-1, BECAUSE WE ARE FOLLOWING 0 BASED INDEXES.
         *
         * STEPS
         *
         * RUN THE LOOP FOR IND TO N,
         * SWAP ITH CHAR WITH IND
         * CALL THE RECURSION FOR IND+1
         * SWAP AGAIN SO THAT BACKTRACK CAN HAPPEN AND STRING CAN RETURN BACK TO ITS ORIGINAL STATE
         *
         * WHY PASSING IND+1 AND NOT I+1 HERE
         *
         * BECAUSE LETS SAY FOR EG, 1 2 3, WE WOULD BE COMPARING 1 WITH 1, AND PASSING ALONG 2 3, NOW FOR
         * 2 3 WE WOULD BE HAVING 2 CHECKS 2 WITH 2, AND 2 WITH 3, HAD WE PASSED I+1, INSTEAD OF IND+1,
         * THEN WE WOULD NEVER HAVE BEEN ABLE TO COMPARE 2 WITH 3 AS I+1 WOULD HAVE BECOME 3 AND RECURSION
         * WOULD HAVE RETURNED FROM THE BASECASE
         *
         * BASECASE
         * CHECKS IF IND == N
         * ADDS THE STRING IN LIST AND RETURNS
         *
         * AFTER THIS RECURSION SORT THE LIST AND FIND THE K-1
         *
         *
         * OPTIMAL APPROACH
         *
         * OPTIMAL APPROACH IS VERY INTERESTING ONE
         *
         * SUPPOSE N = 4, THE WE KNOW AT EVERY STAGE 1ST PLACE WOULD BE CONSTANT AND IT WILL BE PERMUTATION OF
         * NEXT PLACES
         *
         * FOR EG N = 4, MEANS 1 2 3 4,
         * SO PERMUTATIONS WOULD BE 1 2 3 4, 1 2 4 3, 1 3 2 4 AND SO ON, WE KNOW THAT 1ST PLACE 1 WOULD STAY CONSTANT
         * FOR SOME PERMUTATIONS. AS THE TOTAL PERMUTATIONS WOULD BE 4!, WHICH IS 24, HENCE 24/4 = 6, MEANS ALL THE
         * NUMBERS WOULD HAVE 6 PERMUTATIONS WHEN THEY ARE AT 1ST PLACE, WHICH IS SIMPLY 4-1 = 3! MEANS WE CAN FIND
         * THE NUMBER OF PERMUTATIONS WHEN A NUMBER IS CONSTANT
         *
         * NOW WE WILL HAVE THIS 3! OR 6 AS A FACT, WITH THIS WE CAN EVALUATE WHICH BLOCK OUR NUMBER LIES,
         * THAT SIMPLY MEANS WE CAN GET THE 1ST ELEMENT WHERE KTH PERMUTATION LIES, FOR EG WITH 17, AS WE ARE
         * FOLLOWING 0 BASED INDEX SO K WOULD BE 16, SO IF WE DIVIDE K WITH FACT WE ARE BOUND TO GET THE FIRST NUMBER OF
         * THE BLOCK WHERE IT LIES, IN THIS CASE IT IS 3, NOW AFTER THIS WE WOULD BE LEFT WITH 1 2 4,
         *
         *
         * NOW TO CALCULATE MODIFIED K, WHICH WILL HELP US TO GET 1ST NUMBER FROM A BLOCK, WE WILL SIMPLY
         * K % FACT, WHICH WOULD GIVE US, MODIFIED K, FOR THIS IT WOULD BE 4
         *
         * NOW FOR THIS TO KNOW THE FACTORIAL, WE CAN SIMPLY GET IT BY DIVIDING OUR ACTUAL FACT BY ARR SIZE, WHICH WOULD BE
         * 6 / 3, WHICH IS TRUE AS 1 2 4, EVERY PERMUTATIONS ARE 2 FOR EVERY NUMBER, FOR EG FOR 1 AT FIRST INDEX
         * PERMUTATION ARE 1 2 4, 1 4 2, AND TOTAL PERMUTATIONS WOULD BE 0-5, WHICH IS 6.
         *
         * NOW WITH K AS 4 WE WILL GET 4 AS THE NEXT NUMBER, WE WILL CONTINUE THIS PROCESS TILL ARR SIZE IS 0.
         *
         * STEPS:
         *
         * HAVE A ARRAY LIST, STORE NUMBERS FROM 1 TO N IN IT, AND UPDATE THE FACT AS N-1 FACT!, AS DISCUSSED ABOVE
         *
         * RUN A WHILE LOOP
         * GET THE FIRST ELEMENT FROM K / FACT POSITION
         * REMOVE ELEMENT IN ARRAY LIST
         * UPDATE K AS K%FACT
         * UPDATE FACT AS FACT/ARR.SIZE()
         */
        int n = 3, k = 3;
        String ans = getPermutationBrute(n, k);
        System.out.println("The Kth permutation sequence is " + ans);
    }
}
