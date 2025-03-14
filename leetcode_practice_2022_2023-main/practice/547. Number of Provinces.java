class Solution {
    private int[][] matrix;
    public int findCircleNum(int[][] isConnected) {
        boolean[][] visited = new boolean[isConnected.length][isConnected[0].length];
        int count = 0;

        matrix = isConnected;

        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j] == 1 && !visited[i][j]){
                    count++;
                    dfs(i, j, visited);
                }
            }
        }

        return count;
    }

    private void dfs(int r, int c, boolean[][] visited){
        if(r<0 || r>=matrix.length || c<0 || c>=matrix[0].length || matrix[r][c] == 0 || visited[r][c]) return;

        visited[r][c] = true;

        int[] rowOffSet = new int[]{0, 1, 0, -1};
        int[] colOffSet = new int[]{1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int newr = r + rowOffSet[i];
            int newc = c + colOffSet[i];
            dfs(newr, newc, visited);
        }

    }

}