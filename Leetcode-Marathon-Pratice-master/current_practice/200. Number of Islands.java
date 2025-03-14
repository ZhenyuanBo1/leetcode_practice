class Solution {
    private boolean[][] seen;

    public int numIslands(char[][] grid) {
        this.seen = new boolean[grid.length][grid[0].length];

        int count=0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !seen[i][j]){
                    count += 1;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j){

        if(grid[i][j] == '0') return;

        seen[i][j] = true;

        if(i-1>=0 && !seen[i-1][j]){
            dfs(grid, i-1, j);
        }

        if(i+1<grid.length && !seen[i+1][j]){
            dfs(grid, i+1, j);
        }

        if(j-1>=0 && !seen[i][j-1]){
            dfs(grid, i, j-1);
        }

        if(j+1<grid[0].length && !seen[i][j+1]){
            dfs(grid, i, j+1);
        }
    }
}