class WordDictionary {
    Map<Integer, List<String>> map;
    public WordDictionary() {
        map = new HashMap<>();
    }

    public void addWord(String word) {
        if(map.containsKey(word.length())){
            map.get(word.length()).add(word);
        }else{
            List<String> strList = new ArrayList<>();
            strList.add(word);
            map.put(word.length(), strList);
        }
    }

    public boolean search(String word) {
        if(!map.containsKey(word.length())) return false;

        List<String> list = map.get(word.length());
        //check if word contains '.'
        if(word.indexOf(".") == -1){
            if(!list.contains(word)){
                return false;
            }
            return true;
        }
        for(String str: list){
            if(match(str, word)) return true;
        }
        return false;
    }
    private boolean match(String target, String word){
        for(int i=0; i<word.length(); i++){
            if(word.charAt(i) == '.') continue;
            if(word.charAt(i) != target.charAt(i)) return false;
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */