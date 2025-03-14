class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> transformation = new HashSet<>();

        for(String word : words){
            char[] arr = word.toCharArray();
            String trans = "";
            for(char ch: arr){
                int index = ch-'a';
                trans += codes[index];
            }
            transformation.add(trans);
        }

        return transformation.size();
    }
}