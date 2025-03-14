class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left=0;
        int right=0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();

        while(right<s.length()){
            int count = map.getOrDefault(s.charAt(right), 0)+1;
            map.put(s.charAt(right++), count);
            if(map.size() <= k){
                maxLen = Math.max(maxLen, right-left);
            }else if(map.size() > k){
                int updatedVal = map.get(s.charAt(left))-1;
                if(updatedVal == 0){
                    map.remove(s.charAt(left++));
                }else{
                    map.put(s.charAt(left++), updatedVal);
                }
            }
        }

        return maxLen;
    }
}