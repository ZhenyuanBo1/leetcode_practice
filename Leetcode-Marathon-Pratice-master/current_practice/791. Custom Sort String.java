class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        String res = "";

        for(int i=0; i<order.length(); i++){
            char curr = order.charAt(i);
            if(map.containsKey(curr)){
                int count = map.get(curr);
                while(count > 0){
                    res += curr;
                    count--;
                }
                map.remove(curr);
            }
        }

        for(Character ch: map.keySet()){
            int count = map.get(ch);
            while(count > 0){
                res += ch;
                count--;
            }
        }

        return res;
    }
}