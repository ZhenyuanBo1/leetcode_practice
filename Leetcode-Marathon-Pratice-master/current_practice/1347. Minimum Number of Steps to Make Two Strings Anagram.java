class Solution {
    public int minSteps(String s, String t) {

        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0)+1);
        }

        for(int i=0; i<t.length(); i++){
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0)+1);
        }


        int count = 0;
        for(Character ch: smap.keySet()){
            if(!tmap.containsKey(ch)){
                count += smap.get(ch);
            }else{
                if(smap.get(ch) > tmap.get(ch)) count += smap.get(ch) - tmap.get(ch);
            }
        }

        return count;
    }
}