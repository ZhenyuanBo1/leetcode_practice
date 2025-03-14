class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int[] candidates = new int[rectangles.length];
        int max = Integer.MIN_VALUE;
        int count=0;

        for(int i=0; i<rectangles.length; i++){
            candidates[i] = Math.min(rectangles[i][0], rectangles[i][1]);
            if(candidates[i]>max){
                max = candidates[i];
            }
        }

        for(int i=0; i<candidates.length; i++){
            if(candidates[i] == max){
                count += 1;
            }
        }

        return count;


    }
}