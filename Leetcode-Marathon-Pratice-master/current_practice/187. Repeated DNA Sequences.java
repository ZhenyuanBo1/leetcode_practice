class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();

        if(s.length() < 10) return res;

        int i=0, j=0;
        Map<String, Integer> map = new HashMap<>();

        while(j<s.length()){
            while(j-i<10){
                j++;
            }
            if(j-i == 10){
                String curr = s.substring(i, j);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                i++;
            }
        }

        for(String str: map.keySet()){
            if(map.get(str) > 1){
                res.add(str);
            }
        }

        return res;
    }
}