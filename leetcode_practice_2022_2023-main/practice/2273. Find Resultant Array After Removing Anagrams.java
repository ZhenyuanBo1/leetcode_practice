class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> wordList = new ArrayList<>();
        boolean found = false;

        for(String word: words){
            wordList.add(word);
        }

        for(int i=0; i<words.length; i++){
            if(i+1<words.length && isAnagram(words[i], words[i+1])){
                wordList.remove(i+1);
                found = true;
                break;
            }
        }

        if(found){
            if(!found) return wordList;

            String[] newWords = new String[wordList.size()];

            for(int i=0; i<wordList.size(); i++){
                newWords[i] = wordList.get(i);
            }

            return removeAnagrams(newWords);
        }

        return wordList;

    }
    private boolean isAnagram(String a, String b){
        Map<Character, Integer> mapa = new HashMap<>();
        Map<Character, Integer> mapb = new HashMap<>();

        for(int i=0; i<a.length(); i++){
            mapa.put(a.charAt(i), mapa.getOrDefault(a.charAt(i), 0) + 1);
        }

        for(int i=0; i<b.length(); i++){
            mapb.put(b.charAt(i), mapb.getOrDefault(b.charAt(i), 0) + 1);
        }

        return mapa.equals(mapb);
    }
}