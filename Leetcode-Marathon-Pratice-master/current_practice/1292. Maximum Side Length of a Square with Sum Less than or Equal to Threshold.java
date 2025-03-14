class Solution {
    private int m, n;
    // private int[][] presum;
    public int maxSideLength(int[][] mat, int threshold) {
        /*
        1. use binary search by value to search for a possible max length
        2. use presum to prepopulate the sum in this 2D matrix
        */
        m = mat.length;
        n = mat[0].length;
        int[][] presum = new int[m + 1][n + 1];

        //populate presum
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                presum[i][j] = presum[i-1][j] + presum[i][j-1] - presum[i-1][j-1] + mat[i-1][j-1];
            }
        }

        int left = 1, right = Math.min(m, n);

        while(left < right){
            int mid = right - (right-left)/2;
            if(isOK(mid, presum, threshold)){
                left = mid;
            }else{
                right = mid-1;
            }
        }

        //accomodate the case where mat has only one element
        if(isOK(left, presum, threshold)) return left;

        return 0;
    }

    private boolean isOK(int mid, int[][] presum, int threshold){

        for(int i=mid; i<presum.length; i++){
            for(int j=mid; j<presum[0].length; j++){
                int sum = presum[i][j] - presum[i][j-mid] - presum[i-mid][j] + presum[i-mid][j-mid];
                if(sum <= threshold){
                    return true;
                }
            }
        }

        return false;
    }
}