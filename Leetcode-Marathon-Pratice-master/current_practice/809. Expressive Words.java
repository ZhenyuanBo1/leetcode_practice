class Solution {
    public int expressiveWords(String s, String[] words) {
        String compressed = compress(s);

        int count = 0;
        for(String word: words){
            String compressedWord = compress(word);
            if(canBeExtendedFrom(compressed, compressedWord)) count += 1;
        }

        return count;
    }
    private String compress(String s){
        StringBuilder sb = new StringBuilder();

        int count = 0;
        for(int i=1; i<=s.length(); i++){
            count += 1;
            if(i== s.length() || s.charAt(i) != s.charAt(i-1)){
                sb.append(s.charAt(i-1)).append(count);
                count = 0;
            }
        }

        return sb.toString();
    }

    private boolean canBeExtendedFrom(String compressed, String compressedWord){
        if(compressed == null || compressed.length() == 0) return false;

        if(compressed.length() != compressedWord.length()) return false;

        for(int i=0; i<compressed.length(); i+=2){
            int compressedCount = compressed.charAt(i+1) - '0';
            int count = compressedWord.charAt(i+1) - '0';

            if(compressed.charAt(i) != compressedWord.charAt(i)) return false;
            if(compressedCount < 3 && compressedCount != count) return false;
            if(compressedCount < count) return false;
        }

        return true;
    }

}