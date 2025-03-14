class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0; i<strs.length; i++){
            String item = strs[i];
            char[] strArr = item.toCharArray();
            Arrays.sort(strArr);
            String key = String.valueOf(strArr);
            if(!map.containsKey(key)){
                List<String> anagrams = new ArrayList<>();
                anagrams.add(item);
                map.put(key, anagrams);
            }else{
                map.get(key).add(item);
            }
        }

        List<List<String>> resList = new ArrayList<>();

        for(List<String> value: map.values()){
            resList.add(value);
        }

        return resList;
    }
}