class Solution {
    List<Character> list = new ArrayList<>();
    public int lengthOfLongestSubstring(String s) {
        int len = Integer.MIN_VALUE;
        int prev = 0;
        int curr = prev;
        while(prev < s.length()){
            while(curr < s.length() && !list.contains(s.charAt(curr))){
                list.add(s.charAt(curr));
                curr++;
            }
            len = Math.max(len, list.size());
            if(curr < s.length()) list.remove(0);
            prev++;
        }
        return len == Integer.MIN_VALUE ? 0 : len;
    }
}