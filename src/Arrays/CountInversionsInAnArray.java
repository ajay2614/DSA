package Arrays;

public class CountInversionsInAnArray {
    public static int mergeSort(int arr[], int si, int ei) {
        int mid, invCount = 0;
        if(si < ei) {
            mid = si + (ei - si) / 2;
            invCount += mergeSort(arr, si, mid);
            invCount += mergeSort(arr, mid + 1, ei);
            invCount += merge(arr, si, mid, ei);
        }

        return invCount;

    }

    private static int merge(int arr[], int si, int mid, int ei) {

        int dummy[] = new int[ei - si + 1];

        int inv_count = 0;
        int ind1 = si;
        int ind2 = mid + 1;

        int x=0;

        while (ind1 <= mid && ind2 <= ei) {
            if(arr[ind1] <= arr[ind2])
                dummy[x++] = arr[ind1++];
            else {
                dummy[x++] = arr[ind2++];
                inv_count += mid - ind1 + 1;
            }
        }

        while (ind1 <= mid) {
            dummy[x++] = arr[ind1++];
        }
        while (ind2 <= ei){
            dummy[x++] = arr[ind2++];
        }

        for (int i=0,j=si;i<dummy.length && j<=ei;i++,j++) {
            arr[j] = dummy[i];
        }
        return inv_count;
    }

    public static void main(String args[]) {
        int arr[] = {5,4,3,2,1};

        System.out.println(mergeSort(arr, 0, arr.length-1));
    }
}
