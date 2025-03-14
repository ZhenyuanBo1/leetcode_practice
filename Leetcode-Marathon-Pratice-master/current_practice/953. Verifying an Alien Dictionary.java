class Solution {
    private Map<Character, Integer> map;
    public boolean isAlienSorted(String[] words, String order) {
        this.map = new HashMap<>();

        for(int i=0; i<order.length(); i++){
            this.map.put(order.charAt(i), i);
        }

        for(int i=0; i+1<words.length; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            //compare two words
            if(!isSorted(word1, word2)) return false;
        }

        return true;
    }
    private boolean isSorted(String word1, String word2){
        for(int i=0; i<word1.length(); i++){
            if(i>=word2.length()) return false;
            int index1 = this.map.get(word1.charAt(i));
            int index2 = this.map.get(word2.charAt(i));
            if(index1 < index2) return true;
            else if(index1 == index2) continue;
            else return false;
        }

        return true;
    }
}