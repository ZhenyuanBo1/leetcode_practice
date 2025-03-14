class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()) return new ArrayList<>();

        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        //build pMap
        for(int i=0; i<p.length(); i++){
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0)+1);
        }

        List<Integer> res = new ArrayList<>();

        int left=0;
        int right=0;

        while(right<s.length()){
            sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0)+1);

            if(right-left + 1 == p.length()){
                //check if the sMap equals pMap
                if(sMap.equals(pMap)){
                    res.add(left);
                }

                int updatedVal = sMap.get(s.charAt(left)) - 1;
                if(updatedVal == 0){
                    sMap.remove(s.charAt(left++));
                }else{
                    sMap.put(s.charAt(left++), updatedVal);
                }
            }

            right++;
        }

        return res;
    }
}