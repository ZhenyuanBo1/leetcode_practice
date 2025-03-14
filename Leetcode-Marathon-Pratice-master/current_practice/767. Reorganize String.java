class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        String res = "";

        while(map.size()>0){
            for(Character ch: map.keySet()){
                res += ch;
                int updatedVal = map.get(ch)-1;
                if(updatedVal == 0){
                    map.remove(ch);
                }else{
                    map.put(ch, updatedVal);
                }
            }
        }

        for(int i=0; i+1<res.length(); i++){
            if(res.charAt(i) == res.charAt(i+1)) return "";
        }


        return res;
    }
}