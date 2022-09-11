package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class MissingAndRepeatingNumber {

    /*
    TC O(N)
    SC O(1)
     */
    public static int[] missingAndRepeatingSumSoln(ArrayList<Integer> arr, int n) {

        int sumActual = 0;
        int sumExpected = 0;

        long sumsqActual = 0l;
        long sumsqExpected = 0l;
        for(int i=0;i<n;i++) {
            sumActual += arr.get(i);
        }
        for (int i=1;i<=n;i++) {
            sumExpected += i;
        }

        for (int i=0;i<n;i++) {
            sumsqActual += Long.valueOf(arr.get(i) * arr.get(i));
        }

        for (int i=1;i<=n;i++) {
            sumsqExpected += i*i;
        }

        int diffSq = (int) Math.abs(sumsqActual-sumsqExpected);
        int diff = Math.abs(sumActual-sumExpected);

        int result = diffSq/diff;

        int repeating = 0;
        int missing = 0;
        int resultAdd = (result + diff)/2;
        int resultSub = (result - diff)/2;

        for(int i=0;i<n;i++) {
            if (arr.get(i) == resultAdd){
                repeating = resultAdd;
                missing = resultSub;
            } else if (arr.get(i) == resultSub) {
                repeating = resultSub;
                missing = resultAdd;
            }
        }
        return new int[]{missing,repeating};
    }

    /*
       TC O(N)
       SC O(1)
    */
    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {

        int x = 0;

        for(int i=0;i<n;i++) {
            x = x ^ arr.get(i);
            x = x ^ i+1;
        }

        int setBit = x & ~(x-1);
        int missing = 0;
        int repeating = 0;

        for(int i=0;i<n;i++) {
            if((arr.get(i) & setBit) > 0)
                missing = missing ^ arr.get(i);
            else
                repeating = repeating ^ arr.get(i);

            if((i+1 & setBit) > 0)
                missing = missing ^ i+1;
            else
                repeating = repeating ^ i+1;
        }

        for(int i=0;i<n;i++) {
            if(arr.get(i) == missing) {
                int temp = repeating;
                repeating = missing;
                missing = temp;
            }
        }

        return new int[]{missing,repeating};
    }


    public static void main(String[] args) {
        /*
        THE QUESTION HAS A REPEATING NUMBER AND A MISSING NUMBER, WE NEED TO IDENTIFY THESE

        1ST APPROACH, MUCH EASIER TO EXPLAIN APPROACH, ALWAYS GO WITH THIS IN INTERVIEW

        SUPPOSE ARRAY HAS NUMBER A B C C, WITH D MISSING, THE ADDING ALL ARRAY ELEMENTS AS WELL AS A TO D
        WOULD GET US A B C C SUM AND A B C D SUM ON SUBTRACTING WE ARE LEFT WITH C-D,SIMILARLY WE ARE LEFT WITH
        Csq - Dsq, WHICH CAN ALSO BE WRITTEN AS (C-D)(C+D), UPON DIVISION WITH C-D OF THIS WE CAN GET BOTH THE NUMBER
        DONT FORGET TO LINEARLY CHECK IF AND UPDATE.


        2ND APPROACH

        MUCH TOUGHER BUT MORE INTERESTING APPROACH, IN THIS USING XOR, SUPPOSE WE XOR A B C C AND THEN A B C D, WE KNOW
        WE ARE LEFT WITH EXACT XOR OF C * D, WHICH ARE MISSING AND REPEATING NUMBERS, THIS IS BECAUSE OTHER NUMBERS CANCELLED
        EACH ONE OUT.

        NOW FOR GETTING THE NUMBERS, FIRST WE WILL GET SETBIT, WHICH XOR & ~(XOR-1), WHY WE ARE GETTING THIS. WE KNOW XOR OF
        1 & 0 IS 1, THAT MEANS ALL THE SET BIT IN XOR ANSWER WERE EITHER SET IN C OR D. SO WE CAN TAKE ANY BIT TO COMPARE,
        WE ARE GETTING LAST BIT FOR COMPARISON, WHICH WILL BE GIVEN BY XOR & ~(XOR-1)

        HOW XOR & ~(XOR-1) WORKS

        XOR OF ANY NUMBER EX = 101011
        XOR-1                = 101010

        EVERY BIT IS SAME ONLY LAST BIT IS DIFFERENT, WHAT ~(XOR-1) GIVES US OPPOSITE OF XOR-1 = 010101, HENCE ANSWER WOULD BE 1.

        NOW HAVE TWO VIRTUAL BUCKET WHICH IS SIMPLY JUST TWO VARABLES, IF ARR[I] & SETBIT != 0, ADD XOR OF ARR[I] AND BUCKET1,
        SIMILARLY DO FOR BUCKET 2.

        DO THIS FOR ARR & ALSO FOR 1 TO N, NOW IN THE END WE WOULD BE LEFT WITH OUR MISSING AND REPEATING NUMBERS, WE CAN
        LINEARLY CHECK IF ONE IS PRESENT IN ARRAY.

        --NOTE, WE CAN HAVE DIFFERENT FOR LOOPS OR SAME FOR LOOP FOR EVALUATION OF XOR WITH ARR AND NUMBERS 1 TO N, IT WONT
        MAKE ANY DIFF AS ULTIMATELY CANCEL ONES, WOULD GET CANCELLED AS ITS XOR.
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(5);
        arrayList.add(3);
        arrayList.add(2);

        int[] b = arrayList.stream().mapToInt(Integer::intValue).toArray();
        missingAndRepeatingSumSoln(arrayList, arrayList.size());
        missingAndRepeating(arrayList, arrayList.size());

    }
}
