class Solution {
    private char[][] board;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        boolean[][] visited = new boolean[board.length][board[0].length];
        //iterate through the entire board to find the starting point for possible path
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(backtrack(i, j, word, 0)) return true;
            }
        }

        return false;
    }

    private boolean backtrack(int r, int c, String word, int index){
        
        //use index to check if word has been processed
        if(index >= word.length()){
            return true;
        }

        if(r<0 || r>=this.board.length || c<0 || c>=this.board[0].length || this.board[r][c] != word.charAt(index)) return false;
        
        this.board[r][c] = '#';

        int[] rowOffsets = new int[]{0, 1, 0, -1};
        int[] colOffsets = new int[]{1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int newr = r + rowOffsets[i];
            int newc = c + colOffsets[i];
            if(backtrack(newr, newc, word, index+1)){
                return true;
            }
        }

        this.board[r][c] = word.charAt(index);

        return false;
    }
}

//V2:

class Solution {
    private char[][] matrix;
    public boolean exist(char[][] board, String word) {
        this.matrix = board;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(backtrack(0, word, i, j, visited)) return true;
            }
        }
        return false;
    }
    private boolean backtrack(int index, String word, int r, int c, boolean[][] visited){
        if(index >= word.length()){
            return true;
        }

        if(r<0 || r>=matrix.length || c<0 || c>=matrix[0].length || visited[r][c] || matrix[r][c] != word.charAt(index)) return false;

        
        visited[r][c] = true;
        
        int[] rowOffset = new int[]{0, 1, 0, -1};
        int[] colOffset = new int[]{1, 0, -1, 0};
        
        for(int i=0; i<4; i++){
            int newr = r + rowOffset[i];
            int newc = c + colOffset[i];
            if(backtrack(index+1, word, newr, newc, visited)) return true;
        }

        visited[r][c] = false;
        
        return false;
    }
}