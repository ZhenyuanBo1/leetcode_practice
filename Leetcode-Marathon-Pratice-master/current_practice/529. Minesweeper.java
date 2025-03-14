class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int R = board.length, C = board[0].length;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{click[0], click[1]});

        boolean[][] visited = new boolean[R][C];

        while(!q.isEmpty()){
            int[] currpos = q.remove();
            int r = currpos[0], c = currpos[1];

            if(visited[r][c]) continue;

            if(board[r][c] == 'M'){
                board[r][c] = 'X';
                break;
            }
            visited[r][c] = true;

            List<int[]> list = new ArrayList<int[]>();

            int numMines = 0;

            for(int[] dir: dirs){
                int newr = r + dir[0], newc = c + dir[1];
                if(newr >= 0 && newr < R && newc >= 0 && newc < C){
                    if(board[newr][newc] == 'M') numMines += 1;
                    else list.add(new int[]{newr, newc});
                }
            }

            //only add neighboring cells if there are no mines around!!!
            if(numMines == 0){
                board[r][c] = 'B';
                for(int i = 0; i < list.size(); i++){
                    q.add(list.get(i));
                }
            }else
                 board[r][c] = (char)('0' + numMines);
        }

        return board;
    }
}