package BinarySearch;

public class AllocateMinimumNumberOfPagesToStudents {
    /**
     *
     * Time Complexity : O(NlogN)
     *
     * Reason: Binary search takes O(log N). For every search, we are checking if an allocation
     * is possible or not. Checking for allocation takes O(N).
     *
     * Space Complexity: O(1)
     *
     * Reason: No extra data structure is used to store spaces.
     */
    public static int findPages(int[]books,int n,int m) {
        if(m > n)
            return -1;

        int low = books[0];
        int high = books[0];

        for(int i=1;i<n;i++) {
            low = Math.min(books[i],low);
            high += books[i];
        }

        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(m,books,n,mid)) {
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return low;
    }
    public static boolean isPossible(int totalStudents, int[] books, int n, int barrier) {
        int allocatedStudents = 1;
        int res = 0;
        for(int i=0;i<n;i++) {
            if(res + books[i] > barrier) {
                allocatedStudents++;
                res = books[i];
                if(res > barrier)
                    return false;
            }
            else
                res += books[i];
        }
        if(allocatedStudents <= totalStudents)
            return true;
        return false;
    }

    public static void main(String[] args) {

        /**
         *
         * THE QUESTION STATES THAT GIVEN AN ARRAY REPRESENTING TOTAL PAGES OF DIFFERENT BOOKS, WE NEED TO FIND A WAY SUCH
         * THAT EACH STUDENT CAN HAVE A LESSER VALUES THAN A CERTAIN MINIMUM PAGES, EG MIN PAGES ARE STUDENTS CAN HAVE
         * IS 25, AND TOTAL PAGES ARE 70 AND STUDENTS ARE 3, THEN WITH MIN OF 25, STUDENT1 AND STUDENT2 CAN HAVE 25 PAGES EACH
         * AND STUDENT3 CAN HAVE 20 PAGES, WHICH ARE ALL SMALLER OR EQUAL TO MINIMUM PAGES.
         *
         * OPTIMAL APPROACH
         *
         * USING A BINARY SINCE WE KNOW THAT MAXIMUM VALUE THAT COULD BE IS TOTAL OF ALL THE PAGES, AND FOR THE MIN PAGES
         * WE WILL USE THE MIN VALUE FROM ARRAY, THIS IS BECAUSE SAY FOR WORST CASE ALL THE VALUES ARE SAME LIKE ALL ARE 12
         * THEN DEFINITELY MINIMUM VALUE WOULD THE 12, SO WE CAN SAY THE ANSWER WOULD LIE BETWEEN LOW AND HIGH,
         *
         * RUN BS WHILE(LOW<=HIGH), GET MID VALUE, NOW TO CHECK WHETHER MID VALUE AS THE MIN VALUE CAN HAVE ALL THE STUDENTS
         * ALLOCATED, WE WILL RUN ISPOSSIBLE METHOD
         *
         * IS POSSIBLE METHOD
         *
         * IN THIS ISPOSSIBLE METHOD WE WILL CHECK WHETHER GIVEN A MINVALUE/BARRIER, WHETHER WE CAN DISTRUBUTE PAGES TO
         * STUDENTS WITH THAT MINVALUE,
         *
         * HAVE A VARIABLE ALLOCATEDSTUDENTS WHICH INDICATES STUDENTS ALLOCATED AND A RES VARIABLE TO CHECK IF
         * RES + PAGES[I] > BARRIER, WE CAN HAVE RES AS 0 AND THEN ITERATE FROM 0 TO N FOR THE PAGES ARRAY OR
         * RES AS PAGES[0] AND ITERATE FROM 1 TO N, BOTH ARE SAME
         *
         * WHILE ITERATING CHECK IF RES+PAGES[I]>BARRIER, MEANS WE HAVE CROSSED THE MINIMUM PAGES VALUE THAT MUST
         * BE ASSIGNED TO A STUDENT, INCREASE THE ALLOCATED STUDENTS AND HAVE RES[I] = PAGES[I], IF RES > MIN VALUE
         * IT MEANS THE MIN VALUE IS SMALLER THAN ONE OF THE ELEMENTS IN ARRAY STATING THIS IS FALSE
         *
         * ELSE JUST UPDATE RES WITH PAGES[I], IF THE COUNT OF ALLOCATED STUDENTS IS SMALLER THAN OR EQ TO TOTAL STUDENT MEANS
         * WE WERE SUCCESSFULLY ABLE TO ALLOCATE PAGES TO STUDENTS ELSE RETURN FALSE
         *
         *
         * NOW BACK IN THE BINARY SEARCH HAVE HIGH = MID-1, WHEN MID VALUE AS MIN IS POSSIBLE BECAUSE WE NEED TO MOVE SEARCH
         * SPACE TO LEFT AS WE ARE LOOKING FOR MIN VALUE, IF NOW HAVE LOW = MID+1,
         *
         * RETURN LOW, WHY LOW? BECAUSE SAY IF WE HAD A VARIABLE RES TRACKING, WE WOULD UPDATE RES EVERYTIME MID VALUE IS
         * POSSIBLE, SO WHEN HIGH WOULD BECOME MID-1, AND WOULD BECOME ONE SMALLER THAN LOW, WE WOULD HAVE UPDATED RES JUST BEFORE
         * IT, AND IT WOULD DEFINITELY BE SAME AS LOW.
         *
         *
         *
         */
        int N = 4;
        int A[] = {12,34,67,90};
        int M = 2;
        findPages(A, N, M);
    }
}
