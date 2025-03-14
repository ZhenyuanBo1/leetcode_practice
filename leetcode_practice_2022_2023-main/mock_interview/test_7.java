class Solution {
    private char[][] matrix;
    public boolean exist(char[][] board, String word) {
        this.matrix = board;
        boolean[][] visited = new boolean[board.length][board[0].length];
        String candidate = board[0][0] + "";
        return backtrack(candidate, word, 0, 0, visited);
    }
    private boolean backtrack(String candidate, String word, int r, int c, boolean[][] visited){
        if(candidate.length() == word.length()){
            if(candidate.equals(word)) return true;
            return false;
        }
        
        visited[r][c] = true;
        
        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};
        
        for(int i=0; i<4; i++){
            int newr = r + rowOffset[i];
            int newc = c + colOffset[i];
            if(newr>=0 && newr<matrix.length && newc>=0 && newc<matrix[0].length && !visited[newr][newc]){
                if(bfs(candidate+matrix[newr][newc], word, newr, newc, visited)) return true;
            }
        }
        visited[r][c] = false;
        
        return false;
    }
}