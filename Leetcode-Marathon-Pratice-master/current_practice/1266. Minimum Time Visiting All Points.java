class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for(int i=0; i+1<points.length; i++){
            int[] currPoint = points[i];
            int[] nextPoint = points[i+1];
            int maxVal = Math.max(Math.abs(currPoint[0]-nextPoint[0]), Math.abs(currPoint[1]-nextPoint[1]));
            minTime += maxVal;
        }

        return minTime;
    }
}