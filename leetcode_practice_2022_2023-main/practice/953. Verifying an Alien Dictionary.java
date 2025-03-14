class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i=0; i<words.length; i++){
            if(i+1 < words.length && !isSorted(words[i], words[i+1], order)){
                return false;
            }
        }

        return true;
    }
    private boolean isSorted(String word1, String word2, String order){
        int i = 0;
        while(i<word1.length() && i<word2.length()){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            int c1Index = order.indexOf(c1);
            int c2Index = order.indexOf(c2);
            if(c1Index > c2Index) return false;
            else if(c1Index < c2Index) return true;
            i++;
        }
        if(i<word1.length()) return false;
        return true;
    }
}