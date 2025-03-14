class Solution {
    public void gameOfLife(int[][] board) {
        int[][] board_copy = new int[board.length][board[0].length];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    board_copy[i][j] = makeDecision(board, true, i , j);
                }else{
                   board_copy[i][j] = makeDecision(board, false, i , j);
                }
            }
        }

        for(int i=0; i<board_copy.length; i++){
            for(int j=0; j<board_copy[0].length; j++){
                board[i][j] = board_copy[i][j];
            }
        }


    }
    private int makeDecision(int[][] board, boolean isLive, int i, int j){
        int countLiveCell = 0;
        if(i+1<board.length && board[i+1][j] == 1){
            countLiveCell += 1;
        }
        if(i-1>=0 && board[i-1][j] == 1){
            countLiveCell += 1;
        }
        if(i+1<board.length && j+1<board[0].length && board[i+1][j+1] == 1){
            countLiveCell += 1;
        }
        if(i-1>=0 && j-1>=0 && board[i-1][j-1] == 1){
            countLiveCell += 1;
        }
        if(i-1>=0 && j+1<board[0].length && board[i-1][j+1] == 1){
            countLiveCell += 1;
        }
        if(i+1<board.length && j-1>=0 && board[i+1][j-1] == 1){
            countLiveCell += 1;
        }
        if(j-1>=0 && board[i][j-1] == 1){
            countLiveCell += 1;
        }
        if(j+1<board[0].length && board[i][j+1] == 1){
            countLiveCell += 1;
        }

        if(isLive){
            if(countLiveCell < 2) return 0;
            if(countLiveCell <= 3) return 1;
            if(countLiveCell > 3) return 0;
        }else{
            if(countLiveCell == 3) return 1;
        }

        return 0;
    }
}