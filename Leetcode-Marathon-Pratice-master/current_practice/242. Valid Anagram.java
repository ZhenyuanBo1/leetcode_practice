class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();

        for(char ch: s.toCharArray()){
            smap.put(ch, smap.getOrDefault(ch, 0)+1);
        }

        for(char ch: t.toCharArray()){
            if(!smap.containsKey(ch)){
                return false;
            }else{
                smap.put(ch, smap.get(ch)-1);
            }
        }

        for(Character key: smap.keySet()){
            if(smap.get(key)>0) return false;
        }

        return true;
    }
}