class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][]visited, char[][]grid, int r , int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c] == '0' || visited[r][c]) return;
        visited[r][c] = true;

        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int newr = r + rowOffset[i];
            int newc = c + colOffset[i];
            dfs(visited, grid, newr, newc);
        }
    }
}