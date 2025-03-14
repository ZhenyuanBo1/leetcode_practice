class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String sorted = "";

            for(char c: arr){
                sorted += c;
            }

            if(map.containsKey(sorted)){
                map.get(sorted).add(s);
            }else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sorted, list);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(String key: map.keySet()){
            ans.add(map.get(key));
        }
        
        return ans;
    }
}