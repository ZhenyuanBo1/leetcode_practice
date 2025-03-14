class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /*
        since p's length is fixed, we use sliding window and we compare hashmap to check if it is anagram to each other
        */
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> pmap = new HashMap<>();

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<p.length(); i++){
            pmap.put(p.charAt(i), pmap.getOrDefault(p.charAt(i), 0) + 1);
        }

        for(int i=0; i<s.length(); i++){
            smap.put(s.charAt(i), smap.getOrDefault(s.charAt(i), 0) + 1);

            //this is the sliding window check
            if(i>=p.length()){
                int index = i-p.length();
                if(smap.get(s.charAt(index)) == 1){
                    smap.remove(s.charAt(index));
                }else{
                    smap.put(s.charAt(index), smap.get(s.charAt(index))-1);
                }
            }

            if(pmap.equals(smap)){
                ans.add(i-p.length()+1);
            }
        }

        return ans;
    }
}

/*
sliding window template
1. two pointers - left = 0, right should be used in the for loop
2. when window is set up, we use the left pointer to contract and perform necessary logic
3. increment left by 1
*/