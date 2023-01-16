import java.util.Stack;

public class Interview {

    /**
     *
     * [1,2],[3,2],[2,1]]
     */
    public static int returnCommanders(int[][] array) {
        int n = array.length;
        if(n == 0)
            return -1;
        if(n == 1)
            return 1;
        int pU = array[0][1];
        int cnt = 1;
        for (int i=1;i<n;i++) {
            if(array[i][1] != array[i-1][1])
                return -1;
            else if (pU == array[i][0])
                return -1;
            else
                cnt++;
        }
        return pU;
    }

    public static void main(String[] args) {
        int arr[][] = {{1,5},{2,3},{3,4},{4,5},{5,1},{4,1}};
        System.out.println(returnCommanders(arr));
    }
}
