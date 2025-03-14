class Solution {
    private char[][] matrix;
    private boolean[][] visited;
    class TrieNode{
        public String word;
        public Map<Character, TrieNode> next = new HashMap<>();
    }
    class Trie{
        TrieNode root;
        public Trie(){
            this.root = new TrieNode();
        }
        public void insert(String word){
            TrieNode curr = root;
            for(int i=0; i<word.length();i++){
                if(curr.next.get(word.charAt(i)) == null){
                    curr.next.put(word.charAt(i), new TrieNode());
                }
                curr = curr.next.get(word.charAt(i));
            }
            curr.word = word;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        this.matrix = board;
        this.visited = new boolean[board.length][board[0].length];

        Trie trie = new Trie();

        for(String word: words){
            trie.insert(word);
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(trie.root.next.get(board[i][j]) != null){
                    String curr = board[i][j] + "";
                    backtrack(res, i, j, curr, trie.root);
                }
            }
        }

        return res;
    }
    private void backtrack(List<String>res, int r, int c, String curr, TrieNode parentNode){
        TrieNode currNode = parentNode.next.get(matrix[r][c]);

        if(currNode.word != null){
            if(!res.contains(currNode.word)) res.add(currNode.word);
        }

        visited[r][c] = true;

        int[] rowOffSet = new int[]{0, 1, 0, -1};
        int[] colOffSet = new int[]{1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int newr = r + rowOffSet[i];
            int newc = c + colOffSet[i];
        
            if(newr>=0 && newr<matrix.length && newc>=0 && newc<matrix[0].length && !visited[newr][newc]){
                if(currNode.next.get(matrix[newr][newc]) != null){
                    backtrack(res, newr, newc, curr + matrix[newr][newc], currNode);
                }
            }
        }

        visited[r][c] = false;
    }
}