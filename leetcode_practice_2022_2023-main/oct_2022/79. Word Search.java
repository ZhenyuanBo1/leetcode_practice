class Solution {
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        //iterate through the entire board to find the starting point for possible path
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(helper(i, j, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean helper(int r, int c, String word, int index){
        if(index>=word.length()) return true;
        if(r<0 || r>=this.board.length || c<0 || c>=this.board[0].length || word.charAt(index) !== this.board[r][c]) return false;

        //mark the cell to be visited
        this.board[r][c] = '#';

        boolean check = false;

        int[] rowOffsets = {0, 1, 0 , -1};
        int[] colOffsets = {1, 0, -1, 0};

        for(int i=0; i<4; i++){
            //traverse 4 directions to explore next char
            if(helper(r + rowOffsets[i], c + colOffsets[i], word, index+1)) return true;
        }

        this.board[r][c] = word.charAt(index);
        return false;
    }
}