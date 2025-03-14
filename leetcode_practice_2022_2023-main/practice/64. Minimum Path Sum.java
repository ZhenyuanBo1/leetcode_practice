class Solution {
    private boolean[][] visited;
    private int[][] matrix;
    public int minPathSum(int[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length];
        this.matrix = grid;
        return dfs(0, 0);
    }

    private int dfs(int r, int c){
        if(r<0 || r>=matrix.length || c<0 || c>=matrix[0].length || visited[r][c]) return 0;

        if(r==matrix.length-1 && c == matrix[0].length-1) return matrix[r][c];

        int sum = 0;

        visited[r][c] = true;

        int[] rowOffset = new int[]{0, 1};
        int[] colOffset = new int[]{1, 0};

        for(int i=0; i<2; i++){
            int newr = r + rowOffset[i];
            int newc = c + colOffset[i];
            sum = Math.(sum, matrix[r][c] + dfs(newr, newc));
        }

        return sum;
    }
}