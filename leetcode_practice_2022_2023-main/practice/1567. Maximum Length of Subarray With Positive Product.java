class Solution {
    public int getMaxLen(int[] nums) {
        int slow = 0;
        int max = Integer.MIN_VALUE;
        while(slow < nums.length){
            int product = 1;
            int fast = slow;
            while(fast < nums.length){
                product *= nums[fast];
                if(product > 0) max = Math.max(max, fast - slow+1);
            }
            slow++;
        }
        return max;
    }
}