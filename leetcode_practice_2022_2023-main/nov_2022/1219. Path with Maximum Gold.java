class Solution {
    //sample template for 2-d array DFS/Backtracking questions
    private int[][] grid;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        int max = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                max = Math.max(max, helper(i,j,visited));
            }
        }
        return max;
    }

    private int helper(int r, int c, boolean[][]visited){

        if(r<0 || r>=this.grid.length || c<0 || c>=this.grid[0].length || visited[r][c] || this.grid[r][c] == 0) return 0;

        visited[r][c] = true;

        int origin = this.grid[r][c];
        
        int max = 0;

        //has to be this direction!!!
        int[] rowOffsets = {0, 1, 0 , -1};
        int[] colOffsets = {1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int newr = r+rowOffsets[i];
            int newc = c+colOffsets[i];
            max = Math.max(max, helper(newr, newc, visited));
        }

        visited[r][c] = false;
        this.grid[r][c] = origin;
        return max + origin;
    }
}