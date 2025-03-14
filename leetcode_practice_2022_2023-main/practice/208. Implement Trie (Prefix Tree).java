class TrieNode{
    public boolean flag;
    public Map<Character, TrieNode> next = new HashMap<>();
}
class Trie {

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            if(curr.next.get(word.charAt(i)) == null){
                curr.next.put(word.charAt(i), new TrieNode());
            }
            curr = curr.next.get(word.charAt(i));
        }
        curr.flag = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = this.root;
        for(int i=0; i<word.length(); i++){
            if(curr.next.get(word.charAt(i)) == null) return false;
            curr = curr.next.get(word.charAt(i));
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for(int i=0; i<prefix.length(); i++){
            if(curr.next.get(prefix.charAt(i)) == null) return false;
            curr = curr.next.get(prefix.charAt(i));
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */