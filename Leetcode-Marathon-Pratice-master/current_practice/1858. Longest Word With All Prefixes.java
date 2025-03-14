class TrieNode{
    char val;
    List<TrieNode> children;
    
    TrieNode(char val){
        this.val = val;
        this.children = new ArrayList<>();
    }
}
class Solution {
    List<String> wordList;
    int max = Integer.MIN_VALUE;
    public String longestWord(String[] words) {
        wordList = Arrays.asList(words);
        Collections.sort(wordList);
        TrieNode root = new TrieNode(' ');
        for(String word: wordList){
            add(word, root);
        }
        List<String> res = new ArrayList<>();
        traverse(root, "", res);
        if(res.size() == 0) return "";
        List<String> resList = new ArrayList<>();
        for(String word: res){
            if(word.length() == max) resList.add(word);
        }
        Collections.sort(resList);
        return resList.get(0);
    }

    private void add(String word, TrieNode root){
        char[] charArray = word.toCharArray();
        TrieNode currNode = root;
        for(int i=0; i<charArray.length; i++){
            boolean foundChild = false;
            char currChar = charArray[i];
            for(TrieNode child : currNode.children){
                if(child.val == currChar){
                    currNode = child;
                    foundChild = true;
                    break;
                }
            }
            if(!foundChild){
                TrieNode newNode = new TrieNode(currChar);
                currNode.children.add(newNode);
                currNode = newNode;
            }
        }
    }

    private void traverse(TrieNode node, String curr, List<String> arr){
        for(int i=0; i<node.children.size(); i++){
            TrieNode currChild = node.children.get(i);
            curr += currChild.val;
            if(!wordList.contains(curr)){
              curr = curr.substring(0, curr.length()-1);
              continue;
            }
            max = Math.max(curr.length(), max);
            arr.add(curr);
            traverse(currChild, curr, arr);
            curr = curr.substring(0, curr.length()-1);
        }
    }
}