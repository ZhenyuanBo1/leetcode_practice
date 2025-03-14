class WordDistance {
    Map<String, List<Integer>> locations = new HashMap<>();

    public WordDistance(String[] wordsDict) {
        for(int i=0; i<wordsDict.length; i++){
            if(locations.containsKey(wordsDict[i])){
                locations.get(wordsDict[i]).add(i);
            }else{
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                locations.put(wordsDict[i], indices);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> word1Indices = locations.get(word1);
        List<Integer> word2Indices = locations.get(word2);

        int minDis = Integer.MAX_VALUE;

        int i=0, j=0;

        while(i<word1Indices.size() && j<word2Indices.size()){
            minDis = Math.min(minDis, Math.abs(word1Indices.get(i) - word2Indices.get(j)));
            if(word1Indices.get(i) > word2Indices.get(j)){
                j++;
            }else{
                i++;
            }
        }

        return minDis;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */