class Solution {
    public int minOperations(int[] nums) {
        int moves = 0;
        for(int i=0; i+1<nums.length; i++){
            if(nums[i]>=nums[i+1]){
                moves += nums[i]+1-nums[i+1];
                nums[i+1] = nums[i]+1;
            }
        }
        return moves;
    }
}