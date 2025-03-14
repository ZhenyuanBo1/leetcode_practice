class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1map = new HashMap<>();
        Map<Character, Integer> s2map = new HashMap<>();

        for(int i=0; i<s1.length(); i++){
            s1map.put(s1.charAt(i), s1map.getOrDefault(s1.charAt(i), 0) + 1);
        }

        for(int i=0; i<s2.length(); i++){
            s2map.put(s2.charAt(i), s2map.getOrDefault(s2.charAt(i), 0) + 1);

            if(i>=s1.length()){
                int index = i-s1.length();
                if(s2map.get(s2.charAt(index)) == 1){
                    s2map.remove(s2.charAt(index));
                }else{
                    s2map.put(s2.charAt(index), s2map.get(s2.charAt(index))-1);
                }
            }

            if(s1map.equals(s2map)){
                return true;
            }
        }

        return false;
    }


}