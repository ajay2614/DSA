package BinarySearch;

public class KthElementOfTheTwoSortedArrays {
    /**
     * TC : BIG O(MIN(N,M))
     * SC : BIG O(1)
     */
    public static long kthElementBrute( int arr1[], int arr2[], int n, int m, int k) {

        int i=0;
        int j=0;
        k-=1;

        while(i < n && j < m) {
            if(arr1[i] < arr2[j]) {
                if(k==0)
                    return arr1[i];
                i++;
                k--;
            }
            else {
                if(k==0)
                    return arr2[j];
                j++;
                k--;
            }
        }

        while(i < n) {
            if(k==0)
                return arr1[i];
            k--;
            i++;
        }
        while(j < m) {
            if(k==0)
                return arr2[j];
            k--;
            j++;
        }

        return 1l;
    }

    /**
     *
     * Time Complexity : log(min(m,n))
     *
     * Reason: We are applying binary search in the array with minimum size among the two.
     * And we know the time complexity of the binary search is log(N) where N is the size of the array.
     * Thus, the time complexity of this approach is log(min(m,n)), where m,n are the sizes of two arrays.
     *
     * Space Complexity: O(1)
     *
     * Reason: Since no extra data structure is used, making space complexity to O(1).
     */
    public static int kthElement(int row1[], int row2[], int m, int n, int k) {

        if(m > n)
            return kthElement(row2,row1,n,m,k);

        int low = Math.max(0,k-n);
        int high = Math.min(m, k);

        while(low <= high) {
            int cut1 = low + (high-low)/2;
            int cut2 = k - cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : row1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : row2[cut2-1];
            int r1 = cut1 == m ? Integer.MAX_VALUE : row1[cut1];
            int r2 = cut2 == n ? Integer.MAX_VALUE : row2[cut2];

            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1,l2);
            }
            if(l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        /**
         * BRUTE APPROACH
         *
         * RUN A WHILE LOOP AND COMPARE WHICH ELEMENT OF EITHER ARR1 OR ARR2 IS BIGGER LIKE WE FOLLOW IN MERGE SORT
         * , AND AT THE SAME TIME DECREMENT K, SO WHEN K BECOMES 1, SIMPLY RETURN THAT ELEMENT.
         *
         * BINARY SEARCH APPROACH
         *
         * THIS APPROACH IS PRETTY SIMILAR TO MEDIAN OF 2 SORTED ARRAYS APPROACH, ONLY DIFFERENCE HERE IS ON THE LEFT PARTITION
         * RATHER THAN HAVING HALF OR HALF + 1 ELEMENTS LIKE WE DID FOR MEDIAN, HERE WE WILL HAVE K ELEMENTS OF THE LEFT SIDE
         * AND REST ON THE RIGHT SIDE, OTHER APPROACH IS SAME, CHECK FOR L1,L2 SMALLER THAN R2,R1 AND THEN RETURN MAX OF L1,L2
         *
         * HOWEVER THERE ARE SOME THINGS THAT ARE DIFFERENT
         *
         * IN HERE LOW WE CAN TAKE IS MAX OF 0, K-ARR2.LENGTH
         * WHY THIS?, BECAUSE SAY THERE IS ARR1 OF 1 2 3, AND ARR 2 OF 1,2,3,4 AND WE NEED TO FIND 6TH ELEMENT AS THE KTH ELEMENT
         * NOW AS WE KNOW HERE LOW AND HIGH RATHER THAN INDEX, HERE IT REPRESENTS MIN AND MAX ELEMENTS WE CAN TAKE INITIALLY,
         * SO SINCE LOW AS 0 WOULD MEANS WE WOULD HAVE TO TAKE 6 ELEMENT FROM ARR2, BUT AS ARR2 ONLY HAS 4 ELEMENTS, HENCE WE TAKE
         * LOW AS MIN OF 0 AND K-ARR2.LENGTH
         *
         * SIMILARLY FOR HIGH, THE K WE CAN TAKE IS MIN OF K AND ARR1.LENGTH, THE REASON FOR THIS IS BECAUSE SAY
         * K IS 2 AND ARRAY IS OF 4 LENGTH, SINCE HIGH AS 4 WOULD HAVE MEANT TAKING 4 ELEMENTS AT MAX, BUT SINCE WE NEED TO
         * FIND K OF ONLY 2 AND WE CAN ONLY TAKE MAX OF 2 ELEMENTS SO THAT'S WHY WE TAKE HIGH AS MIN OF K AND ARR1.LENGTH.
         *
         * TO FIND CUT2, WE NEED TO SUBTRACT K WITH CUT1, THIS IS BECAUSE SAY K IS 2, AND CUT1 IS 1, IT MEANS WE NEED TO TAKE
         * 2 ELEMENTS ON LEFT SIDE OF PARTITION SO 2-1=1, MEANING WE WILL TAKE 1 ELEMENT FROM ARR2.
         *
         *
         */
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};

        kthElement(arr1,arr2,arr1.length, arr2.length, 5);
    }
}
