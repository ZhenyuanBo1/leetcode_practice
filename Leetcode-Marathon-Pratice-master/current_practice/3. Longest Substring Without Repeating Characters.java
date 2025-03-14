class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = 0;
        int left = 0;
        int maxLen = 0;

        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLen = Math.max(set.size(), maxLen);
                right += 1;
            }else{
                set.remove(s.charAt(left++));
            }
        }

        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();

        int max = 0;

        int l=0, r=0;

        while(r<s.length()){
            if(!list.contains(s.charAt(r))){
                list.add(s.charAt(r));
                r++;
            }else{
                max = Math.max(r-l, max);
                list.remove(0);
                l++;
            }
        }

        return Math.max(list.size(), max);
    }
}