class Solution {
    private int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        int max = Integer.MIN_VALUE;
        this.grid = grid;
        boolean[] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                max = Math.max(max, maxArea(i, j, visited));
            }
        }
    }
    private int maxArea(int r, int c, boolean[][] visited){
        if(r<0 || r>=this.grid.length || c<0 || c>=grid[0].length || this.grid[r][c] == 0 || visited[r][c]) return 0;
        visited[r][c] = true;
        return 1+maxArea(r+1, c, visited) + maxArea(r-1, c, visited) + maxArea(r, c+1, visited) + maxArea(r, c-1, visited);
    }
}