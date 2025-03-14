class Solution {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> indices = new ArrayList<>();

        List<String> wordList = new ArrayList<>();

        for(String word: words){
            wordList.add(word);
        }

        for(int i=0; i<text.length(); i++){
            for(int j=i+1; j<=text.length(); j++){
                String substr = text.substring(i, j);
                if(wordList.contains(substr)){
                    indices.add(new int[]{i, j});
                }
            }
        }

        int[][] res = new int[indices.size()][2];

        for(int i=0; i<res.length; i++){
            res[i][0] = indices.get(i)[0];
            res[i][1] = indices.get(i)[1]-1;
        }

        return res;
    }
}

class Solution {
    class TrieNode{
        public boolean flag; // denote whether it is a string;
        public Map<Character, TrieNode> next = new HashMap<>();
    }
    class Trie{
        public TrieNode root;
        public Trie(){
            this.root = new TrieNode();
        }
        public void insert(String word){
            TrieNode curr = root;
            for(int i=0; i<word.length(); i++){
                char c = word.charAt(i);
                if(curr.next.get(c) == null){
                    curr.next.put(c, new TrieNode());
                }
                curr = curr.next.get(c);
            }
            curr.flag = true;
        }
    }
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> indices = new ArrayList<>();

        Trie trie = new Trie();
        for(String word: words){
            trie.insert(word); // create trie structure
        }

        for(int i=0; i<text.length(); i++){
            TrieNode p = trie.root;
            for(int j=i; j<text.length(); j++){
                if(p.next.get(text.charAt(j)) == null){
                    break;
                }
                p = p.next.get(text.charAt(j));
                if(p.flag){
                    indices.add(new int[]{i, j});
                }
            }
        }

        int[][] ans = new int[indices.size()][2];

        ans = indices.toArray(ans); // covert list to array

        return ans;


    }
}t