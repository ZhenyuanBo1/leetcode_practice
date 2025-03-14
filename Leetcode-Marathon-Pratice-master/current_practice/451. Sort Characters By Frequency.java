class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        TreeMap<Integer, List<Character>> map1 = new TreeMap<>();

        for(Character ch: map.keySet()){
            int freq = map.get(ch);
            if(map1.containsKey(freq)){
                map1.get(freq).add(ch);
            }else{
                List<Character> list = new ArrayList<>();
                list.add(ch);
                map1.put(freq, list);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(Integer freq: map1.keySet()){
            List<Character> list = map1.get(freq);
            for(Character c: list){
                int n = freq;
                while(n>0){
                    sb.insert(0, c);
                    n--;
                }
            }
        }

        return sb.toString();
    }
}