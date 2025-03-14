class Solution {
    boolean[][] seen;

    public int maxAreaOfIsland(int[][] grid) {
        seen = new boolean[grid.length][grid[0].length];
        int maxArea = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                maxArea = Math.max(maxArea, calculateArea(grid, i, j));
            }
        }

        return maxArea;
    }

    private int calculateArea(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=grid.length || c>=grid[0].length || seen[r][c] || grid[r][c] == 0){
            return 0;
        }

        seen[r][c] = true;

        return (1 + calculateArea(grid, r+1, c) + calculateArea(grid, r-1, c) + calculateArea(grid, r, c-1) + calculateArea(grid, r, c+1));
    }
}