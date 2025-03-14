class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0, right = 0, max=1;

        while(right < s.length()){
            if(freqMap.size()>2){
                int updatedVal = freqMap.get(s.charAt(left))-1;
                if(updatedVal == 0){
                    freqMap.remove(s.charAt(left));
                }else{
                    freqMap.put(s.charAt(left), updatedVal);
                }
                left++;
            }else{
                freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right),0)+1);
                max = Math.max(right-left, max);
                right++;
            }
        }

        return freqMap.size() > 2 ? max : Math.max(right-left, max);
    }
}

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0, right = 0, max=1;

        while(right < s.length()){
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right),0)+1);
            right++;
            // System.out.println(freqMap);
            if(freqMap.size()>2){
                int updatedVal = freqMap.get(s.charAt(left))-1;
                if(updatedVal == 0){
                    freqMap.remove(s.charAt(left));
                }else{
                    freqMap.put(s.charAt(left), updatedVal);
                }
                left++;
            }else{
                max = Math.max(right-left, max);
            }
        }

        return max;
    }
}