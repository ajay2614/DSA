package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

class ColorPair{
    int row;
    int col;
    int clr;
    ColorPair(int row, int col, int clr) {
        this.row = row;
        this.col = col;
        this.clr = clr;
    }
}
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int oldColor = image[sr][sc];

        if(oldColor == color)
            return image;

        Queue<ColorPair> q = new LinkedList<>();
        q.offer(new ColorPair(sr, sc, color));
        image[sr][sc] = color;
        int di[] = {1,0,-1,0};
        int dj[] = {0,1,0,-1};

        while(!q.isEmpty()) {
            ColorPair p = q.poll();
            int row = p.row;
            int col = p.col;
            int clr = p.clr;

            for(int i=0;i<4;i++) {
                int nrow = row + di[i];
                int ncol = col + dj[i];

                if(nrow >= 0 && ncol >= 0 && nrow < n  && ncol < m
                        && image[nrow][ncol] == oldColor) {
                    image[nrow][ncol] = clr;
                    q.add(new ColorPair(nrow, ncol, clr));
                }
            }
        }
        return image;
    }

}
