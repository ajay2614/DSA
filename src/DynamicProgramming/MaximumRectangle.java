package DynamicProgramming;

import java.util.Stack;

public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int heights[] = new int[m];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(matrix[i][j] == '1')
                    heights[j]++;
                else
                    heights[j] = 0;
            }
            int area = findHistoArea(heights);
            max = Math.max(area, max);
        }
        return max;
    }

    public int findHistoArea(int heights[]) {

        int n = heights.length;
        int max = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<=n;i++) {
            while(!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])) {

                int height = heights[st.peek()];

                st.pop();

                int width = 0;

                if(st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() -1;

                int area = width * height;

                max = Math.max(area, max);
            }
            st.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        /*
        THE QUESTION IS COMPLETELY DEPENDENT ON LARGEST AREA IN HISTOGRAM, THE ONLY DIFF IS WE ARE GIVEN A 2D ARRAY
        OF 0 & 1, THE CONCEPT IS WE ADD THE HEIGHT IF PREVIOUS COLUMN OF PREVIOUS ROW WAS 1, ELSE WE MAKE IT 0,
        WE WILL RUN A LOOP OF I & J, FOR EVERY ROW, WE WILL GET THE HEIGHTS ARRAY AND THEN PASS IN LARGEST AREA
        IN HISTOGRAM TO COMPUTE THE AREA, AT END WE CHOOSE THE MAXIMUM.
         */
    }
}
