class Solution {
    Set<Integer> set = new HashSet<>();
    public int longestConsecutive(int[] nums) {
        for(int num: nums){
            set.add(num);
        }

        int maxLen = 0;

        for(Integer num: set){
            if(!set.contains(num-1)){
                int curr = num;
                int currLen = 1;
                while(set.contains(curr+1)){
                    currLen += 1;
                    curr += 1;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }

        return maxLen;
    }
}