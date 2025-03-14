class Solution {
    public int numSpecialEquivGroups(String[] words) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word: words){
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String hash = String.valueOf(wordArr);
            if(map.containsKey(hash)){
                map.get(hash).add(word);
            }else{
                List<String> group = new ArrayList<>();
                group.add(wordArr);
                map.put(hash, group);
            }
        }

        int max = Integer.MIN_VALUE;

        for(String key: map.keySet()){
            max = Math.max(max, map,get(key).size());
        }

        return max;
    }
}