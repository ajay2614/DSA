package Arrays;

public class FindNUniqueIntegersSumUptoZero {
    public int[] sumZero(int n) {
        int arr[] = new int[n];
        for(int i=0;i<n/2;i++) {
            arr[i] = (-1) * (i+1);
        }
        int j=1;
        if(n%2 != 0) {
            for(int i=n/2+1;i<n;i++) {
                arr[i] = j++;
            }
        }
        else{
            for(int i=n/2;i<n;i++) {
                arr[i] = j++;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        /**
        THE QUESTION ASKS US TO GET AN ARRAY OF SIZE N, WHICH RESULTS TO SUM 0, AS WE KNOW WITH N FOR ODD WE CAN MAKE
        SERIES WHICH RESULT TO 0 & SIMILARLY FOR EVEN TOO, FOR EG IF N = 5 , WE CAN MAKE -2 -1 0 1 2, FOR EVEN 4, WE CAN
        MAKE -2 -1 1 2, FIRST STEP WE FILL NEGETIVE TILL N/2, AFTERWARDS IF EVEN WE START FROM N/2 ELSE ODD WE START
        FROM N/2 + 1 SO IT CAN HAVE 0 IN MIDDLE
         */
    }

}
