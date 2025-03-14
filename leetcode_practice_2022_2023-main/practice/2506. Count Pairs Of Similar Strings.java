class Solution {
    public int similarPairs(String[] words) {
        int count = 0;
        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if(isSimilar(words[i], words[j])){
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isSimilar(String word1, String word2){
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for(int i=0; i<word1.length(); i++){
            set1.add(word1.charAt(i));
        }

        for(int i=0; i<word2.length(); i++){
            set2.add(word2.charAt(i));
        }

        return set1.equals(set2);
    }
}