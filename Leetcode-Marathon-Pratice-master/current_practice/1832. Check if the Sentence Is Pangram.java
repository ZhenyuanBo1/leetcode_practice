class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] letters = new int[26];

        for(int i=0; i<sentence.length(); i++){
            letters[sentence.charAt(i)-'a']++;
        }

        for(int i=0; i<letters.length; i++){
            if(letters[i] < 1) return false;
        }

        return true;
    }

}