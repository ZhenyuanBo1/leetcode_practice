class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int slow = 0;
        int maxLen = Integer.MIN_VALUE;

        while(slow < nums.length){
            int fast = slow + 1;
            while(fast < nums.length && (nums[fast] - nums[slow] == 1 || nums[fast] == nums[fast-1])){
                fast++;
            }
            if(nums[fast-1] == nums[slow]) maxLen = Math.max(maxLen, 0);
            else maxLen = Math.max(maxLen, fast - slow);
            slow++;
        }
        return maxLen;
    }
}