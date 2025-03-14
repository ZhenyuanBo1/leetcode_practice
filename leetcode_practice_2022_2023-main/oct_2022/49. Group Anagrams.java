class Solution {
    Map<String, List<String>> map = new HashMap<>();
    public List<List<String>> groupAnagrams(String[] strs) {
        for(String str: strs){
            char[] sorted = str.toCharArray();
            Arrays.sort(sorted);
            String sortedStr = "";
            for(char ch: sorted){
                sortedStr += ch;
            }
            if(map.containsKey(sortedStr)){
                List<String> group = map.get(sortedStr);
                group.add(str);
            }else{
                map.put(sortedStr, new ArrayList<String>(Arrays.asList(str)));
            }
        }
        List<List<String>> res = new ArrayList<>();

        for(String key: map.keySet()){
            res.add(map.get(key));
        }

        return res;
    }
}