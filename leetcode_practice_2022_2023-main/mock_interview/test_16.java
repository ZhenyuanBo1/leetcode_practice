class Solution {
    private char[][] matrix;
    private boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        this.matrix = board;
        this.visited = new boolean[board.length][board[0].length];

        List<String> wordList = new ArrayList<>();

        int maxLen = 0;

        for(String word: words){
            wordList.add(word);
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                String curr = board[i][j] + "";
                backtrack(res, wordList, i, j, curr, maxLen);
            }
        }

        return res;
    }
    private void backtrack(List<String>res, List<String> wordList, int r, int c, String curr, int maxLen){
        
        if(wordList.indexOf(curr) > -1){
            if(!res.contains(curr)) res.add(curr);
        }

        if(curr.length() > maxLen) return;

        visited[r][c] = true;

        int[] rowOffSet = new int[]{0, 1, 0, -1};
        int[] colOffSet = new int[]{1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int newr = r + rowOffSet[i];
            int newc = c + colOffSet[i];
        
            if(newr>=0 && newr<matrix.length && newc>=0 && newc<matrix[0].length && !visited[newr][newc]){
                backtrack(res, wordList, newr, newc, curr + matrix[newr][newc], maxLen);
            }
        }

        visited[r][c] = false;
    }
}