class Solution {
    public int countBattleships(char[][] board) {
        //DFS
        boolean[][] visited = new boolean[board.length][board[0].length];
        int count = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    count++;
                    dfs(visited, board, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] visited, char[][] board, int r, int c){
        if(r<0 || r>=board.length || c<0 || c>=board[0].length || visited[r][c] || board[r][c] == '.') return;
        visited[r][c] = true;

        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};
        for(int i=0; i<4; i++){
            int newr = r + rowOffset[i];
            int newc = c + colOffset[i];
            dfs(visited, board, newr, newc);
        }
    }
}