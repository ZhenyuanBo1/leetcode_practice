class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = Integer.MIN_VALUE;
        int p1 = 0;

        //using two pointers
        /*
        two pointers: slow pointer increment by 1 and fast pointer will move forward
        and come back to the point of slow pointer
        */
        while(p1<s.length()){
            Set<Character> set = new HashSet<>();
            int p2 = p1;
            while(p2 < s.length()){
                if(!set.add(s.charAt(p2))) break;
                p2++;
            }
            max = Math.max(max, p2-p1);
            p1++;
        }

        return max == Integer.MIN_VALUE ? 0 : max;
    }
}