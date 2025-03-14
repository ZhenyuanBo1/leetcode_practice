class Solution {
    public int projectionArea(int[][] grid) {
        int ans = 0;
        for(int i=0; i<grid.length; i++){
            int largestRowVal = 0;
            int largestColVal = 0;
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] > 0) ans+=1;
                largestRowVal = Math.max(largestRowVal, grid[i][j]);
                largestColVal = Math.max(largestColVal, grid[j][i]);
            }

            ans += largestRowVal + largestColVal;
        }

        return ans;
    }
}