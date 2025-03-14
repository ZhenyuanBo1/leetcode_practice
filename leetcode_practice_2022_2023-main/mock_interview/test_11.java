class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1) * (ay2-ay1);
        int area2 = (bx2-bx1) * (by2-by1);

        int cx2, cy2 = 0;
        if(ax2 * bx2 > 0){
            cx2 = Math.min(ax2, bx2);
        }
    }
}