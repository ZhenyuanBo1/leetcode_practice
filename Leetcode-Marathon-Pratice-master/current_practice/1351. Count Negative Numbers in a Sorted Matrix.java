class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            int j=0;
            while(j<grid[0].length && grid[i][j] >= 0) j++;
            count += grid[0].length - j;
        }
        return count;
    }

}

class Solution {
    public int countNegatives(int[][] grid) {
        int r = 0, c = grid[0].length-1;

        int count = 0;

        while(r<grid.length && c>=0){
            if(grid[r][c] < 0){
                count += grid.length - r;
                c--;
            }else{
                r++;
            }
        }

        return count;
    }

}