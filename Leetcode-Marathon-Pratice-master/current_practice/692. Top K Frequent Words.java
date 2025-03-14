class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        TreeMap<String, Integer> tmap = new TreeMap<>();

        for(String word: words){
            tmap.put(word, tmap.getOrDefault(word, 0)+1);
        }

        List<Integer> freqList = new ArrayList<>();

        for(Integer val: tmap.values()){
            freqList.add(val);
        }

        Collections.sort(freqList, Collections.reverseOrder());

        List<String> ans = new ArrayList<>();

        for(Integer freq: freqList){
            for(String word: tmap.keySet()){
                if(tmap.get(word) == freq){
                    if(ans.size() == k) break;
                    if(!ans.contains(word)) ans.add(word);
                }
            }
        }

        return ans;

    }
}