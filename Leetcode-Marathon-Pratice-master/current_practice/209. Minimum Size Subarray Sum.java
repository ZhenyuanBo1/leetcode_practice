class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int sum = 0;

        /*
        1. keep increasing the sum until it hits target
        2. keep moving forward the left until sum becomes less than target
        3. calculate the minimum value
        */
        while(right < nums.length){
            sum += nums[right++];
            while(sum >= target){
                res = Math.min(res, right-left);
                sum -= nums[left++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}