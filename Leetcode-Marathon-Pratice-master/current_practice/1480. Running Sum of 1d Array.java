class Solution {
    public int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            ans[i] = helper(nums, i);
        }
        return ans;
    }
    private int helper(int[] nums, int index){
        int sum = 0;
        for(int i=0; i<=index; i++){
            sum += nums[i];
        }
        return sum;
    }
}